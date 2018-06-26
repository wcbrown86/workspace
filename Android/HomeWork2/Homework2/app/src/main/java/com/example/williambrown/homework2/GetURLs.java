package com.example.williambrown.homework2;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by williambrown on 6/8/17.
 */

public class GetURLs extends AsyncTask<String, Integer, String[]> {

    MainActivity activity;
    String[] urls = null;

    public GetURLs(MainActivity activity){
        this.activity = activity;
    }


    @Override
    protected String[] doInBackground(String... params) {

        StringBuilder builder;

        try {

            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int status = urlConnection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                builder = new StringBuilder();
                String line = reader.readLine();

                while (line != null){
                    builder.append(line);
                    line = reader.readLine();
                }

                urls = builder.toString().split(";");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return urls;
        }
    }

    @Override
    protected void onPostExecute(String[] s) {
        super.onPostExecute(s);

        activity.savedURLS = urls;
        activity.display(1);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
