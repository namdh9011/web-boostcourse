# 2) Spring IoC/DI 컨테이너

**들어가기 전에**

이번 시간엔 스프링 프레임워크의 핵심 개념 중의 하나인 IoC와 DI에 대해 학습하도록 하겠습니다.

 

 

------

**학습 목표**

1. 컨테이너에 대한 개념을 이해한다.
2. IoC에 대한 개념을 이해한다.
3. DI에 대한 개념을 이해한다.

 

 

------

**핵심 개념**

- Container
- IoC (Inversion of Control)
- DI (Dependency Injection)

 

 

------

**학습하기**

**컨테이너(Container)**

컨테이너는 인스턴스의 생명주기를 관리하며, 생성된 인스턴스에게 추가적인 기능을 제공합니다.

예를 들어, Servlet을 실행해주는 WAS는 Servlet 컨테이너를 가지고 있다고 말합니다.

WAS는 웹 브라우저로부터 서블릿 URL에 해당하는 요청을 받으면, 서블릿을 메모리에 올린 후 실행합니다.

개발자가 서블릿 클래스를 작성했지만, 실제로 메모리에 올리고 실행하는 것은 WAS가 가지고 있는 Servlet 컨테이너입니다.

Servlet컨테이너는 동일한 서블릿에 해당하는 요청을 받으면, 또 메모리에 올리지 않고 기존에 메모리에 올라간 서블릿을 실행하여 그 결과를 웹 브라우저에게 전달합니다.

컨테이너는 보통 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하는 것을 말합니다.



**IoC(Inversion of Control)** 

컨테이너가 코드 대신 오브젝트의 제어권을 갖고 있어 IoC(제어의 역전)이라 합니다.

예를 들어, 서블릿 클래스는 개발자가 만들지만, 그 서블릿의 메소드를 알맞게 호출하는 것은 WAS입니다.

이렇게 개발자가 만든 어떤 클래스나 메소드를 다른 프로그램이 대신 실행해주는 것을 제어의 역전이라고 합니다.

 

**DI(Dependency Injection)**

DI는 의존성 주입이란 뜻을 가지고 있으며, 클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것을 말합니다.

 

**DI가 적용 안 된 예**

개발자가 직접 인스턴스를 생성합니다.

```java
class 엔진 {

}

class 자동차 {
     엔진 v5 = new 엔진();
}
```



![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/2_1.jpg)

**Spring에서 DI가 적용된 예**

엔진 type의 v5변수에 아직 인스턴스가 할당되지 않았습니다.

컨테이너가 v5변수에 인스턴스를 할당해주게 됩니다.

```java
@Component
class 엔진 {

}

@Component
class 자동차 {
     @Autowired
     엔진 v5;
}
```

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/2_2.jpg)

**Spring에서 제공하는 IoC/DI 컨테이너**

- BeanFactory : IoC/DI에 대한 기본 기능을 가지고 있습니다.
- ApplicationContext : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천됩니다. 트랜잭션처리, AOP등에 대한 처리를 할 수 있습니다. BeanPostProcessor, BeanFactoryPostProcessor등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 습니다.

- BeanPostProcessor : 컨테이너의 기본로직을 오버라이딩하여 인스턴스화 와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 합니다.

- BeanFactoryPostProcessor : 설정된 메타 데이터를 커스터마이징 할 수 있습니다.

  

 

------

**생각해보기**

1. 스프링 프레임워크는 DI Container라고도 말을 합니다. 스프링 프레임워크 이외에도 DI Container는 존재할까요?

 

 

------

**참고 자료**

[**[참고링크\] Spring - IoC & DI**http://isstory83.tistory.com](http://isstory83.tistory.com/91)

[ ![img](https://cphinf.pstatic.net/mooc/20180201_158/1517460788486yvBJi_PNG/lVj4LX3tpD7vajNBs8b0.png?type=mfullfill_199_148)**[참고링크\] 세 가지 DI 컨테이너로 향하는 저녁 산책**http://www.nextree.co.kr](http://www.nextree.co.kr/p11247/)