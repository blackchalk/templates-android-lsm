package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by r on 8/10/15.
 */
public class SubActivity extends Activity{

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setContentView(R.layout.sub_activity);
        super.onCreate(savedInstanceState);
        tv =(TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        String text = intent.getExtras().getString("thanhcs");
        tv.setText(""+text);
    }
}

