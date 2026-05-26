package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText edtPhone, edtPass;
    private MaterialButton btnLogin;
    private TextView txtDangKy;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getInstance(this);

        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        txtDangKy = findViewById(R.id.txtDangKy);

        btnLogin.setOnClickListener(v -> {

            String phone = edtPhone.getText().toString().trim();
            String password = edtPass.getText().toString().trim();

            if(phone.isEmpty()){

                edtPhone.setError("Nhập số điện thoại");
                return;
            }

            if(password.isEmpty()){

                edtPass.setError("Nhập mật khẩu");
                return;
            }

            NguoiDung nguoiDung =
                    db.nguoiDungDAO()
                            .dangNhap(phone, password);

            if(nguoiDung != null){

                Toast.makeText(
                        this,
                        "Đăng nhập thành công",
                        Toast.LENGTH_SHORT
                ).show();

                startActivity(
                        new Intent(
                                Login.this,
                                MainActivity.class
                        )
                );

            }else{

                Toast.makeText(
                        this,
                        "Sai tài khoản hoặc mật khẩu",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        txtDangKy.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            Login.this,
                            Register.class
                    )
            );
        });
    }
}