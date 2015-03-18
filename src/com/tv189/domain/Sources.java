package com.tv189.domain;

import java.util.Date;

public class Sources {

	private String liveId;
	private String name;
	private int plats;
	private String pinyin;
	private int physicalType;
	private String cpId;
	private String spId;
	private String scover;
	private String description;
	private String nodeId;
	private Date createTime;
	private Date updateTime;
	
	public String getLiveId() {
		return liveId;
	}
	public void setLiveId(String liveId) {
		this.liveId = liveId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlats() {
		return plats;
	}
	public void setPlats(int plats) {
		this.plats = plats;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public int getPhysicalType() {
		return physicalType;
	}
	public void setPhysicalType(int physicalType) {
		this.physicalType = physicalType;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getSpId() {
		return spId;
	}
	public void setSpId(String spId) {
		this.spId = spId;
	}
	public String getScover() {
		return scover;
	}
	public void setScover(String scover) {
		this.scover = scover;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
