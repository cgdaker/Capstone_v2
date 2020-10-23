package edu.usna.capstone.actual_capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button weatherButton;
    private Button footballButton;
    private Button eventButton;
    private Button mailButton;
    private LinearLayout mainLayout;
    private ArrayList<Button> buttonList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get buttons
        this.weatherButton = findViewById(R.id.weather);
        this.footballButton = findViewById(R.id.football);
        this.eventButton = findViewById(R.id.event);
        this.mailButton = findViewById(R.id.mail);
        this.mainLayout = findViewById(R.id.main);

        //add buttons to list to order
        addToList();
        removeAll();
        addAll();
    }

    public void footballScore(View v){
        Intent toSend = new Intent(this, FootballActivity.class);
        startActivity(toSend);
    }

    private void addToList(){

        //add the buttons initially
        buttonList.add(weatherButton);
        buttonList.add(footballButton);
        buttonList.add(eventButton);
        buttonList.add(mailButton);

    }

    private void removeAll(){
        for (int i=0; i<buttonList.size(); i++){
            mainLayout.removeView(buttonList.get(i));
        }
    }

    private void addAll(){
        for (int i=0; i<buttonList.size(); i++){
            mainLayout.addView(buttonList.get(i));
        }
    }
}
