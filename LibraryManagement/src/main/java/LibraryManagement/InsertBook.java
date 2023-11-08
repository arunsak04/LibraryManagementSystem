package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class  InsertBook {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Scanner sc=new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	
	System.out.println("Enter how many books u want to add");
	int book_count=sc.nextInt();
	String sql="insert into book values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	
	while(book_count>0) {
	System.out.println("Enter the book ID");
	int id=sc.nextInt();
	System.out.println("Enter the book name");
	String name=sc.next();
	System.out.println("Enter the book author");
	String author=sc.next();
	System.out.println("Enter the book price");
	double price=sc.nextDouble();
	
	ps.setInt(1,id);
	ps.setString(2, name);
	ps.setString(3,  author);
	ps.setDouble(4, price);
	if(ps.executeUpdate()>0) {
		System.out.println("Book inserted");
	book_count--;}
	else
		System.out.println("Book is not inserted");
	}

con.close();
	
}
}
