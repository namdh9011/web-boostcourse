# 2) DML(select, insert, update, delete)-3

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

**SELECT 구문(CAST 형변환)**



![2_17](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_17.png)

- **SELECT 구문 (CAST 형변환)**

예제

```markup
mysql> select cast(now() as date);
+---------------------+
| cast(now() as date) |
+---------------------+
| 2003-09-25          |
+---------------------+
1 row in set (0.00 sec)
mysql> select cast(1-2 as unsigned);
+----------------------------+
|   cast(1-2 as unsigned)    |
+----------------------------+
|  18446744073709551615 |
+----------------------------+
```

 

**SELECT 구문(그룹함수)**

![2_18](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_18.png)

- **SELECT 구문(그룹함수)**

**SELECT 구문 예제(그룹함수)**

예제 : employee 테이블에서 부서번호가 30인 직원의 급여 평균과 총합계를 출력하시오.



```markup
SELECT AVG(salary) , SUM(salary)
FROM employee
WHERE deptno = 30;
```

![2_19](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_19.png)

- **SELECT 구문 예제(그룹함수)**

**SELECT 구문 예제(그룹함수와 groupby 절)**

예제 : employee 테이블에서 부서별 직원의 부서번호, 급여 평균과 총합계를 출력하시오.

```markup
SELECT deptno, AVG(salary) , SUM(salary)

FROM employee

group by deptno;
```

 

![2_20](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_20.png)

- **SELECT 구문 예제(그룹함수와 groupby 절)**

**참고 자료**

[**[참고링크\] 13.2.9 SELECT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

[**[참고링크\] 13.2.5 INSERT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/insert.html)

[**[참고링크\] 13.2.11 UPDATE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/update.html)

[**[참고링크\] 13.2.2 DELETE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/delete.html)