package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.booknows;
import com.example.myapplication.model.model_detalis;
import com.example.myapplication.model.model_mybooking;
import com.example.myapplication.model.model_service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class parlor extends AppCompatActivity {
    private APIInterface apiInterface;
    ProgressDialog pd;
    String p_id = "";
    String s_id = "";
    String price = "";
    ArrayList<String> ar;
    List<model_service.Data> ar_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        //getSupportActionBar().hide();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        pd = new ProgressDialog(parlor.this);
        pd.setMessage("Please Wait...!");
        final TextView edt1 = (TextView) findViewById(R.id.edt1);
        final TextView edt2 = (TextView) findViewById(R.id.edt2);
        final TextView edt3 = (TextView) findViewById(R.id.edt3);
        Button booknow = (Button) findViewById(R.id.booknow);
        Button fbooknow=(Button) findViewById(R.id.final_booknow);
        TextView map=(TextView) findViewById(R.id.edt3);

        edt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+edt2.getText().toString()));
                startActivity(intent);
            }
        });

        edt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.google.com/maps"));
                startActivity(viewIntent);
            }
        });



        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.show();
                final Dialog dlg=new Dialog(parlor.this);
                dlg.setContentView(R.layout.dialog_booknow);
                Button btn = (Button) dlg.findViewById(R.id.final_booknow);
                final Spinner sp_service=(Spinner)dlg.findViewById(R.id.sp_service);
                final EditText etTime = dlg.findViewById(R.id.etTime);
                final EditText etPrice = dlg.findViewById(R.id.etPrice);
//                ArrayList<String> ar=new ArrayList<>();
//                ar.add("hair");
//                ar.add("skin");
//                ar.add("nail");-----------

                Call<model_service> call=apiInterface.getService(p_id);
                call.enqueue(new Callback<model_service>() {
                    @Override
                    public void onResponse(Call<model_service> call, final Response<model_service> response) {
                        ar=getArray(response.body().getData());
                        ar_res=response.body().getData();
                        final ArrayAdapter<String> adptr=new ArrayAdapter<>(parlor.this,android.R.layout.simple_dropdown_item_1line,ar);
                        sp_service.setAdapter(adptr);
                        sp_service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String item = parent.getItemAtPosition(position).toString();
                                //Toast.makeText(parlor.this, item, Toast.LENGTH_SHORT).show();
                                etPrice.setText("\u20B9 "+getPrice(ar_res,item));
                                s_id = getSid(ar_res,item);
                                price = getPrice(ar_res,item);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        pd.dismiss();
                    }

                    @Override
                    public void onFailure(Call<model_service> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }

                });
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Call<booknows> call = apiInterface.booknow1(p_id,Pref.getValue(parlor.this,"c_id",""),s_id,price,etTime.getText().toString().trim());
                        call.enqueue(new Callback<booknows>() {
                            @Override
                            public void onResponse(Call<booknows> call, Response<booknows> response) {

                               // adapter_my_booking adpte=new adapter_my_booking(MyList.this,response.body().getData(),R.layout.mybooking);
                               // list.setAdapter(adpte);
                                if(response.body().getSucess().equalsIgnoreCase("1"))
                                {
                                    Toast.makeText(parlor.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                    dlg.dismiss();
                                }

                                pd.dismiss();
                            }

                            @Override
                            public void onFailure(Call<booknows> call, Throwable t) {
                                pd.dismiss();

                            }
                        });
                    }
                });
                dlg.show();
            }
        });


        pd.show();
        p_id = Pref.getValue(parlor.this,"p_id","");
        Call<model_detalis> call=apiInterface.parlor(p_id);
        call.enqueue(new Callback<model_detalis>() {
            @Override
            public void onResponse(Call<model_detalis> call, Response<model_detalis> response) {

                    edt1.setText(response.body().getData().get(0).getPname());
                    edt2.setText(response.body().getData().get(0).getPhno());
                    edt3.setText(response.body().getData().get(0).getPaddress());
                    pd.dismiss();
            }

            @Override
            public void onFailure(Call<model_detalis> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });

    }

    private ArrayList<String> getArray(List<model_service.Data> data) {
        ArrayList<String> ar=new ArrayList<>();
        for(int i=0;i<data.size();i++){
            ar.add(data.get(i).getSname());
        }
        return ar;
    }
    private String getSid(List<model_service.Data> data,String item) {
        ArrayList<String> ar=new ArrayList<>();
        for(int i=0;i<data.size();i++){
            if(item.equalsIgnoreCase(data.get(i).getSname()))
                return data.get(i).getS_id();
        }
        return "";
    }
    private String getPrice(List<model_service.Data> data,String item) {
        ArrayList<String> ar=new ArrayList<>();
        for(int i=0;i<data.size();i++){
            if(item.equalsIgnoreCase(data.get(i).getSname()))
                return data.get(i).getService();
        }
        return "";
    }


}
