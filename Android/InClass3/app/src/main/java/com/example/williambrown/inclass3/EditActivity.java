package com.example.williambrown.inclass3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView editName = (TextView) findViewById(R.id.name);
        editName.setVisibility(View.INVISIBLE);
        TextView editEmail = (TextView) findViewById(R.id.email);
        editEmail.setVisibility(View.INVISIBLE);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setVisibility(View.INVISIBLE);
        SeekBar editMood = (SeekBar) findViewById(R.id.edit_mood);
        editMood.setVisibility(View.INVISIBLE);

        if(getIntent().getExtras().get("NAME")!= null){
            editName = (TextView) findViewById(R.id.name);
            editName.setVisibility(View.VISIBLE);
            editName.setText(getIntent().getExtras().getString("NAME"));

        }
    }
}
