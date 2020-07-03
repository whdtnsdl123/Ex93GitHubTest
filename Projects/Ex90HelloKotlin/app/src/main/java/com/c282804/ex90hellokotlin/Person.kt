package com.c282804.ex90hellokotlin

//주생성자 파라미터에 var 키워드를 삽입하면 곧바로 멤버변수가 된 것임
open class Person constructor(var name:String?,var age:Int){

    init {
        println("Person 클래스 생성")
    }
    open fun show(){
        println("name: $name")
    }

}