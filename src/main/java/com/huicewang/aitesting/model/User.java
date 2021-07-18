package com.huicewang.aitesting.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private int id;
    private String username;
    private String password;
    private int age;


    public int getId() {
        return this.id = id;
    }

}
