package com.example.wash_machine_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {

    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Button BtnMove1 = findViewById(R.id.button4_M7);
        BtnMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main7Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        final String sample_text = "Βρίσκεστε στην οθόνη βοήθειας για το βασικό menu της εφαρμογής. Αν επιθυμείτε να βγείτε πατήστε το κουμπί back."
                +"\n" + "\n" + "Εχουμε τρείς επιλογές. Εαν επιθυμούμε μία γρήγορη πλύση πατώντας το κουμπί Quick Wash εισερχόμαστε στην λειτουργία γρήγορης πλύσης."
                +" Εαν επιθυμούμε να προγραμματίσουμε εμείς την πλύση μας πατώντας το κουμπί custom wash εισερχόμαστε στη λειτουργία προσαρμοσμένης πλύσης."
                +" Εαν έχουμε πιάτα με λιπαρούς λεκέδες πατώντας το κουμπί tough wash μας δίνετε η δυνατότητα πραγματοποίησης πλύσης αποκλειστικά για αυτό το σκοπό."
                + "\n" + "\n" + "Η λειτουργία γρήγορης πλύσης ενδείκνυται για αρχάριους χρήστες διότι όλοι οι παράμετροι της πλύσης (νερό,χρόνος,καθαριστικό,θερμοκρασία) είναι προκαθορισμένοι."
                +" Η λειτουργία προσαρμοσμένης πλύσης ενδείκνειται για έμπειρους χρήστες όπου έχουν την δυνατότητα να ορίσουν εκείνοι τις παραμέτρους της πλύσης καθώς και να προγραμματίσουν άλλη στιγμή μέσα στη μέρα."
                + "\n" + "\n" + "Τέλος εαν έχουμε πιάτα με λιπαρούς λεκέδες όπου δεν φεύγουν εύκολα καλό είναι να επιλέξουμε την δυνατότητα της δύσκολης πλύσης η οποία ενδείκνυται για αρχάριους αλλα και έμπειρους χρήστες.";
        final TextView txt = (TextView) findViewById(R.id.textView12_M7);
        txt.setText(sample_text);
        txt.setMovementMethod(new ScrollingMovementMethod());

        final String transl_text = "You are in the help screen for the basic menu of the application. If you want to exit just click the back button below."
                + "\n" + "\n" + "We have three options. If we want to quick wash our dishes click the button Quick Wash to enter the Quick Wash mode."
                +" If we want to plan our wash by clicking the custom wash button we enter the custom wash mode."
                +" If we have dishes with tough dirties we should press the tough wash button in order to confront them."
                + "\n" + "\n" + "Quick wash mode was designed for beginner users with no experience because all the parameters of the wash (water,time,liquid,temperature) are predefined."
                +" Custom wash is suitable for advanced users who can set by their own the parameters of the wash and also to program the wash another hour in the day."
                + "\n" + "\n" + "Furthermore if we have extremely dirty dishes it is ought to choose the tough wash mode that is suitable for both inexperienced and experienced users";

        Button TransBtn = findViewById(R.id.button5_M7);
        TransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == false) {

                    txt.setText(transl_text);
                    flag = true;
                } else {

                    txt.setText(sample_text);
                    flag = false;

                }

            }
        });

    }
}
