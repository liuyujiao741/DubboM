package com.dubbo.test;

import com.dubbo.test.bean.CommuMsg;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class TestMain {
	public static void main(String[] args){
		JSONObject jsonObject=JSONObject.fromObject(new CommuMsg());
		
		String jsonStr=jsonObject.toString();
		System.out.println(jsonStr);
		
		CommuMsg msg=(CommuMsg) JSONObject.toBean(JSONObject.fromObject(jsonStr),CommuMsg.class);
		
		jsonObject=JSONObject.fromObject(msg);
		
		System.out.println(jsonObject.toString());
	}
}
