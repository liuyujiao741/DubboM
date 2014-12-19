package com.dubbo.test.impl;

import com.dubbo.test.HelloService;

public class HelloServiceImpl implements HelloService
{
	public String sayHello(String name)
	{
		return "Hello " + name;
	}
}
