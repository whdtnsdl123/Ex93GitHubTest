package com.c282804.ex59broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Btn(View view) {
        //명시적 인텐트로 리시버 실행하기 : 같은 앱안에 있는 리시버만 실행 할 수 있음. [메니페스트에 등록이 되어 있어야함]
        Intent intent = new Intent(this,MyReceiver.class);
        sendBroadcast(intent);


    }



    //Oreo버전 부터 브로드캐스트나 서비스 컴포넌트 사용에 제한을 두고 있음. (백그라운드에서 너무 리소스를 많이 사용해서 배터리문제..)
    // - 운영체제가 방송하는 시스템 브로드캐스는 정상적으로 동작됨
    // - 개발자의 임의로 보내는 방송은 [동적 리시버 등록]을 해야만 사용 가능.
    // 즉, Manifest.xml에 리시버를 등록하지 않고 Java코드로 리시버를 등록!!-[동적 리시버 등록 ! ]
    // 즉, 앱이 켜져 있을 때만 묵시적 방송을 듣도록 제약!! 



    public void Btn2(View view) {
        //묵시적 인텐트로 방식보내기. : 디바이스에 설치된 모든앱에게 방송함
        Intent intent= new Intent();
        intent.setAction("aaa");// 방송의 액션값(식별값) 지정
        sendBroadcast(intent);


    }

    //액티비티가 ㅣ화면에 보여질때 자동으로 발동하는 콜백메소드
    //onCreate() 실행 후 onStart()실행 후 실행되는 메소드[lifecycle method]


    @Override
    protected void onResume() {
        super.onResume();


        //동적으로 리시버를 등록 [aaa액션을 듣는]
        myReceiver= new MyReceiver();
        IntentFilter filter = new IntentFilter();
        registerReceiver(myReceiver,filter);



    }


    //화면에 안보일때 자동으로 발동하는 메소드

    @Override
    protected void onPause() {
        super.onPause();

        //등록했던 리시버를 등록해제

        unregisterReceiver(myReceiver);
    }
}
