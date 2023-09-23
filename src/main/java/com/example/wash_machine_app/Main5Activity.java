package com.example.wash_machine_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main5Activity extends AppCompatActivity {

    TextView showText;
    int progressBarValue = 0;
    Handler handler = new Handler();
    private Button start_stop_progressBar,finish_progressBar;
    private Button Back_Btn_M5;
    boolean isStart = false;
    boolean hastart = false;
    boolean flag = false;
    int time;
    private EditText editTime;
    private EditText editWater;
    private EditText editLiquid;
    private EditText editTemp;
    private ProgressBar pbar;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    TimePickerDialog timePickerDialog;
    Context myContext = this;
    private ImageView im2,im3,im4;
    boolean temp_flag2 = false;
    private Button ok_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        editTime = (EditText)findViewById(R.id.edit_Time);
        editWater = (EditText)findViewById(R.id.edit_Water);
        editLiquid = (EditText)findViewById(R.id.edit_Liquid);
        editTemp = (EditText) findViewById(R.id.edit_Temp);
        pbar = (ProgressBar)findViewById(R.id.progressBar_Μ5);
        pbar.setVisibility(View.INVISIBLE);
        im2 = (ImageView)findViewById(R.id.imageView2);
        im3 = (ImageView)findViewById(R.id.imageView3);
        im4 = (ImageView)findViewById(R.id.imageView4);
        showText = (TextView) findViewById(R.id.textView_Μ5);
        showText.setVisibility(View.INVISIBLE);


        final Button start_pause_btn = (Button) findViewById(R.id.Start_Pause_Button);
        final Button finish_btn = (Button) findViewById(R.id.Finish_Button);
        start_pause_btn.setEnabled(false);
        finish_btn.setEnabled(false);

        final Button start_now_button = (Button) findViewById(R.id.Start_Now_Btn);
        start_now_button.setVisibility(View.INVISIBLE);

        final Button set_time_button = (Button) findViewById(R.id.Set_Time_Btn);
        set_time_button.setVisibility(View.INVISIBLE);

        Button Btn_temp_7362 = (Button) findViewById(R.id.button2_temp_M5);
        Btn_temp_7362.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder4_m5_temp = new AlertDialog.Builder(Main5Activity.this)
                        .setTitle("WARNING")
                        .setMessage("You are in the custom wash mode. Custom wash mode is an advanced mode that is suitable for the advanced user. User has the ability to define by his own the amount of water, the time, the temperature and the washing liquid that it is going to use.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog4_m5_temp = builder4_m5_temp.create();
                dialog4_m5_temp.show();
            }
        });

        start_now_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start_now_button.setVisibility(View.INVISIBLE);
                set_time_button.setVisibility(View.INVISIBLE);
                showText.setVisibility(View.VISIBLE);
                start_pause_btn.setEnabled(true);
            }
        });

        Back_Btn_M5 = (Button) findViewById(R.id.button2_M5);
        Back_Btn_M5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart == false && hastart == false) {
                    Intent intent_temp_m5 = new Intent(Main5Activity.this,MainActivity.class);
                    startActivity(intent_temp_m5);
                } else {
                    AlertDialog.Builder builder4_m5 = new AlertDialog.Builder(Main5Activity.this)
                            .setTitle("WARNING")
                            .setMessage("By clicking OK you automatically terminate the washing machine. Are you sure?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent6_m5 = new Intent(Main5Activity.this,MainActivity.class);
                                    startActivity(intent6_m5);
                                }
                            }).setNegativeButton("CANCEL",null);
                    AlertDialog dialog4_m5 = builder4_m5.create();
                    dialog4_m5.show();
                }
            }
        });

        set_time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editWater.setEnabled(false);
                editLiquid.setEnabled(false);
                editTime.setEnabled(false);
                showText.setVisibility(View.VISIBLE);
                start_now_button.setVisibility(View.INVISIBLE);
                set_time_button.setVisibility(View.INVISIBLE);
                start_pause_btn.setEnabled(true);
                finish_btn.setEnabled(true);
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Main5Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        int hourofday = calendar.get(Calendar.HOUR_OF_DAY);
                        int minuteofday = calendar.get(Calendar.MINUTE);
                        int seconds = calendar.get(Calendar.SECOND);

                        long milliseconds;
                        milliseconds = (60-seconds)*1000;

                        if (minuteofday < minute) {

                            milliseconds = milliseconds + (minute - minuteofday - 1)*60*1000;

                        } else if (minuteofday == minute){

                            milliseconds = milliseconds + 0;

                        } else {

                            milliseconds = milliseconds + ( 60 -(minuteofday - minute - 1) )*60*1000;
                        }

                        if (hourofday < hourOfDay) {

                            milliseconds = milliseconds + (hourOfDay - hourofday - 1)*60*60*1000;

                        } else if (hourofday == hourOfDay) {

                            milliseconds = milliseconds + 0;

                        } else {

                            milliseconds = milliseconds + (24 - (hourofday - hourOfDay - 1) )*60*60*1000;

                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(Main5Activity.this);
                        builder.setTitle("ATTENTION");
                        builder.setMessage("PLEASE WAIT");
                        builder.setCancelable(true);
                        final AlertDialog dlg = builder.create();
                        dlg.show();

                        final Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                dlg.dismiss();
                                t.cancel();
                            }
                        },milliseconds);
                    }
                },currentHour,currentMinute,android.text.format.DateFormat.is24HourFormat(myContext));
                timePickerDialog.show();

            }
        });

        ok_btn = (Button) findViewById(R.id.ok_Button);


        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;

                int water = Integer.parseInt(editWater.getText().toString());
                if (water < 3 || water > 10) {
                    editWater.setError("Please give a valid value (3-10 lt)");

                } else {
                    flag = true;
                }

                int liquid = Integer.parseInt(editLiquid.getText().toString());
                if (liquid < 8 || liquid > 15) {
                    editLiquid.setError("Please give a valid value (8-15 ml)");
                } else {
                    flag1 = true;
                }

                time = Integer.parseInt(editTime.getText().toString());
                if(time < 20 || time > 60) {
                    editTime.setError("Please give a valid value (20-60 min)");
                } else {
                    flag2 = true;
                    pbar.setMax(time*60);
                }

                int temp = Integer.parseInt(editTemp.getText().toString());
                if (temp < 50 || temp > 80) {
                    editTemp.setError("Please give a valid value (50-80 C)");
                } else {
                    flag3 = true;
                }

                if (flag && flag1 && flag2 && flag3) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(Main5Activity.this)
                            .setTitle("ATTENTION")
                            .setMessage("Click OK if you want to proceed or CANCEL if you want to change the settings of your custom wash.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ok_btn.setVisibility(View.INVISIBLE);
                                    editWater.setEnabled(false);
                                    editLiquid.setEnabled(false);
                                    editTime.setEnabled(false);
                                    editTemp.setEnabled(false);
                                    start_now_button.setVisibility(View.VISIBLE);
                                    set_time_button.setVisibility(View.VISIBLE);
                                }
                            }).setNegativeButton("CANCEL",null);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        start_stop_progressBar = (Button)findViewById(R.id.Start_Pause_Button);
        finish_progressBar = (Button)findViewById(R.id.Finish_Button);

        start_stop_progressBar.setText("Start");
        finish_progressBar.setText("Finish");

        start_stop_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (temp_flag2 == false) {
                    temp_flag2 = true;
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main5Activity.this);
                    builder.setTitle("ATTENTION");
                    builder.setMessage("Your washing machine is about to begin. Are you sure?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    handler = new Handler() {
                                        public void handleMessage(android.os.Message msg)
                                        {
                                            if(isStart)
                                            {
                                                progressBarValue++;
                                            }
                                            pbar.setProgress(progressBarValue);
                                            showText.setText(String.valueOf(progressBarValue/60)+":"+String.valueOf(progressBarValue%60));
                                            if (progressBarValue==pbar.getMax()) {

                                                AlertDialog.Builder builder1 = new AlertDialog.Builder(Main5Activity.this)
                                                        .setTitle("ATTENTION")
                                                        .setMessage("Your dishes have been washed.You are ready.")
                                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Intent intent1 = new Intent(Main5Activity.this,MainActivity.class);
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
                            Intent intent48 = new Intent(Main5Activity.this,Main3Activity.class);
                            startActivity(intent48);
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                if (flag == false) {
                    hastart = true;
                    isStart = true;
                    flag = true;
                    start_stop_progressBar.setText("Pause");
                } else {

                    AlertDialog.Builder builder26 = new AlertDialog.Builder(Main5Activity.this);
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

        finish_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main5Activity.this)
                        .setTitle("WARNING")
                        .setMessage("By clicking OK you automatically terminate the washing machine. Are you sure?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Main5Activity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("CANCEL",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}