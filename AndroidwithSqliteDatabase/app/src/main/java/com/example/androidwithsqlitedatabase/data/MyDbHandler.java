package com.example.androidwithsqlitedatabase.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.androidwithsqlitedatabase.model.Contact;
import com.example.androidwithsqlitedatabase.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    //constructor
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY , %s TEXT , %s TEXT);",Params.TABLE_NAME ,Params.KEY_ID,Params.KEY_NAME , Params.KEY_PHONE );
        Log.d("db" , String.format("Query being run is : %s",create));
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // ==================== this method is used to add data into a table
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Params.KEY_NAME , contact.getName());
        values.put(Params.KEY_PHONE , contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME , null , values);
        Log.d("db" , "successfully values inserted ");

        db.close();
    }


    // ================== this method return all contacts data
    public List<Contact> getAllContacts(){

        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //generate query to read the database
        String select = String.format("select * from %s;",Params.TABLE_NAME);

        Cursor cursor = db.rawQuery(select , null);


        //loop through the row
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);

            }while (cursor.moveToNext());
        }
        return contactList;

    }


    // ================== this method update existing contact data

    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Params.KEY_NAME , contact.getName());
        values.put(Params.KEY_PHONE , contact.getPhoneNumber());

//        int update = db.update(Params.TABLE_NAME, Params.KEY_ID + "=?", new String[]{String.valueOf((contact.getId()))});
//        return update;
//        return db.update(String table, ContentValues values, String whereClause, String[] whereArgs);
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID+"=?", new String[] {String.valueOf(contact.getId())});

    }

}










