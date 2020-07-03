package com.c282804.ex43fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    TextView tv;
    Button btn;
    Button btn2;
    //마치 MainActivity의 onCreate()같은 역할의 메소드
    //즉, 프레그먼트가 화면에 보여줄 뷰들을 만들어 리턴하는 콜백메소드

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //이 프레그먼트가 보여줄 뷰를 만들기
        View view = inflater.inflate(R.layout.fragment_my,container,false);

        //만들어진 뷰 안에 있는 TextView와 Button참조하기 .
        tv=view.findViewById(R.id.tv_myfragment);
        btn=view.findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello Fragment");
            }
        });

        btn2= view.findViewById(R.id.btn2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //이 프레그먼트를 보여주는 액티비티의 TextView를 제어 .
//                //액티비티 참조하기.
//                MainActivity activity=(MainActivity)getActivity();
//                activity.tv.setText("!!!!!");
//            }
//        });
        return view;
    }

    public  void changeText(String msg){
        tv.setText(msg);
    }
}
