package com.example.williambrown.inclass5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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
 * Created by williambrown on 6/6/17.
 */

public class GetNews extends AsyncTask<String, Void, LinkedList<NewsArticle>> {

    LinkedList<NewsArticle> newsList = new LinkedList<NewsArticle>();
    private MainActivity activity;

    public GetNews(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected LinkedList<NewsArticle> doInBackground(String... params) {



        try {

            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int status = urlConnection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();

                while (line != null){
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
            return newsList;
        }
    }

    private void parseJSON(String s) {

        try {
            JSONObject object = new JSONObject(s);
            JSONArray news = object.getJSONArray("articles");

            for(int i = 0; i < news.length(); i++){
                JSONObject newsObject = news.getJSONObject(i);
                NewsArticle article = new NewsArticle();

                article.setAuthor(newsObject.getString("author"));

                String [] date = newsObject.getString("publishedAt").split("[T]");
                article.setDate(date[0]);

                article.setDescription(newsObject.getString("description"));
                article.setImageURL(newsObject.getString("urlToImage"));
                article.setTitle(newsObject.getString("title"));

                newsList.add(article);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(LinkedList<NewsArticle> newsArticles) {
        super.onPostExecute(newsArticles);
        Toast.makeText(activity, "Finishted Executtion", Toast.LENGTH_LONG);
        activity.articles = newsArticles;
        activity.display(0);

    }
}
