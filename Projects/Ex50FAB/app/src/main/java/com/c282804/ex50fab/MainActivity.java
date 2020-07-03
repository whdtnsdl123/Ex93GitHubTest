package com.c282804.ex50fab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Fab(View view) {
        //Toast의 업그레이드 버전 : SnackBar
        Snackbar.make(view,"This is snackbar",Snackbar.LENGTH_INDEFINITE).setAction("ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click ok", Toast.LENGTH_SHORT).show();

            }
        }).show();
    }

    public void btn(View view) {
        //새로운 CoordinatorLayout을 이용하면 원하는 위치에
        //snackbar를 보이게 할 수 있음.

        //스낵바가 놓여질 CoodinatorLayout 뷰객체를 참조하기
        View v= findViewById(R.id.layout_snackbar_container);
        Snackbar.make(v,"snackbar",Snackbar.LENGTH_LONG).setAction("ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
