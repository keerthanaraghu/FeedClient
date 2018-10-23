package com.assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedProcessorDAOImpl implements FeedProcessorDAO{
	// JDBC driver name and database URL
	  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  final String DB_URL = "jdbc:mysql://localhost:3306/gpt?&serverTimezone=UTC";

	 //  Database credentials
	  final String USER = "root";
	  final String PASS = "Apple123!@";
	 
	public void save(String sql) { 
		Connection conn = null;
		Statement stmt = null;
		 try{
			 Class.forName(JDBC_DRIVER);  
			 conn=DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
			 stmt.execute(sql);
			 
		 }catch(SQLException se) {
			 System.out.println(se);
		 }catch(Exception e) {
			 System.out.println(e);
		 }finally{
			    //finally block used to close resources
			    try{
			       if(stmt!=null)
			          conn.close();
			    }catch(SQLException se){
			    }// do nothing
			    try{
			       if(conn!=null)
			          conn.close();
			    }catch(SQLException se){
			       System.out.println(se);
			    }//end finally try
			 }//end try
	
	
	}
	

}
