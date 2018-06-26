package com.example.williambrown.inclass6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by williambrown on 6/8/17.
 */

public class ListItemUI extends LinearLayout {

    public ImageView thumbNail;
    public TextView title;
    public NewsAricle aricle;

    public ListItemUI(Context context){
        super(context);
        inflateXML(context);

    }

    private void inflateXML(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.listitem, this);
        this.thumbNail = (ImageView) findViewById(R.id.thumbNail);
        this.title = (TextView) findViewById(R.id.storyTitle);
    }

    public void OnClickListener(View v){
    }

    public NewsAricle getAricle() {
        return aricle;
    }

    public void setAricle(NewsAricle aricle) {
        this.aricle = aricle;
    }
}