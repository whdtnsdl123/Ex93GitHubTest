package com.c282804.ex45fragmentpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Page3Fragment extends Fragment {

    //ㅍ이지3에서 보여줄 대량의 String 데이터들
    ArrayList<String> datas= new ArrayList<>();

    ListView listView;
    ArrayAdapter adapter;






    //프레그먼트가 처음 생성될때만 호출됨


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //대량의 데이터를 DB나 Network에서 가져오는 작업은
        //보통 처음 한번만 실행함.
        datas.add(new String("aaa"));
        datas.add(new String("bbb"));
        datas.add(new String("ccc"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_page3,container,false);


//
//        //대량의 데이터 추가 .
//        datas.add(new String("aaa"));
//        datas.add(new String("bbb"));
//        datas.add(new String("ccc"));

        listView=view.findViewById(R.id.listview);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);



        return view;
    }
}
