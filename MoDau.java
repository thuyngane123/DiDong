package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MoDau extends AppCompatActivity {

    MaterialButton btnKhachHang, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modau);

        btnKhachHang = findViewById(R.id.btnKhachHang);

        btnAdmin = findViewById(R.id.btnAdmin);


        btnKhachHang.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MoDau.this,
                            Login.class
                    );

            startActivity(intent);

        });


        btnAdmin.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MoDau.this,
                            LoginAdmin.class
                    );

            startActivity(intent);

        });

    }
}