package com.example.fastfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhMucAdapter
        extends RecyclerView.Adapter<DanhMucAdapter.ViewHolder> {

    ArrayList<DanhMuc> list;

    OnDanhMucClick listener;

    // Interface click
    public interface OnDanhMucClick{
        void onClick(DanhMuc danhMuc);
    }

    // Constructor mới
    public DanhMucAdapter(ArrayList<DanhMuc> list,
                          OnDanhMucClick listener) {

        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_danhmuc,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        DanhMuc dm = list.get(position);

        holder.txtTen.setText(dm.getTenDanhMuc());

        String imageName = dm.getHinhAnh();

        int resID = holder.itemView.getContext()
                .getResources()
                .getIdentifier(
                        imageName,
                        "drawable",
                        holder.itemView.getContext().getPackageName()
                );

        if (resID != 0) {

            holder.img.setImageResource(resID);

        } else {

            holder.img.setImageResource(
                    R.drawable.ic_launcher_background
            );
        }

        // Click danh mục
        holder.itemView.setOnClickListener(v -> {

            listener.onClick(dm);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtTen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgDanhMuc);
            txtTen = itemView.findViewById(R.id.txtTenDanhMuc);
        }
    }
}