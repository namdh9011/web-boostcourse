# 2) Web API란?

**들어가기 전에**

Web API에 대해 알아보고 REST API와 Web API의 차이에 대해 알아봅니다.

Web API를 잘 작성하기 위한 디자인 가이드에 대해 살펴보도록 합니다.



 

------

**학습 목표**

1. REST API와 Web API의 차이에 대해 이해합니다.
2. Web API의 디자인 가이드에 대해 이해합니다.



 

------

**핵심 개념**

- Web API
- HTTP Methods



 

------

**학습하기**

- **Web API 란?**

**Web API 디자인 가이드**

- URI는 정보의 자원을 표현해야 합니다.
- 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현합니다.

 

**자원에 대한 행위는 HTTP Method로 표현**

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/11_WEB_API_BE/image/2_1.png)

- **Web API**

**URI는 정보의 자원을 표현해야 한다.**

- GET /members
  : 위의 표현은 맴버의 모든 정보를 달라는 요청입니다.
- GET /members/delete/1
  : GET은 정보를 요청할 때 사용합니다. 위와 같이 동사로 삭제를 표현하면 안 됩니다.
- DELETE /members/1
  : HTTP Method 중의 하나인 DELETE를 이용하여 삭제를 표현해야 합니다.

 

**자원에 대한 행위는 HTTP Method로 표현**

- GET /members/1          (o)
- GET /members/get/1       (x)
- GET /members/add         (x)
- POST /members            (o)
- GET /members/update/1    (x)
- PUT /members/1           (o)
- GET /members/del/1        (x)
- DELETE /members/1        (o)



**슬래시 구분자(/)는 계층을 나타낼 때 사용**

http://domain/houses/apartments

http://domain/departments/1/employees

- URI 마지막 문자로 슬래시 구분자(/)를 포함하지 않습니다.
- 하이픈(-)은 URI가독성을 높일 때 사용합니다.
- 언더바(_)는 사용하지 않습니다.
- URI경로는 소문자만 사용합니다.
- RFC 3986(URI 문법 형식)은 URI스키마와 호스트를 제외하고는 대소문자를 구별합니다.
- 파일 확장자는 URI에 포함하지 않습니다.
- Accept Header를 사용합니다.

 



**상태 코드 (성공)**

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/11_WEB_API_BE/image/2_2.png)

- **상태 코드 (성공)**

**상태 코드 (클라이언트로 인한 오류)**

![2_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/11_WEB_API_BE/image/2_3.png)

- **상태 코드 (클라이언트로 인한 오류)**

**상태 코드 (서버로 인한 오류)**

![2_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/11_WEB_API_BE/image/2_4.png)

- **상태 코드 (서버로 인한 오류)**

**생각해보기**

1. 기계와 기계가 통신하는 방법 중에 web API가 있습니다. 이 외에 또 어떤 방법으로 기계와 기계가 통신할 수 있을까요?



 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180206_145/1517905669861tWwIR_PNG/9mKiLBxD5DucPm09n2IG.png?type=mfullfill_199_148)**[참고링크\] REST API 제대로 알고 사용하기 : TOAST Meetup**http://meetup.toast.com](http://meetup.toast.com/posts/92)

[ ![img](https://cphinf.pstatic.net/mooc/20180206_137/15179056837315vT1i_PNG/hnLFgIhSbGR6OcYVU2PQ.png?type=mfullfill_199_148)**[참고링크\] Servlet and path parameters like /xyz/{value}/test, how to map in web.xml?**https://stackoverflow.com](https://stackoverflow.com/questions/8715474/servlet-and-path-parameters-like-xyz-value-test-how-to-map-in-web-xml)