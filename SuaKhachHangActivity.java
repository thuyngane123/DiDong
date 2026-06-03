package com.example.fastfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuaKhachHangActivity
        extends AppCompatActivity {

    EditText edtTen,
            edtEmail,
            edtSDT,
            edtMatKhau;

    Button btnSua;

    AppDatabase db;

    NguoiDung nguoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_sua_khachhang
        );

        edtTen =
                findViewById(R.id.edtTen);

        edtEmail =
                findViewById(R.id.edtEmail);

        edtSDT =
                findViewById(R.id.edtSDT);

        edtMatKhau =
                findViewById(R.id.edtMatKhau);

        btnSua =
                findViewById(R.id.btnSua);

        db = AppDatabase.getInstance(this);

        int id =
                getIntent().getIntExtra(
                        "id",
                        0
                );

        nguoiDung =
                db.nguoiDungDAO().getById(id);

        edtTen.setText(
                nguoiDung.getHoTen()
        );

        edtEmail.setText(
                nguoiDung.getEmail()
        );

        edtSDT.setText(
                nguoiDung.getSoDienThoai()
        );

        edtMatKhau.setText(
                nguoiDung.getMatKhau()
        );

        btnSua.setOnClickListener(v -> {

            nguoiDung.setHoTen(
                    edtTen.getText().toString()
            );

            nguoiDung.setEmail(
                    edtEmail.getText().toString()
            );

            nguoiDung.setSoDienThoai(
                    edtSDT.getText().toString()
            );

            nguoiDung.setMatKhau(
                    edtMatKhau.getText().toString()
            );

            db.nguoiDungDAO().update(nguoiDung);

            Toast.makeText(
                    this,
                    "Sửa thành công",
                    Toast.LENGTH_SHORT
            ).show();

            finish();

        });

    }
}