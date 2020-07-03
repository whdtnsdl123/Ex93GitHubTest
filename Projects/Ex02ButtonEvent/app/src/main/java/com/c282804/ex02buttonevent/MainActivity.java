package com.c282804.ex02buttonevent;

import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰 객체들의 참조변수는 가급적 멤버변수로 만들것!!
    TextView tv;
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);//이때 xml문서를 읽어서 뷰 객체들을 생성함.

        //xml문서에서 만든 TextView객체를 찾아와서 tv참조변수를 참도호다록..
        tv= this.findViewById(R.id.tv);
        btn= findViewById(R.id.btn);//this.생략가능
        et= findViewById(R.id.et);

        //버튼을 클릭했을때 텍스트뷰의 글 변경
        //버튼이 클릭되는 것을 듣는 리스너 객체 생성

        View.OnClickListener listener= new View.OnClickListener(){
            //이 리스너가 객체가 바라보고 있는 버튼이 클릭되면 자동으로 실행되는 콜백메소드
            public void onClick(View v){
                //이 메소드 안에 코드를 작성하면.. 클릭되었을 때 이 코드들이 실행 됨.
                //tv.setText("Nice");
                Editable editable  =et.getText();
                String s = toString();

                // 얻어온 글씨를 TextView에 설정하기.
                tv.setText(s);

                //EditText에 써있는 글씨를 얻어와서
                //Textview에 설정하기

            }
        };
        //위에서 만든 리스너객체를 버튼에게 설정
        btn.setOnClickListener(listener);


    }
}
