package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterAdmin extends AppCompatActivity {

    TextInputEditText edtHoTen,
            edtPhone,
            edtEmail,
            edtPassword,
            edtConfirmPassword;

    MaterialButton btnRegister;

    TextView txtDangNhap;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);

        // Ánh xạ
        edtHoTen = findViewById(R.id.edtHoTen);

        edtPhone = findViewById(R.id.edtPhone);

        edtEmail = findViewById(R.id.edtEmail);

        edtPassword = findViewById(R.id.edtPassword);

        edtConfirmPassword =
                findViewById(R.id.edtConfirmPassword);

        btnRegister =
                findViewById(R.id.btnRegister);

        txtDangNhap =
                findViewById(R.id.txtDangNhap);

        db = AppDatabase.getInstance(this);


        btnRegister.setOnClickListener(v -> {

            String hoTen =
                    edtHoTen.getText().toString().trim();

            String sdt =
                    edtPhone.getText().toString().trim();

            String email =
                    edtEmail.getText().toString().trim();

            String matKhau =
                    edtPassword.getText().toString().trim();

            String xacNhan =
                    edtConfirmPassword.getText().toString().trim();


            if (hoTen.isEmpty() ||
                    sdt.isEmpty() ||
                    email.isEmpty() ||
                    matKhau.isEmpty() ||
                    xacNhan.isEmpty()) {

                Toast.makeText(
                        this,
                        "Vui lòng nhập đầy đủ thông tin",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            if (!matKhau.equals(xacNhan)) {

                Toast.makeText(
                        this,
                        "Mật khẩu xác nhận không khớp",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            String ngayTao =
                    new SimpleDateFormat(
                            "dd/MM/yyyy HH:mm",
                            Locale.getDefault()
                    ).format(new Date());

            NguoiDung admin = new NguoiDung(
                    hoTen,
                    email,
                    sdt,
                    matKhau,
                    1,
                    ngayTao
            );

            db.nguoiDungDAO().insert(admin);

            Toast.makeText(
                    this,
                    "Đăng ký admin thành công",
                    Toast.LENGTH_SHORT
            ).show();

            startActivity(
                    new Intent(
                            RegisterAdmin.this,
                            LoginAdmin.class
                    )
            );

            finish();
        });

        txtDangNhap.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            RegisterAdmin.this,
                            LoginAdmin.class
                    )
            );

            finish();
        });
    }
}