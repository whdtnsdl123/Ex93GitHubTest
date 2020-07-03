package com.c282804.ex35xmlresourceparse;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> items= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  items.add(new String("aaa"));
      //  items.add(new String("bbb"));

        listView=findViewById(R.id.listview);
        adapter=new ArrayAdapter(this,R.layout.listview_item,items);
        listView.setAdapter(adapter);
    }

    public void Btn(View view) {

        //res/xml/movies를 읽어와서 분석(Parse)g하여 ListView의 데이터(items)에 추가.
        //res창고를 관리하는 창고관리자 객체 소환
        Resources res= getResources();

        //res폴더안의 xml문서를 읽어와서 분석해주는 분석해주는 분석가 객체 소환
        XmlResourceParser xrp= res.getXml(R.xml.movies);

        //분석가 객체(xrp)를 통해 xml문서를 분석하기!!

        try {
            xrp.next();
            int eventType= xrp.getEventType();

            //문서의 끝이 아니면 반복해라!!!
            while (eventType!=XmlResourceParser.END_DOCUMENT){
                xrp.next();
                eventType=xrp.getEventType();

                String item="";//빈 문자열객체 생성

                switch (eventType){
                    case  XmlResourceParser.START_DOCUMENT:
                        Toast.makeText(this, "분석을 시작합니다.", Toast.LENGTH_SHORT).show();
                        break;

                    case XmlResourceParser.START_TAG:
                    String name= xrp.getName();
                    if(name.equals("item")){
                        item="";//영화 1개의 정보 시작문자열
                    }else  if(name.equals(("no"))){
                        item= item+"번호:";

                    }else  if(name.equals("title")){
                        item=item+"제목";

                    }else  if(name.equals("genre")){
                        item=item+"장르";
                    }
                    break;

                    case XmlResourceParser.TEXT:
                        //텍스트 글씨 얻어오기
                        String text= xrp.getText();
                        item= item+item;
                        break;

                    case XmlResourceParser.END_TAG:
                        String name2= xrp.getName();
                        if(name2.equals("no")){
                            item=item+"\n";

                        }else if(name2.equals("item")){
                            //하나의 영화아이템이 끝났으므로
                            //리스트뷰가 보여주는 대량의 데이터(item)에 추가
                            items.add(item);
                            adapter.notifyDataSetChanged();
                        }
                        break;

                    case XmlResourceParser.END_DOCUMENT:
                        break;
                }

                eventType=xrp.next();
            }

            Toast.makeText(this, "파싱을 종료합니다.", Toast.LENGTH_SHORT).show();
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }


    }
}
