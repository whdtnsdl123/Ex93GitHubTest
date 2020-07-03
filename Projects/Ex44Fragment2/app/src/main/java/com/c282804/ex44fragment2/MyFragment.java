package com.c282804.ex44fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    //이 프레그먼트가 보여줄 뷰를 만들어서 리턴해주는 메소드

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my,container,false);

        //혹시 setArguments()전달된 값이 있다면..
        Bundle bundle= getArguments();

        String name= bundle.getString("Name");
        int age = bundle.getInt("Age",20);

        Toast.makeText(getActivity(), name+","+age, Toast.LENGTH_SHORT).show();
        return view;
    }
}
