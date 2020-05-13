package pe.kr.ddakker.spring.cloud.front.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontUIController {
	/*@LoadBalanced
	@Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	@Autowired
    RestTemplate restTemplate;

	@RequestMapping("/index")
	public String index() {
		System.out.println("index");
		return "index";
	}

	@RequestMapping("/goods/detail")
	public String detail() {
		String randomString = this.restTemplate.getForObject("http://backend/goods", String.class);
		String result = "Response :: " + randomString;

		try {
			randomString = this.restTemplate.getForObject("http://backendSecond/goods/options", String.class);
			result += "\n\nResponse :: " + randomString;
			System.out.println("hi end result2: " + result);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return result;
	}
}
