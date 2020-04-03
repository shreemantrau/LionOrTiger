package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{
        NO,ONE,TWO
    }

    private GridLayout gridLayout;
    private Player currentPLayer = Player.ONE;
    private Player [] playerChoices=new Player[]{Player.NO,Player.NO,Player.NO,Player.NO,Player.NO,Player.NO,Player.NO,Player.NO,Player.NO};

    private boolean flag=false;
    TextView playerOneScore;
    TextView playerTwoScore;
    int player_one=0;
    int player_two=0;
    private Button resetButton;
    int[][] winningValues=new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetButton=findViewById(R.id.resetBtn);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }

    public void imageViewIsClicked(View image){

        ImageView img = (ImageView) image;
        playerOneScore=findViewById(R.id.playerOneScore);
        playerTwoScore=findViewById(R.id.playerTwoScore);
        int tiTag=Integer.parseInt(img.getTag().toString());
        if(playerChoices[tiTag]==Player.NO && flag==false) {
            playerChoices[tiTag] = currentPLayer;
            img.setTranslationX(-2000);
            if (currentPLayer == Player.ONE) {
                img.setImageResource(R.drawable.lion);
                currentPLayer = Player.TWO;
            } else if (currentPLayer == Player.TWO) {
                img.setImageResource(R.drawable.tiger);
                currentPLayer = Player.ONE;
            }
            img.animate().translationXBy(2000).rotation(3600).setDuration(2000);

            for (int[] array : winningValues) {
                if (playerChoices[array[0]] == playerChoices[array[1]] && playerChoices[array[1]] == playerChoices[array[2]] && playerChoices[array[0]] != Player.NO) {
                    if (currentPLayer == Player.ONE) {
                        Toast.makeText(this, "Player two is the winner!", Toast.LENGTH_SHORT).show();
                        player_two++;
                        playerOneScore.setText(player_one+"");
                        playerTwoScore.setText(player_two+"");

                    } else {
                        Toast.makeText(this, "Player One is the winner", Toast.LENGTH_SHORT).show();
                        player_one++;
                        playerOneScore.setText(player_one+"");
                        playerTwoScore.setText(player_two+"");
                    }

                    flag=true;
                    resetButton=findViewById(R.id.resetBtn);
                    resetButton.animate().alpha(1).setDuration(4000);
                }

            }
        }

    }

    private void resetGame(){
        gridLayout=findViewById(R.id.gl);
        for(int i=0;i<gridLayout.getChildCount();i++){
            ImageView imageView=(ImageView) gridLayout.getChildAt(i);
            imageView.setImageDrawable(null);
        }

        currentPLayer=Player.ONE;

        for(int i=0;i< playerChoices.length;i++){
            playerChoices[i]=Player.NO;
        }
        resetButton=findViewById(R.id.resetBtn);
        resetButton.animate().alpha(1);
        flag=false;


    }


}
