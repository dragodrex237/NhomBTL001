package com.example.asus.giaodien;

/**
 * Created by ASUS on 04/04/2017.
 */

public class ChuyenXe {
    private String TenNhaXe;
    private String DiemDi;
    private String DiemDen;
    private String GiaTien;

    public ChuyenXe(String tenNhaXe, String diemDi, String diemDen, String giaTien) {
        TenNhaXe = tenNhaXe;
        DiemDi = diemDi;
        DiemDen = diemDen;
        GiaTien = giaTien;
    }

    public String getTenNhaXe() {
        return TenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        TenNhaXe = tenNhaXe;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public void setDiemDi(String diemDi) {
        DiemDi = diemDi;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String diemDen) {
        DiemDen = diemDen;
    }

    public String getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(String giaTien) {
        GiaTien = giaTien;
    }
}
