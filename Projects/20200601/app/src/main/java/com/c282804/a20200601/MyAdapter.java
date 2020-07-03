package com.c282804.a20200601;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] fragment =new Fragment[3];

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragment[0] = new Page1Fragment();
        fragment[1] = new Page2Fragment();
        fragment[2] = new Page3Fragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragment[position];
    }

    @Override
    public int getCount() {

        return fragment.length;
    }
}
