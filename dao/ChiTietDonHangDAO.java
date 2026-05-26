package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.ChiTietDonHang;

import java.util.List;

@Dao
public interface ChiTietDonHangDAO {

    @Insert
    void insert(ChiTietDonHang... chiTiets);

    @Query("SELECT * FROM tblChiTietDonHang WHERE MaDonHang = :maDonHang")
    List<ChiTietDonHang> getTheoDonHang(int maDonHang);
}
