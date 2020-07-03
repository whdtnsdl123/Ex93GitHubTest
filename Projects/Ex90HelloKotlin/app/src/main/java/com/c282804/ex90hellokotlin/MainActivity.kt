package com.c282804.ex90hellokotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun Btn(view: View) {
        //Xml에서 뷰에 지정한 id를 변수명으로 사용
        //주의 import kotlinx.android.synthetic.main.Activity_main.*가 되어 있어야함.

        tv.setText("Nice to meet you. kotlin!!")

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }
}

