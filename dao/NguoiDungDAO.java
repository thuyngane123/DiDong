package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.NguoiDung;

@Dao
public interface NguoiDungDAO {

    @Insert
    void insert(NguoiDung nguoiDung);

    @Query("SELECT * FROM tblNguoiDung WHERE SoDienThoai = :phone AND MatKhau = :password LIMIT 1")
    NguoiDung dangNhap(String phone, String password);

    @Query("SELECT * FROM tblNguoiDung WHERE Email = :email LIMIT 1")
    NguoiDung checkEmail(String email);

    @Query("SELECT * FROM tblNguoiDung WHERE SoDienThoai = :phone LIMIT 1")
    NguoiDung checkPhone(String phone);

    @Query("SELECT * FROM tblNguoiDung WHERE soDienThoai = :sdt AND matKhau = :mk LIMIT 1")
    NguoiDung login(String sdt, String mk);
}