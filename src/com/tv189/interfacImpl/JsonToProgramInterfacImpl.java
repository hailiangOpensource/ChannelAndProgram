package com.tv189.interfacImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tv189.interfac.JsonToProgramInterface;
import com.tv189.tools.JsonUtil;
import com.tv189.domain.JProgram;
import com.tv189.domain.Program;

public class JsonToProgramInterfacImpl implements JsonToProgramInterface {

	@Override
	public List<JProgram> jsonToProgram(String jsonSrc) throws SQLException {
		Program program = new Program();
		List<JProgram> jProgramList = new ArrayList<JProgram>();
		program = (Program) JsonUtil.jsonToProgramList(jsonSrc);
		jProgramList = program.getPrograms();
		

		return jProgramList;
	}

}
