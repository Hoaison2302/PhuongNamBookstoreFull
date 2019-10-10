package com.hungviet.phuongnambookstore.model;

public class Hoa_Don_Ban {
    String theloai,tensach,ngaynhap,soluongban;
    String giaban;

    public Hoa_Don_Ban(String theloai, String tensach, String ngaynhap, String soluongban, String giaban) {
        this.theloai = theloai;
        this.tensach = tensach;
        this.ngaynhap = ngaynhap;
        this.soluongban = soluongban;
        this.giaban = giaban;
    }

    public String getTheloai() {
        return theloai;
    }

    public String getTensach() {
        return tensach;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public String getSoluongban() {
        return soluongban;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setSoluongban(String soluongban) {
        this.soluongban = soluongban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }
}
