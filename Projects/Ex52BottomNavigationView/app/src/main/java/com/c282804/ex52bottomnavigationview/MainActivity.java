package com.c282804.ex52bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentManager fragmentManager;



    Fragment[] fragments = new Fragment[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트의 동적 추가/삭제/제거를 위해 관리자 객체 소환
        fragmentManager=getSupportFragmentManager();

        //각 탭 화면 프레그먼트 객체 생성
        fragments[0] = new Tab1Fragment();
        fragments[1] = new Tab2Fragment();
        fragments[2] = new Tab3Fragment();
        fragments[3] = new Tab4Fragment();

        //첫번째 탬 화면 붙이는 작업
        FragmentTransaction tran = fragmentManager.beginTransaction();
        tran.add(R.id.container,fragments[0]);
        tran.commit();

        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                //프레그먼트 작업 트랜잭션 시작.
                FragmentTransaction tran= fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){


                    case R.id.aa:
                        tran.replace(R.id.container, fragments[0]);
                    break;

                    case R.id.bb:
                        tran.replace(R.id.container, fragments[1]);
                        break;

                    case R.id.cc:
                        tran.add(R.id.container, fragments[2]);
                        break;

                    case R.id.dd:
                        tran.add(R.id.container, fragments[3]);
                        break;


                }

                //트랜잭션 작업 명령 실행
                tran.commit();

                //return true가 아니면 선택은 되지만 효과가 적용되지 않음.
                return true;
            }
        });
    }
}
