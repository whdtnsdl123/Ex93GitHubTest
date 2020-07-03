package com.c282804.ex25activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void clickBtn(View view) {
        //SecondActivity 실행시켜주는 택배기사객체(Intent) 생성하여 요청.
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

        //만약 현재  MainActivity를 세컨드를 실행하면서 종료하고 싶다면.
        finish();
    }

    public void clickBtn2(View view) {
        Intent intent2 = new Intent(this,ThirdActivity.class);
        startActivity(intent2);

    }
}
