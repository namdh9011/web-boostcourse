# 2) DML(select, insert, update, delete)-4

**들어가기 전에**

이번 시간에는 DBMS에 값을 저장, 수정, 삭제, 조회하는 방법에 대해 배워보도록 하겠습니다.

 

 

------

**학습 목표**

1. insert문을 수행할 수 있다.
2. update문을 수행할 수 있다.
3. delete문을 수행할 수 있다.
4. select문을 수행할 수 있다.

 

 

------

**핵심 개념**

- select
- insert
- update
- delete

 

 

------

**학습하기**

**데이터 입력 (INSERT문)**

```markup
INSERT INTO 테이블명(필드1, 필드2, 필드3, 필드4, … ) 
        VALUES ( 필드1의 값, 필드2의 값, 필드3의 값, 필드4의 값, … )

INSERT INTO 테이블명
        VALUES ( 필드1의 값, 필드2의 값, 필드3의 값, 필드4의 값, … )
```

- 필드명을 지정해주는 방식은 디폴트 값이 세팅되는 필드는 생력할 수 있습니다.
- 필드명을 지정해주는 방식은 추 후, 필드가 추가/변경/수정 되는 변경에 유연하게 대처 가능합니다.
- 필드명을 생략했을 경우에는 모든 필드 값을 반드시 입력해야 합니다.

 

**데이터 입력 실습 (INSERT문)**

예제 : ROLE테이블에 role_id는 200, description에는 'CEO'로 한건의 데이터를 저장하시오.

```markup
insert into ROLE (role_id, description) values ( 200, 'CEO');
```

![2_21](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_21.png)

**데이터 수정(UPDATE문)**

```markup
 UPDATE  테이블명
        SET  필드1=필드1의값, 필드2=필드2의값, 필드3=필드3의값, …
   WHERE  조건식
```

- 조건식을 통해 특정 row만 변경할 수 있습니다.
- 조건식을 주지 않으면 전체 로우가 영향을 미치니 조심해서 사용하도록 합니다.

[예제11] user 번호가 1인 사용자의 이름을 영문으로 바꾸고,  join_date을 현재 시간이 적용되도록 수정하시오.



**데이터 수정 실습(UPDATE문)**

예제 : ROLE테이블에 role_id가 200일 경우 description을 'CTO'로 수정하시오.

```markup
update ROLE

set description = 'CTO'

where role_id = 200;
```

\* where절을 안줄 경우 모든 데이터가 수정되니 조심해야 합니다.

![2_22](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_22.png)

- **데이터 수정 실습(UPDATE문)**

**데이터 삭제(DELETE문)**

```markup
 DELETE
      FROM  테이블명
WHERE  조건식
    
```

- 조건식을 통해 특정 row만 삭제할 수 있습니다.
- 조건식을 주지 않으면 전체 로우가 영향을 미치니 조심해서 사용하도록 합니다.

[예제12] user 번호가 1인 사용자를 삭제하시오.



**데이터 삭제 실습(DELETE문)**

예제 : ROLE테이블에서 role_id는 200인 정보를 삭제하시오.

```markup
delete from ROLE where role_id = 200;
```

\* where절을 안줄 경우 모든 데이터가 삭제되니 조심해야 합니다.

![2_23](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_23.png)

- **데이터 삭제 실습(DELETE 문)**

**생각해보기**

사원의 이름과 그 사원이 속한 부서명을 구하려면 어떻게 해야할까요?

이 경우엔 EMPLOYEE 테이블과 DEPARTMENT 테이블을 조인(Join)해야 합니다. 

select문과 join에 대해 알아보세요.

 

 

------

**참고 자료**

[**[참고링크\] 13.2.9 SELECT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

[**[참고링크\] 13.2.5 INSERT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/insert.html)

[**[참고링크\] 13.2.11 UPDATE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/update.html)

[**[참고링크\] 13.2.2 DELETE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/delete.html)

[ ![img](https://cphinf.pstatic.net/mooc/20201027_128/1603786584884IPUAw_PNG/eTquCygoA6oDRZoQ6fXv.png?type=ffn199_148)**SQL Joins Explained**http://www.sql-join.comA resource explaining what a SQL join is, examples of different join types, and the technical ETL documentation required to start joining tables.](http://www.sql-join.com/)

[**[참고링크\] SQL Joins**https://www.w3schools.com](https://www.w3schools.com/sql/sql_join.asp)

[**[참고링크\] 테이블 JOIN - SQL 프로그래밍 배우기 (Learn SQL Programming)**http://www.sqlprogram.com](http://www.sqlprogram.com/Basics/sql-join.aspx)