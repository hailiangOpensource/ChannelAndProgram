//package com.tv189.tests;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import com.tv189.domain.Channel;
//import com.tv189.interfac.JsonToChannelInterface;
//import com.tv189.interfacImpl.JsonToChannelInterfacImpl;
//
//public class TestChannel {
//	
//	public static void main(String[] args) {
//		JsonToChannelInterface jsonToChannelInterface;
//		jsonToChannelInterface = new JsonToChannelInterfacImpl();
//		
//	    String ChannelJson = "[{\"liveBasicInfo\":\"扁平\",\"sources\":[{\"liveId\":\"C8000000000000000001376544343155\",\"name\":\"天翼原创高清2\",\"plats\":33,\"pinyin\":\"\",\"physicalType\":0,\"cpId\":\"00000014\",\"spId\":\"00000014\",\"scover\":\"\",\"description\":\"\",\"nodeId\":\"\",\"createTime\":\"2015-02-11 19:18:38\",\"updateTime\":\"2015-02-12 09:18:12\"}]}]";
//	    try {
//	    	List<Channel> listChannel = jsonToChannelInterface.jsonToChannel(ChannelJson);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
