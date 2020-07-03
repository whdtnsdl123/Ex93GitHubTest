package com.c282804.ex75;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;


    String textUrl="c282804.dothome.co.kr/text.txt";
    String imgUrl="http://c282804.dothome.co.kr/moana01.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        iv=findViewById(R.id.iv);

    }

    public void Btn(View view) {
        //서버에서 제공하는 텍스트파일 읽어오기
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(textUrl);

                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader reader = new BufferedReader(isr);

                    final StringBuffer buffer = new StringBuffer();
                    while (true){
                        String line = reader.readLine();
                        if(line==null) break;

                        buffer.append(line+"\n");
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(buffer.toString());
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

    public void Btn2(View view) {

        //이미지를 네트워크에서 소누십게 로딩하여 보여주는 라이브러리 사용
        Glide.with(this).load(imgUrl).into(iv);

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL(imgUrl);
//
//                    InputStream is = url.openStream();
//                    final Bitmap bm = BitmapFactory.decodeStream(is);
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            iv.setImageBitmap(bm);
//                        }
//                    });
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
    }
}
