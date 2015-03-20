package com.tv189.interfac;

import java.sql.SQLException;
import java.util.List;

import com.tv189.domain.JProgram;
import com.tv189.domain.Program;

public interface ProgramCRUDInterface {

	List<JProgram> findProByLiveIdAndDate(String liveId,String ProgramListDate) ;
	void delProByLiveIdAndCreateTime(List<JProgram> jprograms);
	void insertPro(List<JProgram> jPrograms) ;
//	void delProByLiveIdAndCreateTime(String liveId, String programDate);
}
