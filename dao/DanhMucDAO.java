package com.example.fastfood.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastfood.DanhMuc;

import java.util.List;

@Dao
public interface DanhMucDAO {

    @Insert
    void insert(DanhMuc... danhMucs);

    @Query("SELECT * FROM tblDanhMuc")
    List<DanhMuc> getAll();
}