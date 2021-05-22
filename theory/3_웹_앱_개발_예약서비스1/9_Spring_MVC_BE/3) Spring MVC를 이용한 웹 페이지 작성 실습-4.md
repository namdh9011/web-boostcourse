# 3) Spring MVC를 이용한 웹 페이지 작성 실습-4

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

 **Controller작성 실습 2/3**

1. http://localhost:8080/mvcexam/userform 으로 요청을 보내면 이름, email, 나이를 물어보는 폼이 보여진다.
2. 폼에서 값을 입력하고 확인을 누르면 post방식으로 http://localhost:8080/mvcexam/regist 에 정보를 전달하게 된다.
3. regist에서는 입력받은 결과를 콘솔 화면에 출력한다.

 

**Controller작성 실습 3/3**

1. http://localhost:8080/mvcexam/goods/{id} 으로 요청을 보낸다.
2. 서버는 id를 콘솔에 출력하고, 사용자의 브라우저 정보를 콘솔에 출력한다.
3. 서버는 HttpServletRequest를 이용해서 사용자가 요청한 PATH정보를 콘솔에 출력한다.

 



------

**실습 코드**

userform.jsp

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
<form method="post" action="regist">  
name : <input type="text" name="name"><br>
email : <input type="text" name="email"><br>
age : <input type="text" name="age"><br>
<input type="submit" value="확인"> 
</body>
</html>
```



UserController.java

```java
package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	@RequestMapping(path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userform";
	}
	
	@RequestMapping(path="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {

		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
	}
}
```

 

User.java

```java
package kr.or.connect.mvcexam.dto;

public class User {
	private String name;
	private String email;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
	}	
}
```



regist.jsp

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
<h2>등록되었습니다.</h2>
</body>
</html>
```



goodsById.jsp

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
id : ${id } <br>
user_agent : ${userAgent }<br>
path : ${path }<br>
</body>
</html>
```



GoodsController.java

```java
package kr.or.connect.mvcexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GoodsController {
	@GetMapping("/goods/{id}")
	public String getGoodsById(@PathVariable(name="id") int id,
							   @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
							  HttpServletRequest request,
							  ModelMap model
							  ) {
		
		String path = request.getServletPath();
		
		System.out.println("id : " + id);
		System.out.println("user_agent : " + userAgent);
		System.out.println("path : " + path);
		
		model.addAttribute("id", id);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("path", path);
		return "goodsById";
	}
}
```





------

**생각해보기**

1. SpringMVC를 이용해서 웹 어플리케이션을 개발하는 것과 서블릿을 이용해 개발하는 것과 비교해보면 어떤 장단점이 있다고 생각하세요?

 

 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180219_1/1519005924957WqtFg_PNG/vqqCHR7IDcLcwZlBXyTy.png?type=mfullfill_199_148)**[참고링크\] WebMvcConfigurationSupport**https://github.comspring-framework - Spring Framework](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java)

[ ![img](https://cphinf.pstatic.net/mooc/20201031_57/1604145524209cWugW_PNG/CI0rRFVFYg6zDyB5uWWq.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)