package com.c282804.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LikeActivity extends AppCompatActivity {

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        button= findViewById(R.id.btnlike);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LikeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void Login4(View view) {
        Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show();
    }
}
