package com.c282804.instargram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    int a = 0;


    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);

    }

    public void clickBtn(View v) {
        Toast.makeText(this,"좋아요를 누르셨습니다.",Toast.LENGTH_SHORT).show();

    }

    public void clickBtn2(View view) {
        Toast.makeText(this,"댓글 남기기.",Toast.LENGTH_SHORT).show();

    }

    public void clickBtn3(View view) {
        Toast.makeText(this,"상대에게 보내기.",Toast.LENGTH_SHORT).show();
    }

    public void clickBtn4(View view) {
        Toast.makeText(this,"공유하기.",Toast.LENGTH_SHORT).show();
    }

    public void clickBtn5(View view) {
        a = a+1;
        if(a>4){
            a =4;
        }
        iv.setImageResource(R.drawable.moana01+a);



    }
}
