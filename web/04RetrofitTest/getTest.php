<?php
header('Content-Type:application/json; charset=utf-8');

$name=$_GET['name'];
$msg;=$_GET['msg'];


//연관배열 [인덱스 번호가 ]
$arr= array();
$arr['name']= $name;
$arr['msg']= $msg;

//연관배열을 Json문자열로 변환
echo json_encode($arr);




?>