package product_buying;

import java.security.DomainCombiner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import cart.CartDetails;
import cart.sum;
import product_db.Connection_Class;
import product_db.Product_Data;
import product_db.Updated_Product_db;
import product_fetching.Fetching;
import user_reg_db.Registraion_Insertion_Db;
import user_reg_db.RegistrationList;

public class Buying {
	
	public static void getOrder() {
		//Condition 2:-User enters the Registration Details	
		Registraion_Insertion_Db.getRegister();

		//Condition 4:-All products from Product Database fetched as per Ascending ID number
		ResultSet set=Fetching.getFetched();
		
	try {
		while(set.next()) {
			System.out.println(set.getInt(1));
			System.out.println(set.getString(2));
			System.out.println(set.getString(3));
			System.out.println(set.getInt(4));
			System.out.println(set.getInt(5));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	
	}
	
	public static void getDetails(int id) {
		Connection connect=Connection_Class.getConnect();
		
		
	try {
		PreparedStatement pr=connect.prepareStatement("select * from productdata where id=?;");
		pr.setInt(1,id );
		
		ResultSet set=pr.executeQuery();
		
		while(set.next()) {
		int xid=set.getInt(1);
		String name=set.getString(2);
		String description=set.getString(3);
		int price=set.getInt(4);
		
		//Selection of Product Quantity for Adding To Cart
		Scanner scn=new Scanner (System.in);
		System.out.println("Please enter the Qty to buy>>");
		int qty=scn.nextInt();
		//Condition 5:-Product is Added to Cart of User
		
		PreparedStatement prt=connect.prepareStatement("insert into cart(cartid,name,description,price,quantity) "
				+ "values(?,?,?,?,?)");
		prt.setInt(1, xid);
		prt.setString(2, name);
		prt.setString(3, description);
		prt.setInt(4, price);
		prt.setInt(5, qty);
		
		prt.execute();
		
		System.out.println("Added tio cart Successfully...");
		PreparedStatement psss=connect.prepareStatement("update cart set totalprice=price*quantity;");
		psss.execute();

			
		PreparedStatement pss=connect.prepareStatement("update productdata set quantity=quantity-? where id=?;");
		pss.setInt(1, qty);
		pss.setInt(2, xid);
		
		pss.execute();
		
	/*	PreparedStatement pss2=connect.prepareStatement("select * from productdata where id=?;");
		pss2.setInt(1, xid);
		ResultSet set2=pss2.executeQuery();
		while(set2.next()) {
		
			System.out.println("ID>>"+set2.getInt(1));
			System.out.println("Name>>"+set2.getString(2));
			System.out.println("Description>>"+set2.getString(3));
			System.out.println("Qty"+set2.getInt(5));*/
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void main(String[] args) {
		getOrder();
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Please confirm how many product wants to buy>>");
		int num=scn.nextInt();
		
		for(int x=1;x<=num;x++) {
			System.out.println("Please select the Product>>");
			
			int id=scn.nextInt();
			
			getDetails(id);
			
		   
		}
			CartDetails.getCartDetails();
		
		//Condition 6:-Final Price to pay 
		sum.getSum();
		
		Connection connect=Connection_Class.getConnect();
		

		try {
			PreparedStatement pp=connect.prepareStatement("delete from cart;");
			pp.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}

}
}
