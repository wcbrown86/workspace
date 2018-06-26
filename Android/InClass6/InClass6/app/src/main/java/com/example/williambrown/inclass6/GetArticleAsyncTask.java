package com.example.williambrown.inclass6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by williambrown on 6/8/17.
 */

public class GetArticleAsyncTask extends AsyncTask<String, Void, ArrayList<NewsAricle>> {

    MainActivity activity;
    ProgressDialog progressDialog;

    public GetArticleAsyncTask(MainActivity activity) {
        this.activity = activity;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait..");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected void onPostExecute(ArrayList<NewsAricle> aricles) {
        super.onPostExecute(aricles);

        if (aricles != null) {
            for(final NewsAricle news: aricles){
                ListItemUI item = new ListItemUI(activity);
                View itemView = (View) item;
                item.thumbNail.setImageBitmap(news.getPhoto());
                item.title.setText(news.getTitle());
                item.setAricle(news);
                itemView.setClickable(true);
                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent seeDetails = new Intent(activity, Main2Activity.class);
                        seeDetails.putExtra("TITLE", news.getTitle());
                        seeDetails.putExtra("DATE", news.getPubDate());
                        seeDetails.putExtra("PHOTO", news.getPhoto());
                        seeDetails.putExtra("DESC", news.getDescription());
                        activity.startActivity(seeDetails);
                    }
                });


                activity.container.addView(itemView);
            }

            activity.sv_main.addView(activity.container);
            progressDialog.dismiss();


        } else {
            Toast.makeText(activity, "Articles are Null!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected ArrayList<NewsAricle> doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {

                InputStream in = connection.getInputStream();

                //Thread.sleep(5000);

                return PullParser.parseArticle(in);

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {

            e.printStackTrace();
        }

        return null;
    }

}
