package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblDanhMuc")
public class DanhMuc {

    @PrimaryKey(autoGenerate = true)
    private int maDanhMuc;

    private String tenDanhMuc;

    private String hinhAnh;

    public DanhMuc(String tenDanhMuc,
                   String hinhAnh) {

        this.tenDanhMuc = tenDanhMuc;
        this.hinhAnh = hinhAnh;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }
}