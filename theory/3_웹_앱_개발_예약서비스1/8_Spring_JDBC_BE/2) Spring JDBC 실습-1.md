# 2) Spring JDBC 실습-1

**들어가기 전에**

이번 시간엔 실습을 통해 Spring JDBC에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. DTO와 DAO에 대한 개념을 이해합니다.
2. Spring JDBC를 이용해 DAO를 작성할 수 있습니다.

 

 

------

**핵심 개념**

- DTO
- DAO
- NamedParameterJdbcTemplate

 

 

------

**학습하기**

**DTO란?**

- DTO란 Data Transfer Object의 약자입니다.
- 계층간 데이터 교환을 위한 자바빈즈입니다.
- 여기서의 계층이란 컨트롤러 뷰, 비지니스 계층, 퍼시스턴스 계층을 의미합니다.
- 일반적으로 DTO는 로직을 가지고 있지 않고, 순수한 데이터 객체입니다.
- 필드와 getter, setter를 가진다. 추가적으로 toString(), equals(), hashCode()등의 Object 메소드를 오버라이딩 할 수 있습니다.

 

**DTO의 예**

```java
public class ActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public Long getId() {
        return this.id;
    }
    // ......
}
```



**DAO란?**

- DAO란 Data Access Object의 약자로 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체입니다.
- 보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어집니다.



**ConnectionPool 이란?**

- DB연결은 비용이 많이 듭니다.
- 커넥션 풀은 미리 커넥션을 여러 개 맺어 둡니다.
- 커넥션이 필요하면 커넥션 풀에게 빌려서 사용한 후 반납합니다.
- 커넥션을 반납하지 않으면 어떻게 될까요?

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/8_Spring_JDBC_BE/image/2_1.jpg)

- **ConnectionPool**

**DataSource란?**

- DataSource는 커넥션 풀을 관리하는 목적으로 사용되는 객체입니다.
- DataSource를 이용해 커넥션을 얻어오고 반납하는 등의 작업을 수행합니다.



------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_51/16038691128671cgSt_JPEG/W4Z3MdJUJ97qggyR8Bit.jpg?type=ffn199_148)**[참고링크\] Data Access Object Pattern**https://www.tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

[ ![img](https://cphinf.pstatic.net/mooc/20201028_116/1603869162729SvM4l_JPEG/FT08AJo7GyFE5XRk4oTr.jpg?type=ffn199_148)**[참고링크\] Using JDBC to Connect to a Database**https://ejbvn.wordpress.com](https://ejbvn.wordpress.com/category/week-2-entity-beans-and-message-driven-beans/day-09-using-jdbc-to-connect-to-a-database/)