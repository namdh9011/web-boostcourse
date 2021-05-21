# 1) Spring JDBC 소개

**들어가기 전에**

JDBC를 이용해서 프로그래밍을 하게 되면 반복적인 코드가 많이 발생합니다.

이러한 반복적인 코드는 개발자의 생산성을 떨어트리는 주된 원인이 됩니다.

이러한 문제를 해결하기 위해 등장한 것이 Spring JDBC입니다.

이번 시간엔 Spring JDBC에 대해 알아보도록 하겠습니다.



 

------

**학습 목표**

1. Spring JDBC에 대한 개념을 이해합니다.
2. Spring JDBC의 핵심 클래스와 인터페이스에 대해 이해합니다.



 

------

**핵심 개념**

- JdbcTemplate
- RowMapper



 

------

**학습하기**

**Spring JDBC**

- JDBC 프로그래밍을 보면 반복되는 개발 요소가 있습니다.
- 이러한 반복적인 요소는 개발자를 지루하게 만듭니다.
- 개발하기 지루한 JDBC의 모든 저수준 세부사항을 스프링 프레임워크가 처리해줍니다.
- 개발자는 필요한 부분만 개발하면 됩니다.



**Spring JDBC - 개발자가 해야 할 일은?**

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/3_%EC%9B%B9_%EC%95%B1_%EA%B0%9C%EB%B0%9C_%EC%98%88%EC%95%BD%EC%84%9C%EB%B9%84%EC%8A%A41/8_Spring_JDBC_BE/image/1_1.png)

- **spring JDBC**

**Spring JDBC 패키지**

**org.springframework.jdbc.core**

- JdbcTemplate 및 관련 Helper 객체 제공

**org.springframework.jdbc.datasource**

- DataSource를 쉽게 접근하기 위한 유틸 클래스, 트랜젝션매니져 및 다양한 DataSource 구현을 제공

**org.springframework.jdbc.object**

- RDBMS 조회, 갱신, 저장등을 안전하고 재사용 가능한 객제 제공

**org.springframework.jdbc.support**

- jdbc.core 및 jdbc.object를 사용하는 JDBC 프레임워크를 지원



**JDBC Template**

- org.springframework.jdbc.core에서 가장 중요한 클래스입니다.
- 리소스 생성, 해지를 처리해서 연결을 닫는 것을 잊어 발생하는 문제 등을 피할 수 있도록 합니다.
- 스테이먼트(Statement)의 생성과 실행을 처리합니다.
- SQL 조회, 업데이트, 저장 프로시저 호출, ResultSet 반복호출 등을 실행합니다.
- JDBC 예외가 발생할 경우 org.springframework.dao패키지에 정의되어 있는 일반적인 예외로 변환시킵니다.



 

------

**실습코드**

**JdbcTemplate select 예제1**

열의 수 구하기

```java
int rowCount = this.jdbcTemplate.queryForInt("select count(*) from t_actor");
```



**JdbcTemplate select 예제2**

변수 바인딩 사용하기

```java
int countOfActorsNamedJoe = this.jdbcTemplate.queryForInt("select count(*) from t_actor where first_name = ?", "Joe"); 
```



**JdbcTemplate select 예제3**

String값으로 결과 받기

```java
String lastName = this.jdbcTemplate.queryForObject("select last_name from t_actor where id = ?", new Object[]{1212L}, String.class); 
```



**JdbcTemplate select 예제4**

한 건 조회하기

```java
Actor actor = this.jdbcTemplate.queryForObject(

  "select first_name, last_name from t_actor where id = ?",

  new Object[]{1212L},

  new RowMapper<Actor>() {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

      Actor actor = new Actor();

      actor.setFirstName(rs.getString("first_name"));

      actor.setLastName(rs.getString("last_name"));

      return actor;

    }

  });
```



**JdbcTemplate select 예제5**

여러 건 조회하기

```java
List<Actor> actors = this.jdbcTemplate.query(

  "select first_name, last_name from t_actor",

  new RowMapper<Actor>() {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

      Actor actor = new Actor();

      actor.setFirstName(rs.getString("first_name"));

      actor.setLastName(rs.getString("last_name"));

      return actor;

    }

  });
```



**JdbcTemplate select 예제6**

중복 코드 제거 (1건 구하기와 여러 건 구하기가 같은 코드에 있을 경우)

```java
public List<Actor> findAllActors() {

  return this.jdbcTemplate.query( "select first_name, last_name from t_actor", new ActorMapper());

}

private static final class ActorMapper implements RowMapper<Actor> {

  public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

    Actor actor = new Actor();

    actor.setFirstName(rs.getString("first_name"));

    actor.setLastName(rs.getString("last_name"));

    return actor;

  }

}
```



**JdbcTemplate insert 예제**

INSERT 하기

```java
this.jdbcTemplate.update("insert into t_actor (first_name, last_name) values (?, ?)",  "Leonor", "Watling");
```



**JdbcTemplate update 예제**

UPDATE 하기

```java
this.jdbcTemplate.update("update t_actor set = ? where id = ?",  "Banjo", 5276L);
```



**JdbcTemplate delete 예제**

DELETE 하기

```java
this.jdbcTemplate.update("delete from actor where id = ?", Long.valueOf(actorId));
```



**JdbcTemplate외의 접근방법**

**NamedParameterJdbcTemplate**

- JdbcTemplate에서 JDBC statement 인자를 ?를 사용하는 대신 파라미터명을 사용하여 작성하는 것을 지원
- [NamedParameterJdbcTemplate 예제](https://docs.spring.io/spring/docs/current/spring-framework-reference/data-access.html#jdbc-NamedParameterJdbcTemplate)

**SimpleJdbcTemplate**

- JdbcTemplate과 NamedParameterJdbcTemplate 합쳐 놓은 템플릿 클래스
- 이제 JdbcTemplate과 NamedParameterJdbcTemplate에 모든 기능을 제공하기 때문에 삭제 예정될 예정(deprecated)
- [SimpleJdbcTemplate 예제](https://www.concretepage.com/spring/simplejdbctemplate-spring-example)

**SimpleJdbcInsert**

- 테이블에 쉽게 데이터 insert 기능을 제공
- [SimpleJdbcInsert 예제](https://www.tutorialspoint.com/springjdbc/springjdbc_simplejdbcinsert.htm)



 

------

**생각해보기**

1. JDBC 프로그래밍이 불편해서 이를 해결하기 위해서 등장한 기술에는 Spring JDBC 외에도 다양한 기술들이 존재합니다. 대표적으로 JPA와 MyBatis가 그러한 기술입니다. 문제를 해결하는 방법이 왜 여러 가지가 존재할끼요?



 

------

**참고 자료**

[**[참고링크\] Data Access**https://docs.spring.io](https://docs.spring.io/spring/docs/current/spring-framework-reference/data-access.html#jdbc)