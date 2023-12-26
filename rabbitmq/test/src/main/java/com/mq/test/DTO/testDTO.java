package com.mq.test.DTO;

import java.io.Serializable;

public class testDTO implements Serializable {
    private int num;
    private String name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
