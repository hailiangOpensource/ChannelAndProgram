package com.tv189.logic;

import java.sql.SQLException;

import com.tv189.domain.Channel;
import com.tv189.helper.CreateAndAddLogHelper;
import com.tv189.helper.LogConfigHelper;
import com.tv189.interfac.ChannelCRUDInterface;
import com.tv189.interfac.JsonToChannelInterface;
import com.tv189.interfacImpl.ChannelCRUDInterfaceImpl;
import com.tv189.interfacImpl.JsonToChannelInterfacImpl;

public class ChannelLogic {
	private JsonToChannelInterface jsonToChannelInterface = new JsonToChannelInterfacImpl();
	private ChannelCRUDInterface channelCRUDInterface = new ChannelCRUDInterfaceImpl();
	
	public void publishOrCancelChannel(String method,
			String content) {

		Channel channel = new Channel();
		Channel channelResult = new Channel();
		String loggerName = LogConfigHelper.getHttpInfoLoggerName();
		String msg = null;
		try {
			// json转换为Channel
			channel = jsonToChannelInterface.jsonToChannel(content);
			String liveId = channel.getLiveId();
			msg = "json数据content转换为频道(Channel)对象格式成功，频道的LiveId为："+ liveId;
			
			// 直播频道的发布处理：
			if (method.equals("publish")) {
				channelResult = channelCRUDInterface.findChannelByLiveId(liveId);
				String liveIdResult = channelResult.getLiveId();
				if (channelResult != null && liveIdResult!=null) {
					channelCRUDInterface.delChannelByLiveId(liveIdResult);
					msg += "。插入前，数据库中查询到了LiveId为："+ liveId + "的频道记录，并将其成功删除。";
				}else{
					msg +="。数据库中未查到LiveId为："+liveId + "的频道记录。";
				}
				channelCRUDInterface.insertChannel(channel);
				msg += "。数据库中成功插入LiveId为" + liveId + "的频道记录。";
			}

			// 直播频道的下线处理：
			else if (method.equals("cancel")) {
				channelCRUDInterface.delChannelByLiveId(liveId);
				msg += "。成功删除LiveId为" + liveId + "的频道记录。";
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			CreateAndAddLogHelper.createAndAddLogger(loggerName, msg);
		}
	}	
}
