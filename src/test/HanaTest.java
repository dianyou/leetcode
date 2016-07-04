package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HanaTest {
	public static void main(String args[])
	{
		String hurl = "jdbc:sap://10.131.119.99:30015/?autocommit=false&reconnect=true";
		String user = "SYSTEM";
		String passwd = "manager";
		Connection con = null;
		
		try
		{
			Class.forName("com.sap.db.jdbc.Driver");
			con = DriverManager.getConnection(hurl,user,passwd);
			Statement stmt = con.createStatement();
			String sql = "select * from GAVIN.BPDIRECTORY";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getMetaData());
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
