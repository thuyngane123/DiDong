package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuanLyKhuyenMaiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnThem;
    EditText edtCode, edtGiam, edtHan;

    AppDatabase db;
    ArrayList<KhuyenMai> list;
    KhuyenMaiAdminAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_khuyenmai);

        recyclerView = findViewById(R.id.recyclerViewKhuyenMai);

        edtCode = findViewById(R.id.edtCode);
        edtGiam = findViewById(R.id.edtGiam);
        edtHan = findViewById(R.id.edtHan);
        btnThem = findViewById(R.id.btnThemKhuyenMai);

        db = AppDatabase.getInstance(this);

        list = new ArrayList<>();

        adapter = new KhuyenMaiAdminAdapter(this, list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        loadData();

        btnThem.setOnClickListener(v -> {

            String code = edtCode.getText().toString().trim();
            String han = edtHan.getText().toString().trim();
            String giamStr = edtGiam.getText().toString().trim();

            if (code.isEmpty() || giamStr.isEmpty() || han.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                return;
            }

            int giam;
            try {
                giam = Integer.parseInt(giamStr);
            } catch (Exception e) {
                Toast.makeText(this, "Giảm giá không hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }

            db.khuyenMaiDAO().insert(new KhuyenMai(code, giam, han));

            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            loadData();

            edtCode.setText("");
            edtGiam.setText("");
            edtHan.setText("");
        });
    }

    private void loadData() {
        list.clear();
        list.addAll(db.khuyenMaiDAO().getAll());
        adapter.notifyDataSetChanged();
    }
}
