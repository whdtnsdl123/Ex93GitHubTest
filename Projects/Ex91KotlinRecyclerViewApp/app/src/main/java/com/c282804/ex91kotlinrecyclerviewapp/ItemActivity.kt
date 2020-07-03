package com.c282804.ex91kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.recycler_item.*
import kotlinx.android.synthetic.main.recycler_item.iv

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        //인텐트 객체 소환할 필요 없음 . why?이미 Intent가 액티비티의
        //property 로 존재하므로
        val title=intent.getStringExtra("title")
        val msg=intent.getStringExtra("msg")
        val img=intent.getIntExtra("img",R.drawable.moana01)

        //title은 제목줄에
        supportActionBar!!.title=title


        tv.text=msg
        Picasso.get().load(img).into(iv)
    }
}
