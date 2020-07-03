package com.c282804.ex40sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    EditText etEmail;


    String dbName = "test.db";
    String tableName="member";

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.Name);
        etAge=findViewById(R.id.Age);
        etEmail=findViewById(R.id.Email);


        //dbName으로 데이터베이스 파일 열기
        //문서를 열면 그DB를 제어하는 객체를 리턴해줌
        db=openOrCreateDatabase(dbName,MODE_PRIVATE,null);

        //db객체를 이용해서 DBMS시스템에 명령(SQL)을 줄 수 있음.
        db.execSQL("CREATE TABLE IF NOT EXISTS "+tableName+"(num integer primary key autoincrement, name text not null, age integer, email text)");


    }

    public void insert(View view) {
        String name=etName.getText().toString();
        int  age = Integer.parseInt(etAge.getText().toString());
        String email=etEmail.getText().toString();

        db.execSQL("INSERT INTO "+tableName+"(name , age , email) VALUES('" +name+ "','"+age+"','"+email+"')");

        etName.setText("");
        etAge.setText("");
        etEmail.setText("");


    }

    public void selectall(View view) {

        //where 구문이 없으면 모든 데이터(record)를 읽어오라는 뜻임.
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName, null);
        //리턴된 결과표를 가르키는 Cursor객체를 이용해서 데이터를 한줄씩(row, record) 이동하며 읽어들임
        if(cursor==null) return;

        StringBuffer buffer =new StringBuffer();
        while( cursor.moveToNext()){
            //현재 가르키는 줄(row)의 각 칸(Column)들의 값을얻어오기
            int num = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String email = cursor.getString(cursor.getColumnIndex("email"));

            buffer.append(num+""+name+""+age+""+email+"\n");
        }//while

        //누적한 문자열데이터를 AlertDialog에 보여주기
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage(buffer.toString()).create().show();



        buffer.append(etName+""+etEmail+"\n");

    }

    public void sbn(View view) {
        String name =etName.getText().toString();

        Cursor cursor = db.rawQuery("SELECT name,email FROM "+tableName+" WHERE name=?", new String[]{name});
        if(cursor==null)return;

        while (cursor.moveToNext() ){
            String name2= cursor.getString(0);
            String email= cursor.getString(1);


        }

    }

    public void ubn(View view) {
        String name = etName.getText().toString();
        db.execSQL("UPDATE "+tableName+" SET age=30, email='aa@aa.com'WHERE name=?", new String[]{name});


    }

    public void delete(View view) {
        String name = etName.getText().toString();
        db.execSQL("DELETE FROM "+tableName+" WHERE name=?",new String[]{name});
    }
}
