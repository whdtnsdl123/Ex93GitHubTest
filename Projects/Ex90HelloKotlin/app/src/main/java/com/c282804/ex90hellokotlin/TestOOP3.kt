package com.c282804.ex90hellokotlin

fun main(){
    //안드로이드에 가장 많이 사용되는
    //이너클래스 &익명클래스
    //1..이너클래스는 아웃터 객체만 생성할수있다 .

    val obj= AAA()
    val b =obj.getBBBInstance()
    b.show()

    //2. 인터페이스
//    val obj3= ClickListener() //인터페이스는 직접 객체생성불가
    //인터페이스를 사용하려면 인터페이스를 구현한 클래스를 만들어서
    //그 클래스 안에서 인터페이스의 추상메소드를 오버라이드 해야만 함
    var obj3= Clicker()
    obj3.onClick()


    //3. 익명클래스 [Java문법이 완전 다름 : object키워드 사용]
    val obj4= object : ClickListener{//()가없음 
        override fun onClick() {
            println("Anonymous class onClick!")
        }
    }

}

//인터페이스는 특별할 것이 없음
interface  ClickListener{
    //추상메소드
    fun onClick()
}

//인터페이스를 구현한 클래스
class Clicker: ClickListener{
    override fun onClick() {
        println("click!!")
        println()
    }
}
//클래스안에 클레ㅐ스 : inner class

class  AAA{
    var a:Int=0

    fun show(){
        println("AAAA의 show")
        println()
    }

    fun getBBBInstance():BBB{
        val obj=BBB()
        return obj

    }

    //이너클래스 [자바와 다르게 inner키워드 없으면 아웃터클래스의 멤버를 내 것인양 사용할 수 있음 .]
    inner class BBB{
        fun show(){
            println("아웃터 클래스의 프로퍼티 a: $a")//내것인양
            //이너 안에서 아웃터의 this 사용

        }

    }

}