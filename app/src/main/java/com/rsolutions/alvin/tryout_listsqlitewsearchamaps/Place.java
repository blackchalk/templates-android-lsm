package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

/**
 * Created by r on 8/10/15.
 */
public class Place {
    //Labels table name
    public static final String TABLE = "Place";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_desc = "desc";
    public static final String KEY_lat = "latitude";
    public static final String KEY_lon = "longitude";

    // property help us to keep data
    public int place_ID;
    public String name;
    public String desc;
    public double lat;
    public double lon;
}
