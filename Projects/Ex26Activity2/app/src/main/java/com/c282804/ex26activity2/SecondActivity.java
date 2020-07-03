package com.c282804.ex26activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv=findViewById(R.id.tv);

        //이 액티비티를 실행한 택배기사(intent)객체 참조하기.
        Intent intent = getIntent();
        //인텐트 객체에게 추가데이터를 얻어오기.
        String name = intent.getStringExtra("Name");
        int age = intent.getIntExtra("Age",20);//defaultValue : 혹시 값이 없다면 기본값

        //전달 된 값 TextView에 보여주기
        tv.setText(name+"\n"+age);

    }
}
