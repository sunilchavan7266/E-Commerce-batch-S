package cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import product_db.Connection_Class;

public class sum {
	
	public static void getSum() {
		Connection connect=Connection_Class.getConnect();
		String query="select sum(totalprice) from cart;";
		try {
			Statement st=connect.createStatement();
			ResultSet set=st.executeQuery(query);
			
			 String Countrun="";
		      while(set.next()){
		      Countrun = set.getString(1);
		      System.out.println("Total Cart price :" +Countrun);
		       } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
