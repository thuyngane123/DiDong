package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginAdmin extends AppCompatActivity {

    TextInputEditText edtPhone, edtPass;

    MaterialButton btnLogin;

    TextView txtDangKy;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        edtPhone = findViewById(R.id.edtPhone);

        edtPass = findViewById(R.id.edtPass);

        btnLogin = findViewById(R.id.btnLogin);

        txtDangKy = findViewById(R.id.txtDangKy);

        db = AppDatabase.getInstance(this);


        btnLogin.setOnClickListener(v -> {

            String sdt =
                    edtPhone.getText().toString().trim();

            String mk =
                    edtPass.getText().toString().trim();

            if(sdt.isEmpty() || mk.isEmpty()){

                Toast.makeText(
                        this,
                        "Vui lòng nhập đầy đủ",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            NguoiDung nguoiDung =
                    db.nguoiDungDAO().login(sdt,mk);

            if(nguoiDung == null){

                Toast.makeText(
                        this,
                        "Sai tài khoản hoặc mật khẩu",
                        Toast.LENGTH_SHORT
                ).show();

            }else{

                if(nguoiDung.getVaiTro() == 1){

                    Toast.makeText(
                            this,
                            "Đăng nhập Admin thành công",
                            Toast.LENGTH_SHORT
                    ).show();

                    startActivity(
                            new Intent(
                                    LoginAdmin.this,
                                    AdminActivity.class
                            )
                    );

                    finish();

                }else{

                    Toast.makeText(
                            this,
                            "Bạn không phải Admin",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });


        txtDangKy.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            LoginAdmin.this,
                            RegisterAdmin.class
                    );

            startActivity(intent);

        });

    }
}