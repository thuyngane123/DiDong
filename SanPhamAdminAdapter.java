package com.example.fastfood;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanPhamAdminAdapter
        extends RecyclerView.Adapter<SanPhamAdminAdapter.ViewHolder> {

    Context context;
    ArrayList<SanPham> list;

    AppDatabase db;

    public SanPhamAdminAdapter(
            Context context,
            ArrayList<SanPham> list
    ) {
        this.context = context;
        this.list = list;

        db = AppDatabase.getInstance(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_admin_sanpham,
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

        SanPham sp = list.get(position);

        holder.txtTen.setText(sp.getTenSanPham());

        holder.txtGia.setText(
                sp.getGia() + "đ"
        );

        int imageRes = context.getResources()
                .getIdentifier(
                        sp.getHinhAnh(),
                        "drawable",
                        context.getPackageName()
                );

        holder.img.setImageResource(imageRes);

        holder.btnXoa.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Xóa sản phẩm")
                    .setMessage("Bạn muốn xóa?")
                    .setPositiveButton("Xóa", (dialog, which) -> {

                        db.sanPhamDAO().delete(sp);

                        list.remove(position);

                        notifyDataSetChanged();

                    })
                    .setNegativeButton("Hủy", null)
                    .show();

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

        Button btnXoa, btnSua;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgSanPham);

            txtTen =
                    itemView.findViewById(R.id.txtTen);

            txtGia =
                    itemView.findViewById(R.id.txtGia);

            btnXoa =
                    itemView.findViewById(R.id.btnXoa);

            btnSua = itemView.findViewById(R.id.btnSua);
        }
    }
}