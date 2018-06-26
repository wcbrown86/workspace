package com.example.williambrown.inclass7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by williambrown on 6/15/17.
 */

public class TunesAdapter extends ArrayAdapter<Tunes> {

    Context context;
    List<Tunes> list;
    int resource;

    public TunesAdapter(Context context, int resource, List<Tunes> objects) {
        super(context, resource, objects);

        this.context = context;
        this.list = objects;
        this.resource = resource;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.track = (TextView) convertView.findViewById(R.id.trackTitle);
            holder.artist = (TextView) convertView.findViewById(R.id.artistName);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);

        }
        holder = (ViewHolder) convertView.getTag();

        TextView track = holder.track;
        track.setText("Track: " + list.get(position).getTrackName());

        TextView artist = holder.artist;
        artist.setText("Artist: " + list.get(position).getArtist());

        TextView price = holder.price;
        price.setText("Price: " + Double.toString(list.get(position).getTrackPrice()));

        TextView date = holder.date;
        date.setText("Date: " + list.get(position).getDate());




        return convertView;
    }
    static class ViewHolder{

        TextView artist;
        TextView track;
        TextView price;
        TextView date;
    }
}
