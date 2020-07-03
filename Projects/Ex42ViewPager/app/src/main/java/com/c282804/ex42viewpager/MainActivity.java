package com.c282804.ex42viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> items = new ArrayList<>();




    MyAdapter adapter;
    ViewPager pager;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //대량의 데이터 추가하기
        items.add(new Integer(R.drawable.gametitle_01));
        items.add(new Integer(R.drawable.gametitle_02));
        items.add(new Integer(R.drawable.gametitle_03));
        items.add(new Integer(R.drawable.gametitle_04));
        items.add(new Integer(R.drawable.gametitle_05));
        items.add(new Integer(R.drawable.gametitle_06));
        items.add(new Integer(R.drawable.gametitle_07));
        items.add(new Integer(R.drawable.gametitle_08));
        items.add(new Integer(R.drawable.gametitle_09));
        items.add(new Integer(R.drawable.gametitle_10));

        //아답터 객체 생성
        adapter = new MyAdapter(items,getLayoutInflater());
        //ViewPager에 어댑터 설정
        pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);
}

    public void Prev(View view) {
        //현재 뷰페이지의 page 번호 얻어오기
        int index=pager.getCurrentItem();

        //특정페이지로 이동

        pager.setCurrentItem(index-1,false);
    }

    public void Prev1(View view) {
        int index=pager.getCurrentItem();



        pager.setCurrentItem(index+1,false);
    }
}
