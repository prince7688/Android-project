package com.example.hp.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);
        ArrayList<Word> arrayList =new ArrayList<Word>();
        arrayList.add(new Word("Red","weṭeṭṭi",R.drawable.color_red));
        arrayList.add(new Word("Green","chokokki",R.drawable.color_green));
        arrayList.add(new Word("Brown","ṭakaakki",R.drawable.color_brown));
        arrayList.add(new Word("Gray","ṭopoppi",R.drawable.color_gray));
        arrayList.add(new Word("Black","kululli",R.drawable.color_black));
        arrayList.add(new Word("White","kelelli",R.drawable.color_white));
        arrayList.add(new Word("Dusty Yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        arrayList.add(new Word("Mustard Yellow","chiwiiṭә",R.drawable.color_mustard_yellow));
        Wordaddpter wordaddpter =new Wordaddpter(this,arrayList,R.color.colors);
        ListView ls = (ListView)findViewById(R.id.list_item);
        ls.setAdapter(wordaddpter);
    }
}
