package com.tv189.interfac;

import java.sql.SQLException;
import com.tv189.domain.Channel;

public interface JsonToChannelInterface {

	Channel jsonToChannel(String jsonSrc) throws SQLException;
}
