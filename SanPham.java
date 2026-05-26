package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblSanPham")
public class SanPham {

    @PrimaryKey(autoGenerate = true)
    private int maSanPham;

    private String tenSanPham;

    private double gia;

    private String moTa;

    private String hinhAnh;

    private String trangThai;

    private int maDanhMuc;

    public SanPham(String tenSanPham,
                   double gia,
                   String moTa,
                   String hinhAnh,
                   String trangThai,
                   int maDanhMuc) {

        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.maDanhMuc = maDanhMuc;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }
}