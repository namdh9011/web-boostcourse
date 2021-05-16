# 3) DDL(create, drop)

**들어가기 전에**

이번 시간엔 데이터가 저장되는 틀인 테이블을 생성, 수정, 삭제하는 방법에 대해 배워보도록 하겠습니다.

 



------

**학습 목표**

1. 테이블을 생성할 수 있다.
2. 테이블을 수정할 수 있다.
3. 테이블을 삭제할 수 있다.

 

 

------

**핵심 개념**

- create table
- alter table
- drop table

 

 

------

**학습하기**

**MySQL 데이터 타입**

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_1.png)

- **MySQL 데이터 타입-1**

![3_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_2.png)

- **MySQL 데이터 타입-2**

**테이블 생성**

```markup
create table 테이블명( 
          필드명1 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          필드명2 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          필드명3 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          ........... 
          PRIMARY KEY(필드명) 
          );
```

- 데이터 형 외에도 속성값의 빈 값 허용 여부는 NULL 또는 NOT NULL로 설정
- DEFAULT 키워드와 함께 입력하지 않았을 때의 초기값을 지정
- 입력하지 않고 자동으로 1씩 증가하는 번호를 위한 AUTO_INCREMENT

 

**테이블 생성 실습**

EMPLOYEE와 같은 구조를 가진 EMPLOYEE2 테이블을 생성하시오.

![3_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_3.png)

- **테이블 생성 실습**

```markup
CREATE TABLE EMPLOYEE2(   
            empno      INTEGER NOT NULL PRIMARY KEY,  
           name       VARCHAR(10),   
           job        VARCHAR(9),   
           boss       INTEGER,   
           hiredate   VARCHAR(12),   
           salary     DECIMAL(7, 2),   
           comm       DECIMAL(7, 2),   
          deptno     INTEGER);
```

 

**테이블 수정 (컬럼 추가 / 삭제)**

```markup
alter table 테이블명
          add  필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];

alter table 테이블명
         drop  필드명;
```

 

**테이블 수정 실습 (컬럼 추가)**

실습 – EMPLOYEE2 테이블에 생일(birthdate)칼럼을 varchar(12)형식으로 추가하시오.

```markup
alter table EMPLOYEE2

add birthdate varchar(12);
```

![3_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_4.png)

- **테이블 수정 실습(컬럼추가)**

**테이블 수정 실습 (컬럼 삭제)**

실습 – EMPLOYEE2 테이블의 생일(birthdate)칼럼을 삭제하시오.

```markup
alter table EMPLOYEE2

drop birthdate;
```

![3_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_5.png)

- **테이블 수정 실습(컬럼추가삭제)**

**테이블 수정 (컬럼 수정)**

```markup
alter table  테이블명
     change  필드명  새필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];
```

- change 키워드를 사용하고 칼럼을 새롭게 재정의 (이름부터 속성까지 전부)

 

**테이블 수정 실습 (컬럼 수정)**

실습 – EMPLOYEE2 테이블의 부서번호(deptno)를 dept_no로 수정하시오.

```markup
alter table EMPLOYEE2

change deptno dept_no int(11);
```

![3_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_6.png)

- **테이블 수정 실습(컬럼수정)**

**테이블 이름 변경**

```markup
alter table  테이블명 rename 변경이름
```

 

**테이블 이름 변경 실습**

실습 – EMPLOYEE2 테이블의 이름을 EMPLOYEE3로 변경하시오.

```markup
alter table EMPLOYEE2

rename EMPLOYEE3;
```

![3_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_7.png)

- **테이블 이름 변경 실습**

**테이블 삭제하기**

```markup
drop table 테이블이름;
```

참고로, 제약 조건이 있을 경우에는 drop table 명령으로도 테이블이 삭제되지 않을 수 있습니다.

그럴 경우는 테이블을 생성한 반대 순서로 삭제를 해야합니다.

 

**테이블 삭제 실습**

\* 테이블 삭제 후 desc 명령을 수행하면, 존재하지 않는 테이블이라고 표시됩니다.

실습 – EMPLOYEE2 테이블을 삭제하시오.

```markup
drop table EMPLOYEE2;
```

![3_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/3_8.png)

- **테이블 삭제 실습**

------

**생각해보기**

- 칼럼의 길이가 10인데, 해당 칼럼에 값이 저장되어 있습니다. 이 때 칼럼의 길이를 5로 바꾼다면 어떤 일이 벌어질까요?
- **문자열을 저장하는 데이터 타입인 CHAR와 VARCHAR 차이점에 대해 알아보고 어떤 상황에서 CHAR 또는 VARCHAR 를 선택하는 것이 효율적인지 생각해봅시다.**
- 문자열 데이터 타입에는 문자셋을 지정할 수 있습니다. 문자셋에 따라 해당 필드가 차지하는 공간 크기를 한번 계산해보자. (예: VARCHAR(10) CHARACTER SET UTF8; 은 몇 Byte 크기를 차지할까요? ASCII 일때는 또 몇 Byte 크기를 가질까요?

 

 

------

**참고 자료**

[**[참고링크\] 13.1.18 CREATE TABLE Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/create-table.html)

[**[참고링크\] 13.1.8 ALTER TABLE Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/alter-table.html)

[**[참고링크\] 13.1.29 DROP TABLE Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/drop-table.html)