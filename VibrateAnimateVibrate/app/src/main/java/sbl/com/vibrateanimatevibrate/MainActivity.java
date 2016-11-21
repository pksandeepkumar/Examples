package sbl.com.vibrateanimatevibrate;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;
    private final int MY_PERMISSIONS_REQUEST_VIBRATE = 1231;
    Animation shake;
    Vibrator vibrator;

    ImageView imPlus;

    long animationStartTime = 0;
    long projectedEndTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        imPlus = (ImageView) findViewById(R.id.imPlus);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.VIBRATE)
                != PackageManager.PERMISSION_GRANTED) { ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.VIBRATE},
                MY_PERMISSIONS_REQUEST_VIBRATE);
            return;
        }

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        shake = AnimationUtils.loadAnimation(this, R.anim.vibrate);
        shake.setInterpolator(new AccelerateInterpolator());
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animationStartTime = System.currentTimeMillis();
                projectedEndTime = animationStartTime + SPLASH_TIME_OUT;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                long differenceTime = System.currentTimeMillis() - animationStartTime;
                animation.setDuration(getDurationPercentage(
                        getPercentage(SPLASH_TIME_OUT,differenceTime)));
            }
        });

        imPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startDelayAndGotoSeconActivity();
                vibrator.vibrate((long)1000);
                imPlus.startAnimation(shake);

            }
        });
    }


    public long getDurationPercentage(float percentage) {
        if(percentage < 10f) return 30;
        if(percentage < 20f) return 27;
        if(percentage < 30f) return 24;
        if(percentage < 40f) return 21;
        if(percentage < 50f) return 18;
        if(percentage < 60f) return 15;
        if(percentage < 70f) return 12;
        if(percentage < 80f) return 9;
        if(percentage < 90f) return 3;
        if(percentage < 100f) return 1;
        return 1;
    }

    public float getPercentage(long total, long number){
        return 100f * number / total;
    }

    private void startDelayAndGotoSeconActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startSecondActivity();
            }
        }, SPLASH_TIME_OUT);
    }

    public void startSecondActivity() {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }


}
