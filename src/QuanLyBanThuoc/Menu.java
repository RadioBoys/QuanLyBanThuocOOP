/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public void menuAdmin() throws IOException {
        Boolean exit = false;
        while (!exit) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Quản lý thuốc ");
            System.out.println("2. Quản lý tài khoản ");
            System.out.println("3. Quản lý hóa đơn ");
            System.out.println("4. Thống kê ");
            System.out.println("5. Đăng xuất ");
            System.out.println("0. Thoát ");
            System.out.println("Lựa chọn: ");
            String luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    menuThuoc();
                    break;
                case "2":
                    menuTaikhoan();
                    break;
                case "3":
                    //menuHoadon();
                    break;
                case "4":
                    //menuThongke();
                    break;
                case "5":
                    Login l = new Login();
                    l.login();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.err.println("Nhập sai vui lòng nhập lại!");
                    menuAdmin();
                    break;
            }

        }
    }

    public void menuThuoc() throws IOException {
        List_TaiKhoan tk = new List_TaiKhoan();
        Boolean exit = false;
        while (!exit) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Thêm thuốc ");
            System.out.println("2. Sửa thông tin thuốc");
            System.out.println("3. Xóa thuốc");
            System.out.println("4  Hiển thị danh sách thuốc ");
            System.out.println("5. Tìm kiếm thuốc ");
            System.out.println("6. Trở về ");
            System.out.println("0. Thoát ");
            System.out.println("Lựa chọn: ");
            String luachon = sc.nextLine();
            switch (luachon) {
                case "0":
                    System.exit(0);
                case "1":
                    List_Thuoc listthuoc = new List_Thuoc();
                    listthuoc.docFile();
                    listthuoc.them();
                    break;
                case "2":
                    List_Thuoc listthuoc1 = new List_Thuoc();
                    listthuoc1.docFile();
                    listthuoc1.suaTheoMa();
                    break;
                case "3":
                    List_Thuoc listthuoc2 = new List_Thuoc();
                    listthuoc2.docFile();
                    listthuoc2.xoaTheoMa();
                    break;
                case "4":
                    List_Thuoc listthuoc3 = new List_Thuoc();
                    listthuoc3.docFile();
                    listthuoc3.Xuat(listthuoc3.l_thuoc);
                    break;
                case "5":
                    List_Thuoc listthuoc4 = new List_Thuoc();
                    listthuoc4.docFile();
                    listthuoc4.timkiemgandung();
                    break;
                case "6":
                    menuAdmin();
                default:
                    System.err.println("Nhập sai vui lòng nhập lại!");
                    menuThuoc();
                    break;
            }
        }
    }

    public void menuTaikhoan() throws IOException {
        List_TaiKhoan tk = new List_TaiKhoan();
        Boolean exit = false;
        while (!exit) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Thêm tài khoản ");
            System.out.println("2. Sửa thông tài khoản ");
            System.out.println("3. Xóa tài khoản ");
            System.out.println("4. Hiển thị tài khoản ");
            System.out.println("5. Trở về");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            String luachon = sc.nextLine();
            switch (luachon) {
                case "0":
                    System.exit(0);
                case "1":
                    menuThemtk();
                    break;
                case "2":
                    List_TaiKhoan tk2 = new List_TaiKhoan();
                    tk2.docFile();
                    tk2.suaTheoMa();
                    break;
                case "3":
                    List_TaiKhoan tk3 = new List_TaiKhoan();
                    tk3.docFile();
                    tk3.xoaTheoMa();
                    break;
                case "4":
                    System.out.println("Thông tin tất cả tài khoản");
                    List_TaiKhoan list_TK = new List_TaiKhoan();
                    list_TK.docFile();
                    list_TK.xuat(list_TK.l_taikhoan);
                    break;
                case "5":
                    menuAdmin();
                    break;
                default:
                    System.err.println("Nhập sai vui lòng nhập lại!");
                    menuTaikhoan();
                    break;
            }
        }
    }

    public void menuThemtk() throws IOException {
        System.out.println("------------------------------------------------------------");
        System.out.println("1. Tài khoản admin ");
        System.out.println("2. Tài khoản nhân viên ");
        System.out.println("0. Thoát");
        System.out.println("Lựa chon: ");
        String chontemp = sc.nextLine();
        switch (chontemp) {
            case "0":
                System.exit(0);
            case "1":
                List_TaiKhoan l_tk = new List_TaiKhoan();
                l_tk.docFile();
                TaiKhoan tktemp = new TaiKhoan();
                tktemp.Nhap();
                tktemp.setMa_tk(String.valueOf(l_tk.getNewmatk()));
                tktemp.setQuyen("1");
                l_tk.them(tktemp);
                break;
            case "2":
                List_TaiKhoan tk1 = new List_TaiKhoan();
                tk1.docFile();
                TaiKhoan tktemp1 = new TaiKhoan();
                tktemp1.Nhap();
                tktemp1.setMa_tk(String.valueOf(tk1.getNewmatk()));
                tktemp1.setQuyen("0");
                tk1.them(tktemp1);
                break;
            default:
                System.out.println("Nhập sai vui lòng nhập lại!");
                menuThemtk();
                break;
        }
    }

    public void menuNhanvien() throws IOException{
        Boolean exit = false;
        while(!exit){
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Thêm thuốc: ");
            System.out.println("2. Sửa thông tin thuốc: ");
            System.out.println("3. Hiển thị danh sách thuốc: ");
            
            System.out.println("4. Đăng xuất");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.println("Lựa chon: ");
            String luachon = sc.nextLine();

            switch(luachon){
                case "0":
                    System.exit(0);
                case "1":
                    List_Thuoc listthuoc = new List_Thuoc();
                    listthuoc.docFile();
                    listthuoc.them();
                    break;
                case "2":
                    List_Thuoc listthuoc1 = new List_Thuoc();
                    listthuoc1.docFile();
                    listthuoc1.suaTheoMa();
                    break;
                case "3":
                    List_Thuoc listthuoc3 = new List_Thuoc();
                    listthuoc3.docFile();
                    listthuoc3.Xuat(listthuoc3.l_thuoc);
                    break;
                case "4":
                    Login l = new Login();
                    l.login();
                    break;
                case "5":
                    List_Thuoc listthuoc4 = new List_Thuoc();
                    listthuoc4.docFile();
                    listthuoc4.timkiemgandung();

                default:
                    System.out.println("Nhập sai vui lòng nhập lại!");
                    menuNhanvien();
                    break;
            }
        }
    }

    
}
