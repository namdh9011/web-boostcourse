# 2) 레이어드 아키텍처(Layered Architecture) 실습-5

**들어가기 전에**

이번 시간엔 방명록을 Spring 프레임워크를 이용해 만들어 보도록 하겠습니다.

이를 통해 각 레이어별로 어떤 내용들을 작성해야 하는지 알아보고, 완전히 동작하는 웹 어플리케이션을 개발해 봄으로써 Spring 웹 어플리케이션에 대한 이해를 높이는 시간이 될 수 있길 바랍니다.

 

 

------

**학습 목표**

1. Spring 프레임워크를 이용한 웹 어플리케이션 프로젝트를 구성할 수 있습니다.
2. Spring 프레임워크를 이용한 웹 어플리케이션 개발 시 어떤 요소들을 개발해야하는지 이해합니다.

 



------

**핵심 개념**

- @Controller
- @Service
- @Repository
- @Transactional

 

 

------

**학습하기**

**실습코드**

GuestbookController.java

```java
package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
					   ModelMap model) {
		
		// start로 시작하는 방명록 목록 구하기
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		// 전체 페이지수 구하기
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 5, 10 이렇게 저장된다.
		// list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}
```

 

list.jsp

```markup
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 목록</title>
</head>
<body>

	<h1>방명록</h1>
	<br> 방명록 전체 수 : ${count }
	<br>
	<br>

	<c:forEach items="${list}" var="guestbook">

${guestbook.id }<br>
${guestbook.name }<br>
${guestbook.content }<br>
${guestbook.regdate }<br>

	</c:forEach>
	<br>

	<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
</c:forEach>

	<br>
	<br>
	<form method="post" action="write">
		name : <input type="text" name="name"><br>
		<textarea name="content" cols="60" rows="6"></textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>
```

 

 

------

**생각해보기**

1. 레이어 별로 개발을 진행할 때, 각 레이어별로 잘 동작하는지 확인하는 것은 매우 중요합니다. 어떤 특정 레이어가 올바르게 동작하지 않는다면 웹 어플리케이션은 제대로 동작하지 않을 것입니다. 어느 특정 레이어가 문제가 있는지 알려면, 각 레이어별로 테스트가 필요합니다. 자바에서 테스트 코드를 좀 더 효과적으로 작성할 수 있는 방법에 대해 알아보세요.

 



------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_285/1603872065973cGqmr_PNG/OAQaJEYMAbsYYHWJdszv.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

[**[참고링크\] Serving Web Content with Spring MVC**https://spring.io](https://spring.io/guides/gs/serving-web-content/)

[**[참고링크\] Spring MVC Tutorial**https://www.javatpoint.com](https://www.javatpoint.com/spring-mvc-tutorial)