package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

/**
 *The MainActivity class where player is created or logs in to play the games
 */

public class MainActivity extends AppCompatActivity {

    private String username, password, colour, multiplier, backColour, prevUser, prevPassword;

    private EditText userNameInput, passwordInput, previousUserNameInput, previousPasswordInput,
            colourInput, scoreMultiplier, backColourText;

    private Button submitButton;

    private Player newPlayer;

    private PlayerDataBase playerDataBase;

    /**
     *Created on run. Looks for input to create player.
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

        submitButton = (Button) findViewById(R.id.button);

        playerDataBase = new PlayerDataBase(this);
    }

    /**
     *Creates a Player object that the user will play as throughout each game. Will play the
     *PictureGame first and then continue with the other games.
     */
    public void createPlayer(View view) {
        username = userNameInput.getText().toString();
        password = passwordInput.getText().toString();
        colour = colourInput.getText().toString();
        multiplier = scoreMultiplier.getText().toString();
        backColour = backColourText.getText().toString();
        newPlayer = new Player(username, password, colour, multiplier, backColour);
        newPlayer.addLevel();
        playerDataBase.storePlayerData(newPlayer);
        ((EditText) findViewById(R.id.userNameInput)).setText("");
        ((EditText) findViewById(R.id.passwordInput)).setText("");
        ((EditText) findViewById(R.id.colourInput)).setText("");
        ((EditText) findViewById(R.id.scoreMultiply)).setText("");
        ((EditText) findViewById(R.id.backColour)).setText("");

        Intent intent = new Intent(this, PictureGameActivity.class);
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
    public void checkPlayer(View view)
    {
        prevUser = previousUserNameInput.getText().toString();
        prevPassword = previousPasswordInput.getText().toString();
        ((EditText) findViewById(R.id.userNameInput2)).setText("");
        ((EditText) findViewById(R.id.passwordInput2)).setText("");

        String [] playerInfo = playerDataBase.verify(prevUser, prevPassword);

        if (prevUser.equals(playerInfo[0])&&prevPassword.equals(playerInfo[1])){
            newPlayer = playerDataBase.getPlayer(prevUser);

            if (newPlayer.getGameNum()==1){
                startPictureGame();
            }
            else if (newPlayer.getGameNum()==2){
                startWarGame();
            }
            else
                startSudokuGame();
        }
    }

    /**
     * If a Player's game number is 1, then the player will start at the PictureActivity.
     */
    public void startPictureGame(){
        Intent intent = new Intent(this, PictureGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a Player's game number is 2, then the player will start at the WarGameActivity.
     */
    public void startWarGame(){
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a Player's game number is 1, then the player will start at the SudokuActivity.
     */
    public void startSudokuGame(){
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
