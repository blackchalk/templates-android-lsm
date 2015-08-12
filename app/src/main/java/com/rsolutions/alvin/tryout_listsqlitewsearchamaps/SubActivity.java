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

    TextView tv,tv2;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setContentView(R.layout.sub_activity);
        super.onCreate(savedInstanceState);
        tv =(TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        final String text = intent.getExtras().getString("intentposition");
        tv.setText(""+text);
        tv2.setText("subactivity");
        img = (ImageView)findViewById(R.id.imageView1);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageView1:
                        //TODO open intent and activity here.
                        // and redirect to a mapactivity
                        //search for a match for text in database and
                        // get latitude longitude via persistent data
                        //load map on next activity
                        Log.v("IMAGE CLICKED", "CLICKED " + v.getId() + " " + text);
                        break;
                }
            }
        });
    }
}

