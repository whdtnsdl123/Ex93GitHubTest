package com.c282804.ex27activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et=findViewById(R.id.et);
    }

    public void clickBtn(View view) {
        //MainActivity에 돌려줄 데이터를 EditText에서 얻어오기
        String s= et.getText().toString();

        //MainActivity로 온 Intent 객체 참조하기
        Intent intent = getIntent();

        //되돌려줄 데이터를 intent 객체에 추가하기.
        intent.putExtra("Name",s);
        intent.putExtra("Age",20);

        //인텐트 객체에게 이 결과가 ok라는 설정
        setResult(RESULT_OK,intent);

        //이 액티비티를 종료
        finish();



    }
}
