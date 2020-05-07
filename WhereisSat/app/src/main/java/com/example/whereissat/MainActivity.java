package com.example.whereissat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.whereissat.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        final ImageView image = findViewById(R.id.satArrow);


        final Handler handler = new Handler();
        final int delay = 100; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){
                image.setRotation(image.getRotation()+1);
                handler.postDelayed(this, delay);
            }
        }, delay);
    }

}
