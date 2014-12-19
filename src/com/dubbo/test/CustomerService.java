package com.dubbo.test;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.dubbo.test.bean.CommuMsg;

public interface CustomerService {  
    public String getName();  
    
    public String sendJSON(String json);
    
    public CommuMsg sendObj(CommuMsg msg);
}
