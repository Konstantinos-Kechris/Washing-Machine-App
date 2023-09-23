package com.example.wash_machine_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    TextView showText;
    int progressBarValue = 0;
    Handler handler = new Handler();
    Button start_stop_progressBar,finish_progressBar;
    boolean isStart = false;
    boolean flag = false;
    boolean Btn_flag = false;
    private final int pBarMax = 3600;
    boolean temp_flag2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        final ProgressBar pbar = (ProgressBar)findViewById(R.id.progressBar2_M6);
        pbar.setVisibility(View.INVISIBLE);
        showText =  (TextView) findViewById(R.id.textView16_M6);
        showText.setVisibility(View.INVISIBLE);
        start_stop_progressBar = (Button)findViewById(R.id.button2_M6);
        finish_progressBar = (Button)findViewById(R.id.button5_M6);
        finish_progressBar.setEnabled(false);

        start_stop_progressBar.setText("Start");
        pbar.setMax(pBarMax);

        Button temp_Btn_4t54tg = (Button) findViewById(R.id.button2_temp_M6);
        temp_Btn_4t54tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder4_temp_m6 = new AlertDialog.Builder(Main6Activity.this)
                        .setTitle("WARNING")
                        .setMessage("You are in the tough wash mode. Tough wash mode is mode suitable for both beginner and also the advanced user. The amount of water, time, temperature and washing liquid are predefined.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog4 = builder4_temp_m6.create();
                dialog4.show();
            }
        });

        start_stop_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (temp_flag2 == false) {
                    temp_flag2 = true;
                    AlertDialog.Builder builder55 = new AlertDialog.Builder(Main6Activity.this);
                    builder55.setTitle("ATTENTION");
                    builder55.setMessage("Your washing machine is about to begin. Are you sure?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    handler = new Handler()
                                    {
                                        public void handleMessage(android.os.Message msg)
                                        {
                                            if(isStart)
                                            {
                                                progressBarValue++;
                                            }
                                            pbar.setProgress(progressBarValue);
                                            showText.setText(String.valueOf(progressBarValue/60)+":"+String.valueOf(progressBarValue%60));
                                            if (showText.getText().equals("59:59")) {

                                                AlertDialog.Builder builder1 = new AlertDialog.Builder(Main6Activity.this)
                                                        .setTitle("ATTENTION")
                                                        .setMessage("Your dishes have been washed.You are ready.")
                                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Intent intent1 = new Intent(Main6Activity.this,MainActivity.class);
                                                                startActivity(intent1);
                                                            }
                                                        });
                                                AlertDialog dialog1 = builder1.create();
                                                dialog1.show();

                                            }

                                            handler.sendEmptyMessageDelayed(0, 1000);
                                        }
                                    };

                                    handler.sendEmptyMessage(0);

                                    pbar.setVisibility(View.VISIBLE);
                                    showText.setVisibility(View.VISIBLE);
                                    finish_progressBar.setEnabled(true);
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent48 = new Intent(Main6Activity.this,Main3Activity.class);
                            startActivity(intent48);
                        }
                    });

                    AlertDialog alert = builder55.create();
                    alert.show();

                }


                if (flag == false) {
                    isStart = true;
                    flag = true;
                    Btn_flag = true;
                    start_stop_progressBar.setText("Pause");
                } else {

                    AlertDialog.Builder builder26 = new AlertDialog.Builder(Main6Activity.this);
                    builder26.setTitle("ATTENTION");
                    builder26.setMessage("Your washing machine has been paused.")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert33 = builder26.create();
                    alert33.show();


                    isStart = false;
                    flag = false;
                    start_stop_progressBar.setText("Start");
                }
            }
        });

        Button M4Btn = (Button)findViewById(R.id.button4_M6);
        M4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isStart == false && Btn_flag == false) {
                    Intent intent4 = new Intent(Main6Activity.this,MainActivity.class);
                    startActivity(intent4);

                } else {

                    AlertDialog.Builder builder4 = new AlertDialog.Builder(Main6Activity.this)
                            .setTitle("WARNING")
                            .setMessage("By clicking OK you automatically terminate the washing machine. Are you sure?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent6 = new Intent(Main6Activity.this,MainActivity.class);
                                    startActivity(intent6);
                                }
                            }).setNegativeButton("CANCEL",null);
                    AlertDialog dialog4 = builder4.create();
                    dialog4.show();

                }
            }
        });

        finish_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main6Activity.this)
                        .setTitle("WARNING")
                        .setMessage("By clicling OK you automatically terminate the washing machine. Are you sure?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Main6Activity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("CANCEL",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
