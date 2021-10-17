package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model_mybooking {


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
        @SerializedName("address")
        private String address;
        @SerializedName("username")
        private String username;
        @SerializedName("cid")
        private String cid;
        @SerializedName("email")
        private String email;
        @SerializedName("phno")
        private String phno;
        @SerializedName("offDays")
        private String offDays;
        @SerializedName("bookingTime")
        private String bookingTime;
        @SerializedName("paddress")
        private String paddress;
        @SerializedName("password")
        private String password;
        @SerializedName("pname")
        private String pname;
        @SerializedName("service")
        private String service;
        @SerializedName("sname")
        private String sname;
        @SerializedName("time")
        private String time;
        @SerializedName("prize")
        private String prize;
        @SerializedName("s_id")
        private String s_id;
        @SerializedName("c_id")
        private String c_id;
        @SerializedName("p_id")
        private String p_id;
        @SerializedName("ap_id")
        private String ap_id;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhno() {
            return phno;
        }

        public void setPhno(String phno) {
            this.phno = phno;
        }

        public String getOffDays() {
            return offDays;
        }

        public void setOffDays(String offDays) {
            this.offDays = offDays;
        }

        public String getBookingTime() {
            return bookingTime;
        }

        public void setBookingTime(String bookingTime) {
            this.bookingTime = bookingTime;
        }

        public String getPaddress() {
            return paddress;
        }

        public void setPaddress(String paddress) {
            this.paddress = paddress;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPrize() {
            return prize;
        }

        public void setPrize(String prize) {
            this.prize = prize;
        }

        public String getS_id() {
            return s_id;
        }

        public void setS_id(String s_id) {
            this.s_id = s_id;
        }

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getAp_id() {
            return ap_id;
        }

        public void setAp_id(String ap_id) {
            this.ap_id = ap_id;
        }
    }
}
