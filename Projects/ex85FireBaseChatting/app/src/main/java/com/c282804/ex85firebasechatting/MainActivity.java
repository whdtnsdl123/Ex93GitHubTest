package com.c282804.ex85firebasechatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView ivprofile;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivprofile=findViewById(R.id.iv_circle);
        etName=findViewById(R.id.et_nickname);

        //이미 저장되어 있는 정보들 읽어오기


    }

    public void clickImage(View view) {
    }

    public void clickBtn(View view) {
    }
}
