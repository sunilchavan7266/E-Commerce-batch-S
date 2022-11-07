package product_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Product_Data {
	
	public static void getInsert(String name,String description,int price,int quantity) {
		Connection connect=Connection_Class.getConnect();
		
		try {
			PreparedStatement pr=connect.prepareStatement("insert into productdata(name,description,price,quantity)"
					+ "values(?,?,?,?);");
			pr.setString(1, name);
			pr.setString(2, description);
			pr.setInt(3, price);
			pr.setInt(4, quantity);
			
			pr.execute();
			
			System.out.println("Data inserted Successfully...");
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		for(int x=1;x<=10;x++) {
			System.out.println("Please enter the Product name>>");
			String name=scn.next();
			
			System.out.println("Please enter the Product Description>>");
			String desc=scn.next();
			
			System.out.println("Please enter the Product Price>>");
			int price=scn.nextInt();
			
			System.out.println("Please enter the Product Quantity>>");
			int qty=scn.nextInt();
			
			getInsert(name, desc, price, qty);
			
		}

	}

}
