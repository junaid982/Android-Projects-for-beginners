package com.example.androidwithsqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidwithsqlitedatabase.data.MyDbHandler;
import com.example.androidwithsqlitedatabase.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        Contact std = new Contact();
        Contact std1 = new Contact();
        Contact std2 = new Contact();
        Contact std3 = new Contact();
        Contact std4 = new Contact();

        std.setName("Junaid Ansari");
        std.setName("9821209237");

        std1.setName("Khan Shaziya");
        std1.setName("8898991357");

        std2.setName("Ansari Junaid");
        std2.setName("9892339358");

        std3.setName("Ayaan");
        std3.setName("987456321");

        std4.setName("Ansari");
        std4.setName("789654123");

        db.addContact(std);
        db.addContact(std1);
        db.addContact(std2);
        db.addContact(std3);
        db.addContact(std4);

    }
}