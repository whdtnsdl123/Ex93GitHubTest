package com.c282804.ex74bluetoothtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String permission = Manifest.permission.ACCESS_FINE_LOCATION;
        //Location 에 대한 동적 퍼미션 작업
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkSelfPermission(permission)== PackageManager.PERMISSION_DENIED){
                requestPermissions(new String[]{permission},10);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 10:
                if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "클라이언트로서 새로운 장치를 검색하는 기능이 제한 됩니다 .\n기존에 페어링된 장치는 접속가능하니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clickServer(View view) {
        Intent intent =new Intent(this,ServerActivity.class);
        startActivity(intent);

    }

    public void clickClient(View view) {
        Intent intent =new Intent(this,ClientActivity.class);
        startActivity(intent);
    }
}
