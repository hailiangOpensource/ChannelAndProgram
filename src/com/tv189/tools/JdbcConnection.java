package com.tv189.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tv189.helper.DBHelper;

public class JdbcConnection { 
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
}
