package com.c282804.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //이 액티비티 클래스가 생성된 후 자동으로 호출되는 메소드.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //화면에 보여줄  view를 설정하는 메소드
        setContentView(R.layout.activity_main);
        //파라미터로 전달된 값..
        // res폴더안에 layout폴더 안에 있는 activity_main.xml이라는
        //문서를 읽어서 뷰를 만들어라.




    }
}
