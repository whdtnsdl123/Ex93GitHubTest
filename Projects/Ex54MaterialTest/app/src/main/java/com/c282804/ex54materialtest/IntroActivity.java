package com.c282804.ex54materialtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //4초후에 MainActivity를 자동 실행하기
        handler.sendEmptyMessageDelayed(0,4000);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent =new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);

            finish();


        }
    };

}
