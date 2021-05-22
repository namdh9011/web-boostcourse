# 3) Spring MVC를 이용한 웹 페이지 작성 실습-1

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

- maven project - webapp - mvcexam project 생성
- java 폴더 생성
- pom.xml에 플러그인, jsp servlet, Spring, webmvc
- .settings 에 core.xml에 가서 버전을 3.1로 바꿔줌
- 이클립스 재시작하고 properties에 fect에 가서 버전확인

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180219_1/1519005924957WqtFg_PNG/vqqCHR7IDcLcwZlBXyTy.png?type=mfullfill_199_148)**[참고링크\] WebMvcConfigurationSupport**https://github.comspring-framework - Spring Framework](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java)

[ ![img](https://cphinf.pstatic.net/mooc/20201031_220/16041456742168pyN0_PNG/xsfzeo3FxGBhxNZ2dgSo.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)