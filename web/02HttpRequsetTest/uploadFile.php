<?php

$file =$_FILES['img'];

//받은 파일의 정보는 파일명, 확장자 ,사이즈 임시파일 저장경로 등 여러정보
//$file변수는 배열임

$FileName= $file['name']; //업로드된 파일의 원본파일명. 확장자[moana01.png]
$FileSize = $file['size']; //업로드 된 파일의 데이터 사이즈 :Byte수
$FileType = $file['type']; //업로드된 파일의 MIME타입 ("Image/png") 문자열 리턴
$tmpFileName=$file['tmp_name'];//업로드 된 파일이 임시로 저장 된 곳의 경로 및 파일명

//임시파일로 저장된 업로드 된 파일 데이터는 프로그램이 종료되면
//소멸되므로 서버에 영구적으로 저장하기 위해 원하는 HDD위치로 이동

// 이동시킬 목적지 경로
// 같은 이름이 있으면 덮어쓰면 됨 
// 그래서 보통 업로드 된 날짜를 파일명에 사용함
$FileName= date('Ymdhis'). $srcFileName; //"2020061633125"
$dstName='./uploads/' . $FileName;

$result= move_uploaded_file($tmpFileName, $dstName);
if($result){
    echo "uploaded success";
}else{
    echo "uploaded fail";
}

echo "<br>";
echo "$srcFileName<br>";
echo "$srcFileSize<br>";
echo "$srcFileType<br>";
echo "$srcFileFileName<br>";
echo "$desName<br>";




?>