package com.c282804.ex62servicebindtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MusicService musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //액티비티가 화면에 보일때
    @Override
    protected void onResume() {
        super.onResume();

        //서비스객체 실행 및 연결(bind)
        if(musicService==null){//연결되어 있는 뮤직서비스가 없다면
            Intent intent =new Intent(this,MusicService.class);
            startService(intent); //일단 Service객체 생성[만약 서비스 객체가 없다면 만들고 onStartCommand()가 발동, 있다면 생성은 안하고 onStartCommand()만 발동함]

            //만들어진 Service객체와 연결
            //bindService()호출하면 Service클래스안의 onBind()메소드 발동하고
            //이 onBind()가 서비스객체의 참조값을 가진 객체를 리턴해줌.
            bindService(intent,conn,0);
        }
    }

    //bindService()를 했을때 Service객체와 연결된 통로 객체.
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //두번째 파라미터 : 서비스객체의 참조주소를 주는 메소드가 있는 객체
            MusicService.MyBinder binder = (MusicService.MyBinder)service;
            musicService= binder.getService();//리턴해준 서비스객체 주소 참조
            Toast.makeText(musicService, "서비스와 연결되었습니다.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };




    public void clickPlay(View view) {if(musicService!=null)musicService.playMusic();}

    public void clickPause(View view) {if(musicService!=null)musicService.pauseMusic();}


    public void clickStop(View view) {
        if(musicService!=null){
            musicService.stopMusic();
            unbindService(conn);//연결종료
            musicService=null;
        }

        //서비스객체도 아예 종료
        Intent intent =new Intent(this,MusicService.class);
        stopService(intent);

        finish();//액티비티 종ㅇ료
    }
}
