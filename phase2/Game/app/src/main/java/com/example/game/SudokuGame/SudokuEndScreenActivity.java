package com.example.game.SudokuGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.PlayerPackage.ChooseGame;
import com.example.game.PlayerPackage.Player;
import com.example.game.PlayerPackage.PlayerDataBase;
import com.example.game.R;

public class SudokuEndScreenActivity extends AppCompatActivity {

    /**
     * player object.
     */
    Player newPlayer;

    TextView textView;

    PlayerDataBase playerDataBase;

    int temp;

    /**
     * the time the user used in the game.
     */
    double timeInSeconds;

    /**
     * Create the interface when user finished the game.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_end_screen);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        String sudokupoint = bundle.getString("points");
        temp = (int) bundle.getSerializable("temp");
        timeInSeconds = (double) bundle.getSerializable("time");
        playerDataBase = new PlayerDataBase(this);

        newPlayer.addTime(timeInSeconds);

        textView = findViewById(R.id.endState);
        textView.setTextSize(23);

        // show the points and time used by user in Sudoku and that in the 3 games in total.
        String s = sudokupoint + newPlayer.toString();
        textView.setText(s);

        // get the color user want for numbers they write on the board and change it accordingly.
        if (newPlayer.getColour() != 0) textView.setTextColor(newPlayer.getColour());
        if (newPlayer.getBackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getBackColour());
        }

        /** If a Player backs out before continuing to the next game, the data will not be saved */
        newPlayer.subtractPoints(temp);
        newPlayer.subtractTime();
        playerDataBase.storePlayerData(newPlayer);

        Button nextGame = findViewById(R.id.button3);
        nextGame.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newPlayer.reset(); // resets Player statistics
                        playerDataBase.storePlayerData(newPlayer);
                        Intent intent = new Intent(v.getContext(), ChooseGame.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("player", newPlayer);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

        Button nextLevel = findViewById(R.id.button10);
        nextLevel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newPlayer.addPoints(temp);
                        newPlayer.addTime(timeInSeconds);
                        Intent intent = new Intent(v.getContext(), SudokuEnterGameActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("player", newPlayer);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
    }
}
