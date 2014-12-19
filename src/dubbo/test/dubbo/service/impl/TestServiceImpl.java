package dubbo.test.dubbo.service.impl;

import dubbo.test.dubbo.service.TestService;

public class TestServiceImpl implements TestService{

	@Override
	public void testService(String param) {
		// TODO Auto-generated method stub
		System.out.println("调用TestService成功！");
	}

}
