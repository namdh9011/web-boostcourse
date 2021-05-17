# 2) JDBC 실습-3

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

- java try에 새로 추가된 문법 사용했다. finally 대신 try with resource를 사용해서 수행한다.
- Dao에 selectrist 메소드 추가
- JDBCExam3.java 추가





**실습코드**

RoleDao.java - SELECT

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

	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
```

 

JDBCExam3.java - SELECT

```java
package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {

		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();

		for(Role role : list) {
			System.out.println(role);
		}
	} 
}
```

 

RoleDao.java - Delete

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

	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  roleId);

			deleteCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally

		return deleteCount;
	}
}
```

 

JDBCExam4.java - Delete

```java
package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;

public class JDBCExam4 {
	public static void main(String[] args) {
//삭제 테스트
		int roleId = 500;

		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roleId);

		System.out.println(deleteCount);
	}
}
```

 

RoleDao.java - Update

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
	
	public int updateRole(Role role) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "update role set description = ? where role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2,  role.getRoleId());
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}
}
```

 

JDBCExam5.java - Update

```java
package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam5 {
	public static void main(String[] args) {
//수정테스트
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);

		System.out.println(updateCount);
	} 
}
```

 

[참고] Role 스키마 구조

```markup
mysql> describe Role;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| role_id     | int(11)      | NO   | PRI | NULL    |       |
| description | varchar(100) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
```

 

------

**생각해보기**

1.  JDBC를 이용해서 입력/수정/삭제/조회 메소드를 만들다 보면, 반복적인 코드가 많다는 것을 알 수 있습니다.반복되는 부분을 별도의 메서드나 클래스로 추출한다면 어떤 부분의 중복을 제거할수 있을까요?
2.  JDK7부터 추가된 try-with-resource 구문을 이용한다면 예제 코드 중 어떤 부분을 줄일 수 있을까요? 



------

**참고 자료
**

[**[참고링크\] JDBC Tutorial**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

[**[참고링크\] The try-with-resources Statement**https://docs.oracle.com](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)