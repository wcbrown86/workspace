package com.example.williambrown.inclass3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class StudentViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        if(getIntent().getExtras() != null){
            final Student student = (Student) getIntent().getExtras().getParcelable("Student");
            TextView viewName = (TextView) findViewById(R.id.view_name);
            TextView viewEmail = (TextView) findViewById(R.id.view_email);
            TextView viewDepartment = (TextView) findViewById(R.id.view_department);
            TextView viewMood = (TextView) findViewById(R.id.view_mood);


            viewName.setText(student.studentName);
            viewEmail.setText(student.studentEmail);
            viewDepartment.setText(student.studentDepartment);
            viewMood.setText(Integer.toString(student.studentMood) + "% Positive");

            ImageButton editName = (ImageButton) findViewById(R.id.name);
            editName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent edit_name = new Intent("com.example.williambrown.inclass3.intent.action.VIEW");
                    edit_name.putExtra("NAME", student.studentName);
                    //startActivityForResult(edit_name,RESULT_OK);
                    startActivity(edit_name);
                }
            });


        }
    }

}
