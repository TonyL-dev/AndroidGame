package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String username, password, colour, multiplier, backColour, prevUser, prevPassword;

    EditText userNameInput;
    EditText passwordInput;
    EditText previousUserNameInput;
    EditText previousPasswordInput;
    EditText colourInput;
    EditText scoreMultiplier;
    EditText backColourText;

    Button submitButton;

    Player newPlayer;

    PlayerDataBase playerDataBase;


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

    public void checkPlayer(View view)
    {
        prevUser = previousUserNameInput.getText().toString();
        prevPassword = previousPasswordInput.getText().toString();
        ((EditText) findViewById(R.id.userNameInput2)).setText("");
        ((EditText) findViewById(R.id.passwordInput2)).setText("");

        String [] playerInfo = playerDataBase.verify();

        if (prevUser.equals(playerInfo[0])&&prevPassword.equals(playerInfo[1])){
            newPlayer = playerDataBase.getPlayer();

            System.out.println(newPlayer.getPoints());
            System.out.println(newPlayer.getColour());
            System.out.println(newPlayer.getbackColour());
            System.out.println(newPlayer.getGameNum());

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

    public void startPictureGame(){
        Intent intent = new Intent(this, PictureGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startWarGame(){
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startSudokuGame(){
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
