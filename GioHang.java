package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GioHang")
public class GioHang {

    @PrimaryKey(autoGenerate = true)
    private int maGioHang;

    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private String hinhAnh;
    private int soLuong;

    public GioHang(int maSanPham,
                   String tenSanPham,
                   double gia,
                   String hinhAnh,
                   int soLuong) {

        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}