package com.tv189.helper;

import tools.DynamicResource;

public class DBHelper {

	private static final String configName = "jdbc.properties";

	public static String getValueByName(String name) {
		return DynamicResource.getResource(configName).getString(name);
	}
}
