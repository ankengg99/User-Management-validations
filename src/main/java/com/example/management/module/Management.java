package com.example.management.module;
// module class for holding data of any user
public class Management {
    //attributes of user
private int id;
private String username;
private String name;
private String address;
private String no;

    public Management() {
    }

    public Management(int id, String username, String name, String address, String no) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.no = no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    @Override
    public String toString(){
        return "{"+"UserId : "+id+", \n"+
                "Name : "+name+", \n"+
                "UserName : "+username+", \n"+
                "Address : "+address+", \n"+
                "Phone no : "+no+"\n"+
                "}";

    }

}
