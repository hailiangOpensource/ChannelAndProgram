package com.tv189.interfac;

import java.sql.SQLException;
import java.util.List;

import com.tv189.domain.Channel;
import com.tv189.domain.JProgram;
import com.tv189.domain.Program;

public interface ChannelCRUDInterface {

	Channel findChannelByLiveId(String liveId) throws SQLException;
	void delChannelByLiveId(String liveId) throws SQLException;
	void insertChannel(Channel channel) throws SQLException;
}
