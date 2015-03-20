package com.tv189.interfacImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tv189.domain.Channel;
import com.tv189.interfac.ChannelCRUDInterface;
import com.tv189.tools.JdbcConnection;

public class ChannelCRUDInterfaceImpl implements ChannelCRUDInterface{
	
	Connection connect = JdbcConnection.getDBConnection();
	
	@Override
	public Channel findChannelByLiveId(String liveId) {
		Channel channel = new Channel();
		String sql = "select liveId from Live_Channel_Info where liveId=?";
		
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {
			stmt = connect.prepareStatement(sql);
			stmt.setString(1, liveId);
			stmt.addBatch();
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				channel.setLiveId(rs.getString("liveId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConn(connect, stmt, rs);
		}
		return channel;
	}

	@Override
	public void delChannelByLiveId(String liveId){
		String sql = "delete  from Live_Channel_Info where liveId=?";
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement(sql);
			stmt.setString(1, liveId);
			stmt.addBatch();
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConn(connect, stmt, null);
		}
	}

	@Override
	public void insertChannel(Channel channel){
		String sql = "insert into Live_Channel_Info (liveId,name,plats,pinyin,physicalType,cpId,spId,scover,description,nodeId,createTime,updateTime) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConn(connect, stmt,null);
		}
	
	  }
}
