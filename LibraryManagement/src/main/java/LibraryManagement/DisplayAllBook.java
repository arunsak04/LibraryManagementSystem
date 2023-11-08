package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class DisplayAllBook {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		String sql="select author,book_name,price from book";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Book details");
			System.out.println("Book Author      : "+rs.getString(1));
			System.out.println("Book Book name   : "+rs.getString(2));
			System.out.println("Book Book Price  : "+rs.getDouble(3));
		}
		

	}

}
