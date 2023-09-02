package com.example.androidwithsqlitedatabase.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.androidwithsqlitedatabase.model.Contact;
import com.example.androidwithsqlitedatabase.params.Params;

public class MyDbHandler extends SQLiteOpenHelper {

    //constructor
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY , %s TEXT , %s TEXT);",Params.TABLE_NAME ,Params.KEY_ID,Params.KEY_NAME , Params.KEY_PHONE );
        Log.d("db" , String.format("Query being run is : ",create));
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
}










