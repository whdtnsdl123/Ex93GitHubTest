 package com.c282804.ex65locationtestfusedapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

 public class MainActivity extends AppCompatActivity {

     //Google Fused Location 라이브러리 : 적절한 위치 정보 제공자를 선정하여 위치정보를 제공////

     //외부 라이브러리 추가 : play-service 라이브러리 검색, 근데 넘 ㅜ무거워서.. 명시적으로 location버전만 ㅁ받기.
     //디바이스에 Google Play 추가

     GoogleApiClient googleApiClient;//위치정보관리 객체 (LocationManager 역할)

     FusedLocationProviderClient providerClient;//위치정보
     TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.tv);

        //위치정보제공을 받기위한 퍼미션 작업
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int permissionResult= checkCallingPermission(Manifest.permission.ACCESS_FINE_LOCATION);
            if (permissionResult!= PackageManager.PERMISSION_GRANTED){
                String[] permission= new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(permission,10);
            }
        }

    }//onCreate method...

     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults);

         switch (requestCode){
             case 10:
                 if(grantResults[0] == PackageManager.PERMISSION_DENIED){
                     Toast.makeText(this, "위치정보 사용을 거부하셨습니다.\n사용자의 위치탐생 기능이 제한됩니다.", Toast.LENGTH_SHORT).show();
                 }
                 break;
         }
     }

     public void clickBtn(View view) {
        //Fused API를 이용해서 내 위치 정보 얻어오기(실시간 갱신)

         //위치정보관리 객체 생성을 위해 빌더객체 생성[마치 다이얼로그 빌더처럼]
         GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this,);
         //1. 구글API사용
         builder.addApi(LocationServices.API);//공개 키 사용
         //2.  위치정보 연결 성공 리스너
         builder.addConnectionCallbacks(connectionCallbacks);
         //3. 위치정보 연결 실패 리스너
         builder.addOnConnectionFailedListener(connectionFailedListener);


         //위치정보 관리 객체 생성
         googleApiClient= builder.build();

         //준비가 되어있으니 위치정보 취득을 위한 연결시도
         googleApiClient.connect();//연결이 성공하면 connectionCallbacks 객체의 onConnect()메소드 리스너

         providerClient= LocationServices.getFusedLocationProviderClient(this,)



     }


     //위치정보를 얻기위한 연결시도에 성공을 듣는 리스너 객체
     GoogleApiClient.ConnectionCallbacks connectionCallbacks= new GoogleApiClient.ConnectionCallbacks() {
         @Override
         public void onConnected(@Nullable Bundle bundle) {
             //연결에 성공 됐을때..(아직 위치정보를 얻은 것은 아님..얻을 수 있는 상태)
             Toast.makeText(MainActivity.this, "위치정보탐색을시작할수없습니다.", Toast.LENGTH_SHORT).show();

             //위치정보제공자 객체에게 최적의 제공자를 선택하는 기준 설정
             LocationRequest locationRequest = LocationRequest.create();
             locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);//높은 정확도 제공자를 우선시.
             locationRequest.setInterval(5000);//위치정보 탐색 주기 5초마다.

             //위치정보제공자 객체에게 실시간 위치정보를 요청
             providerClient.requestLocationUpdates(locationRequest.);
         }

         @Override
         public void onConnectionSuspended(int i) {

         }
     };
    //연결시도에 실패했을때 듣는 리스너객체

     GoogleApiClient.OnConnectionFailedListener connectionFailedListener= new GoogleApiClient.OnConnectionFailedListener() {
        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Toast.makeText(MainActivity.this, "위치정보 탐색을 시작 할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
    };

     //위ㅣㅊ정보가 갱신되는 것을 듣는 리스너
     LocationCallback locationCallback=new LocationCallback(){
         @Override
         public void onLocationResult(LocationResult locationResult) {

             Location location = l
             super.onLocationResult(locationResult);
         }
     }

 }
