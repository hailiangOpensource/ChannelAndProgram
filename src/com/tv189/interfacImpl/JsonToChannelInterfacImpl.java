package com.tv189.interfacImpl;

import java.sql.SQLException;

import com.tv189.interfac.JsonToChannelInterface;
import com.tv189.tools.JsonUtil;
import com.tv189.domain.Channel;

public class JsonToChannelInterfacImpl implements JsonToChannelInterface {

	@Override
	public Channel jsonToChannel(String jsonSrc) throws SQLException {
		Channel channel = new Channel();
		channel = (Channel) JsonUtil.jsonToChannelList(jsonSrc);

		return channel;
	}

}
