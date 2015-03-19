package com.tv189.interfacImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tv189.domain.Channel;
import com.tv189.interfac.ChannelCRUDInterface;
import com.tv189.tools.JdbcConnection;

public class ChannelCRUDInterfaceImpl implements ChannelCRUDInterface{
	JdbcConnection jdbcConnection = new JdbcConnection();
	Statement stmt1 = jdbcConnection.createStatement();
	
	@Override
	public Channel findChannelByLiveId(String liveId) throws SQLException {
		Channel channel = new Channel();
		
		String sql = "select liveId from Live_Channel_Info where liveId=\""+liveId+"\"";
		ResultSet rs = stmt1.executeQuery(sql);
		while (rs.next()) {
			channel.setLiveId(rs.getString("liveId"));
		}
		return channel;
	}

	@Override
	public void delChannelByLiveId(String liveId) throws SQLException {
		String sql = "delete  from Live_Channel_Info where liveId=\""+liveId+"\"";
		stmt1.executeUpdate(sql);
	}

	@Override
	public void insertChannel(Channel channel) throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		String sql = "insert into Live_Channel_Info (liveId,name,plats,pinyin,physicalType,cpId,spId,scover,description,nodeId,createTime,updateTime) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = jdbcConnection.createPreparedStatement(sql);
		if (channel != null) {
				stmt.setString(1, channel.getLiveId());
				stmt.setString(2, channel.getCategoryName());
				stmt.setInt(3, channel.getPlat());
				stmt.setString(4, channel.getTitle());
				stmt.setInt(5, channel.getPhysicalType());
				stmt.setString(6, channel.getCpId());
				stmt.setString(7, channel.getSpId());
				stmt.setString(8, channel.getSeriesCount());
				stmt.setString(9, channel.getDescription());
				stmt.setString(10, channel.getParentId());
				stmt.setString(11, channel.getCreateTime());
				stmt.setString(12, channel.getUpdateTime());
				
				stmt.addBatch();
				stmt.executeBatch();

			}
	}


}
