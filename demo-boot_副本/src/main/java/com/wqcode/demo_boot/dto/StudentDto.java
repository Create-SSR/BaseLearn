package com.wqcode.demo_boot.dto;

/**
 * @Author create
 * @Date 2024/6/18 15:08
 * @description
 * @Title StudentDto
 * @Package com.wqcode.demo_boot.dto
 */
public class StudentDto {

    private long id;


    private String name;

    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
