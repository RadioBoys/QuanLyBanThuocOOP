/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Thuoc implements NhapXuat {
    private String mathuoc,tenthuoc,gia;

    Scanner sc = new Scanner(System.in);
    public Thuoc() {
    }

    public Thuoc(String mathuoc, String tenthuoc, String gia) {
        this.mathuoc = mathuoc;
        this.tenthuoc = tenthuoc;
       
        this.gia = gia;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

 

 
    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    
    @Override
    public void Nhap(){
        System.out.println("Mời nhập mã thuốc: ");
        setTenthuoc(sc.nextLine());

        System.out.println("Mời nhập tên thuốc: ");
        setTenthuoc(sc.nextLine());
       
        System.out.println("Mời nhập giá: ");
        setGia(sc.nextLine());
    }
    
    @Override
    public void Xuat(){
        System.out.println("Mã Thuốc: "+getMathuoc()+"\nTên thuốc: "+getTenthuoc()  +"\nGiá: "+getGia());
    }
    
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF(mathuoc);
        fileOut.writeUTF(tenthuoc);      
        fileOut.writeUTF(gia);
    }

    public void docFile(DataInputStream fileIn) throws IOException {
        mathuoc = fileIn.readUTF();
        tenthuoc = fileIn.readUTF();
        
        gia = fileIn.readUTF();
    }
}
