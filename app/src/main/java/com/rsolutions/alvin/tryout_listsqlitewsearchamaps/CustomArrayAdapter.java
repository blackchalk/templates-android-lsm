package com.rsolutions.alvin.tryout_listsqlitewsearchamaps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by r on 8/10/15.
 */
public class CustomArrayAdapter extends ArrayAdapter<String>{
    Context context;
    ArrayList<String> arrayList;

    private LayoutInflater inflater;

    public CustomArrayAdapter(Activity context, ArrayList<String> arrayList) {
        super(context,R.layout.single_item,arrayList);
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public Context getContext(){
        return super.getContext();
    }
    @SuppressWarnings("rawtypes")
    @Override
    public View getView(final int position,View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        convertView = inflater.inflate(R.layout.single_item, null);
        holder.tv= (TextView)convertView.findViewById(R.id.tv);
        holder.img = (ImageView)convertView.findViewById(R.id.imageView1);
        holder.tv.setText(arrayList.get(position));
        holder.img.setImageResource(R.drawable.abc_list_divider_mtrl_alpha);
        convertView.setTag(holder);
        return convertView;

    }
    static class ViewHolder{
        TextView tv;
        ImageView img;
//        ImageView icon;
//          ProgressBar progressBar;
//        int position;

    }
}
