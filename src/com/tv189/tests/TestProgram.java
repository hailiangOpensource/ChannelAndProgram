//package com.tv189.tests;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import com.tv189.domain.Program;
//import com.tv189.interfac.JsonToProgramInterface;
//import com.tv189.interfacImpl.JsonToProgramInterfacImpl;
//
//public class TestProgram {
//	
//	public static void main(String[] args) {
//		JsonToProgramInterface jsonToProgramInterface;
//		jsonToProgramInterface = new JsonToProgramInterfacImpl();
//		
//		String programJson = "[{\"liveId\":\"C98000000000000000001355725830536\",\"ProgramListDate\":\"20140826\",\"jPrograms\":[{\"liveListId\":\"1800311\",\"isTaped\":1,\"startTime\":\"2014-03-28 07:30:00\",\"endTime\":\"2014-03-28 08:30:00\",\"title\":\"上午重播\",\"length\":\"3600\",\"scover\":\"D:/scover\",\"cover\":\"D:/cover\",\"status\":1,\"activityId\":\"333333\",\"adapter\":\"555555\",\"ext\":\"lalalala\"},{\"liveListId\":\"1800319\",\"isTaped\":1,\"startTime\":\"2014-03-28 11:30:00\",\"endTime\":\"2014-03-28 12:30:00\",\"title\":\"画说基本面\",\"length\":\"3600\",\"scover\":\"D:/scover\",\"cover\":\"D:/cover\",\"status\":1,\"activityId\":\"333333\",\"adapter\":\"555555\",\"ext\":\"lalalala\"}]}]";
//	    try {
//	    	List<Program> listPro = jsonToProgramInterface.jsonToProgram(programJson);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
