# 2) RestController를 이용하여 web api작성하기

**들어가기 전에**

이번 시간엔 Spring MVC를 이용해서 Web API를 직접 작성해 보도록 하겠습니다.

 

 

------

**학습 목표**

1. Spring MVC를 이용해 Web API를 작성할 수 있습니다.

 

 

------

**핵심 개념**

- @RestController
- @RequestBody
- @PathVariable

 

 

------

**학습하기**

**노트**

- Jackson 디펜덴씨가 있어야한다.
- 크롬 웹스토어 - restlet client 확장 프로그램 설치하면 RestApi 테스트가능
- https 말고 http로 해야된다.....

**실습코드**

GuestbookApiController.java

```java
package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		return map;
	}
	
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		// id가 입력된 guestbook이 반환된다.
		Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		return resultGuestbook;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
	}
}
```

 

 

------

**생각해보기**

1. Web API에게 POST방식으로 값을 전달할 때 JSON메시지를 보냈고, 결과도 JSON메시지를 출력하도록 하였습니다. JSON메시지를 자바객체로 변환하고, 자바객체를 반대로 JSON메시지로 변화하는 부분들이 모두 자동으로 이뤄지고 있는 것을 알 수 있었습니다. 만약 서블릿을 이용해 개발한다면, 이 부분들을 어떻게 구현해야 할까요?
2. 이를 통해 Spring MVC의 장점에 대해 생각해보세요.

 

 

------

**참고 자료**

[**[참고링크\] Building a RESTful Web Service**https://spring.io](https://spring.io/guides/gs/rest-service/)

[**[참고링크\] Building REST services with Spring**https://spring.io](https://spring.io/guides/tutorials/bookmarks/)