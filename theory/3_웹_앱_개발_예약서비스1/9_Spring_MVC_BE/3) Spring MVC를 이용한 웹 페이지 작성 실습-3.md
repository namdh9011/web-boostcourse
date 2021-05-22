# 3) Spring MVC를 이용한 웹 페이지 작성 실습-3

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

- view - plusForm.jsp 파일 생성
- view - plusResult.jsp 파일 생성
- PlusController.java 파일 생성
- ${}가 처리가 안된다. web.xml 파일 보면 2.3 버전이라서 안된다.
- <?xml version="1.0" encoding="UTF-8"?> web.xml파일 최상단 이렇게 바꿔줌.
- servers 에서 톰캣 화살표 눌러서 프로젝트 삭제했다가 다시 넣어준다.



**Controller작성 실습 1/3**

1. 웹 브라우저에서 http://localhost:8080/mvcexam/plusform 이라고 요청을 보 내면 서버는 웹 브라우저에게 2개의 값을 입력받을 수 있는 입력 창과 버튼이 있는 화면을 출력한다.
2. 웹 브라우저에 2개의 값을 입력하고 버튼을 클릭하면 http://localhost:8080/mvcexam/plus URL로 2개의 입력값이 POST방식으로 서버에게 전달한다. 서버는 2개의 값을 더한 후, 그 결과 값을 JSP에게 request scope으로 전달하여 출력한다.

 

**Spring MVC가 지원하는 Controller메소드 인수 타입**

- javax.servlet.ServletRequest
- **javax.servlet.http.HttpServletRequest**
- org.springframework.web.multipart.MultipartRequest
- org.springframework.web.multipart.MultipartHttpServletRequest
- javax.servlet.ServletResponse
- **javax.servlet.http.HttpServletResponse**
- **javax.servlet.http.HttpSession**
- org.springframework.web.context.request.WebRequest
- org.springframework.web.context.request.NativeWebRequest
- java.util.Locale
- java.io.InputStream
- java.io.Reader
- java.io.OutputStream
- java.io.Writer
- javax.security.Principal
- java.util.Map
- org.springframework.ui.Model
- org.springframework.ui.ModelMap
- **org.springframework.web.multipart.MultipartFile**
- javax.servlet.http.Part
- org.springframework.web.servlet.mvc.support.RedirectAttributes
- org.springframework.validation.Errors
- org.springframework.validation.BindingResult
- org.springframework.web.bind.support.SessionStatus
- org.springframework.web.util.UriComponentsBuilder
- org.springframework.http.HttpEntity<?>
- Command 또는 Form 객체

 

**Spring MVC가 지원하는 메소드 인수 애노테이션**

- **@RequestParam**
- **@RequestHeader**
- **@RequestBody**
- @RequestPart
- **@ModelAttribute**
- **@PathVariable**
- @CookieValue

 

**@RequestParam**

- Mapping된 메소드의 Argument에 붙일 수 있는 어노테이션
- @RequestParam의 name에는 http parameter의 name과 멥핑
- @RequestParam의 required는 필수인지 아닌지 판단

 

**@PathVariable**

- @RequestMapping의 path에 변수명을 입력받기 위한 place holder가 필요함
- place holder의 이름과 PathVariable의 name 값과 같으면 mapping 됨
- required 속성은 default true 임

 

**@RequestHeader**

- 요청 정보의 헤더 정보를 읽어들 일 때 사용
- @RequestHeader(name="헤더명") String 변수명

 

**Spring MVC가 지원하는 메소드 리턴 값**

- **org.springframework.web.servlet.ModelAndView**
- org.springframework.ui.Model
- java.util.Map
- org.springframework.ui.ModelMap
- org.springframework.web.servlet.View
- **java.lang.String**
- java.lang.Void
- org.springframework.http.HttpEntity<?>
- org.springframework.http.ResponseEntity<?>
- **기타 리턴 타입**

 

 

------

**실습 코드**

plusForm.jsp

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
<form method="post" action="plus">  
value1 : <input type="text" name="value1"><br>
value2 : <input type="text" name="value2"><br>
<input type="submit" value="확인">  
</form>  
</body>
</html>
```

 

plusResult.jsp

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
${value1} 더하기 ${value2} (은/는) ${result} 입니다.
</body>
</html>
```

 

PlusController.java

```java
package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	@GetMapping(path = "/plusform")
	public String plusform() {
		return "plusForm";
	}

	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value1", required = true) int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
		int result = value1 + value2;

		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		return "plusResult";
	}
}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180219_1/1519005924957WqtFg_PNG/vqqCHR7IDcLcwZlBXyTy.png?type=mfullfill_199_148)**[참고링크\] WebMvcConfigurationSupport**https://github.comspring-framework - Spring Framework](https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java)

[ ![img](https://cphinf.pstatic.net/mooc/20201031_143/1604145569525XYaDb_PNG/obxNiEJbJIl5OR4w4ExQ.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)