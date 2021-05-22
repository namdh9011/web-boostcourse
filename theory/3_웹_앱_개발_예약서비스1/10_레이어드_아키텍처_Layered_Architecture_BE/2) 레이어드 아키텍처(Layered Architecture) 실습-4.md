# 2) 레이어드 아키텍처(Layered Architecture) 실습-4

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

GuestbookService.java

```java
package kr.or.connect.guestbook.service;

import java.util.List;

import kr.or.connect.guestbook.dto.Guestbook;

public interface GuestbookService {
	public static final Integer LIMIT = 5;
	public List<Guestbook> getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip);
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int getCount();
}
```

 

GuestbookServiceImpl.java

```java
package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
//		if(1 == 1)
//			throw new RuntimeException("test exception");
//			
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		
		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}
	
	
}
```

 

GuestbookServiceTest.java

```java
package kr.or.connect.guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

public class GuestbookServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("kang kyungmi22");
		guestbook.setContent("반갑습니다. 여러분. 여러분이 재미있게 공부하고 계셨음 정말 좋겠네요^^22");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
		
	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_285/1603872065973cGqmr_PNG/OAQaJEYMAbsYYHWJdszv.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

[**[참고링크\] Serving Web Content with Spring MVC**https://spring.io](https://spring.io/guides/gs/serving-web-content/)

[**[참고링크\] Spring MVC Tutorial**https://www.javatpoint.com](https://www.javatpoint.com/spring-mvc-tutorial)