package com.example.game.PictureGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.PlayerPackage.ChooseGame;
import com.example.game.PlayerPackage.Player;
import com.example.game.PlayerPackage.PlayerDataBase;
import com.example.game.R;

public class PictureEndScreenActivity extends AppCompatActivity {

    /**
     * Player object
     */
    Player newPlayer;

    TextView textView;
    TextView tempTextView;
    TextView tempTextView2;
    CountDownTimer timer; // timer for movie

    /**
     * Player database
     */
    PlayerDataBase playerDataBase;

    PictureGame p1, p2, p3;

    int level = 1;

    /**
     * Created on run and creates a display for the user to return to the ChooseGame activity.
     * The user can also see the total time taken for the game and the number of points
     * accumulated.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_end_screen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        p1 = (PictureGame) bundle.getSerializable("p1");
        p2 = (PictureGame) bundle.getSerializable("p2");
        p3 = (PictureGame) bundle.getSerializable("p3");

        playerDataBase = new PlayerDataBase(this);

        int time = (p1.getInstantReplayOrder().size() + p2.getInstantReplayOrder().size()
                + p3.getInstantReplayOrder().size()) * 2000;

        // create timer for when instant replay
        timer = new CountDownTimer(time + 4000, 2000) {
            PictureGame replayPG;

            @Override
            public void onTick(long l) {
                // set the current PictureGame based on what level it is
                if (level == 1) {
                    replayPG = p1;
                } else if (level == 2) {
                    replayPG = p2;
                } else {
                    replayPG = p3;
                }

                // if instant replay is done for this level, move onto the next level
                if (replayPG.getInstantReplayOrder().size() == 0) {
                    level++;
                    nextLevel(level);
                } else {
                    // set ImageView to be invisible
                    findViewById(R.id.pictureGameLayout).findViewWithTag
                            (replayPG.getInstantReplayOrder().get(0).
                                    getName()).setVisibility(View.INVISIBLE);
                    replayPG.getInstantReplayOrder().get(0).setIsHiddenImage(false);
                    replayPG.getInstantReplayOrder().remove(0);

                    ((TextView) findViewById(R.id.listOfFruits)).setText(replayPG.picsToFind());
                }
            }

            @Override
            public void onFinish() {
                // when timer is finished
                setContentView(R.layout.activity_picture_end_screen);
                View replayButton = findViewById(R.id.replayButton);
                replayButton.setVisibility(View.GONE);
            }
        };

        textView = findViewById(R.id.endGameStatsPic);
        textView.setText(newPlayer.toString());

        // get the color user want for numbers they write on the board and change it accordingly.
        if (newPlayer.getColour() != 0) {
            textView.setTextColor(newPlayer.getColour());
        }

        if (newPlayer.getBackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getBackColour());
        }

        newPlayer.reset();

        //If a Player backs out before continuing to the next game, the data will not be saved
        playerDataBase.storePlayerData(newPlayer);

    }

    public void chooseNewGame(View view) {
        Intent intent = new Intent(this, ChooseGame.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void instantReplay(View view) {
        nextLevel(level);
        timer.start();
    }

    private void nextLevel(int level) {
        setContentView(R.layout.activity_picture_game);

        tempTextView2 = findViewById(R.id.textView2);

        if (level == 1) {
            setGameBoard(p1);
            tempTextView = findViewById(R.id.listOfFruits);
            tempTextView.setText(p1.picsToFind());
        }
        if (level == 2) {
            setGameBoard(p2);
            tempTextView = findViewById(R.id.listOfFruits);
            tempTextView.setText(p2.picsToFind());
        }
        if (level == 3) {
            setGameBoard(p3);
            tempTextView = findViewById(R.id.listOfFruits);
            tempTextView.setText(p3.picsToFind());
        }

        if (newPlayer.getColour() != 0) {
            tempTextView.setTextColor(newPlayer.getColour());
            tempTextView2.setTextColor(newPlayer.getColour());
        }
    }

    private void setGameBoard(PictureGame pictureGame) {

        if (level == 2) {
            findViewById(R.id.redBackground).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.redBackground).setVisibility(View.INVISIBLE);
        }
        ((ImageView) findViewById(R.id.one)).
                setImageResource(pictureGame.getPictures()[0].getImage());
        findViewById(R.id.one).setTag(pictureGame.getPictures()[0].getName());

        ((ImageView) findViewById(R.id.two)).
                setImageResource(pictureGame.getPictures()[1].getImage());
        findViewById(R.id.two).setTag(pictureGame.getPictures()[1].getName());

        ((ImageView) findViewById(R.id.three)).
                setImageResource(pictureGame.getPictures()[2].getImage());
        findViewById(R.id.three).setTag(pictureGame.getPictures()[2].getName());

        ((ImageView) findViewById(R.id.four)).
                setImageResource(pictureGame.getPictures()[3].getImage());
        findViewById(R.id.four).setTag(pictureGame.getPictures()[3].getName());

        ((ImageView) findViewById(R.id.five)).
                setImageResource(pictureGame.getPictures()[4].getImage());
        findViewById(R.id.five).setTag(pictureGame.getPictures()[4].getName());

        ((ImageView) findViewById(R.id.six)).
                setImageResource(pictureGame.getPictures()[5].getImage());
        findViewById(R.id.six).setTag(pictureGame.getPictures()[5].getName());

        ((ImageView) findViewById(R.id.seven)).
                setImageResource(pictureGame.getPictures()[6].getImage());
        findViewById(R.id.seven).setTag(pictureGame.getPictures()[6].getName());

        ((ImageView) findViewById(R.id.eight)).
                setImageResource(pictureGame.getPictures()[7].getImage());
        findViewById(R.id.eight).setTag(pictureGame.getPictures()[7].getName());

        ((ImageView) findViewById(R.id.nine)).
                setImageResource(pictureGame.getPictures()[8].getImage());
        findViewById(R.id.nine).setTag(pictureGame.getPictures()[8].getName());

        ((ImageView) findViewById(R.id.ten)).
                setImageResource(pictureGame.getPictures()[9].getImage());
        findViewById(R.id.ten).setTag(pictureGame.getPictures()[9].getName());

        ((ImageView) findViewById(R.id.eleven)).
                setImageResource(pictureGame.getPictures()[10].getImage());
        findViewById(R.id.eleven).setTag(pictureGame.getPictures()[10].getName());

        ((ImageView) findViewById(R.id.twelve)).
                setImageResource(pictureGame.getPictures()[11].getImage());
        findViewById(R.id.twelve).setTag(pictureGame.getPictures()[11].getName());

        findViewById(R.id.one).setVisibility(View.VISIBLE);
        findViewById(R.id.two).setVisibility(View.VISIBLE);
        findViewById(R.id.three).setVisibility(View.VISIBLE);
        findViewById(R.id.four).setVisibility(View.VISIBLE);
        findViewById(R.id.five).setVisibility(View.VISIBLE);
        findViewById(R.id.six).setVisibility(View.VISIBLE);
        findViewById(R.id.seven).setVisibility(View.VISIBLE);
        findViewById(R.id.eight).setVisibility(View.VISIBLE);
        findViewById(R.id.nine).setVisibility(View.VISIBLE);
        findViewById(R.id.ten).setVisibility(View.VISIBLE);
        findViewById(R.id.eleven).setVisibility(View.VISIBLE);
        findViewById(R.id.twelve).setVisibility(View.VISIBLE);

        findViewById(R.id.one).setClickable(false);
        findViewById(R.id.two).setClickable(false);
        findViewById(R.id.three).setClickable(false);
        findViewById(R.id.four).setClickable(false);
        findViewById(R.id.five).setClickable(false);
        findViewById(R.id.six).setClickable(false);
        findViewById(R.id.seven).setClickable(false);
        findViewById(R.id.eight).setClickable(false);
        findViewById(R.id.nine).setClickable(false);
        findViewById(R.id.ten).setClickable(false);
        findViewById(R.id.eleven).setClickable(false);
        findViewById(R.id.twelve).setClickable(false);
    }

}
