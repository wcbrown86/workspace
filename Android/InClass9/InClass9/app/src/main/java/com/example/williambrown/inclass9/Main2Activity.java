package com.example.williambrown.inclass9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Main2Activity extends AppCompatActivity {

    MainActivity activity;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calendar = Calendar.getInstance();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText name = (EditText) findViewById(R.id.entered_name);
        final EditText amount = (EditText) findViewById(R.id.entered_amount);

        Button addButton = (Button) findViewById(R.id.add_expense_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expenses expenses = new Expenses(name.getText().toString(), spinner.getSelectedItem().toString(),
                        Double.parseDouble(amount.getText().toString()),dateFormat.format(calendar.getTime()).toString(),
                        UUID.randomUUID().toString());
                MainActivity.expensesMap.put(expenses.getTrasactionID().toString(), expenses);
                MainActivity.conditionRef.updateChildren(MainActivity.expensesMap);

                finish();
            }
        });

        Button cancel = (Button) findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
