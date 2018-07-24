package com.example.hp.miwokapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 5/25/2018.
 */

public class Wordaddpter extends ArrayAdapter<Word> {

    int mcolorresourseid;

    public Wordaddpter(@NonNull Context context, ArrayList<Word>arrayList,int colorid) {
        super(context, 0, arrayList);
        mcolorresourseid =colorid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentword =getItem(position);
        View listitemview =convertView;
        if(listitemview == null)
        {
            listitemview =LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView tx5 =(TextView)listitemview.findViewById(R.id.textView5);
        TextView tx6 =(TextView)listitemview.findViewById(R.id.textView6);
        ImageView img =(ImageView)listitemview.findViewById(R.id.img);
        ImageView playimg =(ImageView)listitemview.findViewById(R.id.playicon);
        tx5.setText(currentword.getmDefaultWord());
        tx6.setText(currentword.getmMiwokWord());
        if(currentword.getmImageResourseId()==0)
        {
              img.setVisibility(View.GONE);
        }
        img.setImageResource(currentword.getmImageResourseId());
        View textcontainer = listitemview.findViewById(R.id.lnout);
        int color= ContextCompat.getColor(getContext(),mcolorresourseid);
        textcontainer.setBackgroundColor(color);
        return listitemview;
    }
}
