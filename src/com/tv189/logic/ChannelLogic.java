package com.tv189.logic;

import java.sql.SQLException;

import com.tv189.domain.Channel;
import com.tv189.helper.CreateAndAddLogHelper;
import com.tv189.helper.LogConfigHelper;
import com.tv189.interfac.ChannelCRUDInterface;
import com.tv189.interfac.JsonToChannelInterface;
import com.tv189.interfacImpl.ChannelCRUDInterfaceImpl;
import com.tv189.interfacImpl.JsonToChannelInterfacImpl;
import com.tv189.log.MyLoggerManager;

public class ChannelLogic {
	private JsonToChannelInterface jsonToChannelInterface = new JsonToChannelInterfacImpl();
	private ChannelCRUDInterface channelCRUDInterface = new ChannelCRUDInterfaceImpl();

	public void publishOrCancelChannel(String synctype, String method,
			String content) {

		Channel channel = new Channel();
		Channel channelResult = new Channel();
		String loggerName = LogConfigHelper.getHttpInfoLoggerName();

		// json转换为Channel
		try {
			channel = jsonToChannelInterface.jsonToChannel(content);
			String msg7 = "json数据content转换为频道(Channel)对象格式成功，频道的LiveId为："
					+ channel.getLiveId();
			CreateAndAddLogHelper.createAndAddLogger(loggerName, msg7);
		} catch (SQLException e1) {
			e1.printStackTrace();
			MyLoggerManager.printInfo("json转为频道对象出错" + e1);
		}

		// 直播频道的发布处理：
		if (method.equals("publish")) {
			try {
				channelResult = channelCRUDInterface
						.findChannelByLiveId(channel.getLiveId());
				if (channelResult != null) {
					channelCRUDInterface.delChannelByLiveId(channelResult
							.getLiveId());
					String msg8 = "插入前，数据库中查询到了LiveId为："
							+ channelResult.getLiveId() + "的频道记录，并将其成功删除";
					CreateAndAddLogHelper.createAndAddLogger(loggerName, msg8);
				}
				channelCRUDInterface.insertChannel(channel);
				String msg9 = "成功插入LiveId为" + channel.getLiveId() + "的频道记录";
				CreateAndAddLogHelper.createAndAddLogger(loggerName, msg9);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}

		// 直播频道的下线处理：
		else if (method.equals("cancel")) {
			try {
				channelCRUDInterface.delChannelByLiveId(channel.getLiveId());
				String msg10 = "成功删除LiveId为" + channel.getLiveId() + "的频道记录";
				CreateAndAddLogHelper.createAndAddLogger(loggerName, msg10);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
