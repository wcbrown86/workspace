package com.example.williambrown.inclass2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

        String printTotal = "";
        TextView text;
        EditText textEntered;
        double amount = 0.0;
        RadioButton checkedButton;
        double total;
        RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method that is called when any button is clicked
    public void updateConversion(View view){

        //Local Variables for computation and adjusting the text
        text = (TextView) findViewById(R.id.textView);
        textEntered = (EditText) findViewById(R.id.editText);

        if(view instanceof RadioButton) {
            try {
                amount = Double.parseDouble(textEntered.getText().toString());
            } catch (Exception e) {
                Log.d("data", e.toString());
            } finally {
                boolean checked = ((RadioButton) view).isChecked();
                //Switch case that determines the conversion eqation, if clear all is selected
                //Then the view is reloaded.
                switch (view.getId()) {
                    //Converts to Euro
                    case R.id.euro:
                        if (checked) {
                            text.setHint(R.string.euro_hint);
                            total = amount * .848282;
                            printTotal = String.format(amount + " USD = " + "%.2f" + " EUR", total);
                        }
                        break;

                    //Converts to Canadian Dollar
                    case R.id.canadianDollar:
                        if (checked) {
                            text.setHint(R.string.canadian_hint);
                            total = amount * 1.19;
                            printTotal = String.format(amount + " USD = " + "%.2f" + " CAD", total);
                        }
                        break;

                    //Converts to British Pound
                    case R.id.british_pound:
                        if (checked) {
                            text.setHint(R.string.british_hint);
                            total = amount * .65;
                            printTotal = String.format(amount + " USD = " + "%.2f" + " GBP", total);
                        }
                        break;

                    //Converts to Japanese Yen
                    case R.id.japanese_yen:
                        if (checked) {
                            text.setHint(R.string.japanese_hint);
                            total = amount * 117.62;
                            printTotal = String.format(amount + " USD = " + "%.2f" + " JPY", total);
                        }
                        break;

                    //Reloads the view if clear all is selected.
                    default:
                        finish();
                        startActivity(getIntent());
                        break;
                }
            }
        }else{
            text = (TextView) findViewById(R.id.textView);
            text.setText(printTotal);
        }

    }
}
