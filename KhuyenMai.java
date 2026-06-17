package com.example.fastfood;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblKhuyenMai")
public class KhuyenMai {

    @PrimaryKey
    @NonNull
    private String maCode;

    private int phanTramGiam;

    private String ngayHetHan;

    public KhuyenMai(@NonNull String maCode,
                     int phanTramGiam,
                     String ngayHetHan) {

        this.maCode = maCode;
        this.phanTramGiam = phanTramGiam;
        this.ngayHetHan = ngayHetHan;
    }

    @NonNull
    public String getMaCode() {
        return maCode;
    }

    public void setMaCode(@NonNull String maCode) {
        this.maCode = maCode;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }
}
