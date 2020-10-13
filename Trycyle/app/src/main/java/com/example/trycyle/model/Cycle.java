package com.example.trycyle.model;

public class Cycle {
    String name;
    String code;

    String status;  //0 mean free and 1 mean taken



    public Cycle(String name, String code,String status) {
        this.name = name;
        this.code = code;
        this.status=status;

    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public String getStatus() {
        return status;
    }

}
