package com.c282804.ex77jsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
    }

    public void clickBtn(View view) {

        //assets폴더의 파일을 가져오기 위해 창고관리자 소환
        AssetManager assetManager =getAssets();


        //assets/test.json파일 얻기위한 InputStream
        try {
            InputStream is = assetManager.open("test.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            while (true){
                String line = reader.readLine();
                if (line==null)break;

                buffer.append(line+"\n");


            }

            String jsonData=buffer.toString();

            //읽어온 jsonData 문자열을 파싱하기
//            JSONObject jsonObject=new JSONObject(jsonData);
//            String name=jsonObject.getString("name");
//            String message=jsonObject.getString("msg");
//
//            tv.setText("이름 :" + name + " 메세지 :"+ message);

            //읽어온 json문자열이 jason배열일대는
            JSONArray jsonArray = new JSONArray(jsonData);

            jsonArray.length();

            StringBuffer buffer1= new StringBuffer();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jo =jsonArray.getJSONObject(i);
                String name= jo.getString("name");
                String message=jo.getString("msg");
                JSONObject obj=jo.getJSONObject("addr");
                String city=obj.getString("city");
                int post = obj.getInt("post");


                buffer1.append(name+","+message+"==>"+city+","+post);
            }

            tv.setText(buffer1.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
