package com.hungviet.phuongnambookstore.model;

public class Top_Ban_Chay {
    public String name,theloai,giaban;
    public int luachon,anh;

    public Top_Ban_Chay(String name, String theloai, String giaban, int luachon, int anh) {
        this.name = name;
        this.theloai = theloai;
        this.giaban = giaban;
        this.luachon = luachon;
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public void setLuachon(int luachon) {
        this.luachon = luachon;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTheloai() {
        return theloai;
    }

    public String getGiaban() {
        return giaban;
    }

    public int getLuachon() {
        return luachon;
    }

    public int getAnh() {
        return anh;
    }
}
