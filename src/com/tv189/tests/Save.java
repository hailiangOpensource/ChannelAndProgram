/*package com.tv189.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.domain.Program;
import com.tv189.tools.JsonUtil;

public class Save {
	public static void main(String[] args) {
		 try {
		      Class.forName("com.mysql.jdbc.Driver");    
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e1) {
		      System.out.print("Error loading Mysql Driver!");
		      e1.printStackTrace();
		    }
		 
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/test","root","mysqlxys");
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
		      String programJson = "[{\"liveId\":\"C98000000000000000001355725830536\",\"ProgramListDate\":\"20140826\",\"jPrograms\":[{\"liveListId\":\"1800311\",\"isTaped\":1,\"startTime\":\"2014-03-28 07:30:00\",\"endTime\":\"2014-03-28 08:30:00\",\"title\":\"上午重播\",\"length\":\"3600\",\"scover\":\"D:/scover\",\"cover\":\"D:/cover\",\"status\":1,\"activityId\":\"333333\",\"adapter\":\"555555\",\"ext\":\"lalalala\"},{\"liveListId\":\"1800319\",\"isTaped\":1,\"startTime\":\"2014-03-28 11:30:00\",\"endTime\":\"2014-03-28 12:30:00\",\"title\":\"画说基本面\",\"length\":\"3600\",\"scover\":\"D:/scover\",\"cover\":\"D:/cover\",\"status\":1,\"activityId\":\"333333\",\"adapter\":\"555555\",\"ext\":\"lalalala\"}]}]";
		           
		      List<Program> listPro = new ArrayList<Program>();
		      listPro = (List<Program>) JsonUtil.jsonToProgramList(programJson);
		      
		      for(Program program:listPro){
		    	  for(JProgram jProgram:program.getjPrograms()){
		    		  stmt.executeUpdate("insert into Live_Program_Info (liveId,ProgramListDate,liveListId,isTaped,startTime,endTime,title,length,scover,cover,status,activityId,adapter,ext) values(\""+program.getLiveId()+"\",\""+program.getProgramListDate()+"\",\""+jProgram.getLiveListId()+"\","+jProgram.getIsTaped()+",\""+jProgram.getStartTime().toLocaleString()+"\",\""+jProgram.getEndTime().toLocaleString()+"\",\""+jProgram.getTitle()+"\",\""+jProgram.getLength()+"\",\""+jProgram.getScover()+"\",\""+jProgram.getCover()+"\","+jProgram.getStatus()+",\""+jProgram.getActivityId()+"\",\""+jProgram.getAdapter()+"\",\""+jProgram.getExt()+"\")");
		    	  }
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
	}
	
}
*/