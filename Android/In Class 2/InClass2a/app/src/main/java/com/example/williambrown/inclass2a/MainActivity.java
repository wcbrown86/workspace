package com.example.williambrown.inclass2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method that is called when any button is clicked
    public void updateConversion(View view){

        //Local Variables for computation and adjusting the text
        TextView text = (TextView) findViewById(R.id.textView);
        EditText textEntered = (EditText) findViewById(R.id.editText);
        double amount = Double.parseDouble(textEntered.getText().toString());
        double total;
        String printTotal;

        //Switch case that determines the conversion eqation, if clear all is selected
        //Then the view is reloaded.
        switch (view.getId()){
            //Converts to Euro
            case R.id.button_EUR:
                total = amount * .848282;
                printTotal = String.format("%.2f", total);
                text.setText(amount + " USD = " + printTotal + " EUR");
                break;

            //Converts to Canadian Dollar
            case R.id.canadianDollor:
                total = amount * 1.19;
                printTotal = String.format("%.2f", total);
                text.setText(amount + " USD = " + printTotal + " EUR");
                break;

            //Converts to British Pound
            case R.id.british_pound:
                total = amount * .65;
                printTotal = String.format("%.2f", total);
                text.setText(amount + " USD = " + printTotal + " EUR");
                break;

            //Converts to Japanese Yen
            case R.id.japaneseYen:
                total = amount * 117.62;
                printTotal = String.format("%.2f", total);
                text.setText(amount + " USD = " + printTotal + " EUR");
                break;

            //Reloads the view if clear all is selected.
            default:
                finish();
                startActivity(getIntent());
                break;
        }
    }
}
