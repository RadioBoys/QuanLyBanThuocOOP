/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface FILE {
    void docFile() throws FileNotFoundException, IOException;

    void ghiThem(ArrayList<Thuoc> dsthuoc) throws FileNotFoundException, IOException;

    void ghiDe() throws FileNotFoundException, IOException;

    //void ghiFile() throws FileNotFoundException, IOException;
	
}
