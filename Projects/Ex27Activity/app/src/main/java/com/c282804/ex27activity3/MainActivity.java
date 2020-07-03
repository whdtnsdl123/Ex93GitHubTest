package com.c282804.ex27activity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
    }

    public void clickBtn(View view) {

        //SecondActivity를 실행 하되 결과를 받기위해서
        Intent intent = new Intent(this,SecondActivity.class);
        startActivityForResult(intent,10);//requestCode 식별번호, 아무번호나 적어도 무관
    }

    //startActivityForResult()로 실행된 Activity 가 종료되어
    //현재 이 MainActivity 가 다시 화면에 보여질때 자동으로 실행되는 콜백메소드
    //즉, SecondActivity 에 갔던 Intent(택배기사가)돌아오면
    //자동으로 실행되는 메소드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //내가 보낸 택배기사가 맞는지 RequestCode 를 통해 확인
        switch (requestCode){
            case 10:
                //Second Activity 의 Ok 결과냐;
                if(resultCode == RESULT_OK){
                    // 돌아온 Intent 객체에게(3번쨰 파라미터 : DATA) Extra 데이터를 얻어오기
                    String name= data.getStringExtra("Name");
                    int age=data.getIntExtra("Age",0);

                    tv.setText(name+"\n"+age);

                }
                break;

        }
    }
}
