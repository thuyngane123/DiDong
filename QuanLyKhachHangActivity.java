package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuanLyKhachHangActivity
        extends AppCompatActivity {

    RecyclerView recyclerView;

    KhachHangAdminAdapter adapter;

    ArrayList<NguoiDung> list;

    AppDatabase db;

    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_quanly_khachhang
        );

        recyclerView =
                findViewById(R.id.recyclerViewKhachHang);

        btnThem =
                findViewById(R.id.btnThemKhachHang);

        db = AppDatabase.getInstance(this);

        list = new ArrayList<>(
                db.nguoiDungDAO().getAll()
        );

        adapter =
                new KhachHangAdminAdapter(
                        this,
                        list
                );

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(adapter);

        // ===== THÊM =====

        btnThem.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            QuanLyKhachHangActivity.this,
                            ThemKhachHangActivity.class
                    )
            );

        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        list.clear();

        list.addAll(
                db.nguoiDungDAO().getAll()
        );

        adapter.notifyDataSetChanged();
    }
}