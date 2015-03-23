package com.tv189.domain;

public class Channel {
	
	  private String liveId;
	  private String categoryName;
	  private int plat;
	  private String title;
	  private int physicalType;
	  private String cpId;
	  private String spId;
	  private String seriesCount;
	  private String description;
	  private String parentId;
	  private String createTime;
	  private String updateTime;
	  
	public String getLiveId() {
		return liveId;
	}
	public void setLiveId(String liveId) {
		this.liveId = liveId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPlat() {
		return plat;
	}
	public void setPlat(int plat) {
		this.plat = plat;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getSeriesCount() {
		return seriesCount;
	}
	public void setSeriesCount(String seriesCount) {
		this.seriesCount = seriesCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
