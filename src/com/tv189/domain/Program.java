package com.tv189.domain;

import java.util.List;

public class Program {
	
	private String date;
	private String liveId;
	private List<JProgram> programs;
	public String getLiveId() {
		return liveId;
	}
	public void setLiveId(String liveId) {
		this.liveId = liveId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<JProgram> getPrograms() {
		return programs;
	}
	public void setPrograms(List<JProgram> programs) {
		this.programs = programs;
	}
}
