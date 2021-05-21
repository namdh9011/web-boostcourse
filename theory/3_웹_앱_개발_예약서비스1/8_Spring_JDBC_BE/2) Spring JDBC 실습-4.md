# 2) Spring JDBC 실습-4

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

**노트**

- RoleDao.java에 insert관련 추가.
- main패키지 - JDBCTest.java 추가.
- RoleDaoSqls.java에 update 관련 추가
- RoleDao.java에 update관련 추가

**실습코드**

RoleDaoSqls.java에 추가

```java
public static final String UPDATE = "UPDATE role SET description = :description WHERE ROLE_ID = :roleId";
```

RoleDao.java

```java
package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");

	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}

	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	

}
```

 

JDBCTest.java

```java
package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(201);
		role.setDescription("PROGRAMMER");
		
		int count = roleDao.insert(role);
		System.out.println(count + "건 입력하였습니다.");
			
		int count = roleDao.update(role);
		System.out.println(count +  " 건 수정하였습니다.");
	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_51/16038691128671cgSt_JPEG/W4Z3MdJUJ97qggyR8Bit.jpg?type=ffn199_148)**[참고링크\] Data Access Object Pattern**https://www.tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

[ ![img](https://cphinf.pstatic.net/mooc/20201028_116/1603869162729SvM4l_JPEG/FT08AJo7GyFE5XRk4oTr.jpg?type=ffn199_148)**[참고링크\] Using JDBC to Connect to a Database**https://ejbvn.wordpress.com](https://ejbvn.wordpress.com/category/week-2-entity-beans-and-message-driven-beans/day-09-using-jdbc-to-connect-to-a-database/)