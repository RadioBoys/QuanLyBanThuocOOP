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
public class List_Thuoc implements List, FILE {

    public static final String FILE_THUOC = "src/QuanLyBanThuoc/thuoc.txt";

    Scanner sc = new Scanner(System.in);
    ArrayList<Thuoc> l_thuoc = new ArrayList();

    public ArrayList<Thuoc> getL_thuoc() {
        ArrayList<Thuoc> l_thuoc = new ArrayList();
        for (Thuoc thuoc : l_thuoc) {
            if (thuoc instanceof Thuoc) {
                l_thuoc.add(thuoc);
            }
        }
        return l_thuoc;
    }

    @Override
    public void them() throws IOException{
        System.out.println("Mời nhập số thuốc cần thêm: ");
        int sothuoc = sc.nextInt();
        for (int i = 0;i<sothuoc;i++){
            List_Thuoc l_thuoc = new List_Thuoc();
            l_thuoc.docFile();
            Thuoc thuoc = new Thuoc();
            thuoc.Nhap();
            thuoc.setMathuoc(String.valueOf(l_thuoc.getNewmathuoc()));
            l_thuoc.Them(thuoc);
        }

    }
    
     public void Them(Thuoc thuoc) throws IOException {
        ArrayList<Thuoc> add = new ArrayList();
        add.add(thuoc);
        ghiThem(add);

    }

    
    public void xoaTheoMa() {
        System.out.println("Nhập mã thuốc cần xóa:");
        int ma = sc.nextInt();
        boolean isDelete = false;
        for (Thuoc thuoc1 : l_thuoc) {
            if (ma == Integer.valueOf(thuoc1.getMathuoc())) {
                l_thuoc.remove(thuoc1);
                try {
                    ghiDe();
                    isDelete = true;
                    break;
                } catch (IOException e) {

                    Logger.getLogger(List_Thuoc.class.getName()).log(Level.SEVERE, null, e);
                }
                isDelete = true;
            }
        }
        if (isDelete == true) {
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Lỗi khi xóa.");
        }
    }

    @Override   
    public void suaTheoMa() {
        System.out.println("Nhập mã thuốc cần sửa:");
        String ma = sc.nextLine();
        boolean isedit = false;
        for (Thuoc thuoc : l_thuoc) {
            if (ma.equals(thuoc.getMathuoc())) {
                thuoc.Nhap();
                isedit = true;
                break;
            }
        }
        try {
            ghiDe();
            if (isedit == true) {
                System.out.println("sửa thành công.");

            } else {
                System.out.println("lỗi khi sửa");
            }
        } catch (IOException e) {
            Logger.getLogger(List_Thuoc.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int getNewmathuoc() {
        int newid = 0;
        if (l_thuoc.isEmpty() == true) {
            return 0;
        } else {
            for (Thuoc thuoc : l_thuoc) {
                if (Integer.valueOf(thuoc.getMathuoc()) > newid) {
                    newid = Integer.valueOf(thuoc.getMathuoc());
                }
            }
        }
        return newid + 1;
    }

    public void Xuat(ArrayList<Thuoc> dsthuoc) {
        if (l_thuoc.isEmpty()) {
            System.err.println("Chưa có thuốc");
            return;
        }
        System.out.println("------------------------------------------------------------");
        for (Thuoc thuoc : dsthuoc) {
            thuoc.Xuat();
            System.out.println("------------------------------------------------------------");
        }
    }

    @Override
    public void docFile() throws FileNotFoundException, IOException {
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream(FILE_THUOC))) {
            while (fileIn.available() > 0) {
                Thuoc thuoc = new Thuoc();
                thuoc.docFile(fileIn);
                l_thuoc.add(thuoc);

            }
            // fileIn.close();

        } catch (IOException e) {
            System.err.println("Loi khi DOC FILE " + FILE_THUOC + "! File moi se duoc tao tu dong.");
        }
    }

    @Override
    public void ghiThem(ArrayList<Thuoc> l_add) throws FileNotFoundException, IOException {
        for (Thuoc thuoc : l_add) {
            try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_THUOC, true))) {
                thuoc.ghiFile(fileOut);
                fileOut.close();
            } catch (IOException e) {
                System.err.println("Loi khi GHI FILE " + FILE_THUOC + "!");
            }
        }
    }

    @Override
    public void ghiDe() throws FileNotFoundException, IOException {
        ArrayList<Thuoc> thuocp = new ArrayList();

        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_THUOC, false))) {
            for (Thuoc thuoc : thuocp) {
                thuoc.ghiFile(fileOut);
            }
        } catch (IOException e) {
            System.err.println("Loi khi GHI FILE " + FILE_THUOC + "!");
        }
    }

    public void ghiFile(Thuoc thuoc) throws FileNotFoundException, IOException {
        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_THUOC, true))) {
            thuoc.ghiFile(fileOut);
        } catch (IOException e) {
            System.err.println("Loi khi GHI FILE " + FILE_THUOC + "!");
        }
    }

    public Thuoc getThuocbyma(String ma) {
        Thuoc l = new Thuoc();
        for (Thuoc thuoc : l_thuoc) {
            if (l.getMathuoc().equals(ma)) {
                l = thuoc;
                break;
            }
        }
        return l;
    }

    public void timkiemgandung() throws IOException {
        this.Xuat(l_thuoc);
        System.out.println("Tìm kiếm:");
        String text = sc.nextLine();
        Xuat(RegexExpression.search(text));

        System.out.println("Nhập mã thuốc cần xem: ");

        int mathuoc = sc.nextInt();

        for (Thuoc i : l_thuoc) {
            if (Integer.valueOf(i.getMathuoc()) == mathuoc) {
                i.Xuat();
                break;
            }
        }
    }
}
