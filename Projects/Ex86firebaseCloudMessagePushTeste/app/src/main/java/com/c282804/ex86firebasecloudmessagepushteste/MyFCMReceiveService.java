package com.c282804.ex86firebasecloudmessagepushteste;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFCMReceiveService  extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //이 안에서는 알림(Notification)만 만들수 있음. [심지어 toast도 불가 ]
        //우선, 리시브 확인용으로 Logcat에 출력
        Log.i("TAG","onMessageReceived!!");

        String fromWho= remoteMessage.getFrom();


        String notiTitle="title";
        String notiBody="body";

        if (remoteMessage.getNotification()){

        }





    }
}
