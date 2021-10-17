package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.model.model_login;
import com.example.myapplication.model.model_signup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup extends AppCompatActivity {

    private APIInterface apiInterface;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Button singup=(Button)findViewById(R.id.singup);
        pd=new ProgressDialog(signup.this);
        pd.setMessage("Please wait...!");
        final EditText edt1=(EditText)findViewById(R.id.edt1);
        final EditText edt2=(EditText)findViewById(R.id.edt2);
        final EditText edt3=(EditText)findViewById(R.id.edt3);
        final EditText edt4=(EditText)findViewById(R.id.edt4);
        final EditText edt5=(EditText)findViewById(R.id.edt5);
        final RadioButton rdo_prl=(RadioButton)findViewById(R.id.rdo_parlour);
        RadioButton rdo_user=(RadioButton)findViewById(R.id.rdo_user);
        
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid=true;
                if(edt1.getText().toString().isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(),"enter username" ,Toast.LENGTH_SHORT).show();
                }
                else if(edt2.getText().toString().isEmpty()){
                    isValid=false;
                    Toast.makeText(getApplicationContext(),"enter email",Toast.LENGTH_SHORT).show();
                    }
                else if(edt2.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"))
                {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }

                else if(edt3.getText().toString().isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "password invalid", Toast.LENGTH_SHORT).show();
                }
                else if(edt4.getText().toString().isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "password invalid", Toast.LENGTH_SHORT).show();
                }
                else if(edt5.getText().toString().isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "invalid ph-no", Toast.LENGTH_SHORT).show();
                }
                else if(edt5.getText().toString().length() != 10){
                    isValid=false;
                    Toast.makeText(getApplicationContext(),"enter 10 digit number",Toast.LENGTH_SHORT).show();

                }
                if(isValid) {
                    pd.show();
                    String type = "0";
                    if (rdo_prl.isChecked()) {
                        type = "1";
                    } else {
                        type = "2";
                    }
                    Call<model_signup> call = apiInterface.signup(edt1.getText().toString(), edt2.getText().toString(), edt3.getText().toString(), edt4.getText().toString(), edt5.getText().toString(), "");
                    call.enqueue(new Callback<model_signup>() {
                        @Override
                        public void onResponse(Call<model_signup> call, Response<model_signup> response) {
                            pd.dismiss();
                            if (response.body().getSucess().equals("1")) {
                                finish();
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(signup.this, ListOfParlour.class);
                                finish();
                                startActivity(in);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<model_signup> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Server Unavailable...!", Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                        }
                    });
                }
            }
        });

    }
}
