package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewDanhMuc;
    RecyclerView recyclerViewSanPham;

    DanhMucAdapter danhMucAdapter;
    SanPhamAdapter sanPhamAdapter;

    ArrayList<DanhMuc> listDanhMuc;
    ArrayList<SanPham> listSanPham;

    AppDatabase db;
    FloatingActionButton cartBtn;

    LinearLayout homeBtn, menuBtn, caidatBtn, taikhoanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView
        recyclerViewDanhMuc =
                findViewById(R.id.recyclerViewDanhMuc);

        recyclerViewSanPham =
                findViewById(R.id.recyclerViewSanPham);


        homeBtn = findViewById(R.id.homeBtn);

        menuBtn = findViewById(R.id.menuBtn);



        caidatBtn = findViewById(R.id.caidatBtn);

        taikhoanBtn = findViewById(R.id.taikhoanBtn);
        cartBtn = findViewById(R.id.cartBtn);


        db = AppDatabase.getInstance(this);


        if(db.danhMucDAO().getAll().size() == 0){

            db.danhMucDAO().insert(
                    new DanhMuc("Pizza","cat_1")
            );

            db.danhMucDAO().insert(
                    new DanhMuc("Burger","cat_2")
            );

            db.danhMucDAO().insert(
                    new DanhMuc("HotDog","cat_3")
            );

            db.danhMucDAO().insert(
                    new DanhMuc("Drink","cat_4")
            );

            db.danhMucDAO().insert(
                    new DanhMuc("Donut","cat_5")
            );
        }

        if(db.sanPhamDAO().getAll().size() == 0){

            db.sanPhamDAO().insert(

                    new SanPham(
                            "Pizza Hải Sản",
                            120000,
                            "Pizza ngon",
                            "p1",
                            "Còn hàng",
                            1
                    ),

                    new SanPham(
                            "Burger Bò",
                            90000,
                            "Burger bò ngon",
                            "b12",
                            "Còn hàng",
                            2
                    )
            );
        }

        listSanPham = new ArrayList<>(
                db.sanPhamDAO().getAll()
        );



        listDanhMuc = new ArrayList<>(
                db.danhMucDAO().getAll()
        );

        listSanPham = new ArrayList<>(
                db.sanPhamDAO().getAll()
        );

        danhMucAdapter =
                new DanhMucAdapter(
                        listDanhMuc,
                        danhMuc -> {

                            listSanPham.clear();

                            listSanPham.addAll(
                                    db.sanPhamDAO()
                                            .getTheoDanhMuc(
                                                    danhMuc.getMaDanhMuc()
                                            )
                            );

                            sanPhamAdapter.notifyDataSetChanged();
                        }
                );


        sanPhamAdapter =
                new SanPhamAdapter(listSanPham);

        recyclerViewDanhMuc.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );

        recyclerViewDanhMuc.setAdapter(danhMucAdapter);


        recyclerViewSanPham.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerViewSanPham.setAdapter(sanPhamAdapter);


        homeBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            MainActivity.class
                    );

            startActivity(intent);
        });


        menuBtn.setOnClickListener(v -> {

            recyclerViewSanPham.smoothScrollToPosition(0);

        });

        taikhoanBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            TaiKhoan.class
                    );

            startActivity(intent);

        });

        caidatBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            CaiDat.class
                    );

            startActivity(intent);

        });
        cartBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            GioHangActivity.class
                    );

            startActivity(intent);

        });



    }
}