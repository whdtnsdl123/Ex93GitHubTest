package com.c282804.ex17searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //oncreate()메소드가 실행 된 후 Option메뉴를 만드는 작업을 작성하기 위해서 자동으로 실행되는 콜백 메소드

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar,menu);

        //위 inflate() 작업을 통해 MenuItem이 만들어져 있음.
        //그 메뉴 아이템객체에게 SearchView를 참조하기위해 얻어오기.
        MenuItem item= menu.findItem(R.id.menu_search);
        sv = (SearchView) item.getActionView();

        //SeachView의 힌트글씨 변경
        sv.setQueryHint("키워드를 검색하세요.");

        //sv.setQuery("seoul",false);



        //소프트키패드의 검색버튼(돋보기 모양)을 클릭하는 것을 듣는 리스너 추가..
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,query+"를 검색했습니다.",Toast.LENGTH_SHORT).show();
                return false;
            }

            //서치뷰의 EditText안에 글씨를 변경할 때 마다 실행되는 콜백 메소드.
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
