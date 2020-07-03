package com.c282804.ex64locationtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    final int REQ_PERMISSION = 10;//final 상수

    TextView tvProviders;

    Boolean isEnter=false; //특정위치에 들어갔는가?

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //위치정보관리자 객체 소환
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        //디바이스가 제공하는 위치정보제공자의 종류 확인
        //gps,network,passive
        List<String> providers = locationManager.getAllProviders();
        String s = "";
        for (String provider : providers) {
            s += provider + ",";
        }
        tvProviders = findViewById(R.id.tv_providers);
        tvProviders.setText(s);

        //위치정보 제공자 중에서 베스트 제공자 얻어오기 .
        //베스트를 선정하는 기준(criteria) 객체 생성
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(true); //비용을 낼건지 허용여부
        criteria.setAccuracy(Criteria.NO_REQUIREMENT);// 정확도를 유효하는가 ?
        criteria.setPowerRequirement(Criteria.NO_REQUIREMENT); //배터리 소모량
        criteria.setAltitudeRequired(true);//고도에 대한 위치 필요한가 ?


        String bestProvider = locationManager.getBestProvider(criteria, true);
        TextView tvBest = findViewById(R.id.tv_best);
        tvBest.setText(bestProvider);

        //베스트위치정보제공자를 얻으려면 위치정보제공에 대한 퍼미션작업
        // 위치정보(동적퍼미션 -앱을 실행할때 다이얼로그를 통해 사용자에게 위치정보 허가 여부 확인 )
        // AndroidManifest.xml퍼미션 먼저 하고..
        //동적퍼미션 작업(마시멜로우 버전 이상에서만..)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //위치정보에 대한 퍼미션 허가를 받았는지 스스로 체크
            int permissionResult = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
            if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                //퍼미션 요청 다이얼로그 화면 보이기....
                String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(permissions, REQ_PERMISSION);
            }
        }

    }//onCreate method..

    //requestPermissions() 메소드를 통해 보여진 다이얼로그에서
    //허가/거부 여부를 선택했을때  자동으로 실행되는 메소드

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQ_PERMISSION:
                //이 메소드의 세번째 파라미터에 결과 있음.
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "위치정보 제공에 동의하지 않았습니다. 이 앱의 일부기능이 제한됩니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "위치정보를 허용했습니다..", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


    public void clickBtn(View view) {
        //내 위치 얻어내기

        //위치정보(위도,경도) 객체 참조변수
        Location location = null;

        //locationManager.getLastKnownLocation()메소드
        //반드시 퍼미션체크 코드가 자바에 명시적으로 존재야만함.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if (locationManager.isProviderEnabled("gps")) {//"gps"사용가능여부
            location = locationManager.getLastKnownLocation("gps");
        } else if(locationManager.isProviderEnabled("network")){
            location = locationManager.getLastKnownLocation("network");
        }

        TextView tvMyLocation= findViewById(R.id.tv_mylocation);
        if(location==null){
            tvMyLocation.setText("내 위치를 못 찾겠어!!!");
        }else {
            //위도 경도 얻어오기.
            double latitude = location.getLatitude();
            double longitude= location.getLongitude();

            tvMyLocation.setText(latitude+","+longitude);
        }
    }


    public void clickBtn2(View view) {
        //내 위치 자동갱신
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
            if (locationManager.isProviderEnabled("gps")) {
                locationManager.requestLocationUpdates("gps", 5000, 2,locationListener );
            } else if (locationManager.isProviderEnabled("network")) {
                locationManager.requestLocationUpdates("network",5000,2,locationListener);
            }


    }




    //갱신된 위치정보를 듣는 리스너 멤버객체
LocationListener locationListener=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude= location.getLongitude();

            TextView tvAuto=findViewById(R.id.tv_automylocation);
            tvAuto.setText(latitude+","+longitude);

            //특정 지정에 들어갔을때 이벤트를 발생
            // 왕십리역 좌표 :37.5612,127.0382

            //내위치(lat,lng)와 왕십리역좌표 사이의 실제거리(m) 계산

            float[] results = new float[3]; //계산 결과를 넣어놓을 반 float배열
            Location.distanceBetween(latitude,longitude,37.5612,127.0382, results);

            //계산결과를 가진 results[0]에 두 좌표사이의 m거리가 계산 되어 있음
            if(results[0]<50){//두 좌표사이의 거리가 50m거리 이내인가?

                if(isEnter==false){
                    new AlertDialog.Builder(MainActivity.this).setMessage("축하합니다. 이벤트 달성").setPositiveButton("Ok", null).create().show();
                    isEnter=true;
                }

                }else{
                if (isEnter) isEnter=false;
            }



            }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    public void clickBtn3(View view) {
    //내 위치 자동갱신 종료
        locationManager.removeUpdates(locationListener);
    }
}//MainActivity class..
