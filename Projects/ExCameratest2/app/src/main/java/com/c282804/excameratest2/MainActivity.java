package com.c282804.excameratest2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    Uri imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int i= checkSelfPermission(Manifest.permission.W);

            if(permissionRe)

        }
    }


    public void clickFAB(View view) {

        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        //캡처된 이미지 Uri를 정하는 메소드

        if(imgUrl!=null) intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUrl);

        startActivityForResult(intent,30);

    }

    //캡처한 이미지를 저장할 파일경로 Uri를 정하는 메소드
    void setImageUri(){

        //외부저장소에 저장하는것을 권장
        //이때 외부저장소의 2가지 영역이 존재함
        //1. 외부저장소 중에서 본인 앱에 할당된 영역 - 퍼미션 없어도됨. 특징: 앱을지우면 저장된 사진도 같ㅇ ㅣ지워짐.

        //2. 외부저장소 중에서 공용영역.. 동적 퍼밋ㄴ 필요. 특징: 앱을 지워도 사진이 저장되어 있음.
        File path= Environment.getExternalStorageDirectory();//외부메모리의 최상위(root) 경로
        path= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        //경로를 정햇으니 파일명 정하기.
        //같은 이름을 저장하면 덮어쓰기가 되므로 저장할때 마다 다른이름으로
        //통상 일시를 이용해서 파일명 정함/ex "IMG_2020611104231.jpg"
        //1. 날짜를 이용하는 방법.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName="IMG"+sdf.format(new Date()) +".jpg";

        //파일명과 경로를 합쳐서 File객체 생성
        File file= new File(path.fileName);
//        //2. 자동으로 임시파일명을 만들어주는메소드 이용하는 방법.
//        try {
//            file=File.createTempFile("IMG_",".jpg",path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //카메라앱에 전달해줘야할 저장 파일경로는 File객체가 아니라 uri객체여야함.
        //File-->Uri 변환
        // 누가(N) 버전(api24)부터 이 변환이 어려워 졌음..
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.N){
            imgUrl=Uri.fromFile(file);

        }else {

            //다른앱에게 파일의 접급을 허용하도록 하는 Content Provider를 이용
            //Provider중에서 안드로이드에 이미 만들어져 있는 FileProvider를 이용
            //1. Manifest.xml에서 <Provider>태그를 이용하여 FileProvider클래스 등록
            //2. Provider가 공개할 파일의 경로를 res>>xml폴더안에 "Paths.xml"이라는 이름으로 만들어서<path>태그로 경로 지정.
            //3. Java에서 <Provider>태그에 작성한 속성 중 authori

        }

    }
}
