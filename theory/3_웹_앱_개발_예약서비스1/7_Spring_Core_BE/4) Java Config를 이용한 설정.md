# 4) Java Config를 이용한 설정

**들어가기 전에**

이번 시간엔 Java Config와 어노테이션을 이용해 스프링에서 사용하는 빈을 정의하고 DI하는 방법에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. JavaConfig형태의 설정파일의 내용을 이해할 수 있습니다.
2. @ComponentScan, @Component, @Autowired 어노테이션의 쓰임새에 대해 이해합니다.

 

 

------

**핵심 개념**

- AnnotationConfigApplicationContext
- @Configuration
- @ComponentScan
- @Component
- @Autowired

 

 

------

**학습하기**

**노트**

- ApplicationConfig.java 파일 생성

- ApplicationContextExam03 파일 생성
- ApplicationConfig2.java 파일 생성

**Java config를 이용한 설정을 위한 어노테이션**

**@Configuration**

- 스프링 설정 클래스를 선언하는 어노테이션

**@Bean**

- bean을 정의하는 어노테이션

**@ComponentScan**

- @Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록

**@Component**

- 컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션

**@Autowired**

- 주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션

**Java Config를 이용해 설정하기**

**ApplicationConfig.java**

```java
package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
```

@Configuration 은 스프링 설정 클래스라는 의미를 가집니다.

JavaConfig로 설정을 할 클래스 위에는 @Configuration가 붙어 있어야 합니다.

ApplicationContext중에서 AnnotationConfigApplicationContext는 JavaConfig클래스를 읽어들여 IoC와 DI를 적용하게 됩니다.

이때 설정파일 중에 @Bean이 붙어 있는 메소드들을 AnnotationConfigApplicationContext는 자동으로 실행하여 그 결과로 리턴하는 객체들을 기본적으로 싱글턴으로 관리를 하게 됩니다.



**ApplicationContextExam03.java**

```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		   
		Car car = (Car)ac.getBean("car");
		car.run();
		
	}
}
```

파라미터로 요청하는 class 타입으로 지정 가능합니다.

Car car = ac.getBean(Car.class);



**ApplicationConfig2.java**

```java
package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
public class ApplicationConfig2 {
}
```

기존 JavaConfig에서 빈을 생성하는 메소드를 모두 제거했습니다.

단, @Configuration아래에 @ComponentScan이라는 어노테이션을 추가했습니다.

@ComponentScan어노테이션은 파라미터로 들어온 패키지 이하에서 @Controller, @Service, @Repository, @Component 어노테이션이 붙어 있는 클래스를 찾아 메모리에 몽땅 올려줍니다.

기존의 Car클래스와 Engine클래스 위에 @Component를 붙이도록 하겠습니다.

 

**Engine.java**

```java
package kr.or.connect.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
}
```



**Car.java**

```java
package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
```

수정된 JavaConfig를 읽어들이여 실행하는 클래스를 보도록 하겠습니다.

 

**ApplicationContextExam04.java**

```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		   
		Car car = ac.getBean(Car.class);
		car.run();
		
	}
}
```

Spring에서 사용하기에 알맞게 @Controller, @Service, @Repository, @Component 어노테이션이 붙어 있는 객체들은 ComponentScan을 이용해서 읽어들여 메모리에 올리고 DI를 주입하도록 하고, 이러한 어노테이션이 붙어 있지 않은 객체는 @Bean어노테이션을 이용하여 직접 생성해주는 방식으로 클래스들을 관리하면 편리합니다.

 

 

------

**생각해보기**

- 다루는 빈(Bean)이 많아질수록 xml로 설정하는 것과 @ComponentScan, @Component, @Autowired를 이용하는 것 중 어떤 것이 유지보수에 좋을 것 같습니까?
- @AutoWired 는 Field, Constructor, Setter Method 에 사용할 수 있습니다. 각각의 방식에 장단점에 대해서 더 생각해보세요.



 

------

**참고 자료**

[**[참고링크\] Spring JavaConfig Reference Guide**https://docs.spring.io](https://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/)

[**[참고링크\] Field Dependency Injection Considered Harmful**http://vojtechruzicka.com](http://vojtechruzicka.com/field-dependency-injection-considered-harmful/)