package com.tv189.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletInputStream;

public class GetParaHelper {

	public static String getParaMap(Map<String,String[]> map,String paraName){
	if(paraName==null || paraName.length()==0){
		String[] s = map.get("paraName");
    	if(s!=null && s.length>0){
    		paraName = s[0];
         	}
    	}
	return paraName;
	}
	
	public static String getParaBySteam(ServletInputStream sInputStream,String paraName) throws Exception{
		if(paraName==null || paraName.length()==0){
			BufferedReader br = new BufferedReader(new InputStreamReader(sInputStream,"UTF-8"));  
	     	String line = null;  
	     	StringBuilder sb = new StringBuilder();  
	     	while ((line = br.readLine()) != null) {  
	     	    sb.append(line);  
	     	} 
	     	paraName = sb.toString();
		   }
		return paraName;
		}
}
