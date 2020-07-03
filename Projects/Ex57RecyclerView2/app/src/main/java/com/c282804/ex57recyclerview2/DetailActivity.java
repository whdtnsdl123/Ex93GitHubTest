package com.c282804.ex57recyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //나한테 온 택배기사 참조하기
        Intent intent= getIntent();
        String name = intent.getStringExtra("Name");
        int ImgID=intent.getIntExtra("img",R.drawable.moana01);

        iv=findViewById(R.id.iv);
        Glide.with(this).load(ImgID).into(iv);

        getSupportActionBar().setTitle(name);


    }
}
