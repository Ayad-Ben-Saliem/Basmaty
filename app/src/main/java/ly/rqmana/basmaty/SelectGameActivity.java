package ly.rqmana.basmaty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageView;
import android.view.MotionEvent;
import android.view.View;

public class SelectGameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_game);

    }

    public void onGameClicked(View view) {
        switch (view.getId()) {
            case R.id.mentalGameIV:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.trueFalseGameIV:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.educationalGameIV:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
