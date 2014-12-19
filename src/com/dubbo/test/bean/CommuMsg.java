package com.dubbo.test.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommuMsg implements Serializable{
	
	private String header;
	
	private String body;
	
	private String[] paramNameList;
	
	private List<String> params=new ArrayList<String>();
	
	private Date createTime;
	
	public CommuMsg(){
		header="dddddddddddddddddddddd";
		body="dddddddddsssssssssssssssssdddddddddddddddddd";
		paramNameList=new String[]{"A","B","C","D"};
		createTime=new Date();
		params.add("aaaaaaaaaaaaaaaaa");
		params.add("bbbbbbbbbbbbbbbbbb");
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String[] getParamNameList() {
		return paramNameList;
	}

	public void setParamNameList(String[] paramNameList) {
		this.paramNameList = paramNameList;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
