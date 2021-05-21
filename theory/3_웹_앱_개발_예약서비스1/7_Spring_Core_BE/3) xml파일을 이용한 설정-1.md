# 3) xml파일을 이용한 설정-1

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

**Maven으로 Java프로젝트 만들기**

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_1.png)

![3_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_2.png)

![3_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_3.png)

![3_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_4.png)

pom.xml 파일에 JDK를 사용하기 위한 플러그인 설정을 추가합니다.

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>kr.or.connect</groupId>
  <artifactId>diexam01</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>diexam01</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
-------------------------------------추가----------------------------------------------------
  <build>
     <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
  </build>
----------------------------------------------------------------------------------------------

</project>
```

![3_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_5.png)

![3_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_6.png)

- 

  프로젝트를 선택하고, Maven -> Update Project를 선택합니다.

![3_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_7.png)

- 

  위와 같은 창이 뜨면 OK버튼을 클릭합니다.

![3_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_8.png)

![3_9](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_9.png)

------

**실습코드**

App.java

```java
package kr.or.connect.diexam01;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
```

 

AppTest.java

```java
package kr.or.connect.diexam01;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
```

![3_10](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_10.png)

- 

  AppTest.java 를 선택한 후 우측버튼을 클릭하고 Run As -> JUnit Test 메뉴를 선택합니다.

![3_11](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_11.png)

- 

  하단의 JUnit 뷰에 하나의 테스트가 성공했다는 메시지와 함께 녹색 막대가 보여집니다.

**Bean class란?**

예전에는 Visual 한 컴포넌트를 Bean이라고 불렀지만, 근래 들어서는 일반적인 Java클래스를 Bean클래스라고 보통 말합니다.

Bean클래스의 3가지 특징은 다음과 같습니다.

- 기본생성자를 가지고 있습니다.
- 필드는 private하게 선언합니다.
- getter, setter 메소드를 가집니다.
- getName() setName() 메소드를 name 프로퍼티(property)라고 합니다. (용어 중요)





------

**실습코드**

UserBean.java

```java
package kr.or.connect.diexam01;

//빈클래스
public class UserBean {
	
	//필드는 private한다.
	private String name;
	private int age;
	private boolean male;
	
	//기본생성자를 반드시 가지고 있어야 한다.
	public UserBean() {
	}
	
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}

	// setter, getter메소드는 프로퍼티라고 한다.
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
```



**Spring Bean Factory를 이용하여 Bean객체 이용하기**

1) pom.xml 파일을 다음과 같이 수정합니다.

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>kr.or.connect</groupId>
  <artifactId>diexam01</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>diexam01</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <spring.version> 4.3.14.RELEASE</spring.version>
  </properties>

  <dependencies>
	<!-- Spring -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>${spring.version}</version>
	</dependency>
  
  
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  <build>
     <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
  </build>
</project>
```

2) 추가된 라이브러리 확인합니다.

![3_12](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_12.png)

3) resources 소스 폴더를 생성합니다.

![3_13](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_13.png)

- 

  프로젝트를 선택하고, 오른쪽 버튼을 클릭한 후 New -> Folder를 선택합니다.

![3_14](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_14.png)

- 

  src/main 폴더를 선택한 후 forder name에 resources라고 Finish버튼을 클릭합니다.

![3_15](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_15.png)

- 

  해당 폴더를 선택하고, 우측버튼을 클릭하여 New – File을 선택합니다. src/main/resources 폴더를 선택한 후 File name에 applicationContext.xml 을 입력하고 Finish버튼을 클릭합니다.

![3_16](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/7_Spring_Core_BE/image/3_16.png)

- 

  위와 같이 생성되었으면 더블클릭하여 파일을 엽니다.

4) resources 소스 폴더에 xml 파일을 작성합니다.





------

**실습코드** 

applicationContext.xml

```markup
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="userBean" class="kr.or.connect.diexam01.UserBean"></bean>

</beans>
```

bean 태그를 하나 입력했는데, 위의 태그는 다음과 같은 의미를 가집니다.

UserBean userBean - new UserBean();



**ApplicationContext를 이용해서 설정파일을 읽어들여 실행하기**

ApplicationContextExam01

```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 
		System.out.println("초기화 완료.");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kim");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스이다.");
		}
		
	}
}
```

**생각해보기**

- Spring컨테이너가 관리하는 객체를 빈(Bean)이라고 말합니다. (여러분들이 직접 new연산자로 생성해서 사용하는 객체는 빈(Bean)이라고 말하지 않습니다.) Spring은 빈을 생성할 때 기본적으로 싱글톤(Singleton)객체로 생성합니다. 싱글톤이란 메모리에 하나만 생성한다는 것입니다. 메모리에 하나만 생성되었을 경우, 해당 객체를 동시에 이용한다면 어떤 문제가 발생할 수 있을까요? 이런 문제를 해결하려면 어떻게 해야할까요?  ( 참고로 Spring에서 빈을 생성할 때 스코프(scope)를 줄 수 있습니다. 스코프를 줌으로써 기본으로 설정된 싱글톤 외에도 다른 방법으로 객체를 생성할 수 있습니다. )



------

**참고 자료**

[**[참고링크 \]Appendix C.XML Schema-based configuration**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/xsd-config.html)