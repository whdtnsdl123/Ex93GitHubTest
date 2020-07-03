package com.c282804.ex68kakaomap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.daum.mf.map.api.MapView;

public class MainActivity extends AppCompatActivity {

    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
