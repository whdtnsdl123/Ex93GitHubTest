package com.c282804.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //뷰들을 참조하는 멤버 참조변수
    EditText et;
    Button btn;
    TextView tv;



    //컴퓨터가 정한 정답 숫자를 저장하고 있을 변수
    int com; // 랜덤하게 500~1000사이의 숫자중에 하나


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에 만든 뷰들을 Id 를 이용해서 찾아와 참조변수에 대입...
        et= findViewById(R.id.et);
        btn= findViewById(R.id.btn);
        tv= findViewById(R.id.tv);


        //사용자가 숫자를 입력하고 비튼을 클릭하면
        //EditText에 입력되어 있는 글씨를 얻어와서 컴퓨터가 정한 정답이 맞는지 비교
        //그 결과 TextView에 보여주기

        //컴퓨터가 정한 정답 값
        Random rnd = new Random();
        com= rnd.nextInt(501) + 500; //500-1000

        //버튼이 클릭되는 것을 듣는 리스너 객체 생성
        View.OnClickListener listener = new View.OnClickListener() {
            //이 리스너가 바라보고 있는 버튼이 클릭되면 자동으로 실행되는 메소드
            @Override
            public void onClick(View v) {
                //EditText에 있는 글씨를 얻어와서
                Editable editable = et.getText();
                String s = editable.toString();
                //얻어온 글씨(String)을 정수형 숫자(int)로 변환
                int user = Integer.parseInt(s);

                //얻어온 값과 com값을 비교하여 그 결과를 TextView에 보여주기
                if(user<com) {
                    tv.setText((user + "보다 큽니다."));
                }else if(user>com) {
                    tv.setText(user + "보다 작습니다.");
                }else {
                    tv.setText("축하합니다.\n정답입니다.");
                }
                //만약 EditText의 그시를 지우고 싶다면..
                //지우는 메소드는 별도로 존재하지 않음.
                et.setText("");//빈문자열로 글씨를 변경하여


            }
        };


        //버튼에 리스트객체 새ㅓㄹ정
        btn.setOnClickListener(listener);
    }
}
