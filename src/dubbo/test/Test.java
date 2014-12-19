package dubbo.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.RegistryService;
import com.alibaba.dubbo.registry.multicast.MulticastRegistry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"dubbo://10.20.153.10/com.alibaba.foo.BarService?version=1.0.0&application=kylin"
		URL url=new URL("webservice","172.16.12.50",8080);
		url.addParameter("anyhost", true);
		url.addParameter("check", false);
		url.addParameter("application", "bonc_etl_provider");
		url.setServiceInterface("testService");
		RegistryService register=new MulticastRegistry(url);
	}

}
