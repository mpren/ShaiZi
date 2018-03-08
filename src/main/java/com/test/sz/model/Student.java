package com.test.sz.model;

import org.springframework.data.annotation.Id;

public class Student {
    @Id
    private Integer id;

    private String userName;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}