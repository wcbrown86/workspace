package com.example.williambrown.homework01;

import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global variables used.
    EditText hours;
    EditText minutes;
    TextView results;
    TextView previous;
    RadioGroup group;
    RadioButton clearRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables used to set and change text fields
        hours = (EditText) findViewById(R.id.input_hours);
        minutes = (EditText) findViewById(R.id.input_minutes);
        results = (TextView) findViewById(R.id.view_results);
        previous = (TextView) findViewById(R.id.previous_day);

        //Variable used to check the radio group and clear radio button.
        group = (RadioGroup) findViewById(R.id.radioGroup);
        clearRadio = (RadioButton) findViewById(R.id.radio_clear);
        

        //sets the switch_buttom variable to the switch, added the setOnChangedListener and
        //the onCheckedChangedListener to look for changes in the switch.
        final Switch switch_button = (Switch) findViewById(R.id.button_switch);
        switch_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            /*  *This method lookds for changes in the switch, if the switch is on
                *it will show he buttoms for converiting the time, If the switch is
                * off if will show the radio buttoms to select the conversion and
                * a convert button.
              */
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //If checked is true, set buttons visiable and radio group invisible
                if (isChecked) {

                    //sets the buttons visible
                    findViewById(R.id.button_est).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_cst).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_mst).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_pst).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_clear).setVisibility(View.VISIBLE);

                    //Sets the radio group and convert buttom invisible
                    findViewById(R.id.radioGroup).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button_convert).setVisibility(View.INVISIBLE);

                    //If the switch is off, set the radio group and convert button visable.
                } else {

                    //sets the buttons invisible
                    findViewById(R.id.button_est).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button_cst).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button_mst).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button_pst).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button_clear).setVisibility(View.INVISIBLE);

                    //Sets the radio group visible and the convert button visible.
                    findViewById(R.id.radioGroup).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_convert).setVisibility(View.VISIBLE);

                }
            }
        });

        //Clear button on click listener.
        Button clear = (Button) findViewById(R.id.button_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        //Method for on click listener for convert EST button
        Button convertEST = (Button) findViewById(R.id.button_est);
        convertEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    int estTime = timeConversion(Integer.parseInt(hours.getText().toString()), 5);
                    if(estTime >= 0) {
                        String timeFormat = formatString(estTime, Integer.parseInt(minutes.getText().toString()));
                        results.setText(" EST:    " + timeFormat);
                    } else {

                        estTime = Math.abs(estTime);
                        estTime = 24 - estTime;
                        String timeFormat = formatString(estTime, Integer.parseInt(minutes.getText().toString()));
                        results.setText(" EST:    " + timeFormat);
                        previous.setText(R.string.previousDay);
                    }
                }
            }
        });

        //Method for on click listener for convert CST button
        Button convertCST = (Button) findViewById(R.id.button_cst);
        convertCST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    int cstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 6);
                    if(cstTime >= 0) {
                        results.setText(" CST:    " + formatString(cstTime, Integer.parseInt(minutes.getText().toString())));
                    } else {

                        cstTime = Math.abs(cstTime);
                        cstTime = 24 - cstTime;
                        results.setText(" CST:    " + formatString(cstTime, Integer.parseInt(minutes.getText().toString())));
                        previous.setText(R.string.previousDay);
                    }
                }
            }
        });

        //Method for on click listener for convert MST button
        Button convertMST = (Button) findViewById(R.id.button_mst);
        convertMST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    int mstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 7);
                    if(mstTime >= 0) {
                        String timeFormat = formatString(mstTime,Integer.parseInt(minutes.getText().toString()));
                        results.setText(" MST:    " + timeFormat);
                    } else {

                        mstTime = Math.abs(mstTime);
                        mstTime = 24 - mstTime;
                        String timeFormat = formatString(mstTime,Integer.parseInt(minutes.getText().toString()));
                        results.setText(" MST:    " + timeFormat);
                        previous.setText(R.string.previousDay);
                    }
                }
            }
        });

        //Method for on click listener for convert PST button
        Button convertPST = (Button) findViewById(R.id.button_pst);
        convertPST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    int pstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 8);
                    if(pstTime >= 0) {
                        results.setText(" PST:    " + formatString(pstTime, Integer.parseInt(minutes.getText().toString())));
                    } else {

                        pstTime = Math.abs(pstTime);
                        pstTime = 24 - pstTime;
                        results.setText(" PST:    " + formatString(pstTime, Integer.parseInt(minutes.getText().toString())));
                        previous.setText(R.string.previousDay);
                    }
                }
            }
        });

        /*
         *Clear method, when the clear all radio is checked the fields and checked item are
         *cleared.
        */
        clearRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                group.clearCheck();
            }
        });

        /*
         *Convert onclick listener that looks that the radio button checked
         *if no radio button is checked the system shows a toast. clear radio button
         *is handled seperatly
        */
        Button convert = (Button) findViewById(R.id.button_convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v = (RadioButton) group.findViewById(group.getCheckedRadioButtonId());
                if(checkInput()){
                    if(!(group.getCheckedRadioButtonId() == -1)) {
                        switch (v.getId()) {
                            case R.id.radio_est:
                                int estTime = timeConversion(Integer.parseInt(hours.getText().toString()), 5);
                                if(estTime >= 0) {
                                    String timeFormat = formatString(estTime, Integer.parseInt(minutes.getText().toString()));
                                    results.setText(" EST:    " + timeFormat);
                                } else {

                                    estTime = Math.abs(estTime);
                                    estTime = 24 - estTime;
                                    String timeFormat = formatString(estTime, Integer.parseInt(minutes.getText().toString()));
                                    results.setText(" EST:    " + timeFormat);
                                    previous.setText(R.string.previousDay);
                                }
                                    group.clearCheck();
                                break;

                            case R.id.radio_cst:
                                int cstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 6);
                                if(cstTime >= 0) {
                                    results.setText(" CST:    " + formatString(cstTime, Integer.parseInt(minutes.getText().toString())));
                                } else {

                                    cstTime = Math.abs(cstTime);
                                    cstTime = 24 - cstTime;
                                    results.setText(" CST:    " + formatString(cstTime, Integer.parseInt(minutes.getText().toString())));
                                    previous.setText(R.string.previousDay);
                                }
                                group.clearCheck();
                                break;
                            case R.id.radio_mst:
                                int mstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 7);
                                if(mstTime >= 0) {
                                    String timeFormat = formatString(mstTime,Integer.parseInt(minutes.getText().toString()));
                                    results.setText(" MST:    " + timeFormat);
                                } else {

                                    mstTime = Math.abs(mstTime);
                                    mstTime = 24 - mstTime;
                                    String timeFormat = formatString(mstTime,Integer.parseInt(minutes.getText().toString()));
                                    results.setText(" MST:    " + timeFormat);
                                    previous.setText(R.string.previousDay);
                                }
                                group.clearCheck();
                                break;
                            case R.id.radio_pst:
                                int pstTime = timeConversion(Integer.parseInt(hours.getText().toString()), 8);
                                if(pstTime >= 0) {
                                    results.setText(" PST:    " + formatString(pstTime, Integer.parseInt(minutes.getText().toString())));
                                } else {

                                    pstTime = Math.abs(pstTime);
                                    pstTime = 24 - pstTime;
                                    results.setText(" PST:    " + formatString(pstTime, Integer.parseInt(minutes.getText().toString())));
                                    previous.setText(R.string.previousDay);
                                }
                                group.clearCheck();
                                break;
                            default:
                                break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "No Radio Button check", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });



    }

    //Format method to help with formating the output string by filling in zeros if needed
    public String formatString(int hoursToString, int minToString){

        return String.format("%02d",hoursToString) + ":" + String.format("%02d",minToString);
    }

    //Method that will subtract the time conversion from the time entered
    public int timeConversion (int time, int conversion){

        return time - conversion;

    }

    //Method that will clear and reset the input and results field.
    public void clear(){

        hours = (EditText) findViewById(R.id.input_hours);
        minutes = (EditText) findViewById(R.id.input_minutes);
        results = (TextView) findViewById(R.id.view_results);

        hours.setText("");
        hours.setHint(R.string.hours_hint);

        minutes.setText("");
        minutes.setHint(R.string.minute_hint);

        results.setText(R.string.results);
        previous.setText(R.string.previousDayFiller);

    }

    /*
     *Checks the input entered by the user to make sure it is vaild, if not a toast is shown and
     *user input is cleared.
    */
    public boolean checkInput(){

        hours = (EditText) findViewById(R.id.input_hours);
        minutes = (EditText) findViewById(R.id.input_minutes);
        previous = (TextView) findViewById(R.id.previous_day);

        previous.setText(R.string.previousDayFiller);

        if(!hours.getText().toString().equals("") || !minutes.getText().toString().equals("")) {
            int hoursInt = Integer.parseInt(hours.getText().toString());
            int minutesInt = Integer.parseInt((minutes.getText().toString()));

            if ((hoursInt >= 0 && hoursInt <= 24) && (minutesInt >= 0 && minutesInt <= 60)) {
                return true;
            } else {

                Toast.makeText(getApplicationContext(), "Time entered is invalid", Toast.LENGTH_LONG).show();
                clear();
                return false;
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "No values entered", Toast.LENGTH_LONG).show();
            clear();
            return false;
        }
    }
}
