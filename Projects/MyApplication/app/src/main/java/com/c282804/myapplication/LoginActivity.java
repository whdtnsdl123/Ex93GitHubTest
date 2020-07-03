package com.c282804.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button= findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,LikeActivity.class);
                startActivity(intent);
                finish();

            }
        });
        button= findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    public void Login2(View view) {
        Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
    }

    public void Login3(View view) {
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
    }
}
