package com.c282804.ex15contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        //액티비티에게 btn객체를 ContextMenu로 등록
        this.registerForContextMenu(btn);
    }

    //Context메뉴로 지정된 View/btn)이 롱 클릭 되었을때
    //보여지는 context menu를 만드는 작업을하는 콜백메소드


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //전달받은 menu객체에 Menuitem을 추가
        //res/menu/context.xml파일을 만들어서 메뉴항목을 작성
        //xml문서를 ㅣㅇㄹ겅와서 Menu객체로 만들기(부풀리다)
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //콘텍스트메뉴의 메뉴아이템을 선택했을때 자동으로 발동하는 콜백메소드.

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.menu_save:
                Toast.makeText(this,"SAVE",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.menu_delete:
                Toast.makeText(this,"DELETE",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    public void clickBtn(View view) {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT);
    }

}
