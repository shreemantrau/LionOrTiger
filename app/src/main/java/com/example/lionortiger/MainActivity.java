package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void imageViewIsClicked(View tappedImage){
        ImageView img=(ImageView) tappedImage;
        img.setTranslationX(-2000);
        img.setImageResource(R.drawable.lion);
        img.animate().translationXBy(2000).rotation(3600).setDuration(2000);
    }
}
