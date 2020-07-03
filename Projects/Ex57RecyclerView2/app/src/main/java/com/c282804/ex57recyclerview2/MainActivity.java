package com.c282804.ex57recyclerview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Item> items = new ArrayList<>();

    MyAdaptor adaptor;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터추가 [실무에서는 DB나 서버에서 데이터를 읽어옴.]
        items.add(new Item("모아나","주인공",R.drawable.moana01,"http://blogfiles.naver.net/MjAxNjEyMTNfMjc1/MDAxNDgxNjIyOTc2NjY4.KtWB0UgV56Ztg6bYO9itG2Duj26mTedDkV4gSUSBhDMg.wPGQgSUhdTcIbxvDOWqOgs_ElNjcUCw9PJC9sPxwFR8g.JPEG.pcgowoon/10.jpg"));
        items.add(new Item("모아나1","주인공1",R.drawable.moana02,"http://blogfiles.naver.net/20150602_219/awonce_14332482141085MlCE_JPEG/98033f92293d4813c98e5cbe828617c7.jpg"));
        items.add(new Item("모아나2","주인공2",R.drawable.moana03,"http://blogfiles.naver.net/MjAxNjEyMjJfMzMg/MDAxNDgyMzg4MjU0ODUy.NVWYq7p5VAD9yVlEdSevZviPhclHh67AUMpcQ81nGeIg.y-o3bsz3zTotLl0D78mWt6YlXL84nItofRcdcqB9I7Mg.JPEG.labellahi/%B5%F0%C1%F6%B4%CF%B8%F0%BE%C6%B3%AA.PNG"));
        items.add(new Item("모아나3","주인공3",R.drawable.moana04,"https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAxNzAxMTZfMjM2%2FMDAxNDg0NTQ4MjM0MDc0.pUEeqClpHK3Ln5TSRYwFb0jnn2gKILvrdXGpkmwzAUEg.o5ecxGe4uPast9nKc1hFX3GV8a62hgz2aHOyTNoC_T0g.GIF%2FI9hkE7uLWzo8yRAG9_2opCkR_29w.jpg&type=b400"));


        adaptor= new MyAdaptor(this,items);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(adaptor);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aa:
                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                break;

            case R.id.menu_bb:
                RecyclerView.LayoutManager layoutManager1 =new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(layoutManager1);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
