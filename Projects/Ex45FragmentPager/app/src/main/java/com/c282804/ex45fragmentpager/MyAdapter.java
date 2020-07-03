package com.c282804.ex45fragmentpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {


    //프레그먼트 참조변수 3개를 가진 배열객체 생성.
    Fragment[] fragments = new Fragment[3];

    //생성자
    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0]= new Page1Fragment();
        fragments[1]= new Page2Fragment();
        fragments[2]= new Page3Fragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {



        return fragments[position];
        }




    @Override
    public int getCount() {
        return fragments.length;
    }
}
