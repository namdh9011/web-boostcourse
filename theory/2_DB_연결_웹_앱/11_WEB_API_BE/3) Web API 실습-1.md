# 3) Web API 실습-1

**들어가기 전에**

이번 시간엔 서블릿을 이용해 Web API를 작성해 보도록 하겠습니다.

참고로 JDBC 수업 시간에 배웠던 RoleDao도 이번 시간에 재활용됩니다.

 



------

**학습 목표**

1. Servlet을 이용해 Web API를 작성할 수 있습니다.
2. 객체를 JSON문자열로 변환시킬 수 있습니다.



 

------

**핵심 개념**

- JSON
- ObjectMapper
- URL pattern에서 wildcard(*)



 

------

**학습하기**

**노트**

- new maven project -> webapp -> webapiexam 프로젝트 생성
- pom.xml 파일 수정
- window -> show view -> general ->navigator 에가면 .settings 폴더를 찾을 수 있음.
- org.eclipse.wst.common.project.facet.core.xml 파일 확인
- jst.web버전을 변경해 줄 수 있음 3.1로 바꿔주고 이클립스 재시작
- properties -> project Facets에 가면 Dynamic Web Module 3.1로 변경된걸 볼 수 있음
- 어노테이션 쓸 것이기 때문에 web.xml파일 필요없다. 삭제해줌. pom.xml에 failOnMissingWebXml 추가
- main에 자바폴더 만들어준다.
- kr.or.connect.webapiexam.api 패키지 생성해주고 jdbcexam에서 지난시간에 한거 가져온다.
- api패키지에 RolesServlet.java 생성해준다.
- tomcat에러가 발생해서 windows -> preferences -> maven -> Usersettings에서 local repository폴더안을 싹 비우고 이클립스 재실행후 server clean project clean 전부 해주고 mavenupdate해주고 나니 정상 실행됨.
- c:user에 가면 .m2가 maven 레파지토리이다. 싹 비우고 메이븐 업데이트하면 알아서 설치 다시됨.

**실습코드**

- 모든 롤 정보 읽어오기. GET /roles
- 특정한 롤정보 읽어오기. GET /roles/{roleId}
- 롤정보 등록하기. POST /roles
- 롤정보 삭제하기. DELETE /roles/{roleId}
- 롤정보 수정하기. PUT /roles/{roleId}



pom.xml

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>kr.or.connect</groupId>
	<artifactId>webapiexam</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	<name>webapiexam Maven Webapp</name>
	<url>http://maven.apache.org</url>
	<properties>
		<!-- web.xml 파일을 삭제해도 eclipse에서 오류가 발생하지 않는다. -->
		<failOnMissingWebXml>false</failOnMissingWebXml>
	</properties>
	<dependencies>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.45</version>
		</dependency>

		<!-- json 라이브러리 databind jackson-core, jackson-annotaion에 의존성이 있다. -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.4</version>
		</dependency>

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<finalName>webapiexam</finalName>
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



RoleServlet.java

```java
package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RolesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		RoleDao dao = new RoleDao();

		List<Role> list = dao.getRoles();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
```

application/json IE8,9 에서 인식안되서 파일 저장으로 나오는 문제에 대한 해결 [바로가기](https://blog.asamaru.net/2016/02/23/jquery-ajax-ie8-content-type-application-json/)

------

**참고 자료**

[**[참고링크\] JDBC Basics**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)