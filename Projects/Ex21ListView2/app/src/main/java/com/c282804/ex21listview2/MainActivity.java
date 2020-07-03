package com.c282804.ex21listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    EditText editText;
    //1.대량의 데이터들
    ArrayList<String> datas= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //리스트뷰에서 보여줄 대량의 데티어 추가
//        datas.add(new String("aaa"));
//        datas.add(new String("bbb"));
//        datas.add("ccc");





        listView=findViewById(R.id.listview);
        editText=findViewById(R.id.et);
        //리스트뷰에 보여질 뷰들을 만들어주는 객체를 생성
        adapter= new ArrayAdapter(this,R.layout.list_item,datas);
        //리스트뷰에 어댑터 설정
        listView.setAdapter(adapter);

        //리스트 뷰의 아이템이 비어있을때 보여지는 뷰를 설정.
        TextView tv= findViewById(R.id.tv_empty);
        listView.setEmptyView(tv);

        //리스트뷰에 아이템 롱 클릭 리스너 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //데이터 삭제
                datas.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void clickBtn(View view) {
        //EditText에 써있는 글씨 써오기
        String s = editText.getText().toString();
        //얻어온 글씨를 대량의 데이터에 추가
        datas.add(s);

        //어댑터에게 새로운 데이터가 있으니 리스트뷰를 갱신하도록 요청
        adapter.notifyDataSetChanged();
        //리스트뷰의 스크롤위치 지정
        listView.setSelection(datas.size() - 1);
        //에디터텍스트의  글시 비우기
        editText.setText("");

    }
}
