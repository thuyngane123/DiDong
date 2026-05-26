package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblChiTietDonHang")
public class ChiTietDonHang {

    @PrimaryKey(autoGenerate = true)
    private int maChiTiet;

    private int maDonHang;

    private int maSanPham;

    private int soLuong;

    private double gia;

    public ChiTietDonHang(int maDonHang,
                          int maSanPham,
                          int soLuong,
                          double gia) {

        this.maDonHang = maDonHang;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGia() {
        return gia;
    }
}