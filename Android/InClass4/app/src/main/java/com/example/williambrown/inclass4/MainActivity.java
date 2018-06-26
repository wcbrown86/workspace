package com.example.williambrown.inclass4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    SeekBar passwordCount;
    SeekBar passwordLength;
    TextView selectedPassword;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordCount = (SeekBar) findViewById(R.id.count_seek);
        final TextView showPasswordLength = (TextView) findViewById(R.id.password_length);
        passwordLength = (SeekBar) findViewById(R.id.password_seek);

        final TextView showPasswordCount = (TextView) findViewById(R.id.password_count);

        passwordCount.setMax(10);
        passwordCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                showPasswordCount.setText(String.valueOf(progress));

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        passwordLength.setMax(23);
        passwordLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                showPasswordLength.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        Button thread = (Button) findViewById(R.id.thread_button);
        thread.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(correctSeek()){
                    ExecutorService threadPool = Executors.newFixedThreadPool(2);
                    threadPool.execute(new Runnable() {

                        String[] passwords = new String[passwordCount.getProgress()];

                        private void sendMsg(String msg){
                            Bundle bundle = new Bundle();
                            bundle.putString("STATUS", msg);
                            bundle.putStringArray("LIST", passwords);
                            Message message = new Message();
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }

                        public void run(){


                            Util generatePasswords = new Util();
                            for(int i = 0; i < passwordCount.getProgress(); i++){

                                passwords[i] = generatePasswords.getPassword(passwordLength.getProgress(),
                                        true,true,true,true);
                            }

                            sendMsg("complete");



                        }
                    });

                }
            }
        });

        Button aysncButton = (Button) findViewById(R.id.async_button);
        aysncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MakePasswords().execute(passwordCount.getProgress(), passwordLength.getProgress());
            }
        });

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                final int[] i = {0};
                final String[] passwords = msg.getData().getStringArray("LIST");
                ProgressDialog progress = new ProgressDialog(MainActivity.this);
                progress.setMessage("Loading");
                progress.setMax(100);
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                if(msg.getData().get("STATUS").equals("complete")){

                    AlertDialog.Builder showPasswords = new AlertDialog.Builder(MainActivity.this);


                    showPasswords.setTitle("Passwords").setItems(passwords, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            i[0] = which;

                        }
                    });
                    showPasswords.show();
                } else {

                    progress.setProgress(msg.getData().getInt("PROGRESS"));


                }
                return false;
            }

        });
    }

    private boolean correctSeek() {

        if(passwordCount.getProgress() > 0 && passwordLength.getProgress() > 7 ){
            return true;
        } else {
            Toast.makeText(getApplicationContext(),"Selection of Number or passwords or Password Lenght is Incorrect", Toast.LENGTH_LONG)
                    .show();
            return false;
        }
    }

    private class MakePasswords extends AsyncTask<Integer, Integer, String[]>{

        @Override
        protected String[] doInBackground(Integer... params) {
            String[] passwords = new String[params[0]];
            Util generatePasswords = new Util();
            for(int i = 0; i < params[0]; i++){

                passwords[i] = generatePasswords.getPassword(params[1],
                        true,true,true,true);
            }

            return passwords;
        }

        protected void onPostExecute(String[] results){
            AlertDialog.Builder showPasswords = new AlertDialog.Builder(MainActivity.this);
            String[] passwords = results;
            final int[] i = {0};
            showPasswords.setTitle("Passwords").setItems(passwords, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    i[0] = which;
                }
            });
            showPasswords.show();
        }
    }
}


