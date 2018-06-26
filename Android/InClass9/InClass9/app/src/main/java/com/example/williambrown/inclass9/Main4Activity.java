package com.example.williambrown.inclass9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        String key = getIntent().getExtras().get("KEY").toString();
        final Expenses expenses =(Expenses) MainActivity.expensesMap.get(key);

        final EditText name = (EditText) findViewById(R.id.entered_name_edit);
        name.setText(expenses.getName());

        final EditText amount = (EditText) findViewById(R.id.entered_amount_edit);
        amount.setText(Double.toString(expenses.getAmount()));

        final Spinner spinner = (Spinner) findViewById(R.id.spinner_edit);


        findViewById(R.id.save_expense_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenses.setAmount(Double.parseDouble(amount.getText().toString()));
                expenses.setCategory(spinner.getSelectedItem().toString());
                expenses.setName(name.getText().toString());

                MainActivity.expensesMap.put(expenses.getTrasactionID(), expenses);
                MainActivity.conditionRef.setValue(MainActivity.expensesMap);
                finish();
            }
        });
    }
}
