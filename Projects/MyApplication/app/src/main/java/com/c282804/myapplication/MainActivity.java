package com.c282804.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    public void Login(View view) {
        Toast.makeText(this, "Welcome to JongHoon", Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        Toast.makeText(this, "Welcome to JongHoon", Toast.LENGTH_SHORT).show();
    }
}
