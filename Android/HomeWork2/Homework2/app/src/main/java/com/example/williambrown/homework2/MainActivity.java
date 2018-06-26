package com.example.williambrown.homework2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.DrawableMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageHolder;
    String[] savedURLS;
    int index = 1;
    ImageButton previousButton = null;
    ImageButton nextButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = (Button) findViewById(R.id.search_button);
        previousButton = (ImageButton) findViewById(R.id.previous_button);
        previousButton.setVisibility(View.INVISIBLE);
        nextButton = (ImageButton) findViewById(R.id.next_button);
        nextButton.setVisibility(View.INVISIBLE);
        ImageView imageHolder = (ImageView) findViewById(R.id.image);
        final TextView searchBar = (TextView) findViewById(R.id.search_field);

        final String[] searchOptions = {"UNCC", "Android", "Winter", "Aurora", "Wonders"};




        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.searchText)
                        .setItems(searchOptions, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                searchBar.setText(searchOptions[which]);
                                clearPhoto();
                                if(isConnectedOnline()) {
                                    GetURLs getURLs;
                                    switch (which){
                                        case 0:
                                            getURLs = new GetURLs(MainActivity.this);
                                            getURLs.execute("http://dev.theappsdr.com/apis/photos/index.php?keyword=uncc");
                                            break;
                                        case 1:
                                            getURLs = new GetURLs(MainActivity.this);
                                            getURLs.execute("http://dev.theappsdr.com/apis/photos/index.php?keyword=android");
                                            break;
                                        case 2:
                                            getURLs = new GetURLs(MainActivity.this);
                                            getURLs.execute("http://dev.theappsdr.com/apis/photos/index.php?keyword=winter");
                                            break;
                                        case 3:
                                            getURLs = new GetURLs(MainActivity.this);
                                            getURLs.execute("http://dev.theappsdr.com/apis/photos/index.php?keyword=aurora");
                                            break;
                                        case 4:
                                            getURLs = new GetURLs(MainActivity.this);
                                            getURLs.execute("http://dev.theappsdr.com/apis/photos/index.php?keyword=wonders");
                                            break;
                                        default:
                                            break;
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "PLease Connect to the Internet!", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                builder.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(++index);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(--index);
            }
        });

    }

    private boolean isConnectedOnline(){

        ConnectivityManager connection = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connection.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }

        return false;
    }

    public void display(int i){
        if(savedURLS.length > 1) {
            if ((i > 0) && (i < savedURLS.length)) {
                GetPhoto photo = new GetPhoto();
                photo.execute(savedURLS[i]);
            } else if (i == 0) {
                GetPhoto photo = new GetPhoto();
                photo.execute(savedURLS[savedURLS.length - 1]);
                index = savedURLS.length-1;
            } else {
                GetPhoto photo = new GetPhoto();
                photo.execute(savedURLS[1]);
                index = 1;
            }

            if (savedURLS.length > 2) {
                nextButton.setVisibility(View.VISIBLE);
                previousButton.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(getApplicationContext(),"This search does not have photos to display", Toast.LENGTH_LONG).show();
        }

    }

    public void clearPhoto(){
        if(imageHolder != null) {
            imageHolder.setImageDrawable(null);
        }
    }


    class GetPhoto extends AsyncTask<String, Integer, Bitmap> {

        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait.");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap image = null;
            try {

                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");

                image = BitmapFactory.decodeStream(urlConnection.getInputStream());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return image;
            }

        }

        @Override
        protected void onPostExecute(Bitmap result){
            if(result != null){
                imageHolder = (ImageView) findViewById(R.id.image);
                imageHolder.setImageBitmap(result);
                progressDialog.dismiss();
            } else {
                Log.d("demo", "Null Data");
            }
        }
    }
}
