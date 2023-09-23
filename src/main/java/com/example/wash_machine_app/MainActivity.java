package com.example.wash_machine_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn2 = (Button) findViewById(R.id.btn2);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textView = findViewById(R.id.textView);
        textView.setText(currentDate);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("WASH IT");

        Thread myThread = null;

        Runnable runnable = new CountDownRunner();
        myThread= new Thread(runnable);
        myThread.start();

        Button BtnMove = findViewById(R.id.button3);
        BtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        Button BtnMove1 = findViewById(R.id.button);
        BtnMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent1);
            }
        });

    }

    public void clickexit (View v) {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{
                    TextView textView3= (TextView)findViewById(R.id.textView3);
                    Date dt = new Date();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    //int seconds = dt.getSeconds();
                    String curTime = hours + ":" + minutes /*+ ":" + seconds*/;
                    textView3.setText(curTime);
                }catch (Exception e) {}
            }
        });
    }

    class CountDownRunner implements Runnable{
        // @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }
}