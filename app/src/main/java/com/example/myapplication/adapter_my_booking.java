package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.model.model_listparlor;
import com.example.myapplication.model.model_mybooking;

import java.util.List;

public class adapter_my_booking extends BaseAdapter
{
    Context context;
    List<model_mybooking.Data> obj;
    int design;
    public adapter_my_booking(Context context1, List<model_mybooking.Data> obj1, int design1){
        context=context1;
        obj=obj1;
        design=design1;
    }

    @Override
    public int getCount() {
        return obj.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v=inflater.inflate(design,null);
        TextView nm=v.findViewById(R.id.servicetype);
        TextView tvPrice = v.findViewById(R.id.tvPrice);
        TextView tvAddress = v.findViewById(R.id.tvAddress);
        TextView txt_contect=v.findViewById(R.id.booking_time);
        nm.setText(obj.get(i).getPname());
        txt_contect.setText(obj.get(i).getTime());
        tvPrice.setText("\u20B9 "+obj.get(i).getPrize());
        tvAddress.setText("Address: "+obj.get(i).getAddress());
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
