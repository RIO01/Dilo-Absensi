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
import java.util.Date;

/**
 * Created by edric on 11/12/2016.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.AcaraHolder>{

    ArrayList<BeritaClass> berita;
    Context context;

    public static class AcaraHolder extends  RecyclerView.ViewHolder{
        CardView cv;
        TextView judul,deskripsi,tanggal;
        ImageView gambar;

        AcaraHolder(View itemview){
            super(itemview);
            cv=(CardView)itemview.findViewById(R.id.cv);
            judul=(TextView)itemview.findViewById(R.id.judul);
            deskripsi=(TextView)itemview.findViewById(R.id.deskripsi);
            gambar=(ImageView) itemview.findViewById(R.id.gambar);
            tanggal=(TextView)itemview.findViewById(R.id.tanggal);
        }

    }


    public RvAdapter(ArrayList<BeritaClass> berita){
        this.berita=berita;
    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    @Override
    public void onBindViewHolder(AcaraHolder holder, int position) {
        holder.judul.setText(berita.get(position).getJudul());
        holder.tanggal.setText(berita.get(position).getTanggal());
        holder.deskripsi.setText(berita.get(position).getDeskripsi());
        Glide.with(context).load(berita.get(position).getGambar()).placeholder(R.drawable.default_thumbnail).into(holder.gambar);

    }

    @Override
    public AcaraHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.v_item,parent,false);
        AcaraHolder acaraHolder=new AcaraHolder(v);
        context=parent.getContext();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(parent.getContext(),IsiBerita.class);
                parent.getContext().startActivity(intent);
            }
        });


        return acaraHolder;
    }




}
