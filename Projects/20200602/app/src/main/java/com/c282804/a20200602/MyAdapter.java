package com.c282804.a20200602;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[5];

    String[] tabTexts= new String[]{"추천","분류","최신","평점","이슈"};

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]= new Tab1FragMent();
        fragments[1]= new Tab2FragMent();
        fragments[2]= new Tab3FragMent();
        fragments[3]= new Tab4FragMent();
        fragments[4]= new Tab5FragMent();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {        return fragments.length; }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {return tabTexts[position];
    }
}
