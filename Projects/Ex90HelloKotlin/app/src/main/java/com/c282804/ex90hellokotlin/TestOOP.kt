package com.c282804.ex90hellokotlin

fun main(){
    //1.클래스 선언 및 객체 생성: new 키워드 없음
    var obj= Myclass()
    obj.show()




    //1.1 다른 .kt파일에 class만들기 [당연히 확장자 .kt]
    var obj2=myKtClass()
    obj2.show()

    //코틀린에서는 주생성자 보조생성자 가 존재함
    //2.1 주 생성자 [Priamry Constructor]
    var s= Simple() //생성자 호출
    //2.2 주생성자 호출ㅇ ㅔ

    var s2= Simple2(10,20)
    s2.show()

    //2.3만약 생성자 오버로딩을 구현하고 싶다면
    //보조 생성자 활용(c,java와 흡사한 방식)
    var s3= Simple3(10)
    var s4= Simple3(100)// 오버로딩 생성자 호출

    //2.4 주생성자와 보조생성자 동시사용[주 생성자를 만들어 놓고 나중에 오버로딩할때 ]
    var s5= Simple4() //주생성자 호출
    var s6= Simple4(200) //오버로딩한 보조생성자 호출

    //참고
    var s7=Simple5()

}

//2.4 주생성자 + 보조 생성자
class  Simple4 constructor(){
    init {
        println("simple4 init")
        println()
    }
    //보조 생성자 추가하고 싶다면 명시적으로 주생성자를 호출하는 코드가
    //옆에 있으면 됨
    constructor(num: Int):this(){
        println("simple4 Secondary constructor")
        println()
    }
}

//2.3 보조생성자 [클래스안에 construct()블럭 구현 ]
//보조생성자만 구현해도 주 생성자는 원래부터 존재하고 있는 것
class Simple3{
    //init
    init {
        println("여기는 객체 처음 만들때 무조건 실행")
    }

    //보조생성자
    constructor(num: Int){
        println("Simple3dml Secondary 생성자")
        println()

        //보조생성자는 Overloading이 가능함[보조생성자 var키워드로 한번에 멤버변수 만들기 불가 ]


    }
}

//2.2 주생성자 파라미터 받기[주생성자는 오버로딩 불가]
class  Simple2 constructor(var num:Int,num2: Int) {//var키워드를 사용하면 그 멤버변수임, num2는 var이 없으므로 매개변수(지역변수)



    init {
        println("Simple2 생성")
        println("num: $num") //멤버변수
        println("num2 : $num2") //매게변수
    }
    fun show(){
        println("show method num : $num")//num은 멤버변수
//        println("show method num : $num2")//num2는 주 생성자의 지역변수임
    }

    //멤버변수 에 ㅂ매개변수값 대입을 생성자 블럭에 안해도 됌
    var n:Int=num2 //변수 대입하듯이 주생성자의 매개변수 대입가능

}
//2.1 주생성자 : 클래스명 옆에 constructor()라고 명시
class Simple constructor(){
    //주생성자는 {}가 없기에 코드 작성할 곳이 없음
    //주생성자를 위한 별도의 초기화 블럭이 존재함
    init {
        println("Simple 주생성자 실행!!!")
        println()
    }


}

//1. 클래스 선언[멤버변수를 Property[프로퍼티 : 속성] 라고
class Myclass{
    //멤버변수 [Property]- 반드시 초기화 해야함

    var a:Int=10
    //메소드 : Method
    fun show(){
        println("show : ${a}")
        println()
    }
}
//참고로  constructor 키워드 접근제한자나 어노테이션이 없다면 생략 가능
class Simple5 constructor(){
    init {
        println("Simple5 주 생성자")
    }
}