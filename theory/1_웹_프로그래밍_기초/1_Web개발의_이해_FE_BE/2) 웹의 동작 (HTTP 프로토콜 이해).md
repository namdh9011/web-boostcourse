# 웹의 동작 (HTTP 프로토콜 이해)

### 학습 목표

1.  HTTP프로토콜의 작동방식에 대하여 알아봅니다.
2.  HTTP프로토콜의 요청/응답 데이터 포맷에 대하여 알아봅니다.


### 핵심 개념
- HTTP
- Request 형식
- Request Method
- Response 형식
- 응답 코드

### 학습하기

- **웹의 동작 (HTTP 프로토콜 이해)**

  영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.

**HTTP (Hypertext Transfer Protocol)란?**

- 팀 버너스리(Tim Berners-Lee)와 그가 속한 팀은 CERN에서 HTML뿐만 아니라 웹 브라우저 및 웹 브라우저 관련 기술과 HTTP를 발명하였습니다.
- 문서화된 최초의 HTTP버전은 HTTP v0.9(1991년)입니다.
- HTTP는 서버와 클라이언트가 인터넷상에서 데이터를 주고받기 위한 프로토콜(protocol)입니다.
- HTTP는 계속 발전하여 HTTP/2까지 버전이 등장한 상태입니다.

 

**HTTP 작동방식**

- HTTP는 서버/클라이언트 모델을 따릅니다.
- 클라이언트 -> 서버 : 요청
- 서버 -> 클라이언트 : 응답
- 장점
	
	\- 불특정 다수를 대상으로 하는 서비스에는 적합하다.
	
	\- 클라이언트와 서버가 계속 연결된 형태가 아니기 때문에 클라이언트와 서버 간의 최대 연결 수보다 훨씬 많은 요청과 응답을 처리할 수 있다.
- 단점
	
	\- 연결을 끊어버리기 때문에, 클라이언트의 이전 상황을 알 수가 없다.
	
	\- 이러한 특징을 무상태(Stateless)라고 말한다.
	
	\- 이러한 특징 때문에 정보를 유지하기 위해서 Cookie와 같은 기술이 등장하게 되었다.

 

**URL (Uniform Resource Locator)**

- 인터넷 상의 자원의 위치
- 특정 웹 서버의 특정 파일에 접근하기 위한 경로 혹은 주소

![2-1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/2_2_HTTP.png)

- **HTTP (Hypertext Transfer Protocol)**

- 요청 메서드 : GET, PUT, POST, PUSH, OPTIONS 등의 요청 방식이 온다.
- 요청 URI : 요청하는 자원의 위치를 명시한다.
- HTTP 프로토콜 버전 : 웹 브라우저가 사용하는 프로토콜 버전이다.

첫번째 줄의 요청메소드는 서버에게 요청의 종류를 알려주기 위해서 사용됩니다.

각각의 메소드 이름은 다음과 같은 의미를 가집니다.

참고로 최초의 웹 서버는 GET방식만 지원해줬습니다.

- GET : 정보를 요청하기 위해서 사용한다. (SELECT)
- POST : 정보를 밀어넣기 위해서 사용한다. (INSERT)
- PUT : 정보를 업데이트하기 위해서 사용한다. (UPDATE)
- DELETE : 정보를 삭제하기 위해서 사용한다. (DELETE)
- HEAD : (HTTP)헤더 정보만 요청한다. 해당 자원이 존재하는지 혹은 서버에 문제가 없는지를 확인하기 위해서 사용한다.
- OPTIONS : 웹서버가 지원하는 메서드의 종류를 요청한다.
- TRACE : 클라이언트의 요청을 그대로 반환한다. 예컨데 echo 서비스로 서버 상태를 확인하기 위한 목적으로 주로 사용한다.



### 생각해보기

1. HTTP에 S가 붙은 HTTPS 는 어떤 용도로 사용되는 건가요? HTTP와 무엇이 다른가요?

   **HTTP와 HTTPS의 차이**

   \- HTTP는 인터넷에서 웹 서버와 사용자 컴퓨터에 설치된 웹 브라우저 사이의 문서를 전송하기 위한 통신 규약인데 HTTP는 단순한 텍스트를 주고 받기 때문에 네트워크에서 전송 신호를 인터셉트 하는 경우 원치 않는 데이터 유출이 발생할 수 있다.

   \- 따라서 HTTP의 보안 취약점을 해결하기 위해 HTTP + S(Secure Socket)가 사용된다. 골격이나 사용 목적은 갖지만 데이터를 주고 받는 과정에서 보안 요소가 추가된다. HTTPS는 서버와 클라이언트 사이의 모든 통신 내용이 암호화 된다.

   \- HTTPS가 HTTP에 비해 처리속도가 느리지만 현대의 서버와 네트워크 상태가 우수해서 차이가 많이 줄었다.

   \- HTTPS를 사용하는 웹페이지가 많아지는 추세이다.

   \- 마케팅 측면에서도 HTTPS 를 사용할시 검색시 우선 순위가 올라간다. HTTPS를 사용하지 않으면 크롬에서 '주의 요함'이란 표시가 뜬다. 네이버, 다음, 구글 역시 HTTPS 사이트에 검색 우선순위를 높게 쳐준다.





**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180105_152/1515082480601qXxHG_PNG/ol1bHkm0vhvUPGgUJoCI.png?type=mfullfill_199_148)**[참고링크\] An overview of HTTP**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)

[**[참고링크\] HTTP - Hypertext Transfer Protocol Overview**https://www.w3.org](https://www.w3.org/Protocols/)

[**[참고링크\] HTTP - 위키백과, 우리 모두의 백과사전**https://ko.wikipedia.org](https://ko.wikipedia.org/wiki/HTTP)

[**[참고링크\] URL - Wikipedia**https://en.wikipedia.org](https://en.wikipedia.org/wiki/URL)

[**[참고링크\] Uniform Resource Identifier - Wikipedia**https://en.wikipedia.org](https://en.wikipedia.org/wiki/Uniform_Resource_Identifier)
