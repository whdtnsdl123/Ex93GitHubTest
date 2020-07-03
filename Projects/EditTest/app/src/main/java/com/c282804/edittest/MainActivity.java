package com.c282804.edittest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et,et2,et3,et4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);


    }

    public void clickBtn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("게시물 이동");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setMessage("게시물로 이동하시겠습니까?");


        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String s = et.getText().toString();
                String s2 = et.getText().toString();
                String s3 = et.getText().toString();
                String s4 = et.getText().toString();

                Intent intent  = getIntent();
                intent.putExtra("name",s);
                intent.putExtra("nick",s2);
                intent.putExtra("title",s3);
                intent.putExtra("white",s4);

                setResult(RESULT_OK,intent);

             finish();



            }
        });




        builder.show();




        Toast.makeText(this, "확인", Toast.LENGTH_SHORT).show();






    }

    public void clickBtn2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("게시물 나가기");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setMessage("나가시겠습니까?");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();

        Toast.makeText(this, "EXIT", Toast.LENGTH_SHORT).show();


    }


}