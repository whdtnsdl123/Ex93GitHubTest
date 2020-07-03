package com.c282804.ex31thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    int num = 0; //텍스트뷰에 보여질 숫자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
    }


    public void clickBtn(View view) {
        //오래걸리는 작업.
        //별도의 Thread 를 만들지 않았기에 MainThread 가 이 작업을 수행
        for (int i = 0; i < 20; i++) {
            num++;
            tv.setText(num + "");
            //MainThread가 이 반복문안에서만 작업중이여서 TextView에
            //num 값을 보여주는 갱신 작업을 수행할 수 없음!
            //그래서 num값이 증가되는 모습이 보여지지않고 이 반복문이
            //끝난 후 마지막 num값인 20만 보여짐 .
            //그래서 오래걸리는 작업은 Main Thread가 하지 않도록 해야함 .
            //즉, 별도의 Thread가 작업하도록 ..

            //0.5초동안 잠시대기
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickBtn2(View view) {
        //오래걸리는 작업 수행 ... (ex. network, db작업)
        //하는 직원 객체(Thread) 생성 및 실행.
        MyThread t = new MyThread();
        t.start(); // 작업수행일 지시. [이 클래스의 run() 실행]
    }

    //오래걸리는 작업을 수행하는 스레드의 동작을 설계 .
    class MyThread extends Thread {
        //이 객체를 start()하면 자동으로 실행되는 메소드.


        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                num++;
                //tv.setText(num + "");//이 코드 하위버전들은 여기서 에러남!
                //UI(화면)작업은 반드시 Main Thread 만 할 수 있도록.
                //즉, 별도의 THread는 화면변경작업을 수행 할 수 없기에..
                //MainThread에게 화면변경작업수행을 요청하도록 코딩..
                //방법1. Handler객체를 이용.
                //handler.sendEmptyMessage(0);
                //방법2. runOnUiThread()메소드(Activity클래스의 멤버)를 이용
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(num+"");


                    }
                };
                runOnUiThread(runnable);//파라미터로 전달한 runnble객체에게 Ui변경이 가능하도록 위임장

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }//run method..
    }//myThead

    //별도의 Thread가 Main THread에게 UI변경 작업을 요청할 때
    //활용될 객체
    Handler handler = new Handler();

    public void handleMessage(@NonNull Message msg){
        //이곳에서 Ul변경경
        tv.setText(num+"");
    }
}//main


