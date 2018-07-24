package com.example.hp.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);
        ArrayList<Word> arrayList =new ArrayList<Word>();
        arrayList.add(new Word("Where are you going?","minto wuksus"));
        arrayList.add(new Word("What is your name?","tinnә oyaase'nә"));
        arrayList.add(new Word("My name is...","oyaaset..."));
        arrayList.add(new Word("How are you feeling?","michәksәs?"));
        arrayList.add(new Word("I’m feeling good.","Okuchi achit"));
        arrayList.add(new Word("Are you coming?","әәnәs'aa?"));
        arrayList.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        arrayList.add(new Word("I’m coming.","әәnәm"));
        arrayList.add(new Word("Let’s go.","yoowutis"));
        arrayList.add(new Word("Come here.","әnni'nem"));

        Wordaddpter wordaddpter =new Wordaddpter(this,arrayList,R.color.phrases);
        ListView ls = (ListView)findViewById(R.id.list_item);
        ls.setAdapter(wordaddpter);
    }
}
