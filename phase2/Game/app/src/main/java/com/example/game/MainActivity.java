package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.game.PictureGame.PictureGameActivity;
import com.example.game.SudokuGame.SudokuActivity;
import com.example.game.WarGame.WarGameActivity;

/**
 * The MainActivity class where player is created or logs in to play the games
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Customizable features for the Player object
     */
    private String username, password, colour, multiplier, backColour, prevUser, prevPassword;

    /**
     * Input for the customizable features for the Player object by the user
     */
    private EditText userNameInput, passwordInput, previousUserNameInput, previousPasswordInput,
            colourInput, scoreMultiplier, backColourText;

    /**
     * Player object
     */
    private Player newPlayer;

    /**
     * Player database where the player object will be stored and accessed after logging out
     */
    private PlayerDataBase playerDataBase;

    /**
     * Created on run. Looks for input to create player.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = (EditText) findViewById(R.id.userNameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        colourInput = (EditText) findViewById(R.id.colourInput);
        scoreMultiplier = (EditText) findViewById(R.id.scoreMultiply);
        backColourText = (EditText) findViewById(R.id.backColour);
        previousUserNameInput = (EditText) findViewById(R.id.userNameInput2);
        previousPasswordInput = (EditText) findViewById(R.id.passwordInput2);

        playerDataBase = new PlayerDataBase(this);
    }

    /**
     * Creates a Player object that the user will play as throughout each game. Will play the
     * PictureGame first and then continue with the other games.
     * <p>
     * Learned how to pass information from one game level to the next from
     * https://developer.android.com/reference/android/os/Bundle
     */
    public void createPlayer(View view) {

        username = userNameInput.getText().toString();
        password = passwordInput.getText().toString();
        colour = colourInput.getText().toString();
        multiplier = scoreMultiplier.getText().toString();
        backColour = backColourText.getText().toString();
        newPlayer = new Player(username, password, colour, multiplier, backColour);
        playerDataBase.storePlayerData(newPlayer);

        ((EditText) findViewById(R.id.userNameInput)).setText("");
        ((EditText) findViewById(R.id.passwordInput)).setText("");
        ((EditText) findViewById(R.id.colourInput)).setText("");
        ((EditText) findViewById(R.id.scoreMultiply)).setText("");
        ((EditText) findViewById(R.id.backColour)).setText("");

        Intent intent = new Intent(this, ChooseGame.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * When a user enters login information, the checkPlayer method will verify if that Player was
     * previously created or not. If it is a previous Player, they will continue where they left off
     * as the Player data is saved locally.
     */

    public void checkPlayer(View view) {
        prevUser = previousUserNameInput.getText().toString();
        prevPassword = previousPasswordInput.getText().toString();
        ((EditText) findViewById(R.id.userNameInput2)).setText("");
        ((EditText) findViewById(R.id.passwordInput2)).setText("");

        String[] playerInfo;

        if (!(prevUser.equals("") && prevPassword.equals(""))) {
            playerInfo = playerDataBase.verify(prevUser);

            if (prevUser.equals(playerInfo[0]) && prevPassword.equals(playerInfo[1])) {
                newPlayer = playerDataBase.getPlayer(prevUser);
                startingPosition();
            }
        }
    }

    /**
     * Determines where a player should start based on which game they logged off on.
     */
    public void startingPosition(){
        Intent intent;
        if (newPlayer.getGameNum() == 0) {
            intent = new Intent(this, ChooseGame.class);
        } else if (newPlayer.getGameNum() == 1) {
            intent = new Intent(this, PictureGameActivity.class);
        } else if (newPlayer.getGameNum() == 2) {
            intent = new Intent(this, WarGameActivity.class);
        } else {
            intent = new Intent(this, SudokuActivity.class);
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /**
     * Brings up the pop-up menu where a new Player object can be created.
     */
    public void createAccount(View view) {
        findViewById(R.id.shadowView).bringToFront();
        findViewById(R.id.accountView).bringToFront();

        findViewById(R.id.colourInput).bringToFront();
        findViewById(R.id.backColour).bringToFront();
        findViewById(R.id.userNameInput).bringToFront();
        findViewById(R.id.passwordInput).bringToFront();
        findViewById(R.id.scoreMultiply).bringToFront();
        findViewById(R.id.button).bringToFront();
        findViewById(R.id.closeButton).bringToFront();

        findViewById(R.id.colourInput).setVisibility(View.VISIBLE);
        findViewById(R.id.backColour).setVisibility(View.VISIBLE);
        findViewById(R.id.userNameInput).setVisibility(View.VISIBLE);
        findViewById(R.id.passwordInput).setVisibility(View.VISIBLE);
        findViewById(R.id.scoreMultiply).setVisibility(View.VISIBLE);
        findViewById(R.id.button).setVisibility(View.VISIBLE);

        findViewById(R.id.button2).setVisibility(View.INVISIBLE);

        findViewById(R.id.shadowView).setVisibility(View.VISIBLE);
        findViewById(R.id.accountView).setVisibility(View.VISIBLE);

        findViewById(R.id.closeButton).setVisibility(View.VISIBLE);
        findViewById(R.id.createButton).setVisibility(View.INVISIBLE);
    }

    /**
     * Closes pop-up menu.
     */
    public void close(View view){

        findViewById(R.id.colourInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.backColour).setVisibility(View.INVISIBLE);
        findViewById(R.id.userNameInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.passwordInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.scoreMultiply).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.closeButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.button2).setVisibility(View.VISIBLE);

        findViewById(R.id.shadowView).setVisibility(View.INVISIBLE);
        findViewById(R.id.accountView).setVisibility(View.INVISIBLE);

        findViewById(R.id.createButton).setVisibility(View.VISIBLE);
    }
}
