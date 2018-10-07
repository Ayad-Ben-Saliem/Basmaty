package ly.rqmana.basmaty;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class Common {

    public static void showDoneDialog(Context context) {
        Dialog dialog = new Dialog(context);
        AppCompatImageView iv = new AppCompatImageView(context);
        iv.setImageResource(R.drawable.basmaty_logo);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 500);
        iv.setAdjustViewBounds(true);
        dialog.setContentView(iv, params);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        Animation fadeAnimation = new AlphaAnimation(1, 0);
        fadeAnimation.setStartOffset(2000);
        fadeAnimation.setDuration(500);
        iv.setAnimation(fadeAnimation);
        fadeAnimation.start();
        fadeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                dialog.cancel();
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
    }
}
