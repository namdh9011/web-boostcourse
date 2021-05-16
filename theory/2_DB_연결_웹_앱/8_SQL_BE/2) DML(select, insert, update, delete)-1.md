# 2) DML(select, insert, update, delete)-1

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

**데이터 조작어(Data Manipulation Language, DML)의 종류**

데이터 조작어는 모두 동사로 시작합니다.

시작하는 동사에 따라서 다음과 같은 4가지 조작어가 있습니다.

- SELECT – 검색
- INSERT - 등록
- UPDATE - 수정
- DELETE - 삭제



**SELECT 구문의 기본문형**

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_1.png)

- **select 구문의 기본문형**

**SELECT 구문 예제(전체 데이터 검색)**

- 전체 데이터 검색
- SELECT 뒤에 * 를 기술함으로써 나타낼 수 있다.

예제 : departments 테이블의 모든 데이터를 출력하시오.

```mysql
  SELECT * FROM  DEPARTMENT;
```

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_2.png)

- **select 구문 예제**

**SELECT 구문 예제(특정 컬럼 검색)**

- SELECT 뒤에 컬럼을 콤마(,)로 구별해서 나열

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

어떤 칼럼이 있는지는 desc명령으로 확인

```mysql
select empno, name, job from employee;
```

![2_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_3.png)

- **select 구문 예제(특정 컬럼 검색)**

**SELECT 구문 예제(컬럼에 Alias부여하기)**

- 컬럼에 대한 ALIAS(별칭)을 부여해서 나타내는 칼럼의 HEADING을 변경할 수 있다.

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

```mysql
select empno as 사번, name as 이름, job as 직업 from employee;
```

![2_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_4.png)

- **select 구문 예제(칼럼에 alias부여하기)**

**SELECT 구문 예제(컬럼의 합성(Concatenation))**

- 문자열 결합함수 concat 사용

예제 : employee 테이블에서 사번과 부서번호를 하나의 칼럼으로 출력하시오.

```mysql
SELECT concat( empno, '-', deptno) AS '사번-부서번호' 
FROM employee;
```

![2_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_5.png)

- **select 구문 예제(컬럼의 합성)**

**SELECT 구문 예제(중복행의 제거)**

- 중복되는 행이 출력되는 경우, DISTINCT 키워드로 중복행을 제거

예제1 : 사원 테이블의 모든 부서번호 출력하시오. (사원 수 만큼 출력된다.)

```mysql
select deptno from employee;
```

![2_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_6.png)

- **select 구문 예제(중복행의 제거)**

예제2 : 사원 테이블의 부서번호를 중복되지 않게 출력하시오.

```mysql
select distinct deptno from employee;
```

![2_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_7.png)

- **select 구문 예제(중복행의 제거)-2**

**SELECT 구문 예제(정렬하기)**

![2_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_8.png)

- **ORDER BY 절**

**SELECT 구문 예제(정렬하기)**

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

단, 이름을 기준으로 오름차순 정렬합니다.

```mysql
select empno, name, job from employee order by name;

select empno as 사번, name as 이름, job as 직업 from employee order by 이름;
```

![2_9](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_9.png)

- **select 구문 예제(alias를 사용하지 않았을 경우)**

![2_10](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_10.png)

- **select 구문 예제(alias를 사용했을 경우)**

**SELECT 구문 예제(정렬하기)**

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

단, 이름을 기준으로 내림차순 정렬합니다.

```mysql
select empno, name, job from employee order by name desc;
```

![2_11](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_11.png)

- **select 구문 예제(이름 기준 내림 차순 정렬하기 결과)**

**참고 자료**

[**[참고링크\] 13.2.9 SELECT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

[**[참고링크\] 13.2.5 INSERT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/insert.html)

[**[참고링크\] 13.2.11 UPDATE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/update.html)

[**[참고링크\] 13.2.2 DELETE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/delete.html)