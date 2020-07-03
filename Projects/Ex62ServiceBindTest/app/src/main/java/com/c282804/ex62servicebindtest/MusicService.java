package com.c282804.ex62servicebindtest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {



    MediaPlayer mp;

    // startService() 메소드로 싱행했을때만 실행되는 메소드


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {  super.onDestroy(); }


    //bindService()메소드로 실행했을댸 호출 되는 멧도ㅡ
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        MyBinder binder= new MyBinder();

        return binder;//MainAcivity로 파견나갈 객체(Binder)를 리턴
    }

    //이Music Service객체 메모리 주소(객체 참좁값을 )을 리턴해주는
    //기능을 가진 Binder클래스 설계
    class MyBinder extends Binder{
        //이 서비스 객체주소를 리턴해주는메소드
        public MusicService getService(){return MusicService.this;}
    }

    //음앙 재생기능
    void playMusic(){
        if(mp==null){
            mp= MediaPlayer.create(this,R.raw.dragon_flight);
            mp.setLooping(true);
            mp.setVolume(1.0f,1.0f);
        }
        mp.start(); //처음실행 or 이어하기(resume)
    }

    void pauseMusic(){if (mp!=null && mp.isPlaying()) mp.pause();}

    void stopMusic(){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp=null;
        }
    }
}

