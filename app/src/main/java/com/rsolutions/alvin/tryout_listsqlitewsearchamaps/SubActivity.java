package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by r on 8/10/15.
 */
public class SubActivity extends Activity{

    TextView tv,tv2,tv3;
    ImageView img;
    public Double latitude=null;
    public Double longitude=null;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setContentView(R.layout.sub_activity);
        super.onCreate(savedInstanceState);
        //point data to layouts
        tv =(TextView)findViewById(R.id.tv);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.textView5);

        //


        Intent intent = getIntent();
        final String text = intent.getExtras().getString("intentposition");
        //TODO aug121103
        PlaceRepo repo = new PlaceRepo(this);
        Place place = new Place();
        place= repo.getPlacebyName(text);
//        Log.v("SUBACTIVITY TEXTVIEW: ",""+Double.valueOf(place.lat).toString());
        tv2.setText(Double.valueOf(place.lat).toString());
        tv3.setText(Double.valueOf(place.lon).toString());
        tv.setText(""+text);
        img = (ImageView)findViewById(R.id.imageView1);

        latitude=place.lat;
        longitude=place.lon;
        name=place.name;

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO open intent and activity here.
                // and redirect to a mapactivity
                //search for a match for text in database and
                // get latitude longitude via persistent data
                //load map on next activity
                switch (v.getId()) {
                    case R.id.imageView1:
                        Intent i=new Intent(SubActivity.this,MapsActivity.class);
                        i.putExtra("i_lat",latitude);
                        i.putExtra("i_lon",longitude);
                        i.putExtra("i_name",name);
                        startActivity(i);

                        Log.v("IMAGE CLICKED", "CLICKED " + v.getId() + " " + text);

                }

            }
        });



    }

}

