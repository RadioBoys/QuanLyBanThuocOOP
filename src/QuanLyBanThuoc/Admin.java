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
public class Admin extends Person {

    private String maAdmin;
    private TaiKhoan account;

    public Admin() {

    }

    public Admin(String maAdmin, TaiKhoan account, String hoten, String cccd, String diachi, String sdt, int tuoi) {
        super(hoten, cccd, diachi, sdt, tuoi);
        this.maAdmin = maAdmin;
        this.account = account;
    }

    public String getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(String maAdmin) {
        this.maAdmin = maAdmin;
    }

    public TaiKhoan getAccount() {
        return account;
    }

    public void setAccount(TaiKhoan account) {
        this.account = account;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Mời nhập mã Admin: ");
        setMaAdmin(sc.nextLine());
    }
    
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Mã Admin: "+getMaAdmin());
    }
}
