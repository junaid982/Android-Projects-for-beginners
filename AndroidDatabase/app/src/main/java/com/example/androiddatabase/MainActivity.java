package com.example.androiddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androiddatabase.data.MyDbHandler;
import com.example.androiddatabase.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        Contact junaid = new Contact();

        junaid.setPhoneNumber("9821209237");
        junaid.setName("Junaid Ansari");

        db.addContact(junaid);
    }
}