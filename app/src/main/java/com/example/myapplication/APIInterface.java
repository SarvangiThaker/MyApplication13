package com.example.myapplication;

import com.example.myapplication.model.booknows;
import com.example.myapplication.model.model_contactus;
import com.example.myapplication.model.model_detalis;
import com.example.myapplication.model.model_listparlor;
import com.example.myapplication.model.model_login;
import com.example.myapplication.model.model_mybooking;
import com.example.myapplication.model.model_service;
import com.example.myapplication.model.model_signup;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/api/login.php")
    Call<model_login> login(@Query("phno") String phno,@Query("password") String password,
                            @Query("type") String type);
    @GET("/api/signup.php")
    Call<model_signup> signup(@Query("pname") String pname, @Query("password") String password,
                             @Query("address") String address, @Query("phno") String phno,@Query("email") String email,@Query("type") String type);
    @GET("/api/lists.php")
    Call<model_listparlor> listparlor();

    @GET("/api/list.php")
    Call<model_detalis> parlor(@Query("p_id") String p_id);

    @GET("/api/get_Service.php")
    Call<model_service> getService(@Query("p_id") String p_id);

    @GET("/api/Mybooking.php")
    Call<model_mybooking> booknow(@Query("cid") String cid);

    @GET("/api/booknow.php")
    Call<booknows> booknow1(@Query("p_id") String p_id,
                            @Query("c_id") String c_id,
                            @Query("s_id") String s_id,
                            @Query("prize") String prize,
                            @Query("time") String time);

    @GET("/api/contactus.php")
    Call<model_contactus> contactus();




}