package com.c282804.a20200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etage;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.name);
        etage=findViewById(R.id.age);
        tv=findViewById(R.id.tv);

    }


    public void save(View view) {
        String name = etname.toString();
        String ageStr = etage.toString();
        int age;

        try {
            age=Integer.parseInt(ageStr);
        } catch (Exception e) {
            age=0;
        }

        SharedPreferences spf =getSharedPreferences("Data",MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();

        editor.putString()




    }

    public void load(View view) {
    }
}
