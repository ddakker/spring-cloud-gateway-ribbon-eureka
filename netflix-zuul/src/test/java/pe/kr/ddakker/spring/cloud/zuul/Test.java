package pe.kr.ddakker.spring.cloud.zuul;

import java.net.URI;

public class Test {
    public static void main(String[] args) {
        try {
//            System.out.println(new URL("/test?a=b"));
            System.out.println("1: " + new URI("/test?a=b"));
            System.out.println("2: " + new URI("http://localhost:8080/test?a=b"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
