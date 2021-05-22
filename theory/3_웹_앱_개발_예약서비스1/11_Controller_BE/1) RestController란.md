# 1) RestController란?

**들어가기 전에**

이번 시간엔 Rest API를 Spring MVC를 이용해 작성하려면 어떻게 해야 하는지 방법에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. Spring MVC를 이용해 Rest API를 작성하는 방법에 대해 이해합니다.

 

 

------

**핵심 개념**

- Rest API
- Web API
- @RestController
- MessageConvert

 

 

------

**학습하기**

**@RestController**

- Spring 4 에서 Rest API 또는 Web API를 개발하기 위해 등장한 애노테이션합니다.
- 이전 버전의 @Controller와 @ResponseBody를 포함합니다.

 

**MessageConvertor**

- 자바 객체와 HTTP 요청 / 응답 바디를 변환하는 역할
- @ResponseBody, @RequestBody
- @EnableWebMvc 로 인한 기본 설정
- WebMvcConfigurationSupport 를 사용하여 Spring MVC 구현
- Default MessageConvertor 를 제공
- [링크 바로가기](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java) 의 addDefaultHttpMessageConverters메소드 항목 참조

 

**MessageConvertor 종류**

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/11_Controller_BE/image/1_1.png)

- **MessageConvertor 종류**

**JSON 응답하기**

- 컨트롤러의 메소드에서는 JSON으로 변환될 객체를 반환합니다.
- jackson라이브러리를 추가할 경우 객체를 JSON으로 변환하는 메시지 컨버터가 사용되도록 @EnableWebMvc에서 기본으로 설정되어 있습니다.
- jackson라이브러리를 추가하지 않으면 JSON메시지로 변환할 수 없어 500오류가 발생합니다.
- 사용자가 임의의 메시지 컨버터(MessageConverter)를 사용하도록 하려면 WebMvcConfigurerAdapter의 configureMessageConverters메소드를 오버라이딩 하도록 합니다.

 

 

------

**생각해보기**

1. Web API에서 JSON메시지를 자주 사용하는 이유는 무엇일까요?
2. JSON메시지의 장점에 대해 찾아보세요.

 

 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180219_63/1519025015398PgpAE_PNG/5wN8YGqO2YXAWDQ582wg.png?type=mfullfill_199_148)**[참고링크\] spring-projects/spring-framework**https://github.com](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java)

[**[참고링크\] Building a RESTful Web Service**https://spring.io](https://spring.io/guides/gs/rest-service/)

[**[참고링크\] Building REST services with Spring**https://spring.io](https://spring.io/guides/tutorials/bookmarks/)