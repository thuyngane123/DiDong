package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.KhuyenMai;

@Dao
public interface KhuyenMaiDAO {

    @Insert
    void insert(KhuyenMai khuyenMai);

    @Query("SELECT * FROM tblKhuyenMai WHERE maCode = :code LIMIT 1")
    KhuyenMai getTheoCode(String code);
}