package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		String sql="delete from book where price>120";
		PreparedStatement ps=con.prepareStatement(sql);
		 if(ps.executeUpdate()>0)
			 System.out.println("books deleted");
		 con.close();
		
	}

}
