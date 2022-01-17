# spring cloud
* admin (Spring Boot Admin 추가)
* gateway
* eureka server
* front app
* backend app

## admin 서버
* http://localhost:9999/

## 호출 흐름
* gateway:8888/goods/detail (or gateway:8889/goods/detail)
  * frontApp:8080/goods/detail
    * bacnendApp:9090,9091/goods
    * bacnendApp(Second):9093/options
    
 ## 예제 실행
 ```
./gradlew build

## Backend App start
java -jar -Dserver.port=9090 app-backend/build/libs/app-backend-0.0.1-SNAPSHOT.jar
java -jar -Dserver.port=9091 app-backend/build/libs/app-backend-0.0.1-SNAPSHOT.jar
java -jar -Dserver.port=9092 -Dspring.application.name=backendSecond app-backend/build/libs/app-backend-0.0.1-SNAPSHOT.jar

## Front App start
java -jar -Dserver.port=8080 app-front/build/libs/app-front-0.0.1-SNAPSHOT.war 

## Eureka Server start
java -jar eureka-server/build/libs/eureka-server-0.0.1-SNAPSHOT.jar
# 접속: http://localhost:8761/
# 인스턴스 등록 현황에 모두 등록되었는지 확인!!

## Gateway start (gateway)
java -jar gateway/build/libs/gateway-0.0.1-SNAPSHOT.jar
# 접속 http://localhost:8888/goods/detail
# 접속(rewrite) http://localhost:8888/goodsDetail

## Netflix Zuul start (gateway)
java -jar netflix-zuul/build/libs/netflix-zuul-0.0.1-SNAPSHOT.jar
# 접속 http://localhost:8889/goods/detail

## Spring Boot Admin Server start
java -jar admin/build/libs/admin-0.0.1-SNAPSHOT.jar
```