# 2) Spring MVC구성요소-2

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

**DispatcherServlet**

- 프론트 컨트롤러 (Front Controller)
- 클라이언트의 모든 요청을 받은 후 이를 처리할 핸들러에게 넘기고 핸들러가 처리한 결과를 받아 사용자에게 응답 결과를 보여준다.
- DispathcerServlet은 여러 컴포넌트를 이용해 작업을 처리한다.





![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_2.png)

- **DispatcherServlet 내부 동작흐름**

**요청 선처리 작업시 사용된 컴포넌트**

**org.springframework.web.servlet.LocaleResolver**

- 지역 정보를 결정해주는 전략 오브젝트이다.
- 디폴트인 AcceptHeaderLocalResolver는 HTTP 헤더의 정보를 보고 지역정보를 설정해준다.

**org.springframework.web.servlet.FlashMapManager**

- FlashMap객체를 조회(retrieve) & 저장을 위한 인터페이스
- RedirectAttributes의 addFlashAttribute메소드를 이용해서 저장한다.
- 리다이렉트 후 조회를 하면 바로 정보는 삭제된다.

**org.springframework.web.context.request.RequestContextHolder**

- 일반 빈에서 HttpServletRequest, HttpServletResponse, HttpSession 등을 사용할 수 있도록 한다.
- 해당 객체를 일반 빈에서 사용하게 되면, Web에 종속적이 될 수 있다.

**org.springframework.web.multipart.MultipartResolver**

- 멀티파트 파일 업로드를 처리하는 전략

![2_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_3.png)

- **DispatcherServlet 내부 동작흐름 상세 - 요청 선처리 작업**

**요청 전달시 사용된 컴포넌트**

org.springframework.web.servlet.HandlerMapping

- HandlerMapping구현체는 어떤 핸들러가 요청을 처리할지에 대한 정보를 알고 있다.
- 디폴트로 설정되는 있는 핸들러매핑은 BeanNameHandlerMapping과 DefaultAnnotationHandlerMapping 2가지가 설정되어 있다.

org.springframework.web.servlet.HandlerExecutionChain

- HandlerExecutionChain구현체는 실제로 호출된 핸들러에 대한 참조를 가지고 있다.
- 즉, 무엇이 실행되어야 될지 알고 있는 객체라고 말할 수 있으며, 핸들러 실행전과 실행후에 수행될 HandlerInterceptor도 참조하고 있다.

org.springframework.web.servlet.HandlerAdapter

- 실제 핸들러를 실행하는 역할을 담당한다.
- 핸들러 어댑터는 선택된 핸들러를 실행하는 방법과 응답을 ModelAndView로 변화하는 방법에 대해 알고 있다.
- 디폴트로 설정되어 있는 핸들러어댑터는 HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, AnnotationMethodHanlderAdapter 3가지이다.
- @RequestMapping과 @Controller 애노테이션을 통해 정의되는 컨트롤러의 경우 DefaultAnnotationHandlerMapping에 의해 핸들러가 결정되고, 그에 대응되는 AnnotationMethodHandlerAdapter에 의해 호출이 일어난다.

![2_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_4.png)

- **DispatcherServlet 내부 동작흐름 상세 - 요청 전달**

**요청 처리시 사용된 컴포넌트**

**org.springframework.web.servlet.ModelAndView**

- ModelAndView는 Controller의 처리 결과를 보여줄 view와 view에서 사용할 값을 전달하는 클래스이다.

**org.springframework.web.servlet.RequestToViewNameTranslator**

- 컨트롤러에서 뷰 이름이나 뷰 오브젝트를 제공해주지 않았을 경우 URL과 같은 요청정보를 참고해서 자동으로 뷰 이름을 생성해주는 전략 오브젝트이다. 디폴트는 DefaultRequestToViewNameTranslator이다.

 

![2-5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_5.png)

- **DispatcherServlet 내부 동작흐름 상세 - 요청 처리**

**예외 처리시 사용된 컴포넌트**

**org.springframework.web.servlet.handlerexceptionresolver**

- 기본적으로 DispatcherServlet이 DefaultHandlerExceptionResolver를 등록한다.
- HandlerExceptionResolver는 예외가 던져졌을 때 어떤 핸들러를 실행할 것인지에 대한 정보를 제공한다.

![2_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_6.png)

- **DispatcherServlet 내부 동작흐름 상세 - 예외처리**

**뷰 렌더링 과정시 사용된 컴포넌트**

**org.springframework.web.servlet.ViewResolver**

- 컨트롤러가 리턴한 뷰 이름을 참고해서 적절한 뷰 오브젝트를 찾아주는 로직을 가진 전략 오프젝트이다.
- 뷰의 종류에 따라 적절한 뷰 리졸버를 추가로 설정해줄 수 있다.

![2_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_7.png)

- **DispatcherServlet 내부 동작흐름 상세 - 뷰 렌더링 과정**

![2_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/2_8.png)

- **DispatcherServlet 내부 동작흐름 상세 - 요청 처리 종료**

 

 

------

**생각해보기**

1. DispatcherServlet은 요청을 받은 후, 요청을 처리하기 위해서 여러가지 작업을 수행하고 있습니다. 
2. 개발자는 DispatcherServlet이 어떤 방식으로 동작하는지 이해한다면 좀 더 잘 Spring MVC를 잘 사용할 수 있습니다.
3. Spring외에 다른 프레임워크를 학습할 때에도, 해당 프레임워크의 동작원리를 이해하는 것은 굉장히 중요합니다.
4. 어떻게 하면, 다른 사람이 만든 라이브러리나 프레임워크를 좀 더 잘 이해할 수 있을지 고민해보세요.

 

 

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