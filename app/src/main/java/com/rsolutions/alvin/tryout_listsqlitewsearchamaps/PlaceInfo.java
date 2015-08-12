package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by r on 8/11/15.
 */
public class PlaceInfo extends AppCompatActivity implements android.view.View.OnClickListener{

        Button addbtn,deletebtn,btclose;
        EditText editTextname,editTextDesc,editTextlat,editTextlon;
        private int _Place_Id=0;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_info_layout);

        addbtn = (Button) findViewById(R.id.btnSave);
        deletebtn = (Button) findViewById(R.id.btnDelete);
        btclose = (Button) findViewById(R.id.btnClose);

        editTextname = (EditText) findViewById(R.id.editPlaceName);
        editTextDesc = (EditText) findViewById(R.id.editPlaceDesc);
        editTextlat = (EditText) findViewById(R.id.editLat);
        editTextlon= (EditText) findViewById(R.id.editLon);

        addbtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        btclose.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.btnSave)){
            PlaceRepo repo = new PlaceRepo(this);
            Place place = new Place();
            place.lon = Double.parseDouble(editTextlon.getText().toString());
            place.lat=Double.parseDouble(editTextlat.getText().toString());
            place.desc=editTextDesc.getText().toString();
            place.name=editTextname.getText().toString();
            place.place_ID=_Place_Id;

            if (_Place_Id==0){
                _Place_Id = repo.insert(place);

                Toast.makeText(this,"New Place Added!", Toast.LENGTH_SHORT).show();
            }else{

                repo.update(place);
                Toast.makeText(this,"Records updated",Toast.LENGTH_SHORT).show();
            }
        }else if (v== findViewById(R.id.btnDelete)){
            PlaceRepo repo = new PlaceRepo(this);
            repo.delete(_Place_Id);
            Toast.makeText(this, "Place Deleted", Toast.LENGTH_SHORT).show();//show inserted by me
            finish();
        }else if (v== findViewById(R.id.btnClose)){
            finish();
        }


    }



}