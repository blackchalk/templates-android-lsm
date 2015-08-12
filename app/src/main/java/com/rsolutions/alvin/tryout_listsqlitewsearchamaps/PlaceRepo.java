package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by r on 8/10/15.
 */
public class PlaceRepo {
    private DatabaseHelper dbHelper;
    private Context context;

    //inserts a place
    public int insert(Place place){
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Place.KEY_lon,place.lon);
        values.put(Place.KEY_lat,place.lat);
        values.put(Place.KEY_desc,place.desc);
        values.put(Place.KEY_name,place.name);
        //Inserting Rows
        long place_Id = db.insert(Place.TABLE,null,values);
        db.close();
        return (int)place_Id;
    }
    public void delete(int place_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Place.TABLE, Place.KEY_ID + "= ?", new String[] { String.valueOf(place_Id) });
        db.close(); // Closing database connection
    }
    public void update(Place place) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Place.KEY_lon, place.lon);
        values.put(Place.KEY_lat,place.lat);
        values.put(Place.KEY_desc, place.desc);
        values.put(Place.KEY_name,place.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Place.TABLE, values, Place.KEY_ID + "= ?", new String[]{String.valueOf(place.place_ID)});
        db.close(); // Closing database connection
    }
    public ArrayList<HashMap<String, String>>  getPlaceList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Place.KEY_ID + "," +
                Place.KEY_name + "," +
                Place.KEY_desc + "," +
                Place.KEY_lat + "," +
                Place.KEY_lon +
                " FROM " + Place.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> placeList = new ArrayList<>();//created arraylist
        // to act as a placeholder for our cursor raw queries temporarily

        Cursor cursor = db.rawQuery(selectQuery, null);//created a cursor with selectquery items
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {//iterate whole row
            do {
                HashMap<String, String> placehashmap = new HashMap<>();//create hashmap
                placehashmap.put("id", cursor.getString(cursor.getColumnIndex(Place.KEY_ID)));
                placehashmap.put("name", cursor.getString(cursor.getColumnIndex(Place.KEY_name)));
//                placehashmap.put("lat",cursor.getString(cursor.getColumnIndex(Place.KEY_lat)));
//TODO so this arraylist will populate our listview with id(hidden from the view actually)& names ..have you consider adding other collumnindex?

                placeList.add(placehashmap);//arraylist

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return placeList;

    } public Place getMovieById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Place.KEY_ID + "," +
                Place.KEY_name + "," +
                Place.KEY_desc + "," +
                Place.KEY_lat + "," +
                Place.KEY_lon +
                " FROM " + Place.TABLE
                + " WHERE " +
                Place.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Place place = new Place();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );


        if (cursor.moveToFirst()) {
            do {
                place.place_ID =cursor.getInt(cursor.getColumnIndex(Place.KEY_ID));
                place.name =cursor.getString(cursor.getColumnIndex(Place.KEY_name));
                place.desc  =cursor.getString(cursor.getColumnIndex(Place.KEY_desc));
                place.lat =cursor.getInt(cursor.getColumnIndex(Place.KEY_lat));
                place.lon =cursor.getInt(cursor.getColumnIndex(Place.KEY_lon));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return place;
    }





}
