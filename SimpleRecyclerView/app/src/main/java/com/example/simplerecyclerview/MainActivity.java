package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrConatct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        FloatingActionButton btnOpenDialog = findViewById(R.id.btnOpenDialog);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //add data to a model

        ContactModel model = new ContactModel(R.drawable.user , "Junaid Ansari" , "9821209258");
        arrConatct.add(model);

        // simple way to add
        arrConatct.add(new ContactModel(R.drawable.user , "Khan Shaz" , "8898991579"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ayaan Khan" , "9892993952"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ayaan Khan" , "9899874561"));
        arrConatct.add(new ContactModel(R.drawable.user , "Sohail Khan" , "987456325"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ansar " , "7896321458"));
        arrConatct.add(new ContactModel(R.drawable.user , "Yash Pitre" , "7539514568"));
        arrConatct.add(new ContactModel(R.drawable.user , "Brijesh Pal" , "8524567534"));
        arrConatct.add(new ContactModel(R.drawable.user , "Harsh R" , "9514568527"));
        arrConatct.add(new ContactModel(R.drawable.user , "Abrab Khan" , "8527531479"));
        arrConatct.add(new ContactModel(R.drawable.user , "Nitesh Aru" , "9514569874"));
        arrConatct.add(new ContactModel(R.drawable.user , "Khan F" , "8898991147"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ayaan Khan" , "9892993958"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ayaan Khan" , "9899874561"));
        arrConatct.add(new ContactModel(R.drawable.user , "Sohail Khan" , "987456325"));
        arrConatct.add(new ContactModel(R.drawable.user , "Ayaan Khan" , "7896321458"));
        arrConatct.add(new ContactModel(R.drawable.user , "Yash Pitre" , "7539514568"));
        arrConatct.add(new ContactModel(R.drawable.user , "Brijesh Pal" , "8524567534"));
        arrConatct.add(new ContactModel(R.drawable.user , "Harsh R" , "9514568527"));
        arrConatct.add(new ContactModel(R.drawable.user , "Abrab Khan" , "8527531479"));
        arrConatct.add(new ContactModel(R.drawable.user , "Nitesh Aru" , "9514569874"));

        //
        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this , arrConatct);
        recyclerView.setAdapter(adapter);


    }
}