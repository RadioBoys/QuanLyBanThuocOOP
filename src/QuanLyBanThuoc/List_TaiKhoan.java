/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class List_TaiKhoan {

    ArrayList<TaiKhoan> l_taikhoan = new ArrayList();
    public static final String FILE_TAIKHOAN = "src/QuanLyBanThuoc/taikhoan.txt";
    Scanner scan = new Scanner(System.in);

    public void docFile() throws FileNotFoundException, IOException {
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream(FILE_TAIKHOAN))) {
            while (fileIn.available() > 0) {
                TaiKhoan tk = new TaiKhoan();
                tk.docFile(fileIn);
                l_taikhoan.add(tk);
            }

        } catch (IOException e) {
            System.err.println("Loi khi DOC FILE " + FILE_TAIKHOAN);
        }
    }

    public void ghiThem(ArrayList<TaiKhoan> dstk) throws FileNotFoundException, IOException {
        for (TaiKhoan tk : dstk) {
            try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_TAIKHOAN, true))) {

                tk.ghiFile(fileOut);
                fileOut.close();
            } catch (IOException e) {
                System.err.println("Loi khi GHI FILE " + FILE_TAIKHOAN + "!");
            }
        }
    }

    public void ghiDe() throws FileNotFoundException, IOException {
        ArrayList<TaiKhoan> tk = l_taikhoan;

        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_TAIKHOAN, false))) {
            for (TaiKhoan tk1 : tk) {
                tk1.ghiFile(fileOut);
            }
        } catch (IOException e) {
            System.err.println("Loi khi GHI FILE " + FILE_TAIKHOAN + "!");
        }
    }

//    public void ghiFile(TaiKhoan tk) throws FileNotFoundException, IOException {
//        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_TAIKHOAN, true))) {
//            tk.ghiFile(fileOut);
//        } catch (IOException e) {
//            System.err.println("Loi khi GHI FILE " + FILE_TAIKHOAN + "!");
//        }
//    }

    public int getNewmatk() {
        int newid = 0;
        if (l_taikhoan.isEmpty() == true) {
            return 0;
        } else {
            for (TaiKhoan tk : l_taikhoan) {
                if (Integer.valueOf(tk.getMa_tk()) > newid) {
                    newid = Integer.valueOf(tk.getMa_tk());
                }
            }
        }
        return newid + 1;
    }

    public void suaTheoMa() {

        System.out.println("Nhập mã tài khoản:");
        int ma_tk = scan.nextInt();
        boolean isUpdate = false;
        ArrayList<TaiKhoan> tkedit = new ArrayList();
        for (TaiKhoan tk : l_taikhoan) {
            if (Integer.valueOf(tk.getMa_tk()) == ma_tk) {
                tk.Nhap();
            }
            tkedit.add(tk);
        }
        System.out.println();
        try {
            ghiDe();
            isUpdate = true;

        } catch (IOException ex) {

            Logger.getLogger(List_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        isUpdate = true;
        if (isUpdate == true) {
            System.out.println("Sửa thành công.");
        } else {
            System.out.println("Lỗi khi sửa.");
        }
    }

    public void xuat(ArrayList<TaiKhoan> dstk) {
        System.out.println("------------------------------------------------------------");
        for (TaiKhoan tk : dstk) {
            tk.Xuat();
            System.out.println("------------------------------------------------------------");
        }
    }

    public void them(TaiKhoan tk) throws IOException {
        ArrayList<TaiKhoan> add = new ArrayList();
        add.add(tk);
        ghiThem(add);

    }

    public void xoaTheoMa() {
        System.out.println("Nhập mã tài khoản xóa:");
        int ma = scan.nextInt();
        boolean isDelete = false;
        for (TaiKhoan tk1 : l_taikhoan) {
            if (ma == Integer.valueOf(tk1.getMa_tk())) {
                l_taikhoan.remove(tk1);
                try {
                    ghiDe();
                    isDelete = true;
                    break;
                } catch (IOException ex) {

                    Logger.getLogger(List_Thuoc.class.getName()).log(Level.SEVERE, null, ex);
                }
                isDelete = true;

            }
        }
        if (isDelete == true) {
            System.out.println("xóa thành công.");
        } else {
            System.out.println("Lỗi khi xóa.");
        }
    }

    public static void main(String[] args) throws IOException {
        TaiKhoan a = new TaiKhoan("0", "admin", "admin", "1");
        List_TaiKhoan dstk = new List_TaiKhoan();
        dstk.docFile();
        //dstk.them(a);
        dstk.xuat(dstk.l_taikhoan);

    }
}
