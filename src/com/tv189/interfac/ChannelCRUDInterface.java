package com.tv189.interfac;

import java.sql.SQLException;

import com.tv189.domain.Channel;

public interface ChannelCRUDInterface {

	Channel findChannelByLiveId(String liveId) throws SQLException;
	void delChannelByLiveId(String liveId) throws SQLException;
	void insertChannel(Channel channel) throws SQLException;
}
