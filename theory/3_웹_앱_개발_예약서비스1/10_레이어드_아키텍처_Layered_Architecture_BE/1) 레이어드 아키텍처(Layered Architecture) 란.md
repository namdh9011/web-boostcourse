# 1) 레이어드 아키텍처(Layered Architecture) 란?

**들어가기 전에**

이번 시간엔 웹 어플리케이션을 만들 때 자주 사용하는 레이어드 아키텍처(Layered Architecture) 에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. 웹 어플리케이션 개발시 레이어드 아키텍처(Layered Architecture) 가 사용되는 이유에 대해 이해합니다.
2. 웹 어플리케이션 개발시 각 레이어의 구성요소에 대해서 이해합니다.

 

 

------

**핵심 개념**

- Controller
- Service
- Repository

 

 

------

**학습하기**

**Controller에서 중복되는 부분을 처리하려면?**

- 별도의 객체로 분리합니다.
- 별도의 메소드로 분리합니다.
- 예를 들어 쇼핑몰에서 게시판에서도 회원 정보를 보여주고, 상품 목록 보기에서도 회원 정보를 보여줘야 한다면 회원 정보를 읽어오는 코드는 어떻게 해야 할까요?

 

**컨트롤러와 서비스**

- 비지니스 메소드를 별도의 Service객체에서 구현하도록 하고 컨트롤러는 Service객체를 사용하도록 합니다.

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/1_1.png)

- **컨트롤러와 서비스**

**서비스(Service)객체란?**

비지니스 로직(Business logic)을 수행하는 메소드를 가지고 있는 객체를 서비스 객체라고 합니다.

보통 하나의 비지니스 로직은 하나의 트랜잭션으로 동작합니다.

 

**트랜잭션(Transaction)이란?**

트랜잭션의 특징은 크게 4가지로 구분됩니다.

1. 원자성 (Atomicity)
2. 일관성 (Consistency)
3. 독립성 (Isolation)
4. 지속성 (Durability)

 

**원자성 (Atomicity)**

예를 들어 "출금"이라는 기능의 흐름이 다음과 같다고 생각해봅시다.

1. 잔액이 얼마인지 조회한다.
2. 출금하려는 금액이 잔액보다 작은지 검사한다.
3. 출금하려는 금액이 잔액보다 작다면 (잔액 - 출금액)으로 수정한다.
4. 언제, 어디서 출금했는지 정보를 기록한다.
5. 사용자에게 출금한다.

위의 작업이 4번에서 오류가 발생했다면 어떻게 될까요?

4번에서 오류가 발생했다면, 앞의 작업을 모두 원래대로 복원을 시켜야 합니다.

이를 rollback이라고 합니다.

5번까지 모두 성공했을 때만 정보를 모두 반영해야 합니다.

이를 commit 한다고 합니다.

이렇게 rollback 하거나 commit을 하게 되면 하나의 트랜잭션 처리가 완료됩니다.

 

**일관성 (Consistency)**

일관성은 트랜잭션의 작업 처리 결과가 항상 일관성이 있어야 한다는 것입니다.

트랜잭션이 진행되는 동안에 데이터가 변경되더라도 업데이트된 데이터로 트랜잭션이 진행되는 것이 아니라, 처음에 트랜잭션을 진행하기 위해 참조한 데이터로 진행됩니다.

이렇게 함으로써 각 사용자는 일관성 있는 데이터를 볼 수 있는 것입니다.

 

**독립성 (Isolation)**

독립성은 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 경우에 어느 하나의 트랜잭션이라도 다른 트랜잭션의 연산을 끼어들 수 없습니다.

하나의 특정 트랜잭션이 완료될 때까지, 다른 트랜잭션이 특정 트랜잭션의 결과를 참조할 수 없습니다.

 

**지속성 (Durability)**

지속성은 트랜잭션이 성공적으로 완료되었을 경우, 결과는 영구적으로 반영되어야 한다는 점입니다.

 

**JDBC 프로그래밍에서 트랜잭션 처리 방법**

DB에 연결된 후 Connection객체의 setAutoCommit메소드에 false를 파라미터로 지정합니다.

입력, 수정, 삭제 SQL이 실행을 한 후 모두 성공했을 경우 Connection이 가지고 있는 commit()메소드를 호출합니다.

 

**@EnableTransactionManagement**

Spring Java Config파일에서 트랜잭션을 활성화 할 때 사용하는 애노테이션입니다.

Java Config를 사용하게 되면 PlatformTransactionManager 구현체를 모두 찾아서 그 중에 하나를 매핑해 사용합니다.

특정 트랜잭션 메니저를 사용하고자 한다면 TransactionManagementConfigurer를 Java Config파일에서 구현하고 원하는 트랜잭션 메니저를 리턴하도록 합니다.

아니면, 특정 트랜잭션 메니저 객체를 생성시 @Primary 애노테이션을 지정합니다.

 

**서비스 객체에서 중복으로 호출되는 코드의 처리**

데이터 엑세스 메소드를 별도의 Repository(Dao) 객체에서 구현하도록 하고 Service는 Repository객체를 사용하도록 합니다.



**레이어드 아키텍처**

![1_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/10_%EB%A0%88%EC%9D%B4%EC%96%B4%EB%93%9C_%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98_Layered_Architecture_BE/image/1_2.png)


- **레이어드 아키텍처**

**설정의 분리**

Spring 설정 파일을 프리젠테이션 레이어쪽과 나머지를 분리할 수 있습니다.

web.xml 파일에서 프리젠테이션 레이어에 대한 스프링 설정은 DispathcerServlet이 읽도록 하고, 그 외의 설정은 ContextLoaderListener를 통해서 읽도록 합니다.

DispatcherServlet을 경우에 따라서 2개 이상 설정할 수 있는데 이 경우에는 각각의 DispathcerServlet의 ApplicationContext가 각각 독립적이기 때문에 각각의 설정 파일에서 생성한 빈을 서로 사용할 수 없습니다.

위의 경우와 같이 동시에 필요한 빈은 ContextLoaderListener를 사용함으로써 공통으로 사용하게 할 수 있습니다.

ContextLoaderListener와 DispatcherServlet은 각각 ApplicationContext를 생성하는데, ContextLoaderListener가 생성하는 ApplicationContext가 root컨텍스트가 되고 DispatcherServlet이 생성한 인스턴스는 root컨텍스트를 부모로 하는 자식 컨텍스트가 됩니다.

참고로, 자식 컨텍스트들은 root컨텍스트의 설정 빈을 사용할 수 있습니다.

 

 

------

**생각해보기**

1. 레이어로 구성하지 않을 경우 어떤 문제가 발생할까요?
2. 레이어를 구성하지 않고 중복코드를 제거할 수 있을까요?

 

 

------

**참고 자료**

[**[참고링크\] Understanding Spring Web Application Architecture: The Classic Way**https://www.petrikainulainen.net](https://www.petrikainulainen.net/software-development/design/understanding-spring-web-application-architecture-the-classic-way/)

[ ![img](https://cphinf.pstatic.net/mooc/20180219_188/1519008743702UsH9R_PNG/B00KXgyAG2IcrCWfDIw2.png?type=mfullfill_199_148)**[참고링크\] Architecture - Tutorial for Telosys Tools 2.1**https://sites.google.com](https://sites.google.com/site/telosystutorial/springmvc-jpa-springdatajpa/presentation/architecture)