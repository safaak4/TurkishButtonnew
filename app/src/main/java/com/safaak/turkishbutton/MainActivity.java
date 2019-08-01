package com.safaak.turkishbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    ImageView turkishbutton;
    MediaPlayer turkishsoundd;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2480250351827652/2561254047");

        turkishbutton = findViewById(R.id.imageView);
        turkishsoundd = MediaPlayer.create(this, R.raw.turkishbuttonsound);

        i = 0;


    }

    public void buttonpress(View view){

        turkishbutton.setImageResource(R.drawable.turkishbutton_pressed);
        turkishsoundd.start();

        Handler hndler= new Handler();
        hndler.postDelayed(new Runnable() {
            @Override
            public void run() {
                turkishbutton.setImageResource(R.drawable.turkishbutton);

            }
        },130);

        i++;

        if(i % 7 == 0){
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }else if((i+2) % 7 == 0){
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }

    }


}
