package com.example.fastfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThemSanPhamActivity extends AppCompatActivity {

    EditText edtTen, edtGia, edtMoTa,
            edtHinh, edtTrangThai, edtDanhMuc;

    Button btnThem;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sanpham);

        edtTen = findViewById(R.id.edtTen);
        edtGia = findViewById(R.id.edtGia);
        edtMoTa = findViewById(R.id.edtMoTa);
        edtHinh = findViewById(R.id.edtHinh);
        edtTrangThai = findViewById(R.id.edtTrangThai);
        edtDanhMuc = findViewById(R.id.edtDanhMuc);

        btnThem = findViewById(R.id.btnThemSanPham);

        db = AppDatabase.getInstance(this);

        btnThem.setOnClickListener(v -> {

            String ten = edtTen.getText().toString();

            double gia = Double.parseDouble(
                    edtGia.getText().toString()
            );

            String moTa =
                    edtMoTa.getText().toString();

            String hinh =
                    edtHinh.getText().toString();

            String trangThai =
                    edtTrangThai.getText().toString();

            int maDanhMuc = Integer.parseInt(
                    edtDanhMuc.getText().toString()
            );

            SanPham sanPham = new SanPham(
                    ten,
                    gia,
                    moTa,
                    hinh,
                    trangThai,
                    maDanhMuc
            );

            db.sanPhamDAO().insert(sanPham);

            Toast.makeText(
                    this,
                    "Thêm sản phẩm thành công",
                    Toast.LENGTH_SHORT
            ).show();

            finish();

        });

    }
}