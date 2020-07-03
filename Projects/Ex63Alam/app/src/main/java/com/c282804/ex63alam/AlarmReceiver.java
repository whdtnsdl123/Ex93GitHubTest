package com.c282804.ex63alam;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import java.util.Date;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,new Date().toString(), Toast.LENGTH_SHORT).show();

        //다시 15초후에 알람이 발동하도록.. 재 알람 지정(마치: 행운의 편지)
        Intent intent2 = new Intent(context,AlarmActivity.class);
        PendingIntent pendingIntent =PendingIntent.getBroadcast(context,11,intent2,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,pendingIntent);
        }else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+15000,pendingIntent);
        }

    }
}
