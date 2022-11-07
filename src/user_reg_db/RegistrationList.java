package user_reg_db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegistrationList {
	//Condition 8:-Entire Registration List Fetching

	
	public static void getDetails() {
	Connection con=Connection_Class_Reg.getConnect();
	String query2="select * from user_reg_details;";
	 

	try {
		Statement st=con.createStatement();
		ResultSet set=st.executeQuery(query2);
		
		while(set.next()) {
			System.out.println("User Id>>"+set.getString(1));
			System.out.println("User FirstName>>"+set.getString(2));
			System.out.println("User LastName>>"+set.getString(3));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
       
	}

}
