package com.example.fastfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {

    RecyclerView recyclerViewGioHang;

    GioHangAdapter gioHangAdapter;

    ArrayList<GioHang> listGioHang;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        recyclerViewGioHang =
                findViewById(R.id.recyclerViewGioHang);

        db = AppDatabase.getInstance(this);

        listGioHang = new ArrayList<>(
                db.gioHangDAO().getAll()
        );

        gioHangAdapter =
                new GioHangAdapter(listGioHang);

        recyclerViewGioHang.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerViewGioHang.setAdapter(
                gioHangAdapter
        );
    }
}