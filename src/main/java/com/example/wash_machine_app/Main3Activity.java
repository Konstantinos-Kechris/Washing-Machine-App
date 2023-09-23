package com.example.wash_machine_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        Button ButtonMove = findViewById(R.id.BackBtn2);

        ButtonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(intent1);
            }
        });

        Button temp_Btn_123 = (Button) findViewById(R.id.button2_M3);
        temp_Btn_123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent34_m3 = new Intent(Main3Activity.this,Main7Activity.class);
                startActivity(intent34_m3);
            }
        });


        final Button QuickWash = findViewById(R.id.QuckWashBtn);
        QuickWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent2);

            }

        });

        Button CustomBtn = findViewById(R.id.CustomButton);
        CustomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main3Activity.this,Main5Activity.class);
                startActivity(intent2);
            }
        });

        Button tough_wash_btn = (Button) findViewById(R.id.Tough_Wash_Btn);
        tough_wash_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent9 = new Intent(Main3Activity.this,Main6Activity.class);
                startActivity(intent9);

            }

        });

    }

}