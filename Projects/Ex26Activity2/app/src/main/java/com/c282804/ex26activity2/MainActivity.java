package com.c282804.ex26activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
    }

    public void clickBtn(View view) {
        //SecondActivity에 전달할 데이터를 EditText로 부터 얻어오기
        String s= et.getText().toString();

        //SecondActivity를 실행할 Intent(택배기사)객체를 생성
        Intent intent =new Intent(this,SecondActivity.class);

        //SecondActivity에 전달할 데이터를 택배기사(intent)에게 전달
        intent.putExtra("Name",s);//식별자(name)와 값(value)추가
        intent.putExtra("Age",20);
        //택배기사를 통해 새로운 액티비티 시작
        startActivity(intent);
    }
}
