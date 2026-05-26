package com.example.fastfood;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.fastfood.dao.ChiTietDonHangDAO;
import com.example.fastfood.dao.DanhGiaDAO;
import com.example.fastfood.dao.DanhMucDAO;
import com.example.fastfood.dao.DonHangDAO;
import com.example.fastfood.dao.KhuyenMaiDAO;
import com.example.fastfood.dao.NguoiDungDAO;
import com.example.fastfood.dao.SanPhamDAO;
import com.example.fastfood.dao.GioHangDAO;


@Database(
        entities = {
                NguoiDung.class,
                DanhMuc.class,
                SanPham.class,
                DanhGia.class,
                DonHang.class,
                ChiTietDonHang.class,
                KhuyenMai.class,
                GioHang.class
        },
        version = 5
)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "FastFoodDB"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract NguoiDungDAO nguoiDungDAO();

    public abstract DanhMucDAO danhMucDAO();

    public abstract SanPhamDAO sanPhamDAO();

    public abstract DanhGiaDAO danhGiaDAO();

    public abstract DonHangDAO donHangDAO();

    public abstract ChiTietDonHangDAO chiTietDonHangDAO();

    public abstract KhuyenMaiDAO khuyenMaiDAO();
    public abstract GioHangDAO gioHangDAO();

}
