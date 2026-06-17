package com.example.fastfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuaKhuyenMaiActivity
        extends AppCompatActivity {

    EditText edtCode,
            edtGiam,
            edtHan;

    Button btnSua;

    AppDatabase db;

    KhuyenMai km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_sua_khuyenmai
        );

        edtCode = findViewById(R.id.edtCode);

        edtGiam = findViewById(R.id.edtPhanTram);

        edtHan = findViewById(R.id.edtNgayHetHan);

        btnSua = findViewById(R.id.btnThem);

        db = AppDatabase.getInstance(this);

        String code =
                getIntent().getStringExtra(
                        "code"
                );

        km =
                db.khuyenMaiDAO()
                        .getByCode(code);

        edtCode.setText(
                km.getMaCode()
        );

        edtCode.setEnabled(false);

        edtGiam.setText(
                String.valueOf(
                        km.getPhanTramGiam()
                )
        );

        edtHan.setText(
                km.getNgayHetHan()
        );

        btnSua.setOnClickListener(v -> {

            km.setPhanTramGiam(
                    Integer.parseInt(
                            edtGiam.getText().toString()
                    )
            );

            km.setNgayHetHan(
                    edtHan.getText().toString()
            );

            db.khuyenMaiDAO().update(km);

            Toast.makeText(
                    this,
                    "Cập nhật thành công",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        });
    }
}