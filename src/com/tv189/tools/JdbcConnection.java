package com.tv189.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tv189.helper.DBHelper;

public class JdbcConnection { 
	private static PreparedStatement pstmt ;
	private static Statement stmt ;
	public static Connection getDBConnection(){
		String con = DBHelper.getValueByName("con");
		String characterEncoding = DBHelper.getValueByName("characterEncoding");
		String allowMultiQueries = DBHelper.getValueByName("allowMultiQueries");
		String autoReconnect = DBHelper.getValueByName("autoReconnect");
		String User = DBHelper.getValueByName("User");
		String Password = DBHelper.getValueByName("Password");
		String conparaStr = con+"?characterEncoding="+characterEncoding+"&allowMultiQueries="+allowMultiQueries+"&autoReconnect="+autoReconnect;
		Connection connect=null;
		try {
		      Class.forName("com.mysql.jdbc.Driver");    
		      connect= DriverManager.getConnection(conparaStr,User,Password);
		}
		catch (Exception e) {
		      e.printStackTrace();
		      System.out.print("get data error!");
		}
		return connect;
	}
	public static PreparedStatement createPreparedStatement(String sql) {
		Connection connect = JdbcConnection.getDBConnection();
		 try {
		      pstmt =connect.prepareStatement(sql);
		 }
		 catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		 }
		 return pstmt;
	}
	public Statement createStatement() {
		try{
		      Connection connect = JdbcConnection.getDBConnection();
    		  stmt = connect.createStatement(); 
		}
		catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		}
        return stmt;
	}
	
	  /** 
     * 关闭连接对象 
     * 
     * @param conn 
     *            连接对象 
     * @param pstmt 
     *            预编译对象 
     * @param rs 
     *            结果集 
     */  
    public static void closeAll(Connection conn, Statement pstmt, ResultSet rs) {  
        try {  
            if (rs != null) {  
                rs.close();  
            }  
            if (pstmt != null) {  
                pstmt.close();  
            }  
            if (conn != null) {  
                pstmt.close();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    
	
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	
}
