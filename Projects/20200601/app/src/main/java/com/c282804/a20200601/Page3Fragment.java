package com.c282804.a20200601;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Page3Fragment extends Fragment {
    ArrayList<String> datas = new ArrayList<>();

    ArrayAdapter adapter;
    ListView listView;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        datas.add (new String("aaa"));
        datas.add (new String("bbb"));
        datas.add (new String("ccc"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3,container,false);


        listView=view.findViewById(R.id.listview);
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        return view;

    }
}
