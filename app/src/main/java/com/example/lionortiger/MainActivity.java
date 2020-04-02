package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    enum Player{
        ONE,TWO
    }
    Player currentPLayer = Player.ONE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageViewIsClicked(View tappedImage){
        ImageView img=(ImageView) tappedImage;
        img.setTranslationX(-2000);
        if(currentPLayer == Player.ONE) {
            img.setImageResource(R.drawable.lion);
            currentPLayer=Player.TWO;
        } else if(currentPLayer == Player.TWO){
            img.setImageResource(R.drawable.tiger);
            currentPLayer=Player.ONE;
        }
        img.animate().translationXBy(2000).rotation(3600).setDuration(2000);
    }
}
