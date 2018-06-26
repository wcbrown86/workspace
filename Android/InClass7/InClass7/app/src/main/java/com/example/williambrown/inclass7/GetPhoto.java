package com.example.williambrown.inclass7;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by williambrown on 6/15/17.
 */

public class GetPhoto extends AsyncTask<String, Void, Bitmap> {

    ProgressDialog progressDialog;
    Main2Activity activity;

    public GetPhoto(Main2Activity activity){
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
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(bitmap != null){

            activity.imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();

        }
    }
}
