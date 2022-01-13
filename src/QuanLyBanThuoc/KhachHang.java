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
public class KhachHang extends Person{
    private String maKH;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoten, String cccd, String diachi, String sdt, int tuoi) {
        super(hoten, cccd, diachi, sdt, tuoi);
        this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Mời nhập mã khách hàng: ");
        setMaKH(sc.nextLine());
    }
    
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Mã khách hàng: "+getMaKH());
    }
}
