package com.hungviet.phuongnambookstore.model;

public class Person {
    public String email,hoten,matkhau,manguoidung;
    public int sdt,kechan,custom,thucrac;


    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(String manguoidung) {
        this.manguoidung = manguoidung;
    }

    public int getKechan() {
        return kechan;
    }

    public void setKechan(int kechan) {
        this.kechan = kechan;
    }

    public int getCustom() {
        return custom;
    }

    public void setCustom(int custom) {
        this.custom = custom;
    }

    public int getThucrac() {
        return thucrac;
    }

    public void setThucrac(int thucrac) {
        this.thucrac = thucrac;
    }
}
