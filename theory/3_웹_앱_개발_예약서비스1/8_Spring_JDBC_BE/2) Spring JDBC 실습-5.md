# 2) Spring JDBC 실습-5

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

- RoleDaoSqls.java에 delete, select 추가
- RoleDao.java에 delete, select 추가
- JDBCTest.java에 테스트 추가

**실습코드**

RoleDaoSqls.java에 추가

```java
public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role where role_id = :roleId";
public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id = :roleId";
```



RoleDao.java에 추가

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
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
```

 

JDBCTest.java에 추가

```java
Role resultRole = roleDao.selectById(201);
System.out.println(resultRole);
		
int deleteCount = roleDao.deleteById(500);
System.out.println(deleteCount + "건 삭제하였습니다.");
	
Role resultRole2 = roleDao.selectById(500);
System.out.println(resultRole2);
		
```

 

 

------


**생각해보기**

1. JdbcTemplate을 이용하지 않고 NamedParameterJdbcTemplate를 이용하여 DAO를 작성한 이유는 무엇이라고 생각하나요?



------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_51/16038691128671cgSt_JPEG/W4Z3MdJUJ97qggyR8Bit.jpg?type=ffn199_148)**[참고링크\] Data Access Object Pattern**https://www.tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

[ ![img](https://cphinf.pstatic.net/mooc/20201028_116/1603869162729SvM4l_JPEG/FT08AJo7GyFE5XRk4oTr.jpg?type=ffn199_148)**[참고링크\] Using JDBC to Connect to a Database**https://ejbvn.wordpress.com](https://ejbvn.wordpress.com/category/week-2-entity-beans-and-message-driven-beans/day-09-using-jdbc-to-connect-to-a-database/)