package com.example.williambrown.inclass5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.LinkedList;

// APT key c5af87380e02451d8405285c96e2e0d5

public class MainActivity extends AppCompatActivity {

    LinkedList<NewsArticle> articles;
    TextView title;
    TextView author;
    TextView date;
    TextView description;
    TextView fillerDescription;
    ImageButton first, previous, next, last;
    Button finished;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.newSelection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        title = (TextView) findViewById(R.id.news_title);
        author = (TextView) findViewById(R.id.news_author);
        date = (TextView) findViewById(R.id.news_date);
        description = (TextView) findViewById(R.id.news_description);
        finished = (Button) findViewById(R.id.finished_button);
        finished.setVisibility(View.INVISIBLE);

        fillerDescription = (TextView) findViewById(R.id.description);
        fillerDescription.setVisibility(View.INVISIBLE);

        first = (ImageButton) findViewById(R.id.first_button);
        first.setVisibility(View.INVISIBLE);

        previous = (ImageButton) findViewById(R.id.previous_button);
        previous.setVisibility(View.INVISIBLE);

        next = (ImageButton) findViewById(R.id.next_button);
        next.setVisibility(View.INVISIBLE);

        last = (ImageButton) findViewById(R.id.last_button);
        last.setVisibility(View.INVISIBLE);



        findViewById(R.id.get_news).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isConnectedOnline()){
                    if(spinner.getSelectedItemPosition() == 1) {
                        GetNews get = new GetNews(MainActivity.this);
                        get.execute("https://newsapi.org/v1/articles?apiKey=c5af87380e02451d8405285c96e2e0d5&source=bbc-news");
                    } else if (spinner.getSelectedItemPosition() == 2){
                        GetNews get = new GetNews(MainActivity.this);
                        get.execute("https://newsapi.org/v1/articles?apiKey=c5af87380e02451d8405285c96e2e0d5&source=cnn");
                    } else {
                        Toast.makeText(MainActivity.this, "Please Select a New Source", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_LONG).show();
                }
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(0);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != 0) {
                    display(--position);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position <= articles.size()) {
                    display(++position);
                }
            }
        });

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(articles.size()-1);
            }
        });
    }

    public void display(int i) {
        position = i;
        if((articles != null) && i < articles.size()){
         GetPhoto getPhoto = new GetPhoto();
            getPhoto.execute(articles.get(i).getImageURL());

            author.setText("Author: " + articles.get(i).getAuthor());
            title.setText("Title: " + articles.get(i).getTitle());
            date.setText("Date: " + articles.get(i).getDate());
            fillerDescription.setVisibility(View.VISIBLE);
            description.setText(articles.get(i).getDescription());
            finished.setVisibility(View.VISIBLE);

            if(articles.size() > 1){
                first.setVisibility(View.VISIBLE);
                previous.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                last.setVisibility(View.VISIBLE);

            }



        } else {
            Toast.makeText(MainActivity.this, "No information in articles", Toast.LENGTH_LONG);
        }


    }


    private class GetPhoto extends AsyncTask<String, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {

            try {

                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");

                Bitmap image = BitmapFactory.decodeStream(urlConnection.getInputStream());
                return image;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result){
            if(result != null){
                ImageView view = (ImageView) findViewById(R.id.news_image);
                view.setImageBitmap(result);

            } else {
                Log.d("demo", "Null Data");
            }
        }
    }

    private boolean isConnectedOnline(){

        ConnectivityManager connection = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connection.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }

        return false;
    }
}