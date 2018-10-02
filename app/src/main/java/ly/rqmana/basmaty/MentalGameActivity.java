package ly.rqmana.basmaty;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MentalGameActivity extends AppCompatActivity {

    View draggingView;
    boolean isViewCatched;
    private ImageView circle;
    private ImageView rectangle;
    private ImageView square;
    private ImageView triangle;
    private ImageView circlePlace;
    private ImageView rectanglePlace;
    private ImageView squarePlace;
    private ImageView trianglePlace;
    private ConstraintLayout rootLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_game);

        circle = findViewById(R.id.circle);
        rectangle = findViewById(R.id.rectangle);
        square = findViewById(R.id.square);
        triangle = findViewById(R.id.triangle);
        circlePlace = findViewById(R.id.circlePlace);
        rectanglePlace = findViewById(R.id.rectanglePlace);
        trianglePlace = findViewById(R.id.trianglePlace);
        squarePlace = findViewById(R.id.squarePlace);
        rootLayout = findViewById(R.id.rootLayout);

        rootLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if(dragEvent.getAction()== DragEvent.ACTION_DRAG_ENDED)
                {
                    if(!isViewCatched)
                    {
                        draggingView.setVisibility(View.VISIBLE);
                    }
                }
                return true;
            }
        });

        View.OnDragListener dragListener =new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if(dragEvent.getAction()== DragEvent.ACTION_DROP )
                {
                    if(view.equals(circlePlace)&&draggingView.equals(circle) ||
                            view.equals(squarePlace)&&draggingView.equals(square) ||
                            view.equals(rectanglePlace)&&draggingView.equals(rectangle) ||
                            view.equals(trianglePlace)&&draggingView.equals(triangle) )
                    {
                        isViewCatched = true;
                        Bitmap bitmap = ((BitmapDrawable) ((AppCompatImageView) draggingView).getDrawable()).getBitmap();
                        ((AppCompatImageView) view).setImageBitmap(bitmap);
                    }
                }

                return true;
            }
        };

        View.OnTouchListener listener =new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isViewCatched = false;
                view.startDrag(null,new View.DragShadowBuilder(view),null,0);
                view.setVisibility(View.INVISIBLE);
                draggingView = view;

                return false;
            }
        };

        circle.setOnTouchListener(listener);
        rectangle.setOnTouchListener(listener);
        square.setOnTouchListener(listener);
        triangle.setOnTouchListener(listener);

        circlePlace.setOnDragListener(dragListener);
        rectanglePlace.setOnDragListener(dragListener);
        squarePlace.setOnDragListener(dragListener);
        trianglePlace.setOnDragListener(dragListener);
    }
}
