package com.c282804.ex55listviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터들
    ArrayList<String> items = new ArrayList<>();

    MyAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가
        items.add(new String("aa"));
        items.add(new String("bb"));
        items.add(new String("cc"));

        adapter= new MyAdapter(items,this);
        listView=findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
