package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblDanhGia")
public class DanhGia {

    @PrimaryKey(autoGenerate = true)
    private int maDanhGia;

    private int maNguoiDung;

    private int maSanPham;

    private int soSao;

    private String noiDung;

    public DanhGia(int maNguoiDung,
                   int maSanPham,
                   int soSao,
                   String noiDung) {

        this.maNguoiDung = maNguoiDung;
        this.maSanPham = maSanPham;
        this.soSao = soSao;
        this.noiDung = noiDung;
    }

    public int getMaDanhGia() {
        return maDanhGia;
    }

    public void setMaDanhGia(int maDanhGia) {
        this.maDanhGia = maDanhGia;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public int getSoSao() {
        return soSao;
    }

    public String getNoiDung() {
        return noiDung;
    }
}