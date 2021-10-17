package com.example.myapplication.model;

public class model_signup {

    @com.google.gson.annotations.SerializedName("msg")
    private String msg;
    @com.google.gson.annotations.SerializedName("sucess")
    private String sucess;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSucess() {
        return sucess;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }
}
