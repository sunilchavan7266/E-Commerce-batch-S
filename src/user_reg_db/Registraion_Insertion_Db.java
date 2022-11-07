package user_reg_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registraion_Insertion_Db {
	
	public static void getRegister() {
		
		Connection connect=Connection_Class_Reg.getConnect();
		
		Scanner scn=new Scanner(System.in);
		
		System.out.println("<<Please provide the All Details for Registraion>>");
		
		System.out.println("Please enter the firstName>>");
		String fname=scn.next();
		
		System.out.println("Please enter the lastName>>");
		String lname=scn.next();
		
		System.out.println("Please enter the mail-id>>");
		String email_id=scn.next();
		
		System.out.println("Please enter the Mobile Number>>");
        long moNum=scn.nextLong();
        
        System.out.println("Please enter the city>>");
        String city=scn.next();
		
		try {
			PreparedStatement ps=connect.prepareStatement("insert into user_reg_details(firstname,lastname,email_id,mobile_no,city)"
					+ "values(?,?,?,?,?);");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email_id);
			ps.setLong(4, moNum);
			ps.setString(5, city);
			
			ps.execute();
			
			System.out.println("Registration Successfull....");
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
