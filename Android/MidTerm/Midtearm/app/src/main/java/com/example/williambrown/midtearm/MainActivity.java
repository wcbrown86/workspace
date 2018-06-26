package com.example.williambrown.midtearm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    ScrollView scrollView = null;
    Switch sort = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView2);
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
                    if(seek.getProgress() >= 10 && name.getText() != null){

                        String search = name.getText().toString().trim().replace(' ', '+');
                        GetTracks getTracks = new GetTracks(MainActivity.this);
                        getTracks.execute("https://itunes.apple.com/search?term=" + search +"&limit=" + seek.getProgress());
                    }
                }
            }
        });

        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
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
