package product_fetching;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import product_db.Connection_Class;

public class Fetching {
	
	public static ResultSet getFetched() {
		Connection connect=Connection_Class.getConnect();
		ResultSet set=null;
		String query="select * from productdata order by id asc;";
		try {
			Statement st=connect.createStatement();
			 set=st.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
	}

}
