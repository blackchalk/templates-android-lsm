package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by r on 8/10/15.
 */
/**
 * This class helps open, create, and upgrade the database file.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //create db
    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_PLACE = "CREATE TABLE " + Place.TABLE + "("
                + Place.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Place.KEY_name + " TEXT, "
                + Place.KEY_desc + " TEXT, "
                + Place.KEY_lat + " DOUBLE, "
                + Place.KEY_lon + " DOUBLE )";

        db.execSQL(CREATE_TABLE_PLACE);

    }
           //Update the database by checking version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Place.TABLE);

        // Create tables again
        onCreate(db);

    }

}

