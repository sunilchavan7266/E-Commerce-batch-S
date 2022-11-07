package product_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Class {
	public static Connection getConnect() {
		Connection connect=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","root","Sunil@123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
	}

}
