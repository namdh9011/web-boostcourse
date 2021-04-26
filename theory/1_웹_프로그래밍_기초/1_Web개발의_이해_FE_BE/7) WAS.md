# 7) WAS

**들어가기 전에**

WAS는 무엇이고, 왜 필요한지 그리고, 어떤 종류의 WAS가 있는지 알아봅니다.

또한, 웹서버와의 차이점은 무엇인지 알아봅니다.

 

------

**학습 목표**

1. WAS가 무엇인지 알 수 있다.
2. WAS의 종류를 알아본다.
3. 웹서버와 WAS의 차이점을 설명할 수 있다.

 

 

------

**핵심 개념**

- WAS (Web Application Server)
- Apache Tomcat

 

 

------

**학습하기**

**클라이언트/서버 구조**

클라이언트(Client)는 서비스(Service)를 제공하는 서버(Server)에게 정보를 요청하여 응답 받은 결과를 사용합니다.

![7-1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/7_1_ServerClient.png)

- **클라이언트/서버 구조**

**DBMS (DataBase Management System)**

다수의 사용자가 데이터베이스 내의 데이터에 접근할 수 있도록 해주는 소프트웨어입니다.

![7-2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/7_2_DBMS.png)

- **DBMS (DataBase Management System)**

**미들웨어 (MiddleWare)**

클라이언트 쪽에 비즈니스 로직이 많을 경우, 클라이언트 관리(배포 등)로 인해 비용이 많이 발생하는 문제가 있습니다.

비즈니스 로직을 클라이언트와 DBMS사이의 미들웨어 서버에서 동작하도록 함으로써 클라이언트는 입력과 출력만 담당하도록 합니다.

![7-3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/7_3_MiddleWare.png)

- **미들웨어(MiddleWare)**

**WAS (Web Application Server)**

WAS는 일종의 미들웨어로 웹 클라이언트(보통 웹 브라우저)의 요청 중 웹 애플리케이션이 동작하도록 지원하는 목적을 가집니다.

![7-4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/7_4_WAS.png)

- **WAS (Web Application Server)**

**웹 서버 vs WAS**

- WAS도 보통 자체적으로 웹 서버 기능을 내장하고 있습니다.
- 현재는 WAS가 가지고 있는 웹 서버도 정적인 콘텐츠를 처리하는 데 있어서 성능상 큰 차이가 없습니다.
- 규모가 커질수록 웹 서버와 WAS를 분리합니다.
- 자원 이용의 효율성 및 장애 극복, 배포 및 유지보수의 편의성을 위해 웹서버와 WAS를 대체로 분리합니다.

 

 

**생각해보기**

1. 톰켓 버전별 차이점에 대해서 알아보세요.