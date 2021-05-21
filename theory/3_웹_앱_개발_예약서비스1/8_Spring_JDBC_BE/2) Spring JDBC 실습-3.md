# 2) Spring JDBC 실습-3

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

- dto 패키지 - Role.java 생성
- dao 패키지 - RoleDao.java, RoleDaoSqls.java 생성
- ApplicationConfig에 @ComponentScan추가
- main 패키지 - SelectAllTest.java 추가

**실습코드**

Role.java

```java
package kr.or.connect.daoexam.dto;

public class Role {
	private int roleId;
	private String description;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
}
```

 

RoleDaoSqls.java

```java
package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
}
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
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}

}
```

 

ApplicationConfig.java 에 추가

```java
@ComponentScan(basePackages = { "kr.or.connect.daoexam.dao" })
```

 

SelectAllTest.java

```java
package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		
		RoleDao roleDao =ac.getBean(RoleDao.class);

		List<Role> list = roleDao.selectAll();
		
		for(Role role: list) {
			System.out.println(role);
		}

	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20201028_51/16038691128671cgSt_JPEG/W4Z3MdJUJ97qggyR8Bit.jpg?type=ffn199_148)**[참고링크\] Data Access Object Pattern**https://www.tutorialspoint.com](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

[ ![img](https://cphinf.pstatic.net/mooc/20201028_116/1603869162729SvM4l_JPEG/FT08AJo7GyFE5XRk4oTr.jpg?type=ffn199_148)**[참고링크\] Using JDBC to Connect to a Database**https://ejbvn.wordpress.com](https://ejbvn.wordpress.com/category/week-2-entity-beans-and-message-driven-beans/day-09-using-jdbc-to-connect-to-a-database/)