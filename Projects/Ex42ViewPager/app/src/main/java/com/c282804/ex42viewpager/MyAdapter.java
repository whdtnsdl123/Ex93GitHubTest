package com.c282804.ex42viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.c282804.ex42viewpager.R;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    ArrayList<Integer> items ;
    LayoutInflater inflater;


    //생성자 메소드

    public MyAdapter(ArrayList<Integer> items,LayoutInflater inflater){

        this.items=items;
        this.inflater= inflater;


    }
    //이 아답터가 만들 페이지의 총개수를 리턴 (즉,데이터의 개수)
    @Override
    public int getCount() {
        return items.size();
    }

    //이 아답터가 page.xml설계도면을 기반으로
    //ViewPage에 보여질 한 페이지(View 객체)를 만들어내는 작업 메소드.
    //ListView에 사용되는 아답터의 getView()같은 메소드.


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //page.xml문서를 읽어와서 View객체로 만들기
        View page = inflater.inflate(R.layout.page,null);

        //page안에 있는 ImageView에 현재번째(position) 이미지를 설정
        ImageView iv =page.findViewById(R.id.iv);
        iv.setImageResource(items.get(position));

        switch (position){
            case 0:
                break;

            case 1:
                break;
        }

        //만들어진 page를 ViewPager(첫번째 파라미터 :container)에 추가하기.
        container.addView(page);


        return page;//만들어진 페이지뷰 객체리턴 :검증을 위해서 .

    }

    //화면에서 더이상 보이지 않아 메모리에서 page를 제거하라는 메소드


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);



    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object; //뷰페이저가 보여줄 view와 위에서 만든 page(object) 객체가 같은지 리턴
    }
}



