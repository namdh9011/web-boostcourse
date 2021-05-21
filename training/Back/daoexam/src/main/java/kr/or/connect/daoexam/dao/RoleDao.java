package kr.or.connect.daoexam.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;	//static import 사용 
@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;	//이름을 이용해서 바인딩 하거나 객체 값을 가져올 수 있게해줌
	private SimpleJdbcInsert insertAction;		//Insert를 위해 필요
	
	//java는 필드에 roleId와 같은 카멜 표기법을 쓰고 MySQL은 role_id와 같은 방식으로 네이밍을 해주는데 두 필드 값이 달라도 알아서 네이밍 해준다.
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");		//insert 어떤 테이블에 넣을지 알려줌.
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
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
