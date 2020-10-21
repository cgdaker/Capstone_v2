package edu.usna.capstone.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void footballScore(View v){
        Intent toSend = new Intent(this, FootballActivity.class);
        startActivity(toSend);
    }
}
