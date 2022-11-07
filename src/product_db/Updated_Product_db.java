package product_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Updated_Product_db {
		
		//Condition 7:-To check quantity of each product after buying from Product DB.
		
		public static void getUpdatedProductTable()  {
		Connection connect=Connection_Class.getConnect();
			
		Scanner scn=new Scanner(System.in);
		System.out.println("Please enter the Product ID to Fetched>>");
		int id2=scn.nextInt();
		PreparedStatement pss2;
		try {
			pss2 = connect.prepareStatement("select * from productdata where id=?;");
			
			pss2.setInt(1, id2);
			ResultSet set2=pss2.executeQuery();
			while(set2.next()) {
			
				System.out.println("ID>>"+set2.getInt(1));
				System.out.println("Name>>"+set2.getString(2));
				System.out.println("Description>>"+set2.getString(3));
				System.out.println("Qty"+set2.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		

	}




