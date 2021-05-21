# 2) Spring MVC구성요소-1

**들어가기 전에**

이번 시간엔 Spring MVC에서 가장 핵심적인 역할을 수행하는 DispatcherServlet이 어떤 순서로 동작하는지 살펴보도록 하겠습니다.

이를 통해서 Spring MVC에서 사용되는 컴포넌트들에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. DispatcherServlet이 어떤 순서로 동작하는지 이해한다.
2. DispatcherServlet에서 사용되는 컴포넌트(객체)들이 어떤 것들이 있는지 안다.

 

 

------

**핵심 개념**

- DispatcherServlet
- HandlerMapping
- HandlerAdapter
- ViewResolver

 

 

------

**학습하기**

**Spring MVC 기본 동작 흐름**

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_1.png)

- **Spring MVC 기본 동작 흐름**





**요청 처리를 위해 사용되는 컴포넌트**

- DispatcherServlet
  - HandlerMapping
  - HanderAdapter
  - MuiltpartResolver
  - LocaleResolver
  - ThemeResolver
  - HanderExceptionResolver
  - RequestToViewNameTranslator
  - ViewResolver
  - FlashMapManager

------

**참고 자료**

[**[참고링크\] Overview of Spring MVC Architecture**https://terasolunaorg.github.io](https://terasolunaorg.github.io/guideline/1.0.1.RELEASE/en/Overview/SpringMVCOverview.html)

[**[참고링크\] Modules**https://docs.spring.io](https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch01s02.html)

[**[참고링크\] Spring MVC - DispatcherServlet 동작 원리 출처: http://jess-m.tistory.com/15 [Jess's Home]**http://jess-m.tistory.com](http://jess-m.tistory.com/15)

[**[참고링크\] Spring DispatcherServlet의 기본 7가지 DI전략**http://kimddochi.tistory.com](http://kimddochi.tistory.com/86)

[ ![img](https://cphinf.pstatic.net/mooc/20180219_261/151900438006802DCv_JPEG/pEJs3PgwjklDD5acHu7a.jpg?type=mfullfill_199_148)**[참고링크\] Spring MVC – Full java based config**https://samerabdelkafi.wordpress.com](https://samerabdelkafi.wordpress.com/2014/08/03/spring-mvc-full-java-based-config/)

[**[참고링크\] web.xml vs Initializer with Spring**http://www.baeldung.com](http://www.baeldung.com/spring-xml-vs-java-config)

[**[참고링크\] Spring – Mixing XML and JavaConfig**https://www.mkyong.com](https://www.mkyong.com/spring/spring-mixing-xml-and-javaconfig/)

[ ![img](https://cphinf.pstatic.net/mooc/20180219_37/1519004424262VcnFy_JPEG/FYpOX6DaSR44ofFn7Wx6.jpg?type=mfullfill_199_148)**[참고링크\] arey/spring-javaconfig-sample**https://github.com](https://github.com/arey/spring-javaconfig-sample/blob/master/src/main/webapp/WEB-INF/web.xml)

[**[참고링크\] WebMvcConfigurationSupport**https://docs.spring.io](https://docs.spring.io/spring/docs/3.0.6.RELEASE_to_3.1.0.BUILD-SNAPSHOT/3.1.0.BUILD-SNAPSHOT/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.html)

[ ![img](https://cphinf.pstatic.net/mooc/20180219_15/1519004438201bo85U_JPEG/oKcxKI0ZsZiw6rOljZLN.jpg?type=mfullfill_199_148)**[참고링크\] Spring mvc (2) 그리고 Spring boot**http://wonwoo.ml](http://wonwoo.ml/index.php/post/1590)

[**[참고링크\] Migrate Spring MVC servlet.xml to Java Config**https://www.luckyryan.com](https://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/)

[**[참고링크\] Spring RequestMapping**http://www.baeldung.com](http://www.baeldung.com/spring-requestmapping)