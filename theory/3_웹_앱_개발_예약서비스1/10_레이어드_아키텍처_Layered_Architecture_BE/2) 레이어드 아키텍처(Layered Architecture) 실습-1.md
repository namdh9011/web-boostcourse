# 2) 레이어드 아키텍처(Layered Architecture) 실습-1

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

**노트**

- 실습
  1. Spring JDBC를 이용한 Dao 작성
  2. Controller + Service + Dao
  3. 트랜잭션 처리
  4. Srping MVC에서 폼값 입력받기
  5. Spring MVC에서 redirect하기
  6. Controller에서 jsp에게 전달한 값을 JSTL과 EL을 이용해 출력하기

- 요구사항1
  1. 방명록 정보는 guestbook 테이블에 저장
  2. id는 자동으로 입력된다.
  3. id, 이름, 내용, 등록일을 저장

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_1.PNG)

- 요구사항2
  1. http://localhost:8080/guestbook/을 요청하면 자동으로 /guestbook/list로 리다이렉팅
  2. 방명록이 없으면 건수는 0이 나오고 아래에 방명록을 입력하는 폼이 보여진다.

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_2.PNG)

- 요구사항3
  1. 이름과 내용을 입력하고, 등록버튼을 누르면 /guestbook/write URL로 입력한 값을 전달하여 저장
  2. 값이 저장된 이후에는 /guestbook/list로 리다이렉트 된다.

![2_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_3.PNG)

- 요구사항4
  1. 입력한 한건의 정보가 보여진다.
  2. 방명록 내용과 폼 사이의 숫자는 바염ㅇ록 페이지 링크. 방명록 5건당 1페이지로 설정한다.

![2_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_4.PNG)

- 요구사항5
  1.  방명록이 6건 입력되자 아래 페이지 수가 2건 보여진다. 1페이지를 누르면 /guestbook/list?start0을 요청하고, 2페이지를 누르면 /guestbook/list?start5를 요청하게 된다.
  2. /guestbook/list는 /guestbook/list?start0과 결과가 같다.

![2_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_5.PNG)

- 요구사항6
  1. 방명록에 글을 쓰거나, 방명록의 글을 삭제할때는 Log테이블에 클라이언트 ip주소, 등록(삭제) 시간, 등록/삭제(method칼럼) 정보를 데이터베이스에 저장한다.
  2. 사용하는 테이블은 log이다.
  3. id는 자동으로 입력되도록 한다.

![2_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_6.PNG)

![2_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_7.PNG)

![2_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/2_8.png)

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_285/1603872065973cGqmr_PNG/OAQaJEYMAbsYYHWJdszv.png?type=ffn199_148)**[참고링크\] Web on Servlet Stack**https://docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

[**[참고링크\] Serving Web Content with Spring MVC**https://spring.io](https://spring.io/guides/gs/serving-web-content/)

[**[참고링크\] Spring MVC Tutorial**https://www.javatpoint.com](https://www.javatpoint.com/spring-mvc-tutorial)