package aarohi.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	/**
	 * This Method is for JDBC UPDATE
	 * @param query
	 * @throws SQLException
	 */

	public void executeUpdateJDBC(String query) throws SQLException {
	
		//Create an Object
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classic", "root", "TIGER");
		
		Statement state = con.createStatement();
		 
		int result=state.executeUpdate(query);
		
		if(result >= 1) {
			System.out.println(result+" "+"UPDATED"); 
		 }
		 
		con.close();
		System.out.println("DB Closed");
	}
	
	/**
	 * This Table is for ExecuteQuery JDBC
	 * @param query
	 * @throws SQLException
	 */
	public void executeQueryJDBC(String query) throws SQLException {
		//Create an Object
	  Driver driverRef=new Driver();
	  DriverManager.registerDriver(driverRef);
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classic", "root", "TIGER");	
	  Statement state = con.createStatement();
	  ResultSet res = state.executeQuery(query);
	  
	  for(int i=0;i<res.getInt(i);i++) {
		  
	  while(res.next()) {
		  System.out.println(res.getString(i)+"\n");
	   }
	  }
	 con.close();
	 System.out.println("DB Closed");
	}
}
	

