package com.example.williambrown.inclass9;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public static Map expensesMap;
    ListView expenseView;
    ExpenseAdapter adapter = null;
    ArrayList<Expenses> arrayList;

    public static DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    public static DatabaseReference conditionRef = rootRef.child("expenses");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expensesMap = new HashMap<String, Expenses>();
        arrayList = new ArrayList<Expenses>(expensesMap.values());


        expenseView = (ListView) findViewById(R.id.expense_list);

        ImageButton add = (ImageButton) findViewById(R.id.add_expense);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        adapter = new ExpenseAdapter(MainActivity.this, R.layout.expense_holder, arrayList);
        expenseView.setAdapter(adapter);


        expenseView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Expenses remove = adapter.getItem(position);
                adapter.remove(remove);
                expensesMap.remove(remove.getTrasactionID());
                conditionRef.setValue(expensesMap);

                return true;
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Expenses expenses = data.getValue(Expenses.class);
                    expensesMap.put(expenses.getTrasactionID(), expenses);

                }
                arrayList = new ArrayList<Expenses>(expensesMap.values());
                adapter = new ExpenseAdapter(MainActivity.this, R.layout.expense_holder, arrayList);
                expenseView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
