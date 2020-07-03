package com.c282804.ex44fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
    }

    public void Btn(View view) {
        //R.id.container 인 LinearLayout 에 MyFragment 를 동적 추가


        //Transaction (트랙잭션) :롤백기능이 있는 작업단위!!
        FragmentTransaction tran = fragmentManager.beginTransaction();

        //트랜잭션을 통해 원하는 작업 수행
        MyFragment fragment =new MyFragment();

        //프레그먼트를 동적으로 추가할때 데이터를 전달할 수도 있음.
        Bundle bundle = new Bundle();
        bundle.putString("Name","sam");
        bundle.putInt("Age",20);
        fragment.setArguments(bundle);

        tran.add(R.id.container,fragment);//id가 container인 뷰그룹에 프레그먼트 동적추가
        //tran.remove(fragment);//제거
        //tran.replace(R.id.container,fragment2);//교체

        //프레그먼트를 빽스텍에 추가하면 뒤로 가게 할 때 Activity가 바로 꺼지지 않음.
        tran.addToBackStack(null);

        //트랜잭션이 완료되엇다고 명령
        tran.commit();
    }
}
