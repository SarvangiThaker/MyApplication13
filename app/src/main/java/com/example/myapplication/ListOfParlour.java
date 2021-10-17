package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.model.model_listparlor;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfParlour extends AppCompatActivity {

    private APIInterface apiInterface;
    ProgressDialog pd;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll);
       // getSupportActionBar().hide();


        apiInterface = APIClient.getClient().create(APIInterface.class);
        pd=new ProgressDialog(ListOfParlour.this);
        pd.setMessage("Please wait...!");
        final ListView list=(ListView)findViewById(R.id.list);
        TextView txt_mylist=(TextView)findViewById(R.id.txt_mylist);
        TextView txt_srch=(TextView)findViewById(R.id.txt_srch);
        TextView txt_aboutus=(TextView)findViewById(R.id.txt_aboutus);
       TextView txt_contactus=(TextView)findViewById(R.id.txt_contactus);

        final TextView number=(TextView) findViewById(R.id.design_number_empty);


        txt_mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ListOfParlour.this,MyList.class);
                startActivity(in);
            }
        });
        txt_srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ListOfParlour.this,ListOfParlour.class);
                finish();
                startActivity(in);
            }
        });
        txt_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ListOfParlour.this,AboutUs.class);
                startActivity(in);
            }
        });
       txt_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ListOfParlour.this,contactus.class);
                startActivity(in);
            }
        });

//        ArrayList<container_list_parlor> obj1=new ArrayList<>();
//        container_list_parlor o=new container_list_parlor();
//        o.setName("Shilpas");
//        o.setContect("1234567890");
//        container_list_parlor o1=new container_list_parlor();
//        o1.setName("Bonanza");
//        o1.setContect("0987654321");
//        obj1.add(o);
//        obj1.add(o1);
        pd.show();
        Call<model_listparlor> call = apiInterface.listparlor();
        call.enqueue(new Callback<model_listparlor>() {
            @Override
            public void onResponse(Call<model_listparlor> call, Response<model_listparlor> response) {

                adapter_list_parlor adpte=new adapter_list_parlor(ListOfParlour.this,response.body().getData(),R.layout.design_list_parlor);
                list.setAdapter(adpte);
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<model_listparlor> call, Throwable t) {
                pd.dismiss();

            }
        });


    }
}
