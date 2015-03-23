package com.tv189.interfacImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.interfac.ProgramCRUDInterface;
import com.tv189.tools.JdbcConnection;

public class ProgramCRUDInterfaceImpl implements ProgramCRUDInterface{
	
	@Override
	public List<JProgram> findProByLiveIdAndDate(String liveId,String ProgramListDate){
		JProgram pro = new JProgram();
		List<JProgram> programs = new ArrayList<JProgram>();
		
		String sql = "select liveId,ProgramListDate from Live_Program_Info where liveId=? and ProgramListDate=?";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = connect.prepareStatement(sql);
			stmt.setString(1, liveId);
			stmt.setString(2, ProgramListDate);
			stmt.addBatch();
			rs = stmt.executeQuery();
				while (rs.next()) {
					pro.setLiveId(rs.getString("liveId"));
					pro.setProgramDate(rs.getString("ProgramListDate"));
					programs.add(pro);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(connect, stmt, rs);
		}
		return programs;
	}

	@Override
	public void delProByLiveIdAndCreateTime(List<JProgram> jPrograms){
		String sql = "delete  from Live_Program_Info where liveId=? and ProgramListDate=?";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt =null;
		try {
			stmt = connect.prepareStatement(sql);
			for(JProgram jProgram:jPrograms){
				stmt.setString(1, jProgram.getLiveId());
				stmt.setString(2, jProgram.getProgramDate());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(connect, stmt,null);
		}
		
	}

	@Override
	public void insertPro(List<JProgram> jPrograms){
		String sql = "insert into Live_Program_Info (liveId,ProgramListDate,liveListId,isTaped,startTime,endTime,title,length,scover,cover,status,activityId,adapter,ext) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement(sql);
			for(JProgram jProgram:jPrograms){
				stmt.setString(1, jProgram.getLiveId());
				stmt.setString(2, jProgram.getProgramDate());
				stmt.setString(3, jProgram.getLiveListId());
				stmt.setInt(4, jProgram.getIsTaped());
				stmt.setString(5, jProgram.getStartTime());
				stmt.setString(6, jProgram.getEndTime());
				stmt.setString(7, jProgram.getTitle());
				stmt.setString(8, jProgram.getLength());
				stmt.setString(9, jProgram.getScover());
				stmt.setString(10, jProgram.getCover());
				stmt.setInt(11, jProgram.getStatus());
				stmt.setString(12, jProgram.getActivityId());
				stmt.setString(13, jProgram.getAdapter());
				stmt.setString(14, jProgram.getExt());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(connect, stmt,null);
		}
		
	}
}
