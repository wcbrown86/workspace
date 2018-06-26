package com.example.williambrown.inclass9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView name;
    TextView cat;
    TextView amount;
    TextView date;
    Expenses expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button editButton = (Button) findViewById(R.id.edit_button);
        Button closeButton = (Button) findViewById(R.id.close_button);
        name = (TextView) findViewById(R.id.name_view);
        cat = (TextView) findViewById(R.id.cat_view);
        amount = (TextView) findViewById(R.id.amount_view);
        date = (TextView) findViewById(R.id.date_view);

        final String key = getIntent().getExtras().get("KEY").toString();
        expenses = (Expenses) MainActivity.expensesMap.get(key);
        name.setText(expenses.getName());
        cat.setText(expenses.getCategory());
        amount.setText(Double.toString(expenses.getAmount()));
        date.setText(expenses.getDate());



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(Main3Activity.this, Main4Activity.class);
                editIntent.putExtra("KEY", key);
                startActivity(editIntent);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {

        name.setText(expenses.getName());
        cat.setText(expenses.getCategory());
        amount.setText(Double.toString(expenses.getAmount()));
        date.setText(expenses.getDate());
        super.onResume();
    }
}
