/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface List {
    void them()throws IOException;

    //void xoaTheoMa();

    void suaTheoMa();

    void Xuat(ArrayList<Thuoc> dsthuoc);
}
