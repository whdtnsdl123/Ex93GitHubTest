package com.c282804.ex38externalstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= findViewById(R.id.et);
        tv= findViewById(R.id.tv);
    }
    public void Save(View view) {

        //외장메모리(SD카드)가 있는지?
        String state = Environment.getExternalStorageState();

        //외장메모리(state)가 연결(Mounted)되어 있지 않은지 확인
        if(!state.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this, "SDcard is not mounted", Toast.LENGTH_SHORT).show();
            return;

        }

        String data=et.getText().toString();
        et.setText("");

        //데이터를 저장할 파일의 경로 얻어오기.
        File path;


        //외부메모리에 앱한테 할당한 고유한 폴더경로 얻어오기.
        File[] dirs=getExternalFilesDirs("My Dir");
        path=dirs[0];//첫번째 경로를 선택

        tv.setText(path.getPath() );//위에서 선택한 경로를 출력해보기

        //위의 경로(path)와 파일명을 결합한 File객체 생성
        File file =new File(path,"Data.txt");

        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter writer = new PrintWriter(fw);// 보조 writer
            writer.println(data);
            writer.flush();
            writer.close();

            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Load(View view) {
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)||
           state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){

            //읽을 수 없는 상태


            File[] dirs = getExternalFilesDirs("My Dir");
            File path=dirs[0];
            File file = new File(path,"Data.txt");


            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);

                StringBuffer buffer = new StringBuffer();
                while (true){
                    String line = reader.readLine();
                    if(line==null) break;
                    buffer.append(line+"\n");
                }

                tv.setText(buffer.toString() );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    //requestPermissions() 을 실해앻서 보여진 다이얼로그의
    //허가 거부를 선택했을때 자동으로 실행되는 콜백메소드
    //마치 StartActivityForResult()했을때..onActivityResult()자동 호출


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 1:

                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "저장 가능합니다.", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(this, "외부 저장소 사용불가.", Toast.LENGTH_SHORT).show();
                }
            break;
        }

    }

    public void Btn(View view) {
        //외부메모리에서 본인앱에게 할당된 고유한 경로가 아닌곳을 사용할때.
        //무조건 퍼미션 필요함

        String state = Environment.getExternalStorageState();
        if(!state.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this, "외부 저장소.", Toast.LENGTH_SHORT).show();
            return;
        }

        //동적퍼미션 작업(앱 시랳ㅇ중에 다이얼로그가 보이면서 퍼미션 체크)
        //이 앱에서 저장소를 사용하는 퍼미션이 허가되어 있는지 체크
        //api 23버전(M버전) 이상에서만 체크
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int checkResult= checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            //외부저장소 사용허가가 거부(dinied) 되었는지 확인
            if(checkResult== PackageManager.PERMISSION_DENIED){
                //퍼미션을 허용해 달라고 요청하는 다이얼로그 보이는 메소드 실행
                String[] permission= new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission,1);

                return;
            }

        }

        //퍼미션이 허가된 이후에 실행되는 영역
        //SDcard에 특정 위치 저장하기.

        File path= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(path,"aaa.txt");

        try {
            FileWriter fr = new FileWriter(file,true);
            PrintWriter writer = new PrintWriter(fr);
            writer.println(et.getText().toString());
            writer.flush();
            writer.close();

            tv.setText("저장 완료.");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
