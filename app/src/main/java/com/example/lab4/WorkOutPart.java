package com.example.lab4;

import java.io.Serializable;

public class WorkOutPart implements Serializable {
    private int seconds;
    private String name;

    public WorkOutPart(int seconds, String name) {
        this.seconds = seconds;
        this.name = name;

    }
    public int getSeconds(){return seconds;}

    public String getName() {
        return name;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    public void setName(String name){
        this.name=name;
    }
}

