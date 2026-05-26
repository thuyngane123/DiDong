package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblDonHang")
public class DonHang {

    @PrimaryKey(autoGenerate = true)
    private int maDonHang;

    private int maNguoiDung;

    private String ngayDat;

    private double tongTien;

    private String diaChi;

    private String trangThai;

    public DonHang(int maNguoiDung,
                   String ngayDat,
                   double tongTien,
                   String diaChi,
                   String trangThai) {

        this.maNguoiDung = maNguoiDung;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }
}