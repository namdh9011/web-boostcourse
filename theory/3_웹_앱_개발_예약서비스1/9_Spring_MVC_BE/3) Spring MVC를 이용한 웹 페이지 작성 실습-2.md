# 3) Spring MVC를 이용한 웹 페이지 작성 실습-2

**들어가기 전에**

이번 시간엔 Spring MVC를 이용하여 웹 어플리케이션을 작성하는 방법에 대하여 실습을 통해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

- Spring MVC를 이용해 프로젝트를 구성할 수 있고, 개발자가 작성해야 할 파일이 무엇인지 이해한다.
- Spring MVC를 이용해 웹 어플리케이션을 작성할 수 있다.

 

 

------

**핵심 개념**

- DispacherServlet
- WebApplicationInitializer
- @RequestMapping = @GetMapping = @PostMapping



 

------

**학습하기**

**노트**

- mvcexam 에 패키지 생성 kr.or.connect.mvcexam.config
- WebMvcContextConfiguration.java 파일에 WebMvcConfigurerAdapter 상속받게 생성
- @Configuration, @EnableWebMvc, ComponentScan(bascpackages) 어노테이션 추가.
- 프런트 컨트롤러 코드 작성.
- DispatcherServlet를 FrontController로 설정해주기 위해서 web.xml파일 설정
- web-INF 폴더에 views - main.jsp 만들어줌
- 그냥 실행시키면 index.jsp 파일이 실행된다. web 프로젝트가 무조건 index.jsp를 우선실행시키기 때문인다. 지워버리면 된다.



**DispatcherServlet을 FrontController로 설정하기**

- web.xml 파일에 설정
- javax.servlet.ServletContainerInitializer 사용
  \- 서블릿 3.0 스펙 이상에서 web.xml파일을 대신해서 사용할 수 있다.
- org.springframework.web.WebApplicationInitializer 인터페이스를 구현해서 사용

 

**web.xml파일에서 DispatcherServlet 설정하기 1/2**

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/3_1.png)

- **xml spring 설정 읽어들이도록 DispathcerServlet설정**

![3_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/3_2.png)

- **Java config spring 설정 읽어들이도록 DispathcerServlet설정**

**WebApplicationInitializer를 구현해서 설정하기 1/2**

- Spring MVC는 ServletContainerInitializer를 구현하고 있는 SpringServletContainerInitializer를 제공한다.
- SpringServletContainerInitializer는 WebApplicationInitializer 구현체를 찾아 인스턴스를 만들고 해당 인스턴스의 onStartup 메소드를 호출하여 초기화한다.

![3_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/3_3.png)

- **WebApplicationInitializer를 구현해서 설정하기 2/2**

**Spring MVC 설정**

- kr.or.connect.webmvc.config.WebMvcContextConfiguration

![3_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/3_4.png)

- **Spring MVC 설정**

**@Configuration**

- org.springframework.context.annotation의 Configuration 애노테이션과 Bean 애노테이션 코드를 이용하여 스프링 컨테이너에 새 로운 빈 객체를 제공할 수 있다.

 

**@EnableWebMvc**

- DispatcherServlet의 RequestMappingHandlerMapping, RequestMappingHandlerAdapter, ExceptionHandlerExceptionResolver, MessageConverter 등 Web에 필요한 빈들을 대부분 자동으로 설정해준다.
- xml로 설정의 <mvc:annotation-driven/> 와 동일하다.
- 기본 설정 이외의 설정이 필요하다면 WebMvcConfigurerAdapter 를 상속받도록 Java config class를 작성한 후, 필요한 메소드를 오버라이딩 하도록 한다.

![3_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/3_5.png)

- **@EnableWebMVC**

**WebMvcConfigurationSupport**

- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java

 

**@ComponentScan**

- ComponentScan애노테이션을 이용하면 Controller, Service, Repository, Component애노테이션이 붙은 클래스를 찾아 스프링 컨테이너가 관리하게 된다.
- DefaultAnnotationHandlerMapping과 RequestMappingHandlerMapping구현체는 다른 핸드러 매핑보다 훨씬 더 정교한 작업을 수행한다. 이 두 개의 구현체는 애노테이션을 사용해 매핑 관계를 찾는 매우 강력한 기능을 가지고 있다. 이들 구현체는 스프링 컨테이너 즉 애플리케이션 컨텍스트에 있는 요청 처리 빈에서 RequestMapping애노테이션을 클래스나 메소드에서 찾아 HandlerMapping객체를 생성하게 된다.
- HandlerMapping은 서버로 들어온 요청을 어느 핸들러로 전달할지 결정하는 역할을 수행한다.
- DefaultAnnotationHandlerMapping은 DispatcherServlet이 기본으로 등록하는 기본 핸들러 맵핑 객체이고, RequestMappingHandlerMapping은 더 강력하고 유연하지만 사용하려면 명시적으로 설정해야 한다.

 

**WebMvcConfigurerAdapter**

- org.springframework.web.servlet.config.annotation. WebMvcConfigurerAdapter
- @EnableWebMvc 를 이용하면 기본적인 설정이 모두 자동으로 되지만, 기본 설정 이외의 설정이 필요할 경우 해당 클래스를 상속 받은 후, 메소드를 오버라이딩 하여 구현한다.

 

**Controller(Handler) 클래스 작성하기**

- @Controller 애노테이션을 클래스 위에 붙인다.
- 맵핑을 위해 @RequestMapping 애노테이션을 클래스나 메소드에서 사용한다.

 

**@RequestMapping**

- Http 요청과 이를 다루기 위한 Controller 의 메소드를 연결하는 어노테이션
- Http Method 와 연결하는 방법
   \- @RequestMapping(value="/users", method=RequestMethod.POST)
   \- From Spring 4.3 version (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping)
- Http 특정 해더와 연결하는 방법
   \- @RequestMapping(method = RequestMethod.GET, headers = "content-type=application/json")
- Http Parameter 와 연결하는 방법
   \- @RequestMapping(method = RequestMethod.GET, params = "type=raw")
- Content-Type Header 와 연결하는 방법
   \- @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
- Accept Header 와 연결하는 방법
   \- @RequestMapping(method = RequestMethod.GET, produces = "application/json")



 

------

**실습 코드**

WebMvcContextConfiguration.java

```java
package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main");
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
```

 

web.xml

```markup
<?xml version="1.0" encoding="UTF-8"?>
<web-app>

  <display-name>Spring JavaConfig Sample</display-name>

  <servlet>
    <servlet-name>mvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextClass</param-name>
      <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>kr.or.connect.mvcexam.config.WebMvcContextConfiguration</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>mvc</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>


</web-app>
```

 

main.jsp

```markup
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>main page~~~!!</h1>
</body>
</html>
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180219_1/1519005924957WqtFg_PNG/vqqCHR7IDcLcwZlBXyTy.png?type=mfullfill_199_148)**[참고링크\] WebMvcConfigurationSupport**https://github.comspring-framework - Spring Framework](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java)

[ ![img](https://cphinf.pstatic.net/mooc/20201031_256/1604145705905xXxMU_PNG/q9gfPyjYUOAduHyy97OX.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)