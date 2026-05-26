package com.example.fastfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhGiaAdapter
        extends RecyclerView.Adapter<DanhGiaAdapter.ViewHolder>{

    ArrayList<DanhGia> list;

    public DanhGiaAdapter(ArrayList<DanhGia> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(
                parent.getContext()
        ).inflate(
                R.layout.item_danhgia,
                parent,
                false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        DanhGia dg = list.get(position);

        String sao = "";

        for(int i = 0; i < dg.getSoSao(); i++){
            sao += "★";
        }

        holder.txtSoSao.setText(sao);

        holder.txtNoiDung.setText(
                dg.getNoiDung()
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder{

        TextView txtSoSao,
                txtNoiDung;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSoSao =
                    itemView.findViewById(R.id.txtSoSao);

            txtNoiDung =
                    itemView.findViewById(R.id.txtNoiDung);
        }
    }
}