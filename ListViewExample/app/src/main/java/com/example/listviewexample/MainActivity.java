package com.example.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> arrNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        arrNames.add("junaid");
        arrNames.add("Shaziya");
        arrNames.add("Ansaro");
        arrNames.add("khan");
        arrNames.add("Ahmad");
        arrNames.add("suraj");
        arrNames.add("Raju");
        arrNames.add("Aleem");
        arrNames.add("Badsha");
        arrNames.add("Nitesh");
        arrNames.add("Ashish");
        arrNames.add("Swapnil");
        arrNames.add("Sagar");
        arrNames.add("Brijesh");
        arrNames.add("Rahul");
        arrNames.add("Aftab");
        arrNames.add("Harsh");
        arrNames.add("Yash");

        // array Adapter

        //default list view item
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , arrNames);

//        custom list view item
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_item, arrNames);
        listView.setAdapter(adapter);


//        setup onClicklistern on listview item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrNames.get(position)+" Selected", Toast.LENGTH_SHORT).show();
            }
        });


    }
}