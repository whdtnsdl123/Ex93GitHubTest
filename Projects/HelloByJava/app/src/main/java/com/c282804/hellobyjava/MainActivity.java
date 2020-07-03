package com.c282804.hellobyjava;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //가급적 액티비티가 보여쥬는VIew들의 참조변수는 멤버변수로 만들것!!

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        //Java언어만으로 이 Activity가 보여줄 View들을 설정

        //액티비티에 놓여질 수 있는 것들은 View클래스를 상속한 클래스들만 가능.

        //글씨를 보여주는 TextView객체 생성 및 설정 지역변수가 아닌 멤버변수로 참조변수 만들것.
        tv = new TextView(this) ;
        tv.setText("Hello World");
        //setContentView(tv);
        //만들어진 TextView

        //버튼 객체 생성 및 설정

        btn = new Button(this);
        btn.setText("change text");

        //만들어진 Button을 애기비티에서 보여주기
        //setContentView(btn);

        //기본적으로 액티비티는 한번에 하나의 View객체만 보여줄 수 있음!


        //그래서 여러개의 View객체를 담을 수 있는 ViewGroup객체를 생성
        //ViewGroup중에서 가장 기본적이고 많이 사용되는 LinearLayout클래스를 객체로 생성한다.
        LinearLayout layout = new LinearLayout(this);

        //이 레이아웃객체에 위에서 만든 Button, TextView추가.
        layout.addView(tv);
        layout.addView(btn);

        //이 레이아웃객체를 액티비티가 보여주도록...
        this.setContentView(layout);

        //버튼 클릭했을때 TextView의 글씨 변경
        View.OnClickListener listener = new View.OnClickListener() {
            //이 리스너가 바라보고 있는 버튼이 클릭되면 자동으로 실행되는 콜백메소드.

            @Override
            public void onClick(View v) {
                //TextView가 보여주는 글씨를 변경
                tv.setText("nice to meet you");
            }
        };
        btn.setOnClickListener(listener);

    }

    public void btn(View view) {
    }
}
