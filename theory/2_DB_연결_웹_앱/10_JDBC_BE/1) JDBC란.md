# 1) JDBC란?

**들어가기 전에**

이번 시간엔 JAVA언어를 이용해서 DBMS로 부터 정보를 조회하는 방법인 JDBC에 대해 알아보도록 하겠습니다.



 

------

**학습 목표**

1. JDBC가 무엇인지 이해한다.



 

------

**핵심 개념**

- JDBC
- DriverManager
- Connection
- Statement
- ResultSet



 

------

**학습하기**

**JDBC 개요**

- JDBC(Java Database Connectivity)의 정의
  \- 자바를 이용한 데이터베이스 접속과 SQL 문장의 실행, 그리고 실행 결과로 얻어진 데이터의 핸들링을 제공하는 방법과 절차에 관한 규약
  \- 자바 프로그램 내에서 SQL문을 실행하기 위한 자바 API
  \- SQL과 프로그래밍 언어의 통합 접근 중 한 형태
- JAVA는 표준 인터페이스인 JDBC API를 제공
- 데이터베이스 벤더, 또는 기타 써드파티에서는 JDBC 인터페이스를 구현한 드라이버(driver)를 제공한다.



**JDBC 환경 구성**

- JDK 설치
- JDBC 드라이버 설치
  \- Maven에 다음과 같은 의존성을 추가한다. MySQL사이트에서 다운로드 한다.

```markup
<dependency>   
  <groupId>mysql</groupId>   
       <artifactId>mysql-connector-java</artifactId>
       <version>5.1.45</version>
 </dependency>
```

- [Java API Reference 참고 바로가기](https://docs.oracle.com/javase/8/docs/api/)
- [JDBC Tutorial 참고 바로가기](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)



**JDBC를 이용한 프로그래밍 방법**

1. import java.sql.*;
2. 드라이버를 로드 한다.
3. Connection 객체를 생성한다.
4. Statement 객체를 생성 및 질의 수행
5. SQL문에 결과물이 있다면 ResultSet 객체를 생성한다.
6. 모든 객체를 닫는다.



**JDBC 클래스의 생성 관계**

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/10_JDBC_BE/image/1_1.png)

- **JDBC클래스의 생성단계**

**JDBC 사용 - 단계별 설명**

\1. IMPORT

```java
import java.sql.*;
```

 

\2. 드라이버 로드

```java
Class.forName( "com.mysql.jdbc.Driver" );
```

 

\3. Connection 얻기

```java
String dburl  = "jdbc:mysql://localhost/dbName";

Connection con =  DriverManager.getConnection ( dburl, ID, PWD );
```

 

소스코드 예제

```java
public static Connection getConnection() throws Exception{
	String url = "jdbc:oracle:thin:@117.16.46.111:1521:xe";
	String user = "smu";
	String password = "smu";
	Connection conn = null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	return conn;
}
```

 

\4. Statement 생성

```java
Statement stmt = con.createStatement();
```

 

\5. 질의 수행

```java
ResultSet rs = stmt.executeQuery("select no from user" );

참고
stmt.execute(“query”);             //any SQL
stmt.executeQuery(“query”);     //SELECT
stmt.executeUpdate(“query”);   //INSERT, UPDATE, DELETE
```

 

\6. ResultSet으로 결과 받기

```java
ResultSet rs =  stmt.executeQuery( "select no from user" );
while ( rs.next() )
      System.out.println( rs.getInt( "no") );
```

 

\7. Close

```java
rs.close();

stmt.close();

con.close();
```

 

소스코드 예제

```java
public List<GuestBookVO> getGuestBookList(){
		List<GuestBookVO> list = new ArrayList<>();
		GuestBookVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from guestbook";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				vo = new GuestBookVO();
				vo.setNo(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setConetnt(rs.getString(4));
				vo.setRegDate(rs.getString(5));
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}		
		return list;		
	}
```

 

소스코드 예제

```java
public int addGuestBook(GuestBookVO vo){
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into guestbook values("
					+ "guestbook_seq.nextval,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getConetnt());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
		
		return result;
	}
```

 

소스코드 예제

```java
public static void close(Connection conn, PreparedStatement ps){
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {e.printStackTrace(); }
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
```



 

------

**생각해보기**

java.sql패키지를 보면 대부분이 interface로 되어 있는 것을 알 수 있습니다.

이를 실제로 구현하는 것은 DBMS를 만든 회사입니다.

java.sql외에 JAVA가 인터페이스만 대부분 제공하는 패키지는 또 어떤 것이 있을까요?

참고로 XML문서의 표준은 w3c에서 정합니다.



 

------

**참고 자료**

[**[참고링크\] Java API Reference**https://docs.oracle.com](https://docs.oracle.com/javase/8/docs/api/)

[**[참고링크\] JDBC Tutorial**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)