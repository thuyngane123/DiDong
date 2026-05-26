package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.SanPham;

import java.util.List;

@Dao
public interface SanPhamDAO {

    @Insert
    void insert(SanPham... sanPhams);

    @Query("SELECT * FROM tblSanPham")
    List<SanPham> getAll();

    @Query("SELECT * FROM tblSanPham WHERE MaDanhMuc = :maDanhMuc")
    List<SanPham> getTheoDanhMuc(int maDanhMuc);

    @Query("SELECT * FROM tblSanPham WHERE MaSanPham = :id")
    SanPham getTheoId(int id);

}