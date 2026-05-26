package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaiKhoan extends AppCompatActivity {

    LinearLayout homeBtn, menuBtn, logoutBtn,caidatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taikhoan);

        homeBtn = findViewById(R.id.homeBtn);
        menuBtn = findViewById(R.id.menuBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        caidatBtn= findViewById(R.id.caidatBtn);

        // Home
        homeBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            TaiKhoan.this,
                            Home.class
                    );

            startActivity(intent);
        });

        // Menu
        menuBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            TaiKhoan.this,
                            MainActivity.class
                    );

            startActivity(intent);
        });
        caidatBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            TaiKhoan.this,
                            TaiKhoan.class
                    );

            startActivity(intent);

        });

        // Logout
        logoutBtn.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Đăng xuất thành công",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }
}