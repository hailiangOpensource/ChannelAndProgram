package com.tv189.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.tv189.helper.DBHelper;

public class JdbcConnection { 
	private PreparedStatement stmt ;
	
	public PreparedStatement createStatement(String sql) {
		String con = DBHelper.getValueByName("con");
		String characterEncoding = DBHelper.getValueByName("characterEncoding");
		String allowMultiQueries = DBHelper.getValueByName("allowMultiQueries");
		String autoReconnect = DBHelper.getValueByName("autoReconnect");
		String User = DBHelper.getValueByName("User");
		String Password = DBHelper.getValueByName("Password");
		
		String conparaStr = con+"?characterEncoding="+characterEncoding+"&allowMultiQueries="+allowMultiQueries+"&autoReconnect="+autoReconnect;
		
		try {
		      Class.forName("com.mysql.jdbc.Driver");        
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		      //"jdbc:mysql://localhost:3306/test","root","mysqlxys");
		      // "jdbc:mysql://192.168.99.83:3306/ChannelAndProgram?characterEncoding=utf-8&allowMultiQueries=true&autoReconnect=true","root","fXL2bO$RQgaRS^lH");
		      conparaStr,User,Password);
		      stmt =connect.prepareStatement(sql);
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
			return stmt;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}
}
