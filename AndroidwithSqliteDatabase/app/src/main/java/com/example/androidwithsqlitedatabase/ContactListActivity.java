package com.example.androidwithsqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidwithsqlitedatabase.data.MyDbHandler;

public class ContactListActivity extends AppCompatActivity {
    RecyclerView rcl_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        rcl_contact = findViewById(R.id.rcl_contact);
        MyDbHandler db = new MyDbHandler(this);
        LinearLayoutManager manager =new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rcl_contact.setLayoutManager(manager);
        rcl_contact.setAdapter(new ContactAdapter(db.getAllContacts()));

    }
}