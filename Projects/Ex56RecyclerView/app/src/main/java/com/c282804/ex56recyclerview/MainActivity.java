package com.c282804.ex56recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items= new ArrayList<>();

    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.add(new String("aaaa"));
        items.add(new String("bbbb"));
        items.add(new String("cccc"));
        items.add(new String("aaaa"));
        items.add(new String("bbbb"));
        items.add(new String("cccc"));
        items.add(new String("aaaa"));
        items.add(new String("bbbb"));
        items.add(new String("cccc"));
        items.add(new String("aaaa"));
        items.add(new String("bbbb"));
        items.add(new String("cccc"));
        items.add(new String("aaaa"));
        items.add(new String("bbbb"));
        items.add(new String("cccc"));


        adapter= new MyAdapter(items,this);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
    }
}
