package com.c282804.ex91kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn= findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            Toast.makeText(this@SecondActivity,"asdf",Toast.LENGTH_SHORT).show()
        }
    }
}
