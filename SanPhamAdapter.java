package com.example.fastfood;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanPhamAdapter
        extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {

    ArrayList<SanPham> list;

    public SanPhamAdapter(ArrayList<SanPham> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sanpham,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        SanPham sp = list.get(position);

        holder.txtTen.setText(
                sp.getTenSanPham()
        );

        holder.txtGia.setText(
                sp.getGia() + "đ"
        );


        int imageRes = holder.itemView
                .getContext()
                .getResources()
                .getIdentifier(
                        sp.getHinhAnh(),
                        "drawable",
                        holder.itemView
                                .getContext()
                                .getPackageName()
                );

        holder.img.setImageResource(imageRes);
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(
                    holder.itemView.getContext(),
                    ChiTietSanPham.class
            );

            intent.putExtra(
                    "ten",
                    sp.getTenSanPham()
            );

            intent.putExtra(
                    "gia",
                    sp.getGia()
            );

            intent.putExtra(
                    "mota",
                    sp.getMoTa()
            );

            intent.putExtra(
                    "hinh",
                    sp.getHinhAnh()
            );

            intent.putExtra(
                    "trangthai",
                    sp.getTrangThai()
            );
            intent.putExtra(
                    "masp",
                    sp.getMaSanPham()
            );

            holder.itemView.getContext()
                    .startActivity(intent);

        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtTen, txtGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgSanPham);

            txtTen = itemView.findViewById(R.id.txtTenSanPham);

            txtGia = itemView.findViewById(R.id.txtGia);
        }
    }
}