package texus.cardroundedcorneritem;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initActivity2();



    }

    public void initActivity1() {
        setContentView(R.layout.activity_main);

        ImageView imImage = (ImageView) this.findViewById(R.id.imImage);
        ImageView imBottomImage = (ImageView) this.findViewById(R.id.imBottomImage);

        int sCorner = 50;
        int sMargin = 0;

//        Glide.with(imImage.getContext())
//                .load("http://www.fnstatic.co.uk/images/content/article/" +
//                        "the-hottest-game-of-food-tinder-you-ll-ever-play.jpeg")
//                .bitmapTransform(new RoundedCornersTransformation( MainActivity.this,sCorner, sMargin))
//                .into(imImage);

        String image = "http://www.fastfoodmenunutrition.com/wp-content/uploads/2015/03/fast-food.jpg";
        image = "http://www.fnstatic.co.uk/images/content/article/" +
                "the-hottest-game-of-food-tinder-you-ll-ever-play.jpeg";

        Glide.with(this)
                .load(image)
                .bitmapTransform(new RoundedCornersTransformation( MainActivity.this,sCorner, sMargin))
                .into(imImage);
    }


    public void initActivity2() {
        setContentView(R.layout.activity_main_picasso);
//        CardVie cardView = (CardView) findViewById(R.id.cv);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("", "CardView clicked");
//            }
//        });

        ImageView imageView = (ImageView) findViewById(R.id.iv);
        String image = "http://o.aolcdn.com/hss/storage/midas/" +
                "19dcdabec46a02182add1b78b897392/202720874/google-pixel-c-1200.jpg";
        image = "http://www.fnstatic.co.uk/images/content/article/" +
                "the-hottest-game-of-food-tinder-you-ll-ever-play.jpeg";
        Glide.with(imageView.getContext())
                .load(image)
//                .resize(dp2px(220), 0)
                .into(imageView);
    }

    public int dp2px(int dp) {
        WindowManager wm = (WindowManager) this.getBaseContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int) (dp * displaymetrics.density + 0.5f);
    }
}
