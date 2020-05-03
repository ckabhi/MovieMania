package abhishekkumar.moviemania.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Interpolator;

import abhishekkumar.moviemania.Controler.ApiClient;
import abhishekkumar.moviemania.Controler.ApiInterface;
import abhishekkumar.moviemania.Model.HomePageRespons;
import abhishekkumar.moviemania.R;
import abhishekkumar.moviemania.View.MainActivity;
import retrofit2.Call;

public class SplashScreen extends AppCompatActivity {
    String APIKEY="5a05b0f74b9986a3f1deb838cec732c2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();

            }
        },1000);



    }

}
