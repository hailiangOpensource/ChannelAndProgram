package com.tv189.interfacImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tv189.domain.Channel;
import com.tv189.interfac.ChannelCRUDInterface;
import com.tv189.tools.JdbcConnection;

public class ChannelCRUDInterfaceImpl implements ChannelCRUDInterface{
//	JdbcConnection jdbcConnection = new JdbcConnection();
//	Statement stmt1 = jdbcConnection.createStatement();
	
	@Override
	public Channel findChannelByLiveId(String liveId)  {
		Channel channel = new Channel();
		Connection conn=JdbcConnection.getDBConnection();
		String sql = "select liveId from Live_Channel_Info where liveId=\""+liveId+"\"";
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				channel.setLiveId(rs.getString("liveId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, stmt, rs);
		}
	
		return channel;
	}

	@Override
	public void delChannelByLiveId(String liveId) {
		Connection conn=JdbcConnection.getDBConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "delete  from Live_Channel_Info where liveId=\""+liveId+"\"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, stmt, null);
		}

	}

	@Override
	public void insertChannel(Channel channel)  {
		Connection conn=JdbcConnection.getDBConnection();
		String sql = "insert into Live_Channel_Info (liveId,name,plats,pinyin,physicalType,cpId,spId,scover,description,nodeId,createTime,updateTime) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (channel != null) {
				pstmt.setString(1, channel.getLiveId());
				pstmt.setString(2, channel.getCategoryName());
				pstmt.setInt(3, channel.getPlat());
				pstmt.setString(4, channel.getTitle());
				pstmt.setInt(5, channel.getPhysicalType());
				pstmt.setString(6, channel.getCpId());
				pstmt.setString(7, channel.getSpId());
				pstmt.setString(8, channel.getSeriesCount());
				pstmt.setString(9, channel.getDescription());
				pstmt.setString(10, channel.getParentId());
				pstmt.setString(11, channel.getCreateTime());
				pstmt.setString(12, channel.getUpdateTime());
				pstmt.addBatch();
				pstmt.executeBatch();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, pstmt, null);
		}
		

	}


}
