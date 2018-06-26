package com.example.williambrown.inclass7;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by williambrown on 6/15/17.
 */

public class GetTracks extends AsyncTask<String, Void, ArrayList<Tunes>> {

    ArrayList<Tunes> tunesArrayList = new ArrayList<Tunes>();
    private MainActivity activity;
    ProgressDialog progressDialog;
    boolean isChecked;

    public GetTracks(MainActivity activity, boolean isChecked) {
        this.activity = activity;
        this.isChecked = isChecked;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Loading");
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected ArrayList<Tunes> doInBackground(String... params) {


        try {

            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int status = urlConnection.getResponseCode();

            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();

                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }

                parseJSON(builder.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return tunesArrayList;
        }
    }

    private void parseJSON(String s) {

        try {
            JSONObject object = new JSONObject(s);
            JSONArray tune = object.getJSONArray("results");

            for (int i = 0; i < tune.length(); i++) {
                JSONObject tuneObject = tune.getJSONObject(i);
                Tunes tunes = new Tunes();

                tunes.setTrackName(tuneObject.getString("trackName"));
                tunes.setAlbum(tuneObject.getString("collectionName"));
                tunes.setAlbumPrice(tuneObject.getDouble("collectionPrice"));
                tunes.setTrackPrice(tuneObject.getDouble("trackPrice"));
                tunes.setArtist(tuneObject.getString("artistName"));
                tunes.setArtworkURL(tuneObject.getString("artworkUrl100"));

                String[] date = tuneObject.getString("releaseDate").split("T");
                tunes.setDate(date[0]);

                tunes.setGenre(tuneObject.getString("primaryGenreName"));


                tunesArrayList.add(tunes);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(final ArrayList<Tunes> tunes) {
        super.onPostExecute(tunes);

        if (tunes != null) {
            if (isChecked) {
                Collections.sort(tunes);
            } else {
                Collections.sort(tunes, new PriceComparator());
            }

            activity.tunesList = tunes;
            TunesAdapter arrayAdapter = new TunesAdapter(activity, R.layout.list_items, tunes);

            activity.listView.setAdapter(arrayAdapter);
            activity.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent seeDetails = new Intent(activity, Main2Activity.class);
                    seeDetails.putExtra("URL", tunes.get(position).getArtworkURL());
                    seeDetails.putExtra("TRACK", tunes.get(position).getTrackName());
                    seeDetails.putExtra("GENRE", tunes.get(position).getGenre());
                    seeDetails.putExtra("ARTIST", tunes.get(position).getArtist());
                    seeDetails.putExtra("ALBUM", tunes.get(position).getAlbum());
                    seeDetails.putExtra("TPRICE", tunes.get(position).getTrackPrice());
                    seeDetails.putExtra("APRICE", tunes.get(position).getAlbumPrice());

                    activity.startActivity(seeDetails);
                }
            });
            progressDialog.dismiss();

        }
    }
}


