/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Person {
    private String hoten,cccd,diachi,sdt;
    private int tuoi;
    
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String hoten, String cccd, String diachi, String sdt, int tuoi) {
        this.hoten = hoten;
        this.cccd = cccd;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tuoi = tuoi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
    public void Nhap(){
        System.out.println("Mời nhập họ tên");
        setHoten(sc.nextLine());
        System.out.println("Mời nhập căn cước");
        setCccd(sc.nextLine());
        System.out.println("Mời nhập địa chỉ");
        setDiachi(sc.nextLine());
        System.out.println("Mời nhập số điện thoại");
        setSdt(sc.nextLine());
        System.out.println("Mời nhập tuổi");
        setTuoi(Integer.parseInt(sc.nextLine()));
    }
    
    public void Xuat(){
        System.out.println("Họ tên: "+getHoten()+"\nCăn cước: "+getCccd()+"\nĐịa chỉ: "+getDiachi()+"\nSdt: "+getSdt()+"\nTuổi: "+getTuoi());
    }
}
