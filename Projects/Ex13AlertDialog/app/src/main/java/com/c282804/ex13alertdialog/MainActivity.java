package com.c282804.ex13alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickBtn(View view) {
        //AlertDialog를 만들어주는 건축가(Builder)객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //2. 건축가에게 만들고자 하는 AlertDialog의 제목과 아이콘 설정.
        builder.setTitle("다이얼로그");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // 다이얼로그에 보일 메세지 설정
        //builder.setMessage("Do you wanna Quit?");

        //다이얼로그에 보일 커스텀뷰 설정
        //XML에 뷰의 모양을 설계하고 이를 객체로 생성하여 다이얼로그에 설정.
        //res/layout/dialog.xml를 자바의 View객체로 만들어주는 객체를(LayoutInflater) 소환.
        LayoutInflater inflater= this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog,null);

        //만들어진 v(LinearLayout)에게 안에 있는 EditText, TextView를 찾아달라고..
        //id를 이용해서 View를 찾아와 참조변수 대입.
        et = v.findViewById(R.id.et);
        tv = v.findViewById(R.id.tv);
        builder.setView(v);

        // 다이얼로그에 버튼 달기
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //이 버튼이 눌러졌을때 자동으로 실행되는 메소드
                Toast t = Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT);
                t.show();

            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast t =Toast.makeText(MainActivity.this,"CANCEL",Toast.LENGTH_SHORT);
                t.show();

            }
        });


        //건축가에게 요구사항을 모두 설정했으니..
        //이 요구사항대로 AlertDialog 를 만들어 달라고 요청
        AlertDialog dialog = builder.create();

        //다이얼로그의 바깥쪽을 터치했을때 다이얼로그가 사라지는 여부 설정.
        //dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);



        //만들어진 다이얼로그 화면 보이기.
        dialog.show();













    }//clickBtn method...

    //다이얼로그안에 있는 커스텀뷰 안에 있는 Button을 클릭했을때 실행되는 메소드
    public void clickDialogBtn(View v){
        //EditText에 있는 글씨를 얻어오기
        String s= et.getText().toString();



        //얻어온 글씨를 TextView에 보이기.
        tv.setText(s);
    }

}//MainActivity class...
