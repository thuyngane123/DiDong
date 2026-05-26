package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fastfood.GioHang;

import java.util.List;

@Dao
public interface GioHangDAO {

    @Insert
    void insert(GioHang gioHang);

    @Update
    void update(GioHang gioHang);

    @Delete
    void delete(GioHang gioHang);

    @Query("SELECT * FROM GioHang")
    List<GioHang> getAll();

    @Query("DELETE FROM GioHang")
    void deleteAll();
    @Query("SELECT * FROM GioHang WHERE maSanPham = :maSP LIMIT 1")
    GioHang checkSanPham(int maSP);
}