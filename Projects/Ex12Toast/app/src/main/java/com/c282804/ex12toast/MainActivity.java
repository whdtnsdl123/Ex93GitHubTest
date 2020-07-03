package com.c282804.ex12toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onclick 속성이 부여된 view가 클릭되면 자동으로 실행되는 메소드.
    public void clickBtn(View v){



        //1. 토스트 객체 생성[new키워드 대신에 Toast클래스의 makeText()메소드를 통해 토스트 객체 생성]
        //context : 안드로이드 운영체지의 기능을 사용할 수 있도록 만든 클래스 운영체제 대리만
        //Activity : context를 상속받았기에 context가 필요할 대 이 액티비티를 전달해도 됌.
        Toast t =Toast.makeText(this,"click",Toast.LENGTH_SHORT);
        //만들어진 토스트객체 화면에 보여라!!
       // t.show();

        //2 res/vlaues/strings.xml안에 문자열을 작성하고 토스트에서 문자열 읽어와 보여주기
        t= Toast.makeText(this,R.string.msg,Toast.LENGTH_SHORT);

        //토스트가 보여질 위치를 지정 가능.
        t.setGravity(Gravity.CENTER,0,0);
        //t.show();

        //3. 토스트에 문자열이 아닌 원하는 모양의 View 보여주기.
        //일단, 빈 문자열로 된 Toast객체 생성
        t= Toast.makeText(this,"",Toast.LENGTH_LONG);

        //토스트가 보여줄 View를 설정 [ 기본은 TextView로 되어 있음 ]

        //이미지뷰 객체 생성

        ImageView iv= new ImageView(this);
        iv.setImageResource(android.R.drawable.ic_lock_silent_mode);

        //텍스트 뷰 객체 생성

        TextView tv = new TextView(this);
        tv.setText("음소거");

        //t.setView(iv);
        //t.setView(tv);
        //토스트는 하나의 뷰만 설정 가능.
        //ViewGroup을 만들어서 그 안에 View들을 넣고
        //토스트에는 ViewGroup 1개를 설정
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(iv);
        layout.addView(tv);

        t.setView(layout);

        //토스트 보이기
        //t.show();
        t.setGravity(Gravity.CENTER,0,0);

        //4.xml로 View 객체 모양을 설계하고 이를 객체로 만들어 사용
        // layout폴더 안에 xml문서를 만들고 그 안에 뷰들을 배치.


        //토스트에 View로 설정하기.
        t=Toast.makeText(this,"",Toast.LENGTH_LONG);


        //xml에서 설계된 뷰들을 Java의 View객체로 만들어 주는 객체(LayoutInflater)에게 만들어(부풀리다 : inflate) 달라고 요청!!
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.toast,null);



        t.setView(view);

        t.setGravity(Gravity.CENTER,0,0);
        t.show();



    }
}
