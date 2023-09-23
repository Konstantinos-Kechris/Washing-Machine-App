package com.example.wash_machine_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;


public class Main4Activity extends AppCompatActivity {

    TextView showText;
    int progressBarValue = 0;
    Handler handler = new Handler();
    Button start_stop_progressBar,finish_progressBar;
    boolean isStart = false;
    boolean flag = false;
    boolean Btn_flag = false;
    private final int pBarMax = 1800;
    boolean temp_flag1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final ProgressBar pbar = (ProgressBar)findViewById(R.id.progressBar);
        pbar.setVisibility(View.INVISIBLE);
        showText =  (TextView) findViewById(R.id.text_view_countdown);
        showText.setVisibility(View.INVISIBLE);
        start_stop_progressBar = (Button)findViewById(R.id.button_start_pause);
        finish_progressBar = (Button)findViewById(R.id.button_finish);
        finish_progressBar.setEnabled(false);

        start_stop_progressBar.setText("Start");
        pbar.setMax(pBarMax);

        Button Btn_temp_1 = (Button) findViewById(R.id.button_2_M4);
        Btn_temp_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder_temp_4 = new AlertDialog.Builder(Main4Activity.this)
                        .setTitle("WARNING")
                        .setMessage("You are in the Quick Wash mode. Quick wash mode is a simple program for a beginner user.The amount of water,time,temperature and washing liquid are predefined.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog4_temp = builder_temp_4.create();
                dialog4_temp.show();
            }
        });

        start_stop_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (temp_flag1 == false) {
                    temp_flag1 = true;
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
                    builder.setTitle("ATTENTION");
                    builder.setMessage("Your washing machine is about to begin. Are you sure?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pbar.setVisibility(View.VISIBLE);
                                    showText.setVisibility(View.VISIBLE);
                                    finish_progressBar.setEnabled(true);


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
                                            if (showText.getText().equals("29:59")) {

                                                AlertDialog.Builder builder1 = new AlertDialog.Builder(Main4Activity.this)
                                                        .setTitle("ATTENTION")
                                                        .setMessage("Your dishes have been washed.You are ready.")
                                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Intent intent1 = new Intent(Main4Activity.this,MainActivity.class);
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
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent48 = new Intent(Main4Activity.this,Main3Activity.class);
                            startActivity(intent48);
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                }


                if (flag == false) {

                    isStart = true;
                    flag = true;
                    Btn_flag = true;
                    start_stop_progressBar.setText("Pause");

                } else {

                    AlertDialog.Builder builder26 = new AlertDialog.Builder(Main4Activity.this);
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

        Button M4Btn = (Button)findViewById(R.id.Back_Button_M4);
        M4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isStart == false && Btn_flag == false) {
                    Intent intent4 = new Intent(Main4Activity.this,MainActivity.class);
                    startActivity(intent4);

                } else {

                    AlertDialog.Builder builder4 = new AlertDialog.Builder(Main4Activity.this)
                            .setTitle("WARNING")
                            .setMessage("By clicking OK, you automatically terminate the washing machine. Are you sure?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent6 = new Intent(Main4Activity.this,MainActivity.class);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this)
                        .setTitle("WARNING")
                        .setMessage("By clicking OK you automatically terminate the washing machine. Are you sure?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("CANCEL",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

}