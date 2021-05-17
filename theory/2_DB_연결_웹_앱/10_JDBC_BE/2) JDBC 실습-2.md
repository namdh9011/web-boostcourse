# 2) JDBC 실습-2

**들어가기 전에**

이번 시간엔 JDBC를 이용해 데이터베이스에서 입력/수정/조회/삭제를 하는 프로그램을 만들어 보도록 하겠습니다.

 

 

------

**학습 목표**

1. JDBC를 이용해 입력/수정/삭제/조회 프로그래밍을 할 수 있다.

 

 

------

**핵심 개념**

- JDBC
- PreparedStatement
- ResultSet
- Connection

 

 

------

**학습하기**

**노트**

- RoleDao.java에 Insert 메서드 추가
- JDBCExam2.java 생성

**실습코드**

RoleDao.java - Insert

```java
package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	public int addRole(Role role) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
}
```



JDBCExam2.java - Insert

```java
package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		int roleId = 501;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);

		System.out.println(insertCount);
	}
}
```

**참고 자료**

[**[참고링크\] JDBC Tutorial**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)