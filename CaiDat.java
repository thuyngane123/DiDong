package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CaiDat extends AppCompatActivity {

    LinearLayout homeBtn, menuBtn;
    LinearLayout btnDangXuat;
    LinearLayout taikhoanBtn;

    Switch switchDarkMode, switchThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);

        // Ánh xạ
        homeBtn = findViewById(R.id.homeBtn);
        menuBtn = findViewById(R.id.menuBtn);
        taikhoanBtn = findViewById(R.id.taikhoanBtn);

        btnDangXuat = findViewById(R.id.logoutBtn);


        switchDarkMode = findViewById(R.id.switchDarkMode);
        switchThongBao = findViewById(R.id.switchThongBao);

        // Home
        homeBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            CaiDat.this,
                            Home.class
                    );

            startActivity(intent);
        });

        // Menu
        menuBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            CaiDat.this,
                            MainActivity.class
                    );

            startActivity(intent);
        });
        taikhoanBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            CaiDat.this,
                            TaiKhoan.class
                    );

            startActivity(intent);

        });


        btnDangXuat.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Đăng xuất thành công",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // Dark mode
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(isChecked){
                Toast.makeText(this, "Đã bật chế độ tối", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Đã tắt chế độ tối", Toast.LENGTH_SHORT).show();
            }

        });

        // Thông báo
        switchThongBao.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(isChecked){
                Toast.makeText(this, "Đã bật thông báo", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Đã tắt thông báo", Toast.LENGTH_SHORT).show();
            }

        });

    }
}