package com.c282804.ex43fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    MyFragment myFragment;


    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);



        //프래그먼트를 관리하는 Manager 객체 소환
        fragmentManager= getSupportFragmentManager();

        myFragment= (MyFragment)fragmentManager.findFragmentById(R.id.frag);




    }

    public void btn(View view) {
        //myFragment안에 있는 TextView의 글씨를 변경!

        //myFragment.tv.setText("Nice!");
        myFragment.changeText("Nice!!");//객체지향적으로 ㄴㅣ껀 니 가..
    }

    //MyFragment 안에 있는 Button의 onClick속성의 콜백메소드
    public  void Btn2(View v){
        tv.setText("!!!!");
    }
}
