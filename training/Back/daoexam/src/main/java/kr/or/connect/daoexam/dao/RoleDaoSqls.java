package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
	//insert문 같은 경우는 쿼리가 따로 필요하지 않음.

	//:값  값이 바인딩 될 부분이다.
	public static final String UPDATE = "UPDATE role set description = :description where role_id = :roleId";
	
}
