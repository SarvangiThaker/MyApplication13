package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    public boolean isLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intenr => login
                isLogin = Pref.getValue(MainActivity.this,"is_login",false);
                if(isLogin){
                    Intent in = new Intent(MainActivity.this, ListOfParlour.class);
                    finish();
                    startActivity(in);
                }
                else {
                    Intent in = new Intent(MainActivity.this, login.class);
                    finish();
                    startActivity(in);
                }
            }
        },2000);
    }
}
