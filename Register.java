package com.example.fastfood;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    private TextInputEditText edtName, edtEmail,
            edtPhone, edtPassword, edtConfirmPassword;

    private MaterialButton btnRegister;
    private TextView txtDangNhap;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = AppDatabase.getInstance(this);

        edtName = findViewById(R.id.edtHoTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        txtDangNhap = findViewById(R.id.txtDangNhap);

        btnRegister.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirmPassword = edtConfirmPassword.getText().toString().trim();

            if(name.isEmpty()){
                edtName.setError("Nhập họ tên");
                return;
            }

            if(email.isEmpty()){
                edtEmail.setError("Nhập email");
                return;
            }

            if(phone.isEmpty()){
                edtPhone.setError("Nhập số điện thoại");
                return;
            }

            if(password.isEmpty()){
                edtPassword.setError("Nhập mật khẩu");
                return;
            }

            if(!password.equals(confirmPassword)){
                edtConfirmPassword.setError("Mật khẩu không khớp");
                return;
            }

            if(db.nguoiDungDAO().checkEmail(email) != null){

                Toast.makeText(
                        this,
                        "Email đã tồn tại",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            if(db.nguoiDungDAO().checkPhone(phone) != null){

                Toast.makeText(
                        this,
                        "Số điện thoại đã tồn tại",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            String ngayTao =
                    java.text.DateFormat.getDateTimeInstance()
                            .format(new java.util.Date());

            NguoiDung nguoiDung = new NguoiDung(
                    name,
                    email,
                    phone,
                    password,
                    0,
                    ngayTao
            );

            db.nguoiDungDAO().insert(nguoiDung);

            Toast.makeText(
                    this,
                    "Đăng ký thành công",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        });

        txtDangNhap.setOnClickListener(v -> finish());
    }
}