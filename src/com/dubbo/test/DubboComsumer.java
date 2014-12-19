package com.dubbo.test;

import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.test.bean.CommuMsg;

public class DubboComsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				 new String[] {"applicationConsumer.xml"});


	        context.start();
	        CustomerService demoService = (CustomerService)context.getBean("demoService"); // get service invocation proxy

	        CommuMsg hello=demoService.sendObj(new CommuMsg());
	        System.out.println( JSONObject.fromObject(hello).toString() ); // cool, how are you~
	}

}
