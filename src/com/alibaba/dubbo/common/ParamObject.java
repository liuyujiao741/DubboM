package com.alibaba.dubbo.common;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ParamObject")
public class ParamObject implements Serializable {
	String token;
	
	Object objectInfo;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getObjectInfo() {
		return objectInfo;
	}
	public void setObjectInfo(Object objectInfo) {
		this.objectInfo = objectInfo;
	}
	
}
