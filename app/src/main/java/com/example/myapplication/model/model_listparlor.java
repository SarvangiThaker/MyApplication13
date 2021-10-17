package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model_listparlor {

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
        @SerializedName("p_id")
        private String p_id;

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

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }
    }
}
