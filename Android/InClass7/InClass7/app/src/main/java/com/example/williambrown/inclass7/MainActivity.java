package com.example.williambrown.inclass7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    ListView listView;
    Switch sort = null;
    ArrayList<Tunes> tunesList = new ArrayList<Tunes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        sort = (Switch) findViewById(R.id.switch_sort);

        final TextView limit = (TextView) findViewById(R.id.seek_view);
        limit.setText("Limit: 10");
        final TextView name = (TextView) findViewById(R.id.search_field);

        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar2);
        seek.setMax(30);
        seek.setProgress(10);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 10){
                    seek.setProgress(10);
                }
                limit.setText("Limit: " + seek.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnectedOnline()){
                    if(seek.getProgress() >= 10 && !name.getText().equals("")){

                        String search = name.getText().toString().trim().replace(' ', '+');
                        GetTracks getTracks = new GetTracks(MainActivity.this,sort.isChecked());
                        getTracks.execute("https://itunes.apple.com/search?term=" + search +"&limit=" + seek.getProgress());
                    } else {
                        Toast.makeText(getApplicationContext(), "All fields must be complete", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                name.setHint(getString(R.string.searchHint));
                seek.setProgress(10);
                limit.setText("Limit: 10");
                if(listView.getAdapter() != null){
                    listView.setAdapter(null);
                }
            }
        });

        sort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isConnectedOnline()) {
                    if (seek.getProgress() >= 10 && !name.getText().equals("")) {
                        String search = name.getText().toString().trim().replace(' ', '+');
                        GetTracks getTracks = new GetTracks(MainActivity.this, isChecked);
                        getTracks.execute("https://itunes.apple.com/search?term=" + search + "&limit=" + seek.getProgress());
                    }
                }
            }
        });

    }

    private boolean isConnectedOnline(){

        ConnectivityManager connection = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connection.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }

        return false;
    }
}
