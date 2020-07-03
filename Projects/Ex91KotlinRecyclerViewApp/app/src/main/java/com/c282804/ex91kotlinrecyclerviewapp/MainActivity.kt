package com.c282804.ex91kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //대량의 데이터 property[멤버변수]
    var item= ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //원래는 서버에서 데이터를 읽어와야 하지만 시간상
        //그냥 대량의 데이터를 추가
        item.add( Item("sam","Hello",R.drawable.moana01))
        item.add( Item("jong","Hello2",R.drawable.moana02))
        item.add( Item("hoon","Hello3",R.drawable.moana03))
        item.add( Item("jin","Hello4",R.drawable.moana04))
        item.add( Item("hee","Hello5",R.drawable.moana05))
        item.add( Item("sam","Hello",R.drawable.moana01))
        item.add( Item("jong","Hello2",R.drawable.moana02))
        item.add( Item("hoon","Hello3",R.drawable.moana03))
        item.add( Item("jin","Hello4",R.drawable.moana04))
        item.add( Item("hee","Hello5",R.drawable.moana05))

        //코틀린의 Recycler는 setAdapter()를 사용하지 않고
        //RecyclerView의 프로퍼티 로서 adapter를 가지고 있음
        //그래서 아답터를 굳이 멤버변수로 만들 필요 없음!!
        recycler.adapter= MyAdapter(this,item)

        //리사이클러뷰에서 레이아웃매니저 설정
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    override fun onResume() {
        super.onResume()

        //리사이클러 뷰 갱신하기
        //리사이클러뷰안ㅇ ㅔ잇는 adapter가 null인지를 체크한 후에 명령요청
        //멤ㅁ버변수가 null이 아닌지 체크를 해주고 실행하는 키워드!!
        //!! 키워드의 특징 : 혹시 null이면 메소드를 실행하지 않음.. 즋 null에러가 나지 않음.
        recycler.adapter!!.notifyDataSetChanged()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_aa->Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show()
            R.id.menu_bb->Toast.makeText(this,"bb",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }




}
