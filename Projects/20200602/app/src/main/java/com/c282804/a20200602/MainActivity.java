package com.c282804.a20200602;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {



    DrawerLayout drawerLayout;
    TabLayout tabLayout;

    ViewPager pager;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter= new MyAdapter(getSupportFragmentManager());

        drawerLayout=findViewById(R.id.layout_drawer);



        pager=findViewById(R.id.pager);
        pager.setAdapter(adapter);
        tabLayout= findViewById(R.id.layout_tab);


        tabLayout.setupWithViewPager(pager);  //탭레이아웃 글씨 보여주는기능
    }
}
