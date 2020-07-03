package com.c282804.ex25activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Third Activity");

        //제목줄 제목 왼쪽에 "뒤로가기"화살표 아이콘 만들기.
        actionBar.setDisplayHomeAsUpEnabled(true);
        //뒤로가기 아이콘을 눌렀을때 돌아갈 Activity(화면)을 Manifest.xml에서 지정
    }
}
