package ly.rqmana.basmaty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2500);

    }
}
