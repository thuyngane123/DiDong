package com.example.fastfood;

import android.app.AlertDialog;
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

public class KhachHangAdminAdapter
        extends RecyclerView.Adapter<KhachHangAdminAdapter.ViewHolder> {

    Context context;

    ArrayList<NguoiDung> list;

    AppDatabase db;

    public KhachHangAdminAdapter(
            Context context,
            ArrayList<NguoiDung> list
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
                        R.layout.item_admin_khachhang,
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

        NguoiDung nd = list.get(position);

        holder.txtTen.setText(
                nd.getHoTen()
        );

        holder.txtEmail.setText(
                nd.getEmail()
        );

        holder.txtSDT.setText(
                nd.getSoDienThoai()
        );



        holder.btnXoa.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Xóa khách hàng")
                    .setMessage("Bạn chắc chắn muốn xóa?")
                    .setPositiveButton("Xóa", (dialog, which) -> {

                        db.nguoiDungDAO().delete(nd);

                        list.remove(position);

                        notifyDataSetChanged();

                    })
                    .setNegativeButton("Hủy", null)
                    .show();

        });



        holder.btnSua.setOnClickListener(v -> {

            Intent intent = new Intent(
                    context,
                    SuaKhachHangActivity.class
            );

            intent.putExtra(
                    "id",
                    nd.getMaNguoiDung()
            );

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtTen, txtEmail, txtSDT;

        Button btnSua, btnXoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTen =
                    itemView.findViewById(R.id.txtTen);

            txtEmail =
                    itemView.findViewById(R.id.txtEmail);

            txtSDT =
                    itemView.findViewById(R.id.txtSDT);

            btnSua =
                    itemView.findViewById(R.id.btnSua);

            btnXoa =
                    itemView.findViewById(R.id.btnXoa);
        }
    }
}