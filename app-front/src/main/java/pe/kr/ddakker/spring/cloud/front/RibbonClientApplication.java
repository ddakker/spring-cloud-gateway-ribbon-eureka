package pe.kr.ddakker.spring.cloud.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "backend", configuration = RibbonConfiguration.class),
        @RibbonClient(name = "backendSecond", configuration = RibbonConfiguration.class)
})
public class RibbonClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
        System.out.println("");
    }
}