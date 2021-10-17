package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model_service {

    @SerializedName("data")
    private List<Data> data;
    @SerializedName("msg")
    private String msg;
    @SerializedName("sucess")
    private String sucess;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

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

    public static class Data {
        @SerializedName("service")
        private String service;
        @SerializedName("p_id")
        private String p_id;
        @SerializedName("sname")
        private String sname;
        @SerializedName("s_id")
        private String s_id;

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getS_id() {
            return s_id;
        }

        public void setS_id(String s_id) {
            this.s_id = s_id;
        }
    }
}
