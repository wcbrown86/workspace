package com.example.williambrown.midtearm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by williambrown on 6/13/17.
 */


public class GetTracks extends AsyncTask<String, Void, LinkedList<Tunes>> {

    LinkedList<Tunes> tunesList = new LinkedList<Tunes>();
    private MainActivity activity;
    ProgressDialog progressDialog;

    public GetTracks(MainActivity activity) {
        this.activity = activity;
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
    protected LinkedList<Tunes> doInBackground(String... params) {


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
            return tunesList;
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


                tunesList.add(tunes);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(LinkedList<Tunes> tune) {
        super.onPostExecute(tune);

        if (tune != null) {
            if(activity.sort.isChecked()){

            }
            for (final Tunes tunes : tune) {
                ListItemUI item = new ListItemUI(activity);
                View itemView = (View) item;

                item.artistName.setText(tunes.getArtist());
                item.price.setText(Double.toString(tunes.getTrackPrice()));
                item.date.setText(tunes.getDate());
                item.track.setText(tunes.getTrackName());
                item.setTunes(tunes);

                itemView.setClickable(true);
                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent seeDetails = new Intent(activity, Main2Activity.class);
                        seeDetails.putExtra("URL", tunes.getArtworkURL());
                        seeDetails.putExtra("TRACK", tunes.getTrackName());
                        seeDetails.putExtra("GENRE", tunes.getGenre());
                        seeDetails.putExtra("ARTIST", tunes.getArtist());
                        seeDetails.putExtra("ALBUM", tunes.getAlbum());
                        seeDetails.putExtra("TPRICE", tunes.getTrackPrice());
                        seeDetails.putExtra("APRICE", tunes.getAlbumPrice());

                        activity.startActivity(seeDetails);
                    }
                });


                activity.container.addView(itemView);
            }

            activity.scrollView.addView(activity.container);
            progressDialog.dismiss();

        }
    }


}