package com.tv189.interfacImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.interfac.ProgramCRUDInterface;
import com.tv189.tools.JdbcConnection;

public class ProgramCRUDInterfaceImpl implements ProgramCRUDInterface{
	@Override
	public List<JProgram> findProByLiveIdAndDate(String liveId,String ProgramListDate) {
		JProgram pro = new JProgram();
		List<JProgram> programs = new ArrayList<JProgram>();
		
		Connection conn = JdbcConnection.getDBConnection();
		String sql = "select liveId,ProgramListDate from Live_Program_Info where liveId=\""+liveId+"\"and ProgramListDate=\""+ProgramListDate+"\"";
		Statement pstmt = null;
		ResultSet rs;
		try {
			pstmt=conn.createStatement();
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				pro.setLiveId(rs.getString("liveId"));
				pro.setProgramDate(rs.getString("ProgramListDate"));
				programs.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, pstmt, null);
		}
		return programs;
	}

	@Override
	public void delProByLiveIdAndCreateTime(List<JProgram> jprograms)  {
		Connection conn=JdbcConnection.getDBConnection();
		String sql = "delete  from Live_Program_Info where liveId=?and ProgramListDate=?";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			for(JProgram jProgram:jprograms){
				pstmt.setString(1, jProgram.getLiveId());
				pstmt.setString(2, jProgram.getProgramDate());
				pstmt.addBatch();
			}
			pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, pstmt, null);
		}
	}

	@Override
	public void insertPro(List<JProgram> jPrograms){
		Connection conn=JdbcConnection.getDBConnection();
		String sql = "insert into Live_Program_Info (liveId,ProgramListDate,liveListId,isTaped,startTime,endTime,title,length,scover,cover,status,activityId,adapter,ext) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = JdbcConnection.createPreparedStatement(sql);
		try {
			for(JProgram jProgram:jPrograms){
				pstmt.setString(1, jProgram.getLiveId());
				pstmt.setString(2, jProgram.getProgramDate());
				pstmt.setString(3, jProgram.getLiveListId());
				pstmt.setInt(4, jProgram.getIsTaped());
				pstmt.setString(5, jProgram.getStartTime());
				pstmt.setString(6, jProgram.getEndTime());
				pstmt.setString(7, jProgram.getTitle());
				pstmt.setString(8, jProgram.getLength());
				pstmt.setString(9, jProgram.getScover());
				pstmt.setString(10, jProgram.getCover());
				pstmt.setInt(11, jProgram.getStatus());
				pstmt.setString(12, jProgram.getActivityId());
				pstmt.setString(13, jProgram.getAdapter());
				pstmt.setString(14, jProgram.getExt());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.closeAll(conn, pstmt, null);
		}

	}

	


}
