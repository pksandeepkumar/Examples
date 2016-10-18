package texus.anmatviewfrmonelayttoanthr;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final int ANIMATION_SPEED = 3000;
    private RelativeLayout rootView;
    private LinearLayout fromLayout, tolayout;
    private Button btn0, btn1, btn2, btn3;
    private Button shuttleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        rootView = (RelativeLayout) this.findViewById(R.id.rlHolder);
        fromLayout = (LinearLayout) this.findViewById(R.id.llFromLayout);
        tolayout = (LinearLayout) this.findViewById(R.id.llToLayout);

        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        btn3 = (Button) this.findViewById(R.id.btn3);
        shuttleView = (Button) findViewById(R.id.shuttle);
    }

    public void moveMe(View view) {

        final View fromView = view;

        Rect fromRect = new Rect();
        Rect toRect = new Rect();
        fromView.getGlobalVisibleRect(fromRect);
        tolayout.getGlobalVisibleRect(toRect);

        AnimatorSet animatorSet = getViewToViewScalingAnimator(rootView,
                shuttleView, fromRect, toRect, ANIMATION_SPEED, 0);

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Button btnFrom = (Button)fromView;
                shuttleView.setText(btnFrom.getText());
                shuttleView.setVisibility(View.VISIBLE);
//                fromView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shuttleView.setVisibility(View.GONE);
                fromView.setVisibility(View.VISIBLE);
                tolayout.removeAllViews();
                Button btnFrom = (Button)fromView;
                Button btn = new Button(MainActivity.this);

                btn.setText( btnFrom.getText());
                tolayout.addView(btn);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }


    public static AnimatorSet getViewToViewScalingAnimator(final RelativeLayout parentView,
                                                           final View viewToAnimate,
                                                           final Rect fromViewRect,
                                                           final Rect toViewRect,
                                                           final long duration,
                                                           final long startDelay) {
        // get all coordinates at once
        final Rect parentViewRect = new Rect(), viewToAnimateRect = new Rect();
        parentView.getGlobalVisibleRect(parentViewRect);
        viewToAnimate.getGlobalVisibleRect(viewToAnimateRect);

        viewToAnimate.setScaleX(1f);
        viewToAnimate.setScaleY(1f);

        // rescaling of the object on X-axis
        final ValueAnimator valueAnimatorWidth = ValueAnimator.ofInt(fromViewRect.width(), toViewRect.width());
        valueAnimatorWidth.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // Get animated width value update
                int newWidth = (int) valueAnimatorWidth.getAnimatedValue();

                // Get and update LayoutParams of the animated view
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) viewToAnimate.getLayoutParams();

                lp.width = newWidth;
                viewToAnimate.setLayoutParams(lp);
            }
        });

        // rescaling of the object on Y-axis
        final ValueAnimator valueAnimatorHeight = ValueAnimator.ofInt(fromViewRect.height(), toViewRect.height());
        valueAnimatorHeight.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // Get animated width value update
                int newHeight = (int) valueAnimatorHeight.getAnimatedValue();

                // Get and update LayoutParams of the animated view
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) viewToAnimate.getLayoutParams();
                lp.height = newHeight;
                viewToAnimate.setLayoutParams(lp);
            }
        });

        // moving of the object on X-axis
        ObjectAnimator translateAnimatorX = ObjectAnimator.ofFloat(viewToAnimate,
                "X", fromViewRect.left - parentViewRect.left, toViewRect.left - parentViewRect.left);

        // moving of the object on Y-axis
        ObjectAnimator translateAnimatorY = ObjectAnimator.ofFloat(viewToAnimate,
                "Y", fromViewRect.top - parentViewRect.top, toViewRect.top - parentViewRect.top);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new DecelerateInterpolator(1f));
        animatorSet.setDuration(duration); // can be decoupled for each animator separately
        animatorSet.setStartDelay(startDelay); // can be decoupled for each animator separately
        animatorSet.playTogether(valueAnimatorWidth, valueAnimatorHeight, translateAnimatorX, translateAnimatorY);

        return animatorSet;
    }
}
