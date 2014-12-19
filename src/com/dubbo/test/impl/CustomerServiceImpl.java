package com.dubbo.test.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dubbo.test.CustomerService;
import com.dubbo.test.bean.CommuMsg;

public class CustomerServiceImpl implements CustomerService{  
    @Override  
    public String getName() {  
        System.out.print("我打印");  
        return "打印结果";  
    }

	@Override
	public String sendJSON(String json) {
		// TODO Auto-generated method stub
		System.out.println(json);
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("response", "OK");
		String result=JSON.toJSONString(jsonObject);
		
		System.out.println(result);
		return result;
	}  
	
	@Override
	public CommuMsg sendObj(CommuMsg msg) {
		// TODO Auto-generated method stub
		msg.setHeader("Result Msg!");
		return msg;
	}  
}  
