package com.example.fastfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KhuyenMaiAdminAdapter
        extends RecyclerView.Adapter<KhuyenMaiAdminAdapter.ViewHolder> {

    Context context;

    ArrayList<KhuyenMai> list;

    AppDatabase db;

    public KhuyenMaiAdminAdapter(
            Context context,
            ArrayList<KhuyenMai> list
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
                        R.layout.item_admin_khuyenmai,
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

        KhuyenMai km = list.get(position);

        holder.txtCode.setText(
                km.getMaCode()
        );

        holder.txtGiam.setText(
                "Giảm " +
                        km.getPhanTramGiam() +
                        "%"
        );

        holder.txtHan.setText(
                "Hết hạn: " +
                        km.getNgayHetHan()
        );

        // Sửa
        holder.btnSua.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            context,
                            SuaKhuyenMaiActivity.class
                    );

            intent.putExtra(
                    "code",
                    km.getMaCode()
            );

            context.startActivity(intent);

        });

        // Xóa
        holder.btnXoa.setOnClickListener(v -> {

            db.khuyenMaiDAO().delete(km);

            list.remove(position);

            notifyDataSetChanged();

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtCode,
                txtGiam,
                txtHan;

        Button btnSua,
                btnXoa;

        public ViewHolder(
                @NonNull View itemView
        ) {
            super(itemView);

            txtCode =
                    itemView.findViewById(R.id.txtCode);

            txtGiam =
                    itemView.findViewById(R.id.txtGiam);

            txtHan =
                    itemView.findViewById(R.id.txtHan);

            btnSua =
                    itemView.findViewById(R.id.btnSua);

            btnXoa =
                    itemView.findViewById(R.id.btnXoa);
        }
    }
}