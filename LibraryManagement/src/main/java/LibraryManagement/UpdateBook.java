package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		String sql="update book set  price=?,author=? where book_name=?";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Enter the book author");
		String author=sc.next();
		System.out.println("Enter the book price");
		double price=sc.nextDouble();
		System.out.println("Enter the book name");
		String name=sc.next();
		ps.setDouble(1, price);
		ps.setString(2,author);
		ps.setString(3, name);
		
		if(ps.executeUpdate()>0) {
			System.out.println("book is updated");
		}
	}

}
