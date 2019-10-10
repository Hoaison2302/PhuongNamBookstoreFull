package com.hungviet.phuongnambookstore.model;

public class Hoa_Don_Nhap {
    String theloai,tensach,ngaynhap,soluong;
    String gianhap;

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public String getGianhap() {
        return gianhap;
    }

    public String getTensach() {
        return tensach;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public String getSoluong() {
        return soluong;
    }



    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }



    public Hoa_Don_Nhap(String theloai, String tensach, String ngaynhap, String soluong, String gianhap) {
        this.theloai = theloai;
        this.tensach = tensach;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
        this.gianhap = gianhap;
    }
}
