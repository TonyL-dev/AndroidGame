import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;
import com.example.game.TestClass;

public class WarGameEndScreen2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_game);
    }

    public void playSudokuGame(View view){
        Intent intent = new Intent(this, TestClass.class);
        startActivity(intent);
    }
}
