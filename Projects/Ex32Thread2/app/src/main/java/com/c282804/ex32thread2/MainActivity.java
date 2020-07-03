package com.c282804.ex32thread2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    MyThread t;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //액티비티가 메모리에서 삭제될대 자동으로 실행되는 메소드.


    @Override
    protected void onDestroy() {
        //별도의 스레드 종료
        //t.stop(); //Thread의 stop 은 사용 권장하지 않음.
        super.onDestroy();
        t.stopThread();

    }

    public void btn(View view) {
        //무한반복하면서 현재시간을 5초마다 토스트로 보여주기.
        //이 작업을 수행하는 별도의 Thread를 생성
        MyThread t = new MyThread();
        t.start();//자동으로 run()메소드 가 발동.
    }

    //현재시간을 무한 출력하는 기능을 수행하는 별동 Thread클래스를 설계
    class MyThread extends Thread{

        boolean isRun= true;
        @Override
        public void run() {
            while (isRun){
                Date now = new Date();//객체가 만들어지는 순간에 시간을 가지고 있음
                final String s =now.toString();//현재시간을 문자열로 리턴해줌.
                //화면변경작업은 별도 Thread가 할 수 없음.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //이 안에서는 UI작업 가능
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
                //5초동안 대기
                try {Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


            }

        //스레드의 종료하ㅡㄴ 기능 메소드
        void stopThread(){
            isRun=false;

        }
    }

}
