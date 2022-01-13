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
public class NhanVien extends Person {
    private String maNV;
    private TaiKhoan account;

    public NhanVien() {
    }

    public NhanVien(String maNV, TaiKhoan account, String hoten, String cccd, String diachi, String sdt, int tuoi) {
        super(hoten, cccd, diachi, sdt, tuoi);
        this.maNV = maNV;
        this.account = account;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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
        System.out.println("Mời nhập mã nhân viên: ");
        setMaNV(sc.nextLine());
    }
    
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Mã nhân viên: "+getMaNV());
    }
}
