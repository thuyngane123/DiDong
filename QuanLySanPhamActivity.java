package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuanLySanPhamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SanPhamAdminAdapter adapter;
    ArrayList<SanPham> list;

    AppDatabase db;

    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_sanpham);

        recyclerView = findViewById(R.id.recyclerViewSanPham);
        btnThem = findViewById(R.id.btnThemSanPham);

        db = AppDatabase.getInstance(this);

        list = new ArrayList<>(
                db.sanPhamDAO().getAll()
        );

        adapter = new SanPhamAdminAdapter(
                this,
                list
        );

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(adapter);

//        btnThem.setOnClickListener(v -> {
//
//            startActivity(
//                    new Intent(
//                            QuanLySanPhamActivity.this,
//                            ThemSanPhamActivity.class
//                    )
//            );
//
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        list.clear();

        list.addAll(
                db.sanPhamDAO().getAll()
        );

        adapter.notifyDataSetChanged();
    }
}