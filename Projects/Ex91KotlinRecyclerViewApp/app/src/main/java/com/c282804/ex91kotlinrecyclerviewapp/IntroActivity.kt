package com.c282804.ex91kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //id가 btn인 버튼에 클릭리스너 추가하기
        btn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                //MainActivity 실행
                var intent= Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun clickExit(view: View) {
        finish()
    }
}
