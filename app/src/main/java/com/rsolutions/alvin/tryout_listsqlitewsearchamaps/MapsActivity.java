package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    public static final String sLATITUDE="i_lat";
    public static final String sLONGITUDE="i_lon";
    public static final String sNAME="i_name";

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        Intent i = getIntent();
        String name = i.getExtras().getString(sNAME);
        final double lat = i.getDoubleExtra(sLATITUDE, 0);
        final double lon= i.getDoubleExtra(sLONGITUDE,0);


        gotoLocation(new LatLng(lat,lon),name);
//        Log.v("MAPSS",""+lat);
//        mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lon)).title("Target").snippet(name));
    }
    public void gotoLocation(LatLng latLng,String locString){

        if(mMap==null)
            return;
        //add a marker for the given location
        MarkerOptions markerOpt = new MarkerOptions()
                .draggable(false)
                .flat(false)
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("You choose:")
                .snippet(locString);
        //see the onMarkedClicked callback for why we do this
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        //draw this marker
        mMap.addMarker(markerOpt);
    }
}
