package com.c282804.ex83firebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.ed);
        tv=findViewById(R.id.tv);

    }

    public void send(View view) {
        //Edittext에 있는 글씨 얻어오기
        String text= et.getText().toString();

        //Firebase 실시간DB에 저장..

        //1. Firebase 실시간 DB관리 객체 얻어오기.
        FirebaseDatabase db= FirebaseDatabase.getInstance();

        //2. 저장시킬 노드 참조객체 가져오기.
        DatabaseReference rootRef=db.getReference();//최상위 노드

        //3. 해당 노드에 값 설정.
        rootRef.setValue(text);

    }
}
