package com.example.williambrown.inclass7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        imageView = (ImageView) findViewById(R.id.imageView);

        GetPhoto getPhoto = new GetPhoto(Main2Activity.this);
        getPhoto.execute((String) getIntent().getExtras().get("URL"));

        TextView track = (TextView) findViewById(R.id.track_title);
        track.setText("Track: " + (String) getIntent().getExtras().get("TRACK"));

        TextView genre = (TextView) findViewById(R.id.genre_text);
        genre.setText("Genre: " + (String) getIntent().getExtras().get("GENRE"));

        TextView artist = (TextView) findViewById(R.id.artist_text);
        artist.setText("Artist: " + (String) getIntent().getExtras().get("ARTIST"));

        TextView album = (TextView) findViewById(R.id.album_text);
        album.setText("Album: " + (String) getIntent().getExtras().get("ALBUM"));

        TextView tPrice = (TextView) findViewById(R.id.track_price_text);
        tPrice.setText("Track Price: $" + (String) getIntent().getExtras().get("TPRICE").toString());

        TextView aPrice = (TextView) findViewById(R.id.album_price_text);
        aPrice.setText("Album Price: $" + (String) getIntent().getExtras().get("APRICE").toString());







        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

