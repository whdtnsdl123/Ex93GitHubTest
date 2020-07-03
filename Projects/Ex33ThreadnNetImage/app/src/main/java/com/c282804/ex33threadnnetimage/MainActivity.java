package com.c282804.ex33threadnnetimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
    }

    public void btn(View view) {
        //네티워크상에 있는 이미지 읽어와서 ImageView보여주기.
        //안드로이드에서 Main Thread는 네트워크 작업을 할 수 없음.
        //네크워크 작업을 하는 별도의 Thraed가 있어야만 함.
        Thread t= new Thread(){
            @Override
            public void run() {
                //Network에 있는 이미지 주소
                String imgUrl="https://pgnqdrjultom1827145.cdn.ntruss.com/img/7f/a2/7fa25e94ce0262f82418e9d2f9a3f576dc87dc3907ab2e2dd5c614a33c764e5f_v1.jpg";

                //파일까지 연결되는 무지개로드(Stream)를 만들어주는해임달(URL) 객체 생성
                try {
                    URL url = new URL(imgUrl);
                    //해임달에게 무지개로드를 열어달라고
                    InputStream is = url.openStream();

                    //무지개로드를 통해서 이미지 데이터 읽어와서
                    //안드로이드에 이미지를 관리하는 객체인 bitmap로 만들기


                    //그 Bitmap객체를 이미지뷰에 설정
                    final Bitmap bm = BitmapFactory.decodeStream(is);

                    //그 Bitmap객체를 이미지뷰에 설정
                    //이미지변경은 화면이 변경되는 것이고..
                    //별도의 스레드는 화면을변경 할 수 없음..
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            iv.setImageBitmap(bm);
                            
                        }
                    });



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        t.start();

    }
}
