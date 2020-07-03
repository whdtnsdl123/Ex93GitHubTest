package com.c282804.ex34threadprogress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    Handler handler;
    int gauge=0;//막대바 프로그래스의 진행률 값
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Btn(View view) {

        //wheel type pregress dialog
        dialog = new ProgressDialog(this);
        dialog.setTitle("wheel DiaLog");
        dialog.setMessage("Downloading....");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        //3초 뒤에 다이얼로그 종료
        //handler 객체를 이용
        handler.sendEmptyMessageDelayed(0,3000);


        //handler객체 생성
        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                dialog.dismiss();
            }
        };




    }

    public void Btn2(View view) {

        //bar style progress dialog
        dialog= new ProgressDialog(this);
        dialog.setTitle("막대바 다이얼로그");
        dialog.setMessage("다운로드 중..");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setMax(100);

        dialog.setCanceledOnTouchOutside(false);


        dialog.show();

        dialog.setProgress(gauge);

        //별도 스레드가 게이지 증가시키도록./.
        new Thread(){
            @Override
            public void run() {
                while (gauge<100){
                    gauge++;
                    dialog.setProgress(gauge);

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                dialog.dismiss();
            }
        }.start();





    }
}
