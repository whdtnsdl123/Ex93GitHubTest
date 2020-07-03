package com.c282804.ex14optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    //상수화된 변수( final 상수)
    final int Menu_AAA = 1;
    final int Menu_BBB = 2;
    //이 액티비티가 처음 생성되면 자동으로 호출되는 메소드.(콜백메소드)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onCreate()메소드가 실행된 후 .
    //자동으로  OptionMenu를 만드는 작업을 하는
    //이 콜백메소드가 발동함.

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //방법1. 메뉴아이템 추가를 Java언어의 add()메소드로 하기!!
        //옵션메뉴에 들어갈 메뉴아이템을 생성하여 추가하면 됨.
        //menu.add(0,1,0,"aaa"); //자동으로 aaa라는 글씨를 가진 MenuItem 객체가 생성 및 추가
        //menu.add(0,2,0,"bbb");

        //방법2. 메뉴항목 설계를 XML언어로 하고 이를 Java에서 객체로 만들어 적용.
        //res/menu/option.xml문서를 만들고 그안에 메뉴항목들을 설계
        // menu폴더의 xml문서를 읽어와서 Menu객체로 만들어(부풀리는) 주는 객체(MenuInflater 에게 만들어 달라고 요청.)
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.option, menu);

        //Overflow(더보기)된 메뉴들은 기본적으로 icon이 보이지않음.
        //근데 꼭 하고싶다면..
        if( menu instanceof  MenuBuilder){
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }



        return super.onCreateOptionsMenu(menu);
    }
    //OptionMenu의 메뉴항목을 선택했을때
    //자동으로 실행되는 콜백메소드


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //선택한 MenuItem객체를 파라미터(매개변수 : Item)로 전달받음

        //전달된 Item객체의 아이디를 이용해서 식별하여 원하는 작업 수행
        int id = item.getItemId();
        switch ( id ){
            case R.id.menu_search:
                Toast t = Toast.makeText(this,"SEARCH",Toast.LENGTH_SHORT);
                t.show();

                break;

            case R.id.menu_add:
                Toast.makeText(this,"ADD",Toast.LENGTH_SHORT).show();

                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
