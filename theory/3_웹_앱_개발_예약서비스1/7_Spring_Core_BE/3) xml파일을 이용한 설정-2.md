# 3) xml파일을 이용한 설정-2

**들어가기 전에**

이번 시간엔 Spring의 IoC / DI 컨테이너에 대한 동작을 확인하기 위해 Maven을 이용해 프로젝트를 생성한 후, XML 형식의 설정 파일을 만들어 IoC와 DI가 잘 동작하는지 확인해 보도록 하겠습니다.

 

 

------

**학습 목표**

1. Maven을 이용해 스프링 프레임워크를 사용하는 프로젝트를 생성할 수 있습니다.
2. Bean이 무엇인지 이해합니다.
3. XML형식의 스프링 설정파일의 내용을 이해합니다.

 

 

------

**핵심 개념**

- Bean
- ApplicationContext
- DI

 

 

------

**학습하기**

**노트**

- Engine.java, Car.java 생성
- ApplicationContextExam02.java 생성



**DI 확인하기**

이번에는 DI 즉 의존성 주입을 확인해보도록 하겠습니다.

Car와 Engine이라는 클래스 2개를 생성합니다.





------

**실습코드**

Engine.java

```java
package kr.or.connect.diexam01;

public class Engine {
	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
}
```

 

Car.java

```java
package kr.or.connect.diexam01;

public class Car {
	Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
```

위의 Car 클래스가 제대로 동작하도록 하려면 보통 다음과 같은 코드가 작성되야 합니다.

```java
Engine e = new Engine();
Car c = new Car();
c.setEngine( e );
c.run();
```

1, 2 번째 줄을 Spring 컨테이너에게 맡기기 위해 설정파일에 다음과 같은 코드를 입력합니다.

```markup
<bean id="e" class="kr.or.connect.diexam01.Engine"></bean>
<bean id="car" class="kr.or.connect.diexam01.Car">
	<property name="engine" ref="e"></property>
</bean>
```

즉, 위의 XML설정은 다음과 같은 의미를 가집니다.

```java
Engine e = new Engine();
Car c = new Car();
c.setEngine( e );
```

이번엔 위의 설정 파일을 읽어들여 실행하는 ApplicationContextExam02.java를 작성해보도록 하겠습니다.

```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 

		Car car = (Car)ac.getBean("car");
		car.run();
		
	}
}
```

콘솔을 보면 다음과 같이 실행된 것을 알 수 있습니다.

![3_17](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_17.png)

**생각해보기**

- Spring컨테이너가 관리하는 객체를 빈(Bean)이라고 말합니다. (여러분들이 직접 new연산자로 생성해서 사용하는 객체는 빈(Bean)이라고 말하지 않습니다.) Spring은 빈을 생성할 때 기본적으로 싱글톤(Singleton)객체로 생성합니다. 싱글톤이란 메모리에 하나만 생성한다는 것입니다. 메모리에 하나만 생성되었을 경우, 해당 객체를 동시에 이용한다면 어떤 문제가 발생할 수 있을까요? 이런 문제를 해결하려면 어떻게 해야할까요?  ( 참고로 Spring에서 빈을 생성할 때 스코프(scope)를 줄 수 있습니다. 스코프를 줌으로써 기본으로 설정된 싱글톤 외에도 다른 방법으로 객체를 생성할 수 있습니다. )



------

**참고 자료**

[**[참고링크\] Appendix C. XML Schema-based configuration**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/xsd-config.html)