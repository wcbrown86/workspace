package com.example.williambrown.inclass3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button submitSelect = (Button) findViewById(R.id.submit_button);
        submitSelect.setOnClickListener(new View.OnClickListener() {

            //Creates variables for holding the infmormation the user entered.
            EditText name = (EditText) findViewById(R.id.name);
            EditText email = (EditText) findViewById(R.id.email);
            RadioGroup department = (RadioGroup) findViewById(R.id.radioGroup);
            SeekBar mood = (SeekBar) findViewById(R.id.edit_mood);


            @Override
            public void onClick(View v) {
                if (name.getText().equals("") ||
                        email.getText().equals("") ||
                        department.getCheckedRadioButtonId() == -1 ||
                        mood.equals(0)) {

                    Toast.makeText(MainActivity.this, "You Must Complete All Fields", Toast.LENGTH_SHORT).show();

                }else{
                    RadioButton selected = (RadioButton) department.findViewById(department.getCheckedRadioButtonId());
                    Intent viewStudent = new Intent(MainActivity.this, StudentViewActivity.class);
                    Student student = new Student(name.getText().toString(),
                            email.getText().toString(), selected.getText().toString(), mood.getProgress());
                    viewStudent.putExtra("Student", student);
                    startActivity(viewStudent);
                }
            }
        });
    }
}