package edu.usna.capstone.capstone;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import androidx.appcompat.app.AppCompatActivity;

public class FootballActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);

        TextView a = findViewById(R.id.serverResponse);
        MyTask task = new MyTask();
        try {
            task.execute(a).get();
        } catch (Exception e){}
        System.out.println(task.getResult());
        a.setText(task.getResult());
     }
}

//taken from tutorialspoint and stackexchange
class MyTask extends AsyncTask<TextView, Void, Void> {
    String result;

    @Override
    protected Void doInBackground(TextView... textViews) {
        URL url;
        TextView show = textViews[0];
        try {
            url = new URL("https://navysports.com/sports/football");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            StringBuffer stringBuffer = new StringBuffer();

            while (sc.hasNext()){
                stringBuffer.append(sc.next());
            }

            System.out.println(stringBuffer.toString());
            this.result = stringBuffer.toString();
        } catch (IOException e){
            //e.printStackTrace();
            //result = e.toString();
        }
        return null;
    }

    protected String getResult(){
        System.out.println("in get result:" + this.result);
        return this.result;
    }
}