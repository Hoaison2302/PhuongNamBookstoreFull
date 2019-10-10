package com.hungviet.phuongnambookstore.model;

public class Person {
    public String Email,sdt,ten,matkhau;
    public int kechan,custom,thucrac;


    public Person(String email, String sdt, String ten, String matkhau, int kechan, int custom, int thucrac) {
        Email = email;
        this.sdt = sdt;
        this.ten = ten;
        this.matkhau = matkhau;
        this.kechan = kechan;
        this.custom = custom;
        this.thucrac = thucrac;
    }



    public Person(String email) {
        this.Email = email;
    }
}
