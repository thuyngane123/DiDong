package com.example.fastfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThemKhachHangActivity
        extends AppCompatActivity {

    EditText edtTen,
            edtEmail,
            edtSDT,
            edtMatKhau;

    Button btnThem;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_them_khachhang
        );

        edtTen =
                findViewById(R.id.edtTen);

        edtEmail =
                findViewById(R.id.edtEmail);

        edtSDT =
                findViewById(R.id.edtSDT);

        edtMatKhau =
                findViewById(R.id.edtMatKhau);

        btnThem =
                findViewById(R.id.btnThem);

        db = AppDatabase.getInstance(this);

        btnThem.setOnClickListener(v -> {

            String ten =
                    edtTen.getText().toString();

            String email =
                    edtEmail.getText().toString();

            String sdt =
                    edtSDT.getText().toString();

            String mk =
                    edtMatKhau.getText().toString();

            NguoiDung nd =
                    new NguoiDung(
                            ten,
                            email,
                            sdt,
                            mk,
                            0,
                            "2026"
                    );

            db.nguoiDungDAO().insert(nd);

            Toast.makeText(
                    this,
                    "Thêm thành công",
                    Toast.LENGTH_SHORT
            ).show();

            finish();

        });

    }
}