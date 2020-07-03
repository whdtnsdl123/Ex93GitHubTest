package com.c282804.ex78gsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }

    public void GSON(View view) {

        //Gson library를 이용하여 Json문자열을 Person객체로  곧바로 파싱.

        String jsonStr="{'name': 'robin', 'age':25}";

        Gson gson=new Gson();
        Person p = gson.fromJson(jsonStr,Person.class);//json 문자열에서 Person객체로
        tv.setText(p.name+","+p.age);
    }

    public void GSON2(View view) {
        Person p = new Person("robin", 25);

        Gson gson = new Gson();
        String jsonStr=gson.toJson(p);
        tv.setText(jsonStr);
    }

    //멤버변수
    ListView listView;
    ArrayAdapter adapter;
    List<String> items= new ArrayList<>();


    public void GSON3(View view) {

        String str="[{'name:'hong','age': 20}],[{'name:'kim','age': 20}]";

        Gson gson=new Gson();

        Person[] personARR=gson.fromJson(str,Person[].class);

        //배열->리스트
        for(Person p : personARR){
            items.add(p.name+","+p.age);


        }


        listView=findViewById(R.id.listview);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);


    }

    public void GSON4(View view) {
        final String serverUrl="http://c282804.dothome.co.kr/test.json";

        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(serverUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);

                    InputStream is = url.openStream();
                    InputStreamReader isr= new InputStreamReader(is);


                    //Reader까지만 있으면 GSON 알아서 읽어와서 객체로 파싱해줌
                    Gson gson = new Gson();
                    final  Person p = gson.fromJson(isr,Person.class);



                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(p.name+","+p.age);
                        }
                    });



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
