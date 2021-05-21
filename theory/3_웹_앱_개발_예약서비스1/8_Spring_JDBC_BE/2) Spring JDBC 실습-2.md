# 2) Spring JDBC 실습-2

**들어가기 전에**

이번 시간엔 실습을 통해 Spring JDBC에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. DTO와 DAO에 대한 개념을 이해합니다.
2. Spring JDBC를 이용해 DAO를 작성할 수 있습니다.

 

 

------

**핵심 개념**

- DTO
- DAO
- NamedParameterJdbcTemplate

 

 

------

**학습하기**

**노트**

- maven Project - quickstart - daoexam 생성
- pom.xml에 spring, mysql, datasource 디펜던씨 추가
- config 패키지 - ApplicationConfig.java 추가 



**Spring JDBC를 이용한 DAO작성 실습**

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/8_Spring_JDBC_BE/image/2_2.png)

**실습코드**

pom.xml

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>kr.or.connect</groupId>
	<artifactId>daoexam</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>daoexam</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<spring.version>4.3.5.RELEASE</spring.version>
	</properties>

	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<!-- basic data source -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-dbcp2</artifactId>
			<version>2.1.1</version>
		</dependency>


		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.45</version>
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

 

ApplicationConfig.java

```java
package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {

}
```

 

DBConfig.java

```java
package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";

    private String username = "connectuser";
    private String password = "connect123!@#";

    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
}
```

 

DataSourceTest.java

```java
package kr.or.connect.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("접속 성공^^");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_51/16038691128671cgSt_JPEG/W4Z3MdJUJ97qggyR8Bit.jpg?type=ffn199_148)**[참고링크\] Data Access Object Pattern**https://www.tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

[ ![img](https://cphinf.pstatic.net/mooc/20201028_116/1603869162729SvM4l_JPEG/FT08AJo7GyFE5XRk4oTr.jpg?type=ffn199_148)**[참고링크\] Using JDBC to Connect to a Database**https://ejbvn.wordpress.com](https://ejbvn.wordpress.com/category/week-2-entity-beans-and-message-driven-beans/day-09-using-jdbc-to-connect-to-a-database/)