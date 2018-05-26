package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
     TextView storyText;
     Button topButton ;
     Button bottomButton ;
     int currentScene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);
        if(savedInstanceState != null)
        {
            currentScene= savedInstanceState.getInt("Currentscene");

        }
        else
        {
            currentScene = 1;
        }
        gotoScene(currentScene);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(currentScene == 1)
             {
gotoScene(3);

             }
             else if( currentScene == 2)
             {
                 gotoScene(3);
             }
             else
             {
                 gotoScene(5);
             }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentScene == 1)
                {
                    gotoScene(2);

                }
                else if( currentScene == 2)
                {
                    gotoScene(4);
                }
                else
                {
                    gotoScene(5);
                }
            }
        });

    }
    public void gotoScene(int scene)
    {
        currentScene = scene;
      if(scene == 1)
      {
          storyText.setText(R.string.T1_Story);
          topButton.setText(R.string.T1_Ans1);
          bottomButton.setText(R.string.T1_Ans2);
      }
      else if(scene == 2)
      {
          storyText.setText(R.string.T2_Story);
          topButton.setText(R.string.T2_Ans1);
          bottomButton.setText(R.string.T2_Ans2);
      }
      else if(scene == 3)
      {
          storyText.setText(R.string.T3_Story);
          topButton.setText(R.string.T3_Ans1);
          bottomButton.setText(R.string.T3_Ans2);
      }
      else if(scene == 4)
      {
          storyText.setText(R.string.T4_End);
          topButton.setText(R.string.T5_End);
          bottomButton.setText(R.string.T6_End);
      }
      else
      {
          AlertDialog.Builder alert =  new AlertDialog.Builder(this);
          alert.setTitle("Game Over");
          alert.setCancelable(false);
          alert.setMessage("You have reached the conclusion of your Quest!!!!");
          alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  finish();
              }
          });
          alert.show();
      }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("Currentscene", currentScene);

    }
}
