package udg.mxc.aplication1.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;

public class AnimationsActivity extends AppCompatActivity {

    @BindView( R.id.androidImage ) ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        ButterKnife.bind(this);
    }

    @OnClick( R.id.buttonZoom ) public void zoom(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.myanimation);
        imageView.startAnimation(animation);
    }

    @OnClick( R.id.buttonClockWise ) public void clockwise(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        imageView.startAnimation(animation);
    }

    @OnClick( R.id.buttonFade ) public void fade(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        imageView.startAnimation(animation);
    }

    @OnClick( R.id.buttonBlink ) public void blink(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        imageView.startAnimation(animation);
    }

    @OnClick( R.id.buttonMove ) public void move(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);
        imageView.startAnimation(animation);
    }

    @OnClick( R.id.buttonSlide ) public void slide(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);
        imageView.startAnimation(animation);
    }
}
