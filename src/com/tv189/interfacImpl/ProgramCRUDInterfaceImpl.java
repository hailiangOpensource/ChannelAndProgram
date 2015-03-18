package com.tv189.interfacImpl;

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
import com.tv189.tools.JdbcConnection1;
import com.tv189.tools.JsonUtil;

public class ProgramCRUDInterfaceImpl implements ProgramCRUDInterface{
	@Override
	public List<JProgram> findProByLiveIdAndDate(String liveId,String ProgramListDate) throws SQLException {
		JProgram pro = new JProgram();
		List<JProgram> programs = new ArrayList<JProgram>();
		
//		JdbcConnection jdbcConnection = new JdbcConnection();
//		String sql = "select * from Live_Program_Info where liveId=? and ProgramListDate=?";
//		PreparedStatement stmt = jdbcConnection.createStatement(sql);
//			stmt.setString(1, liveId);
//			stmt.setString(2, ProgramListDate);
//			stmt.addBatch();
		JdbcConnection1 jdbcConnection = new JdbcConnection1();
		String sql = "select * from Live_Program_Info where liveId=\""+liveId+"\"and ProgramListDate=\""+ProgramListDate+"\"";
		Statement stmt = jdbcConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pro.setLiveId(rs.getString("liveId"));
				pro.setLiveListId(rs.getString("liveListId"));
				pro.setIsTaped(rs.getInt("isTaped"));
				pro.setProgramDate(rs.getString("ProgramListDate"));
				pro.setStartTime(rs.getString("startTime"));
				pro.setEndTime(rs.getString("endTime"));
				pro.setTitle(rs.getString("title"));
				pro.setLength(rs.getString("length"));
				pro.setScover(rs.getString("sCover"));
				pro.setCover(rs.getString("cover"));
				pro.setStatus(rs.getInt("status"));
				pro.setActivityId(rs.getString("activityId"));
				pro.setAdapter(rs.getString("adapter"));
				pro.setExt(rs.getString("ext"));
				programs.add(pro);
		}
		return programs;
	}

	@Override
	public void delProByLiveIdAndCreateTime(String liveId,String ProgramListDate) throws SQLException {
//		JdbcConnection jdbcConnection = new JdbcConnection();
//		String sql = "delete * from Live_Program_Info where liveId=? and ProgramListDate=?";
//		PreparedStatement stmt = jdbcConnection.createStatement(sql);
//			stmt.setString(1, liveId);
//			stmt.setString(2, ProgramListDate);
//			stmt.addBatch();
//			stmt.executeBatch();
		JdbcConnection1 jdbcConnection = new JdbcConnection1();
		String sql = "delete  from Live_Program_Info where liveId=\""+liveId+"\"and ProgramListDate=\""+ProgramListDate+"\"";
		Statement stmt = jdbcConnection.createStatement();
		stmt.executeUpdate(sql);
	}

	@Override
	public void insertPro(JProgram jProgram) throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		
		
		
		String sql = "insert into Live_Program_Info (liveId,ProgramListDate,liveListId,isTaped,startTime,endTime,title,length,scover,cover,status,activityId,adapter,ext) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = jdbcConnection.createStatement(sql);
		if (jProgram != null) {
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
					stmt.executeBatch();
			}
	}


}
