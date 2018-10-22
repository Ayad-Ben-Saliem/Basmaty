package ly.rqmana.basmaty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class TrueFalseGameActivity extends AppCompatActivity {
    ImageView images;
    ImageButton btnPre, btnNext;
    int count = 0;

    int[] pictures = {
            R.drawable.cat,
            R.drawable.eat,
            R.drawable.friends,
            R.drawable.trush,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = (ImageView) findViewById(R.id.switchs);
        btnPre = (ImageButton) findViewById(R.id.pre);
        btnNext = (ImageButton) findViewById(R.id.next);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                loadImage(count);
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                loadImage(count);
            }
        });

        loadImage(count);

    }
    public void loadImage(int ImageId)
    {
        images.setImageResource(pictures[ImageId]);

        if(count==0)
        {
            btnPre.setEnabled(false);
            btnPre.setImageResource(R.drawable.pre1);
        }
        else if(count==3)
        {
            btnNext.setImageResource(R.drawable.next1);
            btnNext.setEnabled(false);
        }
        else
        {
            btnPre.setImageResource(R.drawable.pre);
            btnPre.setEnabled(true);
            btnNext.setEnabled(true);
            btnNext.setImageResource(R.drawable.next);
        }
    }

}