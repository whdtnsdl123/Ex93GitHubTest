package com.c282804.a;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Jong.ho0n");


    }



    public void Btn(View view) {

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("fuck");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent(MainActivity.this,MessageActivity.class);
                startActivity(intent);



            }
        });
        builder.setNegativeButton("kkk",null);
        builder.create();
        builder.show();
    }
}
