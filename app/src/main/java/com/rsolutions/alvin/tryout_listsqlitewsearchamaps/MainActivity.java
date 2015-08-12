package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
//TODO working as of:{@link:aug112015}

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    EditText editsearch;
    ListView lv;
    private ArrayList<String> mItems;
    Button btnAdd;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.btn_id);
        btnAdd.setOnClickListener(this);

        editsearch = (EditText)findViewById(R.id.editText1);
        lv = (ListView)findViewById(R.id.listview);

        mItems = new ArrayList<>();
        mItems.add("Marikina City");
        mItems.add("Pasig City");
        mItems.add("Roxas Boulevard");
        mItems.add("Cubao");
        mItems.add("Rizal");
        mItems.add("Quezon City");
        mItems.add("Manila");
        mItems.add("Angeles City");
        mItems.add("Paranaque City");


        lv.setAdapter(new CustomArrayAdapter(MainActivity.this, mItems));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()  {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("intentposition",mItems.get(position));
            //TODO somewhere here you need to pass the position from db
            startActivity(intent);
            //open new activity and intent text
            }


        });



        editsearch.addTextChangedListener(new TextWatcher() { //edit search
        //Event when changed word on EditTex
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        final ArrayList<String> temp = new ArrayList<String>();
        int textlength = editsearch.getText().length();
        temp.clear();
        for (int i = 0; i < mItems.size(); i++)
        {
        if (textlength <= mItems.get(i).length())
            {
            if(editsearch.getText().toString().equalsIgnoreCase((String) mItems.get(i).subSequence(0, textlength)))
                {
                temp.add(mItems.get(i));
                }
            }
        }
        lv.setAdapter(new CustomArrayAdapter(MainActivity.this, temp));
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra("intentposition", temp.get(position));
                    //TODO somewhere here you need to pass the position from db
                    startActivity(intent);
                    //open new activity and intent text

                }
            });
        }


@Override
public void beforeTextChanged(CharSequence s, int start, int count,
        int after) {
        // TODO Auto-generated method stub

        }
@Override
public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

        }
        });

        }


@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

    @Override
    public void onClick(View v) {
        if(v==findViewById(R.id.btn_id)){
            //add button intent service
            Intent intent = new Intent(this,PlaceInfo.class);
            intent.putExtra("addintent", 0);
            startActivity(intent);

        }

    }
}

