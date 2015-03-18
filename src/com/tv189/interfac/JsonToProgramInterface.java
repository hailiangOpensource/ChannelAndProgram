package com.tv189.interfac;

import java.sql.SQLException;
import java.util.List;

import com.tv189.domain.JProgram;

public interface JsonToProgramInterface {

	List<JProgram> jsonToProgram(String jsonSrc) throws SQLException;
}
