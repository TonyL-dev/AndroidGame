package com.example.game.PictureGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.ChooseGame;
import com.example.game.MainActivity;
import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;
import com.example.game.SudokuGame.SudokuActivity;

public class PictureEndScreenActivity extends AppCompatActivity {

    Player newPlayer;

    TextView textView;

    PlayerDataBase playerDataBase;

    int points;

    double timeInSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_end_screen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);

        textView = findViewById(R.id.endGameStatsPic);
        textView.setTextSize(23);
        textView.setText(newPlayer.toString());

        // get the color user want for numbers they write on the board and change it accordingly.
        if (newPlayer.getColour() != 0) {
            textView.setTextColor(newPlayer.getColour());
        }

        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

        //If a Player backs out before continuing to the next game, the data will not be saved
//        newPlayer.subtractPoints(points);
//        newPlayer.subtractTime();
//        playerDataBase.storePlayerData(newPlayer);

        newPlayer.reset();

        /** If a Player backs out before continuing to the next game, the data will not be saved */
        playerDataBase.storePlayerData(newPlayer);

        Button nextGame = findViewById(R.id.button4);
        nextGame.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        newPlayer.reset(); // resets Player statistics
//                        playerDataBase.storePlayerData(newPlayer);
                        Intent intent = new Intent(v.getContext(), ChooseGame.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("player", newPlayer);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
    }

}
