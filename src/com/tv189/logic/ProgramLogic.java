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
	private ProgramCRUDInterface programCRUDInterface = new ProgramCRUDInterfaceImpl();
	String msg;
	
	public void publishOrCancelProgram(String synctype, String method,
			String content) {

		List<JProgram> jProgramList = new ArrayList<JProgram>();
		List<JProgram> programs = new ArrayList<JProgram>();
		String loggerName = LogConfigHelper.getHttpInfoLoggerName();

//		// json转为Program
//		try {
//			jProgramList = jsonToProgramInterface.jsonToProgram(content);
//			msg = "json数据content转换为节目单列表(List<JProgram>)格式成功，节目单条数为:"
//					+ jProgramList.size();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//
//		// 直播节目单的发布处理：
//		if (method.equals("publish")) {
//			try {
//				for (JProgram jprogram : jProgramList) {
//					programs = programCRUDInterface.findProByLiveIdAndDate(
//							jprogram.getLiveId(), jprogram.getProgramDate());
//				}
//				if (programs != null) {
//						programCRUDInterface.delProByLiveIdAndCreateTime(programs);
//					    msg =msg+ "插入前，数据库中查询到了" + programs.size()
//							+ "条的节目单记录，并将其成功删除";
//				}
//				programCRUDInterface.insertPro(jProgramList);
//				 msg =msg+ jProgramList.size()+ "条节目单成功插入数据库";
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally{
//				CreateAndAddLogHelper.createAndAddLogger(loggerName, msg);
//			}
//		}
//
//		// 直播节目单的下线处理：
//		else if (method.equals("cancel")) {
//			try {
//					programCRUDInterface.delProByLiveIdAndCreateTime(programs);
//					msg = "成功删除" + jProgramList.size() + "条的节目单记录";
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally{
//				CreateAndAddLogHelper.createAndAddLogger(loggerName, msg);
//			}
//		}
		try {
			// json转为Program
			jProgramList = jsonToProgramInterface.jsonToProgram(content);
			msg = "json数据content转换为节目单列表(List<JProgram>)格式成功，节目单条数为:"+ jProgramList.size();
			
			// 直播节目单的发布处理：
			if (method.equals("publish")) {
				for (JProgram jprogram : jProgramList) {
					programs = programCRUDInterface.findProByLiveIdAndDate(jprogram.getLiveId(), jprogram.getProgramDate());
				}
				if (programs != null) {
					programCRUDInterface.delProByLiveIdAndCreateTime(programs);
				    msg =msg+ "插入前，数据库中查询到了" + programs.size()+ "条的节目单记录，并将其成功删除";
				}
				programCRUDInterface.insertPro(jProgramList);
				 msg =msg+ jProgramList.size()+ "条节目单成功插入数据库";
			}
			// 直播节目单的下线处理：
			else if (method.equals("cancel")) {
					programCRUDInterface.delProByLiveIdAndCreateTime(programs);
					msg = "成功删除" + jProgramList.size() + "条的节目单记录";
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			CreateAndAddLogHelper.createAndAddLogger(loggerName, msg);
		}
	}
}
