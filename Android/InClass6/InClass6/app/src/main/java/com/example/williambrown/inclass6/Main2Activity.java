package com.example.williambrown.inclass6;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("News Details");

        TextView title = (TextView) findViewById(R.id.news_title);
        title.setText((String) getIntent().getExtras().get("TITLE"));

        TextView date = (TextView) findViewById(R.id.date_pub);
        date.setText((String) getIntent().getExtras().get("DATE"));

        ImageView photo = (ImageView) findViewById(R.id.full_sized_image);
        photo.setImageBitmap((Bitmap) getIntent().getExtras().get("PHOTO"));

        TextView desc = (TextView) findViewById(R.id.description_content);
        desc.setText((String) getIntent().getExtras().get("DESC"));
    }
}
