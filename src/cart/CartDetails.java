package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import product_db.Connection_Class;

public class CartDetails {
	
	public static void getCartDetails() {
		Connection connect=Connection_Class.getConnect();
		try {
			PreparedStatement pp=connect.prepareStatement("select * from cart");
			ResultSet set=pp.executeQuery();
			
			while(set.next()) {
				System.out.println("Cart ID>>"+set.getInt(1));
				System.out.println("Product Name>>"+set.getString(2));
				System.out.println("Product Description>>"+set.getString(3));
				System.out.println("Product Price>>"+set.getInt(4));
				System.out.println("Product Qty>>"+set.getInt(5));
				System.out.println("Total Product Price>>"+set.getInt(6));

			}
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
