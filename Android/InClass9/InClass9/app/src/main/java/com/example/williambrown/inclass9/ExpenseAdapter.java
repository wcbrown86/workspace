package com.example.williambrown.inclass9;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by williambrown on 6/15/17.
 */

public class ExpenseAdapter extends ArrayAdapter<Expenses> {

    Context context;
    List<Expenses> list;
    int resource;

    public ExpenseAdapter(Context context, int resource, List<Expenses> objects) {
        super(context, resource, objects);

        this.context = context;
        this.list = objects;
        this.resource = resource;


    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();

            convertView.setTag(holder);
            holder.amount = (TextView) convertView.findViewById(R.id.amount_holder);
            holder.name = (TextView) convertView.findViewById(R.id.name_holder);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();

        TextView name = holder.name;
        name.setText(list.get(position).getName());

        TextView amount = holder.amount;
        amount.setText(Double.toString(list.get(position).getAmount()));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main3Activity.class);
                intent.putExtra("KEY", list.get(position).getTrasactionID());
                context.startActivity(intent);
            }
        });


        return convertView;
    }
    static class ViewHolder{

        TextView name;
        TextView amount;
    }
}