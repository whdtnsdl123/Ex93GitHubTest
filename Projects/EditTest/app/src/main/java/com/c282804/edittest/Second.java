package com.c282804.edittest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    ListView lv;
    ArrayList<Member> members= new ArrayList<>();
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv=findViewById(R.id.lv);
        adapter=new MyAdapter(members,getLayoutInflater());
        lv.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String s = data.getStringExtra("name");
        String s2 = data.getStringExtra("nick");
        String s3 = data.getStringExtra("title");
        String s4 = data.getStringExtra("white");

        members.add(new Member(s,s2,s3,s4));
        adapter.notifyDataSetChanged();
    }

    public void btn3(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivityForResult(intent,0);
    }
}
