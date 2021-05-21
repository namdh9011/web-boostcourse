# 1) Spring MVC란?

**들어가기 전에**

이번 시간엔 Spring 프레임워크에서 웹 어플리케이션 작성을 위해 제공하는 Web MVC모듈에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. MVC Model 1과 MVC Model 2 구조의 차이점에 대해 이해합니다.
2. 발전된 형태의 MVC Model2 구조에 대해 이해합니다.

 

 

------

**핵심 개념**

- MVC Model 1
- MVC Model 2
- Spring MVC

 

 

------

**학습하기**

**MVC란?**

- MVC는 Model-View-Controller의 약자입니다.
- 원래는 제록스 연구소에서 일하던 트뤼그베 린즈커그가 처음으로 소개한 개념으로, 데스트톱 어플리케이션용으로 고안되었습니다.
- Model : 모델은 뷰가 렌더링하는데 필요한 데이터입니다. 예를 들어 사용자가 요청한 상품 목록이나, 주문 내역이 이에 해당합니다.
- View : 웹 애플리케이션에서 뷰(View)는 실제로 보이는 부분이며, 모델을 사용해 렌더링을 합니다. 뷰는 JSP, JSF, PDF, XML등으로 결과를 표현합니다.
- Controller : 컨트롤러는 사용자의 액션에 응답하는 컴포넌트입니다. 컨트롤러는 모델을 업데이트하고, 다른 액션을 수행합니다.

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/1_1.png)

- **MVC Model 1 아키텍처**

![1_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/1_2.png)

- **MVC Model 2 아키텍처**

![1_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/1_3.png)

- **MVC Model2 발전형태**

![1_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/9_Spring_MVC_BE/image/1_4.png)

- **Spring Web Module**

  Model2 MVC 패턴을 지원하는 Spring Module 

 

 

------

**생각해보기**

1. 프론트 컨트롤러(Front Controller)는 모든 요청을 받아 들여 공통적인 작업을 처리해 줍니다. 이를 통해 얻을 수 있는 장점엔 어떤 것이 있을 수 있을까요?

 

 

------

**참고 자료**

[**[참고링크\] Web MVC framework**https://docs.spring.io](https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html)

[**[참고링크\] MVC Model2 | Opendocs**http://myblog.opendocs.co.kr](http://myblog.opendocs.co.kr/archives/tag/mvc-model2)

[**[참고링크\] Model 1 and Model 2 (MVC) Architecture**https://www.javatpoint.com](https://www.javatpoint.com/model-1-and-model-2-mvc-architecture)

[**[참고링크\] Modules**https://docs.spring.io](https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch01s02.html)

[**[참고링크\] IBM Knowledge Center**https://www.ibm.com](https://www.ibm.com/support/knowledgecenter/SSRTLW_9.1.1/com.ibm.etools.struts.doc/topics/cstrdoc001.html)