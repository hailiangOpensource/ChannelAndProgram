package com.tv189.interfacImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.domain.Program;
import com.tv189.interfac.ProgramCRUDInterface;
import com.tv189.tools.JdbcConnection;
import com.tv189.tools.JsonUtil;

public class ProgramCRUDInterfaceImpl implements ProgramCRUDInterface{
	@Override
	public List<JProgram> findProByLiveIdAndDate(String liveId,String ProgramListDate) throws SQLException {
		JProgram pro = new JProgram();
		List<JProgram> programs = new ArrayList<JProgram>();
		
		String sql = "select liveId,ProgramListDate from Live_Program_Info where liveId=? and ProgramListDate=?";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setString(1, liveId);
		stmt.setString(2, ProgramListDate);
		stmt.addBatch();
		ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pro.setLiveId(rs.getString("liveId"));
				pro.setProgramDate(rs.getString("ProgramListDate"));
				programs.add(pro);
		}
		return programs;
	}

	@Override
	public void delProByLiveIdAndCreateTime(String liveId,String ProgramListDate) throws SQLException {
		//JdbcConnection jdbcConnection = new JdbcConnection();
//		String sql = "delete  from Live_Program_Info where liveId=\""+liveId+"\"and ProgramListDate=\""+ProgramListDate+"\"";
//		Statement stmt = jdbcConnection.createStatement();
//		stmt.executeUpdate(sql);
		
		String sql = "delete  from Live_Program_Info where liveId=? and ProgramListDate=?";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, liveId);
			stmt.setString(2, ProgramListDate);
			stmt.addBatch();
			stmt.executeBatch();
		
	}

	@Override
	public void insertPro(List<JProgram> jPrograms) throws SQLException {
		//JdbcConnection jdbcConnection = new JdbcConnection();
		String sql = "insert into Live_Program_Info (liveId,ProgramListDate,liveListId,isTaped,startTime,endTime,title,length,scover,cover,status,activityId,adapter,ext) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connect = JdbcConnection.getDBConnection();
		PreparedStatement stmt = connect.prepareStatement(sql);
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
	}


}
