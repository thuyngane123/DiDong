package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    LinearLayout btnDatNgay;
    LinearLayout homeBtn, menuBtn;
    LinearLayout taikhoanBtn, caidatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Ánh xạ
        btnDatNgay = findViewById(R.id.btnDatNgay);

        homeBtn = findViewById(R.id.homeBtn);

        menuBtn = findViewById(R.id.menuBtn);
        taikhoanBtn = findViewById(R.id.taikhoanBtn);
        caidatBtn= findViewById(R.id.caidatBtn);



        btnDatNgay.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Home.this,
                            MainActivity.class
                    );

            startActivity(intent);

        });


        homeBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Home.this,
                            Home.class
                    );

            startActivity(intent);

        });


        menuBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Home.this,
                            MainActivity.class
                    );

            startActivity(intent);

        });
        taikhoanBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Home.this,
                            TaiKhoan.class
                    );

            startActivity(intent);

        });
        caidatBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Home.this,
                            TaiKhoan.class
                    );

            startActivity(intent);

        });

    }
}