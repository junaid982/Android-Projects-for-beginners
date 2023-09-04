package com.example.androidwithsqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.androidwithsqlitedatabase.data.MyDbHandler;
import com.example.androidwithsqlitedatabase.model.Contact;

import java.util.ArrayList;
import java.util.List;

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
        std.setPhoneNumber("9821209237");

        std1.setName("Khan Shaziya");
        std1.setPhoneNumber("8898991357");

        std2.setName("Ansari Junaid");
        std2.setPhoneNumber("9892339358");

        std3.setName("Ayaan");
        std3.setPhoneNumber("987456321");

        std4.setName("Ansari");
        std4.setPhoneNumber("789654123");

        db.addContact(std);
        db.addContact(std1);
        db.addContact(std2);
        db.addContact(std3);
        db.addContact(std4);


        // update data
        std4.setId(11);
        std4.setName("Changed Junaid");
        std4.setPhoneNumber("000000000");

        int affectedRows = db.updateContact(std4);
        Log.d("db", "No of Effected Rows " + affectedRows);


        //Delete contact
        std1.setId(1);

        db.deleteContactById(std1);

        //get all data
        ArrayList<Contact> allContacts = db.getAllContacts();

        Log.d("db", "All Contact List " + allContacts + "\n");

        for (int i = 0; i < allContacts.size(); i++) {
            Log.d("db1>>>>>>>>>>>>>>>", String.format("Id : %s \n Name : %s \n Phone Number : %s \n ,", allContacts.get(i).getId(), allContacts.get(i).getName(), allContacts.get(i).getPhoneNumber()));
        }


        for (Contact contact : allContacts) {
            Log.d("db2>>>>>>>>>>>>>>>", String.format("Id : %s \n Name : %s \n Phone Number : %s \n ,", contact.getId(), contact.getName(), contact.getPhoneNumber()));
        }
        startActivity(new Intent(MainActivity.this, ContactListActivity.class));


    }
}




















