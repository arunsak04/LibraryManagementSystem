package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Display {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		String sql="select book_name,price  from book where author=?";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Enter the author");
		String author=sc.next();
		ps.setString(1, author);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Book details");
			System.out.println("Book ID     : "+rs.getString(1));
			System.out.println("Book Price  : "+rs.getDouble(2));
		}
		con.close();
	
		
		
		
	}

}
