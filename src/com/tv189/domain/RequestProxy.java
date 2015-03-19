package com.tv189.domain;

public class RequestProxy {
	private String synctype;
	private String method;
	private String content;
	
	public RequestProxy(String synctype, String method, String content) {
		super();
		this.synctype = synctype;
		this.method = method;
		this.content = content;
	}
	public String getSynctype() {
		return synctype;
	}
	public void setSynctype(String synctype) {
		this.synctype = synctype;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
