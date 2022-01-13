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
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class TaiKhoan {

    private String ma_tk;
    private String username;
    private String password;
    private String quyen;

    public TaiKhoan() {

    }

    public TaiKhoan(String ma_tk, String username, String password, String quyen) {
        this.ma_tk = ma_tk;
        this.username = username;
        this.password = password;
        this.quyen = quyen;
    }

    public String getMa_tk() {
        return ma_tk;
    }

    public void setMa_tk(String ma_tk) {
        this.ma_tk = ma_tk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập tài khoản: ");
        setUsername(sc.nextLine());
        System.out.println("Mời nhập mật khẩu: ");
        setPassword(sc.nextLine());
    }

    public void Xuat() {
        String q = ("0".equals(quyen)) ? "Nhân viên" : "Admin";
        System.out.println("Mã tài khoản: " + getMa_tk() + "\nTài khoản: " + getUsername() + "\nMật khẩu: " + getPassword() + "\nQuyền :" + q);
    }

    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF(ma_tk);
        fileOut.writeUTF(username);
        fileOut.writeUTF(password);
        fileOut.writeUTF(quyen);
    }

    public void docFile(DataInputStream fileIn) throws IOException {
        ma_tk = fileIn.readUTF();
        username = fileIn.readUTF();
        password = fileIn.readUTF();
        quyen = fileIn.readUTF();
    }
}
