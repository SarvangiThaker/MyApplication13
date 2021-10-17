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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private APIInterface apiInterface;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        pd=new ProgressDialog(login.this);
        pd.setMessage("Please wait...!");
        final EditText edt1=(EditText)findViewById(R.id.edt1);
        final EditText edt2=(EditText)findViewById(R.id.edt2);
        final Button login=(Button)findViewById(R.id.login);
        Button singup=(Button)findViewById(R.id.singup);
        final RadioButton rdo_prl=(RadioButton)findViewById(R.id.rdo_parlour);
        RadioButton rdo_user=(RadioButton)findViewById(R.id.rdo_user);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isValid=true;
                if(edt1.getText().toString().isEmpty()){
                    isValid=false;
                    Toast.makeText(getApplicationContext(),"enter number" ,Toast.LENGTH_SHORT).show();
                }else if(edt2.getText().toString().isEmpty()){
                    isValid=false;
                    Toast.makeText(getApplicationContext(),"password invalid",Toast.LENGTH_SHORT).show();
                }else if(edt1.getText().toString().length() != 10){
                    isValid=false;
                    Toast.makeText(getApplicationContext(),"enter 10 digit numbernot valid",Toast.LENGTH_SHORT).show();

                }
                if(isValid) {
                    pd.show();
                    String type = "0";
                    if (rdo_prl.isChecked()) {
                        type = "1";
                    } else {
                        type = "2";
                    }
                    Call<model_login> call1 = apiInterface.login(edt1.getText().toString(), edt2.getText().toString(), type);
                    call1.enqueue(new Callback<model_login>() {
                        @Override
                        public void onResponse(Call<model_login> call, Response<model_login> response) {
                            if (response.body().getSucess().equals("1")) {
                                Pref.setValue(login.this,"c_id",response.body().getData().get(0).getCid());
                                Pref.setValue(login.this,"is_login",true);
                                Intent in = new Intent(login.this, ListOfParlour.class);
                                finish();
                                startActivity(in);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            }
                            pd.dismiss();
                        }

                        @Override
                        public void onFailure(Call<model_login> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Server Unavailable...!", Toast.LENGTH_SHORT).show();

                            pd.dismiss();
                        }
                    });
                }

            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(login.this,com.example.myapplication.signup.class);
                startActivity(in);
            }
        });
    }
}
