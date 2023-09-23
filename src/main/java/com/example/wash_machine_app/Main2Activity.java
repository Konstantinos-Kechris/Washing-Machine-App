package com.example.wash_machine_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button BtnMove1 = findViewById(R.id.ReturnBtn);
        BtnMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        final String sample_text = "Καλωσήρθατε στο σύντομο οδηγό χρήσης της εφαρμογής WASH IT." + "\n" + "\n" +  " Ανοίγοντας την εφαρμογή βρίσκεστε στην αρχική οθόνη. Στην αρχική οθόνη υπάρχουν τρία κουμπιά. Πατώντας το κόκκινο κουμπί EXIT βγαίνετε απο την εφαρμογή. Πατώντας το"+
                " κουμπί manual, εισέρχεστε στον σύντομο οδηγό χρήσης της εφαρμογής ενώ πατώντας το κουμπί menu δίνετε η δυνατότητα περιήγησης στις βασικές λειτουργίες της εφαρμογής." + "\n" +  "\n" +
                "Βρισκόμενοι στο menu έχουμε τρείς επιλογές. Αρχικά την επιλογή Quick wash η οποία σχεδιάστηκε για αρχάριους χρήστες με δυσκολία στην εξοικείωση σε android εφαρμογές. Το νερό, ο χρόνος, το καθαριστικό υγρό και η θερμοκρασία είναι προκαθορισμένα."
                + "\n" +  "\n" + "Πατώντας custom wash μεταβαίνουμε στο παράθυρο της προσαρμοσμένης πλύσης. Η επιλογή αυτή σχεδιάστηκε για πιο προχωρημένους χρήστες και τους δίνετε η δυνατότητα προγραμματισμού της πλύσης τους όπως αυτή το επιθυμούν καθώς και δυνατότητα πραγματοποίησης της πλύσης άλλη ώρα μέσα στη μέρα." +
                " Τέλος, η λειτουργία Tough Wash σχεδάστηκε προκειμένου ο χρήστης να πλένει πιάτα με λιπαρούς λεκέδες.";
        final TextView txt = (TextView) findViewById(R.id.textView4);
        txt.setText(sample_text);
        txt.setMovementMethod(new ScrollingMovementMethod());

        final String transl_text = "Welcome to our short instructions guide of our application WASH IT." +"\n" + "\n"
                + "By opening the application you are in the main screen. In main screen they are three buttons.By pressing the EXIT button you exit the application." +
                " By pressing manual button you enter to the manual and by pressing menu you enter to the basic abilities of the system." + "\n" + "\n" +
                "In menu we have two choices. Firstly, we have the choice of quick wash that was designed for beginner users that struggle with android application. Water, Time, Temperature and the washing liquid are predefined." +
                "\n" + "\n"+ "By clicking custom wash we enter the custom wash features. That was designed for the advanced users and they are able to customize the wash by their own and also the ability to wash in another time of the day." +
                " Lastly the tough wash function was designed to confront dishes with tough pits";

        Button TransBtn = findViewById(R.id.TranslateBtn);
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
