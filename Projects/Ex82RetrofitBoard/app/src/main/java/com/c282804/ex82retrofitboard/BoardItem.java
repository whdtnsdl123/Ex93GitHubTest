package com.c282804.ex82retrofitboard;

public class BoardItem {

    //읽어온 게시글 Market테이블의 한 record(row)의 데이터

    int no;            //번호
    String name;       //작성자이름
    String title;      //제목
    String msg;        //내용
    String flie;       //파일경로
    String price;      //가격
    int favor;     //좋아요 여부

    String date;       //작성일자


    public BoardItem(){

    }

    public BoardItem(int no, String name, String title, String msg, String flie, String price, boolean favor, String date) {
        this.no = no;
        this.name = name;
        this.title = title;
        this.msg = msg;
        this.flie = flie;
        this.price = price;
        this.favor = favor;
        this.date = date;
    }
}
