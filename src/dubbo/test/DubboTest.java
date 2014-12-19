package dubbo.test;



import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

import dubbo.test.dubbo.service.TestService;
import dubbo.test.dubbo.service.impl.TestServiceImpl;

public class DubboTest {
	
	public static void test(){
		// 服务实现
		TestService testService = new TestServiceImpl();
		 
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("test");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setRegister(true);
		registry.setAddress("localhost:2181");
		registry.setProtocol("zookeeper");
		
		application.setRegistry(registry);

//		registry.setUsername("aaa");
//		registry.setPassword("bbb");
		 
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("webservice");
		protocol.setPort(8080);
		protocol.setThreads(200);
		 
		 
		// 服务提供者暴露服务配置
		ServiceConfig<TestService> service = new ServiceConfig<TestService>(); 
		service.setApplication(application);
		service.setRegistry(registry); 
		service.setProtocol(protocol); 
		service.setInterface(TestService.class);
		service.setRef(testService);
		service.setVersion("1.0.0");
		 
		// 暴露及注册服务
		service.export();
//		service.unexport();
		
		System.out.println(service.isUnexported());
	}
	
	public static void test2(){
		// 服务实现
		TestService xxxService = new TestServiceImpl();
		 
		RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
		Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://localhost:2181"));
		
		
		registry.register(URL.valueOf("webservice://localhost:8080/com.foo.BarService?category=providers&dynamic=false&application=foo"));
//				registry.unregister(URL.valueOf("memcached://localhost:8080/com.foo.BarService?category=providers&dynamic=false&application=foo"));
		registry.destroy();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
