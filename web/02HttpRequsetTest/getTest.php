<?php


//한글꺠짐 방지
header('Conten-Type:text/html; charset=utf-8');

//php변수의 변수명은 $
//$_GET : 사용자가 GET방식으로 보내온 데이터들을 받은 배열변수


$name= $_GET[0];
$message= $_GET[1];


//받아온 데이터 확인하기 위해 출력 [연산자 ]
echo "Name : " .$name . "<br>";
echo "Message : ".$Message;



?>