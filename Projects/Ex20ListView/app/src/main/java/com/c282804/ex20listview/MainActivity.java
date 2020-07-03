package com.c282804.ex20listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    ArrayAdapter adapter; //참조변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);
        //리스트뷰에서 보여줄 View들을 만들어주는 객체 생성.
        adapter = ArrayAdapter.createFromResource(this,R.array.datas,R.layout.list_item);

        //리스트뷰에게 아답터 설정.
        listView.setAdapter(adapter);

        //리스트뷰의 항목(item)을 클릭하는 것을 듣는 리스너 객체 생성 및 설정.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //res창고 관리자객체 소환
                Resources res=getResources();
                //res/values/arrays.xml 안에 있는 datas 라는 이름의 배열 얻어오기
                String[] arr=res.getStringArray(R.array.datas);
                Toast.makeText(MainActivity.this,arr[position],Toast.LENGTH_SHORT).show();
            }
        });

        // 아 이 템 롱 클릭 리스너 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"long click",Toast.LENGTH_SHORT).show();

                //보통 이곳에서 Popupmenu를 만들어ㅓ 보여줌.


                return true; //true로 안하면 onclick도 발동함.
            }
        });

    }
}
