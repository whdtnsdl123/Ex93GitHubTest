package com.c282804.ex28activity4;

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
        //묵시적 인텐트로 실행 [액티비티 클래스명 명시없이 호출하기]

        Intent intent = new Intent();
        //그 액티비티에 고유한 식별자 같은 키워드를 설정(ex. 인사담당자 앞으로)
        //intent.setAction("aaa");
        intent.setAction("ccc");//여러개 액션기능 지정가능
        startActivity(intent);
    }
}
