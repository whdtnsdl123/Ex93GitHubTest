package com.c282804.ex67googlemap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    //1. GoogleMap Library부터 추가 [Play-service-map]
    //2. 구글 지도 사용에 대한 에이피아이 키 발급

    //구글지도를 제어하는 객체 참조변수
    GoogleMap GMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //서포트맵프레그먼트 안에있는 구글맵 객체를 얻어오기
        //우선 xml에 만든 서포트프레그먼트를 참조하기 .
        FragmentManager fragmentManager = getSupportFragmentManager();
        final SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);

        //비동기 방식(별도 Thread)으로 지도 불러오기.
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                //내 멤버변수에 얻어온 구글 맵 대입
                GMap= googleMap;

                //원하는 좌표 객체 생성
                LatLng seoul = new LatLng(37.56,125.97);

                //마커 옵션객체 생성
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.position(seoul);
                markerOptions.title("서울");
                markerOptions.snippet("대한민국의 수도");

                //지도에 마커 추가
                GMap.addMarker(markerOptions);


                //원하는 좌표 위치로 카메라 이동
                //GMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));

                //카메라 이동을 스무스하게 효과를 주면서 줌까지 적용
                GMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seoul,15));

                //마커 여러개 추가도 가능함
                LatLng mrhi= new LatLng(37.5608,127.0346);

                MarkerOptions mo= new MarkerOptions();
                mo.position(mrhi);
                mo.title("미래능력개발교욱원");
                mo.snippet("http://www.mrhi.or.kr");
                mo.icon(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone));
                mo.anchor(0.5f,1.0f);

                Marker marker = GMap.addMarker(mo);

                marker.showInfoWindow();

                //마커 클릭했을때 반응하기

                //지도에 정보창을 클릭했을때 반응하기.
                GMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        String title = marker.getTitle();


                        if (title.equals("미래능력개발교욱원")){
                            //교육원 홈페이지로 이동(웹브라우저 실행)
                            Intent intent =new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            Uri uri= Uri.parse("http://www.mrhi.or.kr");
                            intent.setData(uri);

                            startActivity(intent);


                        }
                    }
                });




                //카메라 위치 변경
                GMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mrhi,14));

                //정보창의 커스텀모양을 만들고 싶다면..
                //정보창을 만들어주는 Adapter 객체를 생성
                MyInfoWindowAdapter adapter =new MyInfoWindowAdapter(MainActivity.this);
                GMap.setInfoWindowAdapter(adapter);

                //줌컨트롤 보이도록 설정
                UiSettings settings= GMap.getUiSettings();
                settings.setZoomControlsEnabled(true);


                //내위치보여주기[위치정보제공 퍼미션 작업 필요- 동적퍼미션션]
                GMap.setMyLocationEnabled(true);

            }
        });

    }
}
