/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanThuoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Login {
    public static TaiKhoan tk_dangnhap = null;
    
    public void login() throws IOException {
        Scanner scan=new Scanner(System.in);
			System.out.println("Nhập username:");
			String u_name=scan.nextLine();			
			System.out.println("Nhâp password:");
			String u_pass=scan.nextLine();
			TaiKhoan tktemp=checklogin(u_name,u_pass);
			while(tktemp==null)
			{
				System.out.println("Thông tin tài khoản không đúng nhập lại");
				System.out.println("---------------------------------");
				System.out.println("Nhập username:");
				String u_name1=scan.nextLine();			
				System.out.println("Nhâp password:");
				String u_pass1=scan.nextLine();
				tktemp=checklogin(u_name1,u_pass1);	 
			}	
			System.out.println(tktemp.getQuyen());
			if("1".equals(tktemp.getQuyen()))
			{	
				Menu m =new Menu();
				m.menuAdmin();
			}		
			else
			{
				Menu m1=new Menu();
				m1.menuNhanvien();
				
			}
	}
	public TaiKhoan checklogin(String username,String pass) throws IOException
	{
		//lây tất cả tài khoản lên.
		List_TaiKhoan dstk=new List_TaiKhoan();
		dstk.docFile();
		ArrayList<TaiKhoan> l_tk=dstk.l_taikhoan;
		TaiKhoan tklogin = null;
		for(TaiKhoan tki:l_tk)
		{
			if(username.equals(tki.getUsername())&&pass.equals(tki.getPassword()))
			{
				tklogin=tki;
				break;
			}
		}
		
		Login.tk_dangnhap =tklogin;
		return tklogin;
				
	}
    }

