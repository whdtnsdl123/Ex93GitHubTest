package com.c282804.ex90hellokotlin

//코틀린 언어 기초법

//문법적 주요 특징
//1. 문장의 끝을 나타내는 ;를 사용하지 않음 써도 되지만 무시됨
//2. 변수를 만들때 자료형을 사용하지 않고 var 키워드 사용함 . 단 자료형은 존재함
//3. 변수의 코틀린은 함수형 언어 함수를 객체처럼 생각해서 변수에 저장하고 파라미터 넘겨주는 동의 작업이 가능함 [객체지향 언어가 아님 .]

//1)프로그램의 시작함수인 Main함수가 반드시 있어야함 .
//2)함수를 정의할때 리턴 타입위치에 'fun'키워드(function 약자 ) 사용
fun main() {
    println("Hello Kotlin")
    println(10)
    println(10.5)
    println('A')
    println(true)
    print(5 + 3)


    //4)자료형과 변수
    //4.1) 기본자료형 : Boolean, Char, Byte, Short, Int, Long, Float, Double, String, Any(Java의 Object와 비슷) [ 기본적으로 코틀린은 모든 변수가 객체임. 즉, 모두 참조변수임 ]

    //4.2) 변수선언 문법 [ var키워드 ]  ;이 없으므로 변수의 초기화가 없으면 에러임
    var a = 10
    var b = 10.5
    var c = 3.14
    var d = true
    var e = 'A'
    var f = "Hello"
    //자료형이 없는 것이 아니라 대입될때 자료형이 결정됨 .

    //변수이므로 값 변경 가능
    a = 20
    b = 20.5
    println(a)
    println(b)
    println()


    //자료형이 있으므로 다른 자료형 대입 불가
    //a 3.14//ERROR : Double=>Int
    //b=50  //ERROR : Int=>Double 자동형변환 없음

    //명시적 형변환하는방법[(Int)문법 없음 : . toXXX()로변환]
    a = 3.14.toInt()
    b = 50.toDouble()
    println(a)
    println(b)
    println()

    //자료형을 변수선언시에 명시할 수도 있음
    var a2: Int = 20
    var b2: Double = 3.14
    var c2: Boolean //자료형을 명시하려면 초기화를 안해도 됨
    println(a2)
    println(b2)
    //println(c2)초기화 없으면 에러

    //좀 특별한 정수 표현식
    var a3 = 10_000_000

    //화면 출력의 format만들기
    println("이름" + "나이")

    //println(10+"aaa") //정수형이 자동 변환 에러
    println(10.toString() + "aaa")


    //위에가 정식방법인데 좀 불편하죠..
    println("aaa" + 10)//순선적으로 문자열이 먼저 있으면 가능함
    println("" + 10 + "aaa")


    //즉, 이런 특징으로 인해 정수 숫자 2개 덧셈 식 출력
    var num = 50
    var num2 = 30
//    println( num + "+" + num2 + "=" +(num+num2)

    println(num.toString() + " + " + num2.toString() + " = " + (num + num2))
    println("" + num + "+" + num2 + "=" + (num + num2))

    //위 2가지 모두 짜증 마치 php처럼
    println(" $num + $num2 = ${num + num2}")

    //종합화면
    var name = "sam"
    var age = 20
    println("이름 : $name \n나이 :$age")
    println()

    //Any타입[타입이 없다는 표현식]
    var v: Any
    v = 10
    println(v)

    v = 10.5
    println(v)

    v = true
    println(v)

    v = "Hello"
    println(v)


    //가급적 Any사용은 자제 자료형을 특정하기 어려울때만 사용
    var n = null
    println(n)


    //자료형을 명시하면 null저장 불가
//    var n2:Int = null //ERROR
//    var s :String =null //ERROR

    //null저장도 가능하다는 명시적 표기
    var n3: Int? = null
    var s2: String? = null
    println(n3)
    println(s2)

    //상수
    var M = 10
//    M=50 //ERROR

    //상수값 지정 할 때 명시적 자료혀을 사용하면
    val K: Int
    K = 50
//    K=20//ERROR

    //5. 연산자 특이점 ////
    // 숫자타입간에는 자동형변환 됨
    println(10 + 3.14)
    // 숫자타입이 아닌 자료형과는 자동형변환 안됨 .
//    println(10+true)  //ERROR
//    println(10+'A')   //ERROR

    //새로운 연산자 is(자료형 검사 )
    var n4 = 10
    if (n4 is Int) {
        println("n4는 정수입니다")
    }

    //다른 자료형 검사 에러
//    if(n4 is String?){
//
//    }

    //의미 없어 보이지만 Any타입 일때.
    var obj: Any

    obj = 10
    if (obj is Int) println("$obj 는 Int")
    if (obj is Double) println(" $obj 는 Double")

    //자바의 instanceof 처럼

    //사용자 정의 클래스
    class Person {
        //코틀린에서는 멤버변수를 속성[Property]이라고 명명함
        //주의!! 프로퍼티는 반드시 초기화 되어 있어야함

        var name = "sam"
        var age: Int = 20
    }

    var p = Person() //new 키워드 없음
    if (p is Person) {
        println(p.name + "" + p.age)
        println("이름 : ${p.name} 나이 : ${p.age}")
    }

    obj = Person() //객체새엇ㅇ
    if (obj is Person) {

    }


    //6.제어문에서 특이한 점!!
//    var str= (10>5)? "aaa" : "bbb" //삼항연산자 없음
    //대신에 if문이 삼항 연산자 처럼
    var str = if (10 > 5) "aaa" else "bbb"
    println(str)


    str = if (10 > 5) {
        "aaa"
        println("asdfasdfa")
        "kkk"//여려줄이 있으면 마지막 값이 들어감

    } else {
        "bbb"
    }

    println(str)

    //이런 특징 때문에 if문을 코틀린에서는 제어문이 아니라 if표현식이라고 부름

    //switch 문법이 없어졌음[비슷한 녀석이 있음]
    var h: Any? = null

    var n5 = 30
    h = 50
    when (h) {
        10 -> println("aaa")
        20 -> println("bbb")
        //자료형이 다른 것도 동시 체크 가능
        "hello" -> println("ccc")
        true -> println("ddd")
        //변수명으로 값 비교 가능
        n5 -> println("eee")

        //2개 이상의 조건을 묶을 수도 있음
        40, 50 -> println("fff")

        //defalut 같은 역할 [여러줄이면]
        else -> {
            println("aldks")
            println("aaaaa")
        }
    }

    //when을 특정 수식으로 제어 가능[수식비교할때는 ()없어야함]
    h = 85
    when {
        h >= 90 && h <= 100 -> println("A학점")
        h >= 80 -> println("B학점")
        h >= 70 -> println("C학점")
        h >= 60 -> println("D학점")
        else -> println("B학점")
    }

    //when도 if문처럼 변수에 저장 가능함
    h = 20
    var result = when (h) {
        10 -> "Hello"
        20 -> "Nice"
        else -> "Bad"

    }
    println(result)

    //when에서 is 연산자도 사용가능
    when (h) {
        is Int -> println("Int 타입입니다")
        is Double -> println("Double 타입입니다")
        is Person -> println("Person 타입입니다.")
    }

    //반복문도 변화
//    for (var i=0; i<3; i++){
//    }


    //마치 foreach문과 미슷하게
    for (i in 0..5) {
        println(i)

    }
    println()


    //i는 제어변수임 for문의 지역변수 저위에잇는 a 아님
    for (a in 3..10) {
        println(a)
    }
    println()


    //마지막 숫자 전 까지 하고 싶다면
    for (i in 0 until 10) {
        println(i)

        //2씩 증가 (step)
        for (i in 0..10 step 2) {
            println(i)
        }
        println()

        //값의 감소
        for (i in 10 downTo 0) {
            println(i)
        }
        println()

        //값을 2씩 감소 (downTO +step)
        for (i in 10 downTo 0 step 2) {
            println(i)
        }
        println()


        //7.배열 Array - 생성방법이 달라짐
        var arr = arrayOf(10, 20, 30)
        println(arr[0])
        println(arr[1])
        println(arr[2])
//        println(arr[3]) //Exception발생

        //값 변경 도 특별 할 것 없음
        arr[0] = 100
        println(arr[0])

        //배열의 특별한 점 ...
        //맟치 ArrayList처럼 get(), set()메소드 보유
        println(arr.get(0))
        println(arr.get(1))
        println(arr.get(2))
        println()

        arr.set(1, 200)// 1번방에 설정
        println(arr.get(0))
        println(arr.get(1))
        println(arr.get(2))
        println()

        //배열같이
        println("배열의 길이 ${arr.size}")

        //출력 반복문
        for (n in arr) {//요소값들 반복
            println(n)
        }
        println()

        //반복문을 인덱스 값으로
        for (i in arr.indices){
            println(""+i+":"+arr[i])
        }
        println()
        //인덱스와 값을 같이 나오도록
        for ((i,v) in arr.withIndex()){
            println("[$i]:$v")
        }
        println()

        //배열값 넣을 때 자료형을 명시하지 않으면
        //자동 Any타임
        var arr2= arrayOf(10,"Hello",3.14)
        for (t in arr2){
            println(t)
        }
        println()

        //Any타입이여서 다른 자료형 대입 가능
        arr2[1]=20
        for (t in arr2){
            println(t)

        }
        println()

        //단, 배열에 타입지정도 가능함
        var arr3 = arrayOf<Int>(10,20,30)

        //타입을 지정하면 다른 자료형과 함꼐 사용불과
        //var arr4= arrayOF<Int>(10,"Hello",true)

        //명시적 배열을 만드는 다른 방법
        var arr5= intArrayOf(10,20,30)
        var arr6= doubleArrayOf(3.14,1.52)

        //Boolean부터 Double가지 xxxArrayOf() - String은 없음
        //초기값 없이 null값으로 배열만들기
        var arr7= arrayOfNulls<Any>(5)
        for(t in arr7){
            println(t)
        }
        println()

        //배열 변수를 상수로 만들기
        val arr8= arrayOf(10,20,30)
        arr8[0]= 100//값을 못바꾸는 것이아님
        //arr8= arrayOf(100,200,300) //다른 배열참조 불가

        //ArrayList만들기 [배열요소의 추가, 삭제 가능]
        val arrayList = arrayListOf(10,"Hello",true)
        for (e in arrayList){
            println(e)
        }
        println()

        //기존에 처음에 넣었던 자료형 외에는 추가 불가
        arrayList.add(100)
        arrayList.add(false)
        arrayList.add("Good")
        //arrayList.add(3.14)//ERROR

        //인덱스번호로 삭제하기
        arrayList.removeAt(0)
        for (e in arrayList)
            println(e)
    }
    println()







}







