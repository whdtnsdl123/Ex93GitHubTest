package com.c282804.ex79retrofittest;

public class BoardItem {
    //변환할 json 키 값들과 같은 이름의 멤버변수

    String name;
    String msg;

    public BoardItem() {
    }

    public BoardItem(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }
}
