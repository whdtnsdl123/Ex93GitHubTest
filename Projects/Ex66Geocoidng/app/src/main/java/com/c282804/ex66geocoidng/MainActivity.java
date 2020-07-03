package com.c282804.ex66geocoidng;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText ettAddress;
    EditText etLat, etLng;

    double lat,lng;
    double lat2,lng2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ettAddress= findViewById(R.id.et_address);
        etLat= findViewById(R.id.et_lat);
        etLng= findViewById(R.id.et_lng);
    }

    public void clickBtn(View view) {
        //주소->좌표(지오콛징)
        String addr= ettAddress.getText().toString();

        //지오코딩 작업을 수행하는 객체 생성
        Geocoder geocoder = new Geocoder(this, Locale.KOREA);

        try {
            List<Address> addresses =geocoder.getFromLocationName(addr,3);

            StringBuffer stringBuffer= new StringBuffer();
            for(Address t : addresses){
                stringBuffer.append(t.getLatitude()+","+t.getLongitude()+"\n");

            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(stringBuffer.toString()).setPositiveButton("Ok",null).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickBtn2(View view) {

        //좌표->주소(역지오코딩)
        lat2=Double.parseDouble(etLat.getText().toString());
        lng2=Double.parseDouble(etLat.getText().toString());

        Geocoder geocoder =new Geocoder(this,Locale.KOREA);

        try {
            List<Address>addresses=geocoder.getFromLocation(lat2,lng2,3);

            StringBuffer buffer = new StringBuffer();
            for(Address t : addresses){
                buffer.append(t.getCountryName()+"\n");
                buffer.append(t.getCountryCode()+"\n");
                buffer.append(t.getAddressLine(0)+"\n");//주소1.
                buffer.append(t.getAddressLine(1)+"\n");//주소2. 없으면 null
                buffer.append(t.getAddressLine(2)+"\n");//주소3. 없으면 null
                buffer.append(t.getAddressLine(2)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
