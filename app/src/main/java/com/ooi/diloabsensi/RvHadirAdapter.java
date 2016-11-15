package com.ooi.diloabsensi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RvHadirAdapter extends RecyclerView.Adapter<RvHadirAdapter.KehadiranHolder>{

    ArrayList<KehadiranSG> kehadiran;
    Context context;

    public static class KehadiranHolder extends  RecyclerView.ViewHolder{
        TextView nama,email,phone;

        KehadiranHolder(View itemview){
            super(itemview);
            nama=(TextView)itemview.findViewById(R.id.nama);
            email=(TextView)itemview.findViewById(R.id.email);
            phone=(TextView)itemview.findViewById(R.id.phone);
        }

    }


    public RvHadirAdapter(ArrayList<KehadiranSG> kehadiran){
        this.kehadiran=kehadiran;
    }

    @Override
    public int getItemCount() {
        return kehadiran.size();
    }

    @Override
    public void onBindViewHolder(KehadiranHolder holder, int position) {
        holder.nama.setText(kehadiran.get(position).getNama());
        holder.email.setText(kehadiran.get(position).getEmail());
        holder.phone.setText(kehadiran.get(position).getPhone());
    }

    @Override
    public KehadiranHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.v_item,parent,false);
        final KehadiranHolder kehadiranHolder=new KehadiranHolder(v);
        context=parent.getContext();

        return kehadiranHolder;
    }




}
