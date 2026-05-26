package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.DanhGia;

import java.util.List;

@Dao
public interface DanhGiaDAO {

    @Insert
    void insert(DanhGia danhGia);

    @Query("SELECT * FROM tblDanhGia WHERE maSanPham = :maSanPham")
    List<DanhGia> getDanhGiaTheoSanPham(int maSanPham);
}
