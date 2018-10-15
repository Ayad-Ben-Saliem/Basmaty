package ly.rqmana.basmaty;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MentalGame2Activity extends AppCompatActivity {
    View draggingView;
    boolean isViewCached;
    private ImageView One;
    private ImageView Two;
    private ImageView Three;
    private ImageView Four;
    private ImageView OneEmpty;
    private ImageView TwoEmpty;
    private ImageView ThreeEmpty;
    private ImageView FourEmpty;

    private int draggedView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_game2);

        One = findViewById(R.id.One);
        Two = findViewById(R.id.Two);
        Three = findViewById(R.id.Three);
        Four = findViewById(R.id.Four);
        OneEmpty = findViewById(R.id.OneEmpty);
        TwoEmpty = findViewById(R.id.TwoEmpty);
        ThreeEmpty = findViewById(R.id.ThreeEmpty);
        FourEmpty = findViewById(R.id.FourEmpty);
        ConstraintLayout rootTwoLayout = findViewById(R.id.rootTwoLayout);

        rootTwoLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if(dragEvent.getAction()== DragEvent.ACTION_DRAG_ENDED)
                {
                    if(!isViewCached)
                    {
                        draggingView.setVisibility(View.VISIBLE);
                    }
                }
                return true;
            }
        });

        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if(dragEvent.getAction()== DragEvent.ACTION_DROP )
                {
                    if(view.equals(OneEmpty)&&draggingView.equals(One) ||
                            view.equals(TwoEmpty)&&draggingView.equals(Two) ||
                            view.equals(ThreeEmpty)&&draggingView.equals(Three) ||
                            view.equals(FourEmpty)&&draggingView.equals(Four) )
                    {
                        isViewCached = true;
                        Bitmap bitmap = ((BitmapDrawable) ((AppCompatImageView) draggingView).getDrawable()).getBitmap();
                        ((AppCompatImageView) view).setImageBitmap(bitmap);
                        draggedView++;
                        if(draggedView == 4) {
                            Common.showDoneDialog(MentalGame2Activity.this);
                        }
                    }
                }

                return true;
            }
        };

        View.OnTouchListener listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isViewCached = false;
                view.startDrag(null,new View.DragShadowBuilder(view),null,0);
                view.setVisibility(View.INVISIBLE);
                draggingView = view;

                return false;
            }
        };

        One.setOnTouchListener(listener);
        Two.setOnTouchListener(listener);
        Three.setOnTouchListener(listener);
        Four.setOnTouchListener(listener);

        OneEmpty.setOnDragListener(dragListener);
        TwoEmpty.setOnDragListener(dragListener);
        ThreeEmpty.setOnDragListener(dragListener);
        FourEmpty.setOnDragListener(dragListener);

    }
}
