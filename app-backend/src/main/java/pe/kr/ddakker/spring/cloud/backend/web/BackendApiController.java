package pe.kr.ddakker.spring.cloud.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
	public String goods(HttpServletRequest request) {
		String t = request.getParameter("t");
		System.out.println("backend api goods t: " + t);
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key =  parameterNames.nextElement();
			System.out.println("param: " + key + "=" + request.getParameter(key));
		}
		System.out.println("header h: " + request.getHeader("h"));
		System.out.println("header khan.tid: " + request.getHeader("khan.tid"));

		String serverPort = environment.getProperty("local.server.port");
		
		return "goods - appName: " + appName + ", serverPort: " + serverPort;
	}

	@GetMapping("/goods/options")
	public String goodsOptions() {
		System.out.println("backend api goods");
		String serverPort = environment.getProperty("local.server.port");

		return "goodsOptions - appName: " + appName + ", serverPort: " + serverPort;
	}

	@GetMapping("/api/test1")
	public Backend api_test1() {
		return new Backend(1, "ddakker");
	}
}
