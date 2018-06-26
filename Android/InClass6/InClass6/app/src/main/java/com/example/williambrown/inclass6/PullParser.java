package com.example.williambrown.inclass6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by williambrown on 6/8/17.
 */

public class PullParser {


    static ArrayList<NewsAricle> parseArticle(InputStream in) throws XmlPullParserException, IOException {

        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(in, "UTF-8");
        NewsAricle aricle =null;
        ArrayList<NewsAricle> ariclesList = new ArrayList<NewsAricle>();
        int event = parser.getEventType();

        while (event != XmlPullParser.END_DOCUMENT){

            switch (event){
                case XmlPullParser.START_TAG:
                    if(parser.getName().equals("title")){
                        aricle = new NewsAricle();
                        aricle.setTitle(parser.nextText().trim());
                    } else if(parser.getName().equals("link")){
                        aricle.setLink(parser.nextText().trim());
                    } else if(parser.getName().equals("media:content")){
                        aricle.setPhotoLink(parser.getAttributeValue(null,"url"));
                        aricle.setHight(Integer.parseInt(parser.getAttributeValue(null,"height").trim()));
                        aricle.setWidth(Integer.parseInt(parser.getAttributeValue(null,"width").trim()));
                        Bitmap image = null;
                        try {

                            URL url = new URL(aricle.getPhotoLink());
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                            urlConnection.setRequestMethod("GET");

                            image = BitmapFactory.decodeStream(urlConnection.getInputStream());



                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            aricle.setPhoto(image);
                        }
                    } else if(parser.getName().equals("description")){
                        aricle.setDescription(parser.nextText().trim());
                    } else if(parser.getName().equals("pubDate")){
                        aricle.setPubDate(parser.nextText().trim());
                    }
                    break;

                case XmlPullParser.END_TAG:
                    if(parser.getName().equals("item")){
                        ariclesList.add(aricle);
                        aricle = null;
                    }
                    break;
                default:
                    break;
            }


            event = parser.next();
        }


        return ariclesList;
    }
}
