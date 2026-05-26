package com.example.fastfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GioHangAdapter
        extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {

    ArrayList<GioHang> list;

    public GioHangAdapter(ArrayList<GioHang> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_gio_hang,
                        parent,
                        false
                );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position
    ) {

        GioHang gioHang = list.get(position);

        holder.txtTen.setText(
                gioHang.getTenSanPham()
        );

        holder.txtGia.setText(
                gioHang.getGia() + "đ"
        );

        holder.txtSoLuong.setText(
                "Số lượng: " + gioHang.getSoLuong()
        );

        int imageRes = holder.itemView.getContext()
                .getResources()
                .getIdentifier(
                        gioHang.getHinhAnh(),
                        "drawable",
                        holder.itemView.getContext()
                                .getPackageName()
                );

        holder.imgSanPham.setImageResource(imageRes);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgSanPham;

        TextView txtTen, txtGia, txtSoLuong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSanPham =
                    itemView.findViewById(R.id.imgSanPham);

            txtTen =
                    itemView.findViewById(R.id.txtTenSanPham);

            txtGia =
                    itemView.findViewById(R.id.txtGia);

            txtSoLuong =
                    itemView.findViewById(R.id.txtSoLuong);
        }
    }
}
