package com.example.hp.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Familymembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);
        ArrayList<Word> arrayList =new ArrayList<Word>();
        arrayList.add(new Word("Father","әpә",R.drawable.family_father));
        arrayList.add(new Word("Mother","әṭa",R.drawable.family_mother));
        arrayList.add(new Word("Son","angsi",R.drawable.family_son));
        arrayList.add(new Word("Dauhter","tune",R.drawable.family_daughter));
        arrayList.add(new Word("Older Brother","taachi",R.drawable.family_older_brother));
        arrayList.add(new Word("Younger Brother","chalitti",R.drawable.family_younger_brother));
        arrayList.add(new Word("Older Sister","teṭe",R.drawable.family_older_sister));
        arrayList.add(new Word("Younger Sister","kolliti",R.drawable.family_younger_sister));
        arrayList.add(new Word("GrandMother","ama",R.drawable.family_grandmother));
        arrayList.add(new Word("GrandFather","paapa",R.drawable.family_grandfather));

        Wordaddpter wordaddpter =new Wordaddpter(this,arrayList,R.color.family);
        ListView ls = (ListView)findViewById(R.id.list_item);
        ls.setAdapter(wordaddpter);
    }
}
