package com.example.fastfood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblNguoiDung")
public class NguoiDung {

    @PrimaryKey(autoGenerate = true)
    private int maNguoiDung;

    private String hoTen;
    private String email;
    private String soDienThoai;
    private String matKhau;
    private int vaiTro;
    private String ngayTao;

    public NguoiDung(String hoTen,
                     String email,
                     String soDienThoai,
                     String matKhau,
                     int vaiTro,
                     String ngayTao) {

        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public String getNgayTao() {
        return ngayTao;
    }
}