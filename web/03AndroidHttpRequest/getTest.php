<?php


header('Conten-Type:text/plain; charset=utf-8');

//Andoid로부터 보내온 데이터 받기 
$name=$_GET['name'];
$message=$_GET['msg'];

//잘받았는지 Android로 다시 echo해주기
echo "이름 : $name \n";
echo "메세지 : $message";
?>