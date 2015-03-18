package com.tv189.log;

import tools.DynamicResource;

public class LogConfigHelper {

	private static final String configName = "LogConfig.properties";

//	public static String getAppInfoLoggerName() {
//		return DynamicResource.getResource(configName).getString(
//				"AppLoggerName");
//	}

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

	public static String getSendLog() {
		return DynamicResource.getResource(configName).getString("SendrevLog");
	}

	public static String getUserActionLog() {
		return DynamicResource.getResource(configName).getString("UserActionLog");
	}

	/**
	 * 得到客户端上报日志的log4j配置
	 * @author 峰
	 * @return log4j里面Logger的name
	 */
	public static String getClientActionLog() {
		return DynamicResource.getResource(configName).getString("clientActionLog");
	}
	
	public static String getRequestLog() {
		return DynamicResource.getResource(configName).getString("RequestLog");
	}

	public static String getLoginLog() {
		return DynamicResource.getResource(configName).getString("LoginLog");
	}
//	/**
//	 * 统一登录日志
//	 * @return
//	 */
//	public static String getNewLoginLog() {
//		return DynamicResource.getResource(configName).getString("new_login_log");
//	}
//	public static String getSearchLog() {
//		return DynamicResource.getResource(configName).getString("SearchLog");
//	}
//
//	public static String getLogoutLog() {
//		return DynamicResource.getResource(configName).getString("LogoutLog");
//	}
//
//	public static String getCdrLog() {
//		return DynamicResource.getResource(configName).getString("CdrLog");
//	}
//
//	public static String getDebugLog() {
//		return DynamicResource.getResource(configName).getString("DebugLog");
//	}
//
//	public static String getMobileLoginLog() {
//		return DynamicResource.getResource(configName).getString("MoblieLogin");
//	}
//
//	public static String getProxyHttpLog() { return DynamicResource.getResource(configName)
//				.getString("ProxyHttpLog");
//	}
//
//	public static String getSendHeartLog() {
//		return DynamicResource.getResource(configName).getString(
//				"Send_Heart_Log");
//	}
//
//	public static String getHeartLog() {
//		return DynamicResource.getResource(configName).getString("Heart_Log");
//	}
//
//	public static String getTVLoginLog() {
//		return DynamicResource.getResource(configName).getString("TVLoginLog");
//	}
//
//	public static String getWAPLoginLog() {
//		return DynamicResource.getResource(configName).getString("WAPLoginLog");
//	}
//
//	public static void main(String... args) {
//		System.out.println(LogConfigHelper.getProxyHttpLog());
//	}
//
//	// 20130802 接口访问权限日志
//	public static String getApiAccessLog() {
//		return DynamicResource.getResource(configName).getString(
//				"Api_access_log");
//	}
//	
//	//20130812 统一门户登录日志修改
//	public static String getApiUserlogin(){
//		return DynamicResource.getResource(configName).getString("Api_UserLogin");
//	}
	
	/**
	 * 得到系统异常日志的log4j配置
	 * @author 峰
	 * @return log4j里面Logger的name
	 */
	public static String getExceptionLog() {
		return DynamicResource.getResource(configName).getString("exception_Log");
	}
}
