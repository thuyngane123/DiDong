package com.example.fastfood;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ChiTietSanPham extends AppCompatActivity {

    ImageView imgChiTiet;

    TextView txtTen, txtGia, txtTrangThai, txtMoTa, txtSoLuong;

    ImageButton btnTang, btnGiam;

    MaterialButton btnThemGio;


    AppDatabase db;

    int soLuong = 1;


    RecyclerView recyclerViewDanhGia;

    DanhGiaAdapter danhGiaAdapter;

    ArrayList<DanhGia> listDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chitiet_sanpham);

        imgChiTiet = findViewById(R.id.imgChiTiet);

        txtTen = findViewById(R.id.txtTenChiTiet);

        txtGia = findViewById(R.id.txtGiaChiTiet);

        txtTrangThai =
                findViewById(R.id.txtTrangThaiChiTiet);

        txtMoTa = findViewById(R.id.txtMoTa);

        txtSoLuong =
                findViewById(R.id.txtSoLuong);

        btnTang = findViewById(R.id.btnTang);

        btnGiam = findViewById(R.id.btnGiam);

        btnThemGio =
                findViewById(R.id.btnThemGio);


        String ten =
                getIntent().getStringExtra("ten");

        double gia =
                getIntent().getDoubleExtra("gia",0);

        String mota =
                getIntent().getStringExtra("mota");

        String hinh =
                getIntent().getStringExtra("hinh");

        String trangThai =
                getIntent().getStringExtra("trangthai");


        txtTen.setText(ten);

        txtGia.setText(gia + "đ");

        txtMoTa.setText(mota);

        txtTrangThai.setText(trangThai);

        int imageRes = getResources()
                .getIdentifier(
                        hinh,
                        "drawable",
                        getPackageName()
                );

        imgChiTiet.setImageResource(imageRes);


        btnTang.setOnClickListener(v -> {

            soLuong++;

            txtSoLuong.setText(
                    String.valueOf(soLuong)
            );

        });


        btnGiam.setOnClickListener(v -> {

            if(soLuong > 1){

                soLuong--;

                txtSoLuong.setText(
                        String.valueOf(soLuong)
                );
            }

        });
        recyclerViewDanhGia =
                findViewById(R.id.recyclerViewDanhGia);

        db = AppDatabase.getInstance(this);

        int maSP =
                getIntent().getIntExtra("masp",0);

        if(db.danhGiaDAO()
                .getDanhGiaTheoSanPham(maSP)
                .size() == 0){

            db.danhGiaDAO().insert(
                    new DanhGia(
                            1,
                            1,
                            5,
                            "Đồ ăn raats ngon"
                    )
            );
        }

        listDanhGia = new ArrayList<>(
                db.danhGiaDAO()
                        .getDanhGiaTheoSanPham(maSP)
        );

        danhGiaAdapter =
                new DanhGiaAdapter(listDanhGia);

        recyclerViewDanhGia.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerViewDanhGia.setAdapter(
                danhGiaAdapter
        );
        btnThemGio = findViewById(R.id.btnThemGio);

        btnThemGio.setOnClickListener(v -> {

            GioHang gioHangCu =
                    db.gioHangDAO().checkSanPham(maSP);

            if(gioHangCu != null){

                int soLuongMoi =
                        gioHangCu.getSoLuong() + soLuong;

                gioHangCu.setSoLuong(soLuongMoi);

                db.gioHangDAO().update(gioHangCu);

            }else{

                GioHang gioHang = new GioHang(
                        maSP,
                        ten,
                        gia,
                        hinh,
                        soLuong
                );

                db.gioHangDAO().insert(gioHang);
            }

            Toast.makeText(
                    this,
                    "Đã thêm vào giỏ hàng",
                    Toast.LENGTH_SHORT
            ).show();

        });



    }
}