package com.c282804.ex90hellokotlin

import android.bluetooth.BluetoothClass

open class Student constructor(name:String,age:Int,var major:String) : Person(name,age) {
    init {
        println("Student 클래스 만들어 졌어")

    }

    //override 키워드 주의
    override fun show(){
        //super.show()
        println("name: $name age: $age major: $major")


    }
}