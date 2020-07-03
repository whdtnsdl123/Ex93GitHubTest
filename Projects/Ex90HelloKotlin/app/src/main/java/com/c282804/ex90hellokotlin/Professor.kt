package com.c282804.ex90hellokotlin

class Professor : Person {
    var subject:String?=null
    //보조생성자
    constructor(name:String,age:Int, major:String):super(name, age ){
        this.subject=major
        println("Professor 생성")

    }

    override fun show(){

    }
}