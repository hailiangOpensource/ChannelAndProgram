package com.tv189.helper;

import tools.DynamicResource;

public class LogConfigHelper {

	private static final String configName = "LogConfig.properties";

	public static String getHttpInfoLoggerName() {
		return DynamicResource.getResource(configName).getString(
				"HttpLoggerName");
	}
	
	public static String getLogRootPath() {
		return DynamicResource.getResource(configName).getString(
				"Log_Root_PATH");
	}

	public static String getLogType() {
		return DynamicResource.getResource(configName).getString("Log_Type");
	}

	
}
