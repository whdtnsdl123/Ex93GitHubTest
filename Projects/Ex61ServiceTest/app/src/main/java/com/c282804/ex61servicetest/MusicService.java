package com.c282804.ex61servicetest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MusicService extends Service {

    MediaPlayer mp;

    //startService()를 통해 서비스가 시작되면 자동으로 실행되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //Oreo버전부터 운영체제에서 백그라운드작업 및 방송수신작업에 제약을 두고 있음.
        //만약 , 이서비스 객체가 백그라운드에서 계족 동작하고 싶다면.
        //foregroundService()로 실행해야함.
        //즉, 사용자가 서비스가 가동중임을 인지할 수 있는 장치를 마련했다고 보면됨.

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel channel= new NotificationChannel("ch1","뮤직서비스",NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder =new NotificationCompat.Builder(this,"ch1");

            //알림설정들
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setContentTitle("Music Service");
            builder.setContentText("뮤직서비스가 실행중입니다.");
            //알림창을 클릭했을때 뮤직제어화면(MainActivity)으로 전환되도록
            Intent intent1= new Intent(this,MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this,10,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);

            builder.setAutoCancel(true);//원래 클릭하면 알림이 자동 취소되어야 하지만 포어그라운드서비스는 적용되지 않음.

            Notification notification =builder.build();

            //이 서비스를 포어그라운드에서 돌아가도록
            //포어그라운드 서비스를 하려면 Notification을 보이도록 해야함.
            startForeground(1,notification);
        }


        //미디어플레이어 객체 생성 및 시작!
            if(mp==null){
                mp= MediaPlayer.create(this, R.raw.s_again);
                mp.setLooping(true);
                mp.setVolume(1.0f, 1.0f);
            }
            mp.start();
        //메모리문제로 서비스를 강제로 Kill시켰을때
        //메모리문제가 해결되는 자동으로 서비스를 다시 실행해달라!!
        //return START_STICKY


            return START_STICKY;


    }

    //stopServive()를 통해 서비스가 종료되면 자동으로 실행되는 메소드
    @Override
    public void onDestroy() {

        if( mp!=null && mp.isPlaying() ){
            mp.stop();
            mp.release(); //MediaPlayer객체를 메모리에서 삭제하도록
            mp= null;
        }

        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
