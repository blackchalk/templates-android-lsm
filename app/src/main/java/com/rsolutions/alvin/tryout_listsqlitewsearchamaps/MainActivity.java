package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity{
    EditText editsearch;
ListView listView;
private ArrayList<String> mItems;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editsearch = (EditText)findViewById(R.id.editText1);
        listView = (ListView)findViewById(R.id.listView);

        mItems = new ArrayList<>();
        mItems.add("Diary of a Wimpy Kid 6: Cabin Fever");
        mItems.add("Steve Jobs");
        mItems.add("Inheritance (The Inheritance Cycle)");
        mItems.add("11/22/63: A Novel");
        mItems.add("The Hunger Games");
        mItems.add("The LEGO Ideas Book");
        mItems.add("Explosive Eighteen: A Stephanie Plum Novel");
        mItems.add("Catching Fire (The Second Book of the Hunger Games)");
        mItems.add("Elder Scrolls V: Skyrim: Prima Official Game Guide");
        mItems.add("Death Comes to Pemberley");
        mItems.add("Diary of a Wimpy Kid 6: Cabin Fever");
        mItems.add("Steve Jobs");
        mItems.add("Inheritance (The Inheritance Cycle)");
        mItems.add("11/22/63: A Novel");
        mItems.add("The Hunger Games");
        mItems.add("The LEGO Ideas Book");
        mItems.add("Explosive Eighteen: A Stephanie Plum Novel");
        mItems.add("Catching Fire (The Second Book of the Hunger Games)");
        mItems.add("Elder Scrolls V: Skyrim: Prima Official Game Guide");
        mItems.add("Death Comes to Pemberley");

        listView.setAdapter(new CustomArrayAdapter(MainActivity.this, mItems));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()  {

@Override
public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {

        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        intent.putExtra("thanhcs",mItems.get(position));
        startActivity(intent); //when you click,

        //open new activity and intent text
        }


        });


        editsearch.addTextChangedListener(new TextWatcher() { //edit search
//Event when changed word on EditTex
@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
        ArrayList<String> temp = new ArrayList<String>();
        int textlength = editsearch.getText().length();
        temp.clear();
        for (int i = 0; i < mItems.size(); i++)
        {
        if (textlength <= mItems.get(i).length())
        {
        if(editsearch.getText().toString().equalsIgnoreCase(
        (String)
        mItems.get(i).subSequence(0,
        textlength)))
        {
        temp.add(mItems.get(i));
        }
        }
        }
        listView.setAdapter(new CustomArrayAdapter(MainActivity.this, temp));
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

        }

