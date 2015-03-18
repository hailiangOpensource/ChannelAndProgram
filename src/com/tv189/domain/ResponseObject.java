package com.tv189.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseObject implements Serializable{
	private String code;
	private String msg;
	private Object info;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public ResponseObject(String code, String msg, Object info) {
		super();
		this.code = code;
		this.msg = msg;
		this.info = info;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseObject(){
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
}
