package pe.kr.ddakker.spring.cloud.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendApiController {

	@Value("${spring.application.name}")
    String appName;

	@Autowired
    Environment environment;

	@GetMapping("/")
	public String health() {
		return "I am Ok";
	}

	@GetMapping("/goods")
	public String goods() {
		System.out.println("backend api goods");
		String serverPort = environment.getProperty("local.server.port");
		
		return "goods - appName: " + appName + ", serverPort: " + serverPort;
	}

	@GetMapping("/goods/options")
	public String goodsOptions() {
		System.out.println("backend api goods");
		String serverPort = environment.getProperty("local.server.port");

		return "goodsOptions - appName: " + appName + ", serverPort: " + serverPort;
	}
}
