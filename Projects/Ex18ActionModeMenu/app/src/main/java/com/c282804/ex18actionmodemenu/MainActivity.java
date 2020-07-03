package com.c282804.ex18actionmodemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //액션모드 메뉴 시작하기!!
        startActionMode(new ActionMode.Callback() {

            //액션모드메뉴가 처음 만들어질 때 한번 호출 되는 메소드
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.actionmode,menu);

                //액션모드에 추가로 줄 수 있는 설정들
                mode.setTitle("Action Mode");
                mode.setSubtitle("This is Action Mode");

                //액션모드의 배경색은  stlyes.xml에서만 지정이 가능함.


                return true;//리턴값을 반드시 true로해야 모드 발동.
            }

            //액션모드메뉴가 시작 될 때 마다 발동하는 메소드.
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            //액션모드메뉴아이템을 클릭했을때 발동하는 메소드.(like. 옵션아이템같은)
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {


                switch (item.getItemId()){
                    case R.id.menu_aaa:
                        Toast.makeText(MainActivity.this,"SHARE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_bbb:
                        Toast.makeText(MainActivity.this,"MAP",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_ccc:
                        Toast.makeText(MainActivity.this, "DIALOG", Toast.LENGTH_SHORT).show();
                        break;


                }
                return false;
            }

            //액션모드가 닫힐때 자동으로 실행...
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
