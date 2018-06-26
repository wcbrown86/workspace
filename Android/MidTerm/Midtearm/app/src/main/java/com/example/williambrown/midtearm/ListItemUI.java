package com.example.williambrown.midtearm;

/**
 * Created by williambrown on 6/13/17.
 */

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

    public TextView artistName;
    public TextView price;
    public TextView track;
    public TextView date;
    public Tunes tunes;

    public ListItemUI(Context context){
        super(context);
        inflateXML(context);

    }

    private void inflateXML(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.listitem, this);
        this.artistName = (TextView) findViewById(R.id.artistName);
        this.price = (TextView) findViewById(R.id.price);
        this.track = (TextView) findViewById(R.id.trackTitle);
        this.date = (TextView) findViewById(R.id.date);
    }

    public Tunes getTunes() {
        return tunes;
    }

    public void setTunes(Tunes tunes) {
        this.tunes = tunes;
    }
}