package com.tv189.helper;

import com.tv189.log.MyLogger;
import com.tv189.log.MyLoggerManager;

public class CreateAndAddLogHelper {
	public static void createAndAddLogger(String loggerName,String msg) {
		 MyLogger log = new MyLogger(loggerName, msg);
			MyLoggerManager.addLogger(log);
	}
}
