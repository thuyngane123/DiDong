package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.DonHang;

import java.util.List;

@Dao
public interface DonHangDAO {

    @Insert
    long insert(DonHang donHang);

    @Query("SELECT * FROM tblDonHang")
    List<DonHang> getAll();
}