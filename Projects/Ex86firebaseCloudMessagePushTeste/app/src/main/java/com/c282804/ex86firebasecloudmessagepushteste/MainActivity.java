package com.c282804.ex86firebasecloudmessagepushteste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //앱을 FCM서버에서 등록하는 과정
        //앱을 FCM서버에서 등록하면 앱을 식별할 수 있는 고유의 토큰값(문자열)을 줌
        //이 토큰(InstanceID)을 통해 (디바이스들)을 구별하여 메세지가 전달되는 것임

        FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance();
        firebaseInstanceId.getInstanceId();
        Task task = firebaseInstanceId.getInstanceId();
        task.addOnCompleteListener(new OnCompleteListener<InstanceIdResult>task){
            @Override
            public void onComplete(@NonNull Task task) {


            }
        });
    }
}
