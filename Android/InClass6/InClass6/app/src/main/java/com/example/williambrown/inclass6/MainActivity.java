package com.example.williambrown.inclass6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NewsAricle> ariclesList = null;
    LinearLayout container;
    ScrollView sv_main = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv_main = (ScrollView) findViewById(R.id.scview);
        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        ariclesList = new ArrayList<NewsAricle>();

        GetArticleAsyncTask articleAsyncTask = new GetArticleAsyncTask(MainActivity.this);
        articleAsyncTask.execute("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");

    }





}
