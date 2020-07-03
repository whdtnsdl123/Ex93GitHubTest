package com.c282804.ex39sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//Preferences 불러 오는 기능
    EditText etName;
    EditText etAge;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.name);
        etAge=findViewById(R.id.age);
        tv=findViewById(R.id.tv);
    }

    public void save(View view) {

        String name = etName.getText().toString();
        String ageStr= etAge.getText().toString();
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {
            age=0;
        }

        //내부메모리에 Data.xml이라는 문서에 데이터를 저장해주는 객체 소환.
        SharedPreferences pref = getSharedPreferences("Data",MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();//문서 저장을 시작합니다.

        editor.putString("Name",name);
        editor.putInt("Age",age);
        editor.commit();
    }

    public void load(View view) {

        SharedPreferences pref = getSharedPreferences("Data",MODE_PRIVATE);

        String name = pref.getString("Name","No Name");
        int age = pref.getInt("Age",0);

        tv.setText(name+"\n"+age);
    }
}
