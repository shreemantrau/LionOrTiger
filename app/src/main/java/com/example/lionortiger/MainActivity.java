package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{
        ONE,TWO
    }


    Player currentPLayer = Player.ONE;
    Player [] playerChoices=new Player[9];

    int[][] winningValues=new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void imageViewIsClicked(View image){

        ImageView img = (ImageView) image;
        int tiTag=Integer.parseInt(img.getTag().toString());
        playerChoices[tiTag]=currentPLayer;
        img.setTranslationX(-2000);
        if (currentPLayer == Player.ONE) {
            img.setImageResource(R.drawable.lion);
            currentPLayer = Player.TWO;
            } else if (currentPLayer == Player.TWO) {
                img.setImageResource(R.drawable.tiger);
                currentPLayer = Player.ONE;
            }
        img.animate().translationXBy(2000).rotation(3600).setDuration(2000);

        for(int[] array:winningValues){
            if(playerChoices[array[0]]==playerChoices[array[1]] && playerChoices[array[1]]==playerChoices[array[2]] && playerChoices[array[0]] != null ){
                if(currentPLayer == Player.ONE){
                Toast.makeText(this,"Player two is the winner!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Player One is the winner",Toast.LENGTH_SHORT).show();
                }
            }

        }

    }


}
