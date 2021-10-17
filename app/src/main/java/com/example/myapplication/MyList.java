package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.model_listparlor;
import com.example.myapplication.model.model_mybooking;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyList extends AppCompatActivity {
    private APIInterface apiInterface;
    ProgressDialog pd;
    public String cid = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        pd = new ProgressDialog(MyList.this);
        pd.setMessage("Please Wait...!");
        final TextView edt1 = (TextView) findViewById(R.id.servicetype);
        final TextView edt2 = (TextView) findViewById(R.id.booking_time);
        final ListView list=(ListView)findViewById(R.id.list1);
        cid = Pref.getValue(MyList.this,"c_id","");
        pd.show();
        Call<model_mybooking> call = apiInterface.booknow(cid);
        call.enqueue(new Callback<model_mybooking>() {
            @Override
            public void onResponse(Call<model_mybooking> call, Response<model_mybooking> response) {

                adapter_my_booking adpte=new adapter_my_booking(MyList.this,response.body().getData(),R.layout.mybooking);
                list.setAdapter(adpte);
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<model_mybooking> call, Throwable t) {
                pd.dismiss();

            }
        });


    }
}
