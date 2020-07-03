package com.c282804.ex90hellokotlin

import android.app.Person

fun main(){
    //코틀린 상속
    var obj=Second()
    obj.show()

    //상속의 최종연습

}


//상속해줄 부모 클래스는 반드시 open이라는 키워드가 추가되어야함 즉 open이 없으면 자바의 final class와 같은 것임
open class First{
    var a:Int=10

    open fun show(){
        println("a : $a" )

    }

}

//상속의 문법[클래스명 뒤에 : 후 부모클래스 명()작성<- 부모클래스명 뒤에]
class Second : First(){
    var b:Int=20

    //상속받은 메소드의 기능을 변경 :override
    //기존 메소드와 같은 이름고 파라미터로 만든 메소드.
    //오버라이드를 하려면 반드시 override 키워드가 추가 되어야 함 .
    override fun show(){

        //println("a : $a")
        //부모출력은 부모가 알아서..
        super.show()//부모출력은 부모가 알아서
        println("b: $b")
    }

}