package com.tv189.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.helper.CreateAndAddLogHelper;
import com.tv189.helper.LogConfigHelper;
import com.tv189.interfac.JsonToProgramInterface;
import com.tv189.interfac.ProgramCRUDInterface;
import com.tv189.interfacImpl.JsonToProgramInterfacImpl;
import com.tv189.interfacImpl.ProgramCRUDInterfaceImpl;
import com.tv189.log.MyLoggerManager;

public class ProgramLogic {
	private JsonToProgramInterface jsonToProgramInterface = new JsonToProgramInterfacImpl();
	private ProgramCRUDInterface programCRUDInterface= new ProgramCRUDInterfaceImpl();
	
    public void publishOrCancelProgram(String synctype,String method,String content){
        
    	List<JProgram> jProgramList = new ArrayList<JProgram>();
	 	List<JProgram> programs = new ArrayList<JProgram>();
		String loggerName = LogConfigHelper.getHttpInfoLoggerName();
		
     	if(content!=null && content.length()!=0 && synctype!=null && synctype.length()!=0 && method!=null&& method.length()!=0 ){
			if(synctype.equals("liveProgram")){
			  //json转为Program
			   try {
			 	 jProgramList = jsonToProgramInterface.jsonToProgram(content);
				 String msg3 = "json数据content转换为节目单列表(List<JProgram>)格式成功，节目单条数为:"+jProgramList.size();
				 CreateAndAddLogHelper.createAndAddLogger(loggerName, msg3);
			 } catch (SQLException e1) {
				 e1.printStackTrace();
				 MyLoggerManager.printInfo("json转为节目单对象出错"+e1);
			 }
			   
			//1、直播节目单的发布处理：
			 if(method.equals("publish")){
				 try {
					for(JProgram jprogram:jProgramList){
						programs =programCRUDInterface.findProByLiveIdAndDate(jprogram.getLiveId(), jprogram.getProgramDate());
					}
					if(programs!=null){
						for(JProgram jpro:programs){
							programCRUDInterface.delProByLiveIdAndCreateTime(jpro.getLiveId(), jpro.getProgramDate());
						}
						String msg4 = "插入前，数据库中查询到了"+programs.size()+"条的节目单记录，并将其成功删除";
						CreateAndAddLogHelper.createAndAddLogger(loggerName, msg4);
					}
					for(JProgram jpro:jProgramList){
						programCRUDInterface.insertPro(jpro);
						}
					String msg5 = "Program插入数据库成功";
					CreateAndAddLogHelper.createAndAddLogger(loggerName, msg5);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			  }
			 
			 //2、直播节目单的下线处理：
			 if(method.equals("cancel")){
				 try {
	    				for(JProgram jpro:jProgramList){
	    				programCRUDInterface.delProByLiveIdAndCreateTime(jpro.getLiveId(), jpro.getProgramDate());
	    				String msg6 = "成功删除"+jProgramList.size()+"条的节目单记录";
						CreateAndAddLogHelper.createAndAddLogger(loggerName, msg6);
	    				}
			 } catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 }
	  }
    }
}