package com.c282804.ex54materialtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    ImageView iv;


    TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.iv);

        //iv.setImageResource(R.drawable.moana03);
        //Glide Library
        Glide.with(this).load("http://imgnews.naver.net/image/028/2010/02/02/1265100449_6000399535_20100203.JPG").into(iv);

        inputLayout=  findViewById(R.id.layout_et);
        inputLayout.setCounterEnabled(true);//숫자 글씨 적히는것
        inputLayout.setCounterMaxLength(10);//글자 제한 수 넣기

        //Edittext 의 inputtype이 password일때만.
        inputLayout.setPasswordVisibilityToggleEnabled(true);

        TextInputEditText et= findViewById(R.id.et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.toString().contains("#")){
                    inputLayout.setError("특수문자 사용금지");
                }else {
                    inputLayout.setError(null);
                }

                if(s.length()==0) inputLayout.clearFocus();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



}
