package com.c282804.ex30activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //안드로이드의 시스템 앱을 실행하기.
    //ex) 전화걸기,사진,문자,카메라 앱 등등
    //이런 앱들을 모두 지정된 Intent Action 값 을 가지고 있음.
    //그래서 프로그래머는 묵시적 Intent 를 이용해서 지저된 Action 의 앱들을 실행.

    public void clickDial(View view) {
        //전화거는 다이얼화면 앱 실행
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);//다이얼 앱에 약속 된 액션 문자열 값.
        startActivity(intent);

        //다이얼화면에 미리 전화번호가 입력되어 있기를 원한다면..
        Uri uri= Uri.parse("tel:01026002709");
        intent.setData(uri);

        startActivity(intent);

    }

    public void clickSMS(View view) {
        //짧은 문자 서비스
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);


        Uri uri = Uri.parse("smsto:01026002709,01040562709");
        intent.setData(uri);

        //문자내용을 미리 작성해 놓을 수 있음.
        //sms_body약속된 글씨.
        intent.putExtra("sms_body",".....Hello!");

        startActivity(intent);

    }

    public void clickWeb(View view) {
        //웹 페이지 보여주기
        Intent intent = new Intent(Intent.ACTION_VIEW);//액션값 생성자에 지정가능


        intent.setData(Uri.parse("http://www.naver.com"));
        startActivity(intent);

    }

    public void clickGallery(View view) {
        //사진선택 앱

        Intent intent = new Intent(Intent.ACTION_PICK);
        //반드시 추가해야할 설정
        intent.setType("image/*");
        startActivity(intent);
    }

    public void clickCamera(View view) {
        //카메라앱

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
