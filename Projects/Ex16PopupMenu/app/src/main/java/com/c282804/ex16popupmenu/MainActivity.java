package com.c282804.ex16popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn2= findViewById(R.id.btn2);

        //버튼에 롱클릭 리스너
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               // Toast.makeText(MainActivity.this,"Long Click",Toast.LENGTH_SHORT).show();

                //PopupMenu객체 생성 [메뉴객체가 놓여질 수 있는 양탄자같은 객체]
                PopupMenu popup = new PopupMenu(MainActivity.this,btn2);//두번째 파라미터가 팝업메뉴가 붙을 뷰.

                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 클릭했을때를 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        switch (id){
                            case R.id.menu_info:
                                Toast.makeText(MainActivity.this,"INFORMATION",Toast.LENGTH_SHORT).show();
                                break;
                            case  R.id.menu_delete:
                                Toast.makeText(MainActivity.this,"DELETE",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_modify:
                                Toast.makeText(MainActivity.this,"MODIFY",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                //팝업메뉴 보이기
                popup.show();


                //리턴값 : 이 클릭 이벤트의 작업을 여기서  마칠 건지 여부
                return true;
            }
        });
    }

    public void ClickBtn(View view) {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
    }
}
