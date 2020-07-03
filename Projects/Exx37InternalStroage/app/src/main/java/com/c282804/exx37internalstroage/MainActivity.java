package com.c282804.exx37internalstroage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        tv=findViewById(R.id.tv);
    }

    public void clickSave(View view) {
        //파일에 저장할 데이터를 EditText에서 얻어오기
        String data= et.getText().toString();
        et.setText("");//EditText 글 지우기

        //내부메모리(internal)에 파일을 저장할 수 있도록
        //OutputStream을 열수 있는 기능 메소드가 존재함.
        try {
            FileOutputStream fos =openFileOutput("data.txt",MODE_APPEND);
            PrintWriter writer = new PrintWriter(fos);
            writer.println(data);
            writer.flush();
            writer.close();

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void clickLoad(View view) {
        try {
            FileInputStream fis=openFileInput("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
             while (true){
                 String line= reader.readLine();
                 if(line==null)break;
                 buffer.append(line+"\n");
             }

            tv.setText(buffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
