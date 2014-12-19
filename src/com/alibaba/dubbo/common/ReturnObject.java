package com.alibaba.dubbo.common;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ReturnObject")
public class ReturnObject implements Serializable {
	int returnStatus=1;
	String returnStatusStr="成功";		
	Object returnInfo;
	
	public int getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}
	public String getReturnStatusStr() {
		return returnStatusStr;
	}
	public void setReturnStatusStr(String returnStatusStr) {
		this.returnStatusStr = returnStatusStr;
	}
	public Object getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(Object returnInfo) {
		this.returnInfo = returnInfo;
	}
}
