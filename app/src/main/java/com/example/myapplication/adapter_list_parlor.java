package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.model.model_listparlor;

public class adapter_list_parlor extends BaseAdapter {
    Context context;
     List<model_listparlor.Data> obj;
    int design;
    public adapter_list_parlor(Context context1, List<model_listparlor.Data> obj1, int design1){
        context=context1;
        obj=obj1;
        design=design1;
    }

    @Override
    public int getCount() {
        return obj.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v=inflater.inflate(design,null);
        TextView nm=v.findViewById(R.id.text_name);
        final TextView txt_contect=v.findViewById(R.id.design_number_empty);
        final Button CallNow=v.findViewById(R.id.callnow);
        final Button msgNow=v.findViewById(R.id.btm_msg);
        final TextView design_address=(TextView)v.findViewById(R.id.design_address);
        model_listparlor.Data cls;
        cls = obj.get(i);
        nm.setText(cls.getPname());

        txt_contect.setText(cls.getPhno());
        design_address.setText(cls.getPaddress());

        CallNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+txt_contect.getText().toString()));
                context.startActivity(intent);
            }
        });
        msgNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:"+txt_contect.getText().toString()));
                context.startActivity(intent);
            }
        });
        v.setTag(i);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref.setValue(context,"p_id",obj.get((Integer) v.getTag()).getP_id());
                Intent in=new Intent(context,parlor.class);
                context.startActivity(in);
            }
        });

        return v;
    }
}
