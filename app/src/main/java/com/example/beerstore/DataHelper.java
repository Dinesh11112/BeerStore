package com.example.beerstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String cln_ID = "ID";
    public static final String cln_NAME = "NAME";
    public static final String cln_ADDRESS = "ADDRESS";
    public static final String cln_NUMBER = "NUMBER";
    public static final String cln_QUANTITY = "QUANTITY";

    public DataHelper(@Nullable Context context) {
        super(context, "Customerdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + "(" + cln_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + cln_NAME + " TEXT," + cln_ADDRESS + " TEXT," + cln_NUMBER + " TEXT," + cln_QUANTITY + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(ModelData data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put(cln_NAME, data.getName());
        cv.put(cln_ADDRESS, data.getAddress());
        cv.put(cln_NUMBER, data.getNumber());
        cv.put(cln_QUANTITY, data.getQuantitiy());
        long insert = db.insert(CUSTOMER_TABLE, null, cv);

        if(insert== -1){
            return false;
        }
        else {
            return true;
        }
    }
}
