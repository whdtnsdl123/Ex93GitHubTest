package com.c282804.ex24listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Member> members = new ArrayList<>();

    MyAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 Data를 추가작업
        members.add(new Member("최종훈","대한민국",R.drawable.flag_korea));
        members.add(new Member("홍길동","일본",R.drawable.flag_japan));
        members.add(new Member("고길숙","중국",R.drawable.flag_china));
        members.add(new Member("김경식","이탈리아",R.drawable.flag_italy));
        members.add(new Member("박경숙","네팔",R.drawable.flag_nepal));
        members.add(new Member("박정미","러시아",R.drawable.flag_russia));
        members.add(new Member("최종훈","대한민국",R.drawable.flag_korea));
        members.add(new Member("홍길동","일본",R.drawable.flag_japan));
        members.add(new Member("고길숙","중국",R.drawable.flag_china));
        members.add(new Member("김경식","이탈리아",R.drawable.flag_italy));
        members.add(new Member("박경숙","네팔",R.drawable.flag_nepal));
        members.add(new Member("박정미","러시아",R.drawable.flag_russia));

        //대량의 데이터를 적합한 View들로 만들어주는 객체
        LayoutInflater inflater = getLayoutInflater();
        adapter = new MyAdapter(members,inflater);//대량의 데이터들, LayoutInflater

        listView=findViewById(R.id.listview);
        //리스트뷰의 어댑터설정
        listView.setAdapter(adapter);

        //리스트뷰의 아이템 클릭에 반응하는 리스너 추가
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,members.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
