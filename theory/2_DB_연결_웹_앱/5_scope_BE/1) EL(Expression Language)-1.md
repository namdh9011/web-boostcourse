# 1) EL(Expression Language)-1

**들어가기 전에**

jsp에서 표현식을 이용해 값을 출력할 때 변수의 값이 null이면 화면에 null이 출력되었습니다.

이 경우 null인지를 check한 후 null이면 아무것도 없는 문자열을 출력해야 하는 등 불편한 과정을 거쳐야 합니다.

EL을 사용하면 좀 더 편리하게 변수를 JSP에서 사용할 수 있습니다.

그럼 EL에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. EL을 이해한다.
2. EL을 사용할 수 있다. 

 

 

------

**핵심 개념**

- EL
- isELIgnored

 

 

------

**학습하기**

**표현 언어란?**

- 표현 언어(Expression Language)는 값을 표현하는 데 사용되는 스크립트 언어로서 JSP의 기본 문법을 보완하는 역할을 한다.

 

**표현 언어가 제공하는 기능**

- JSP의 스코프(scope)에 맞는 속성 사용
- 집합 객체에 대한 접근 방법 제공
- 수치 연산, 관계 연산, 논리 연산자 제공
- 자바 클래스 메소드 호출 기능 제공
- 표현언어만의 기본 객체 제공

 

**표현언어의 표현방법**

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_1.png)

- **표현언어의 표현 방법**

**표현언어의 기본 객체**

![1_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_2.png)

- **표현언어의 표현방법**

**표현 언어의 기본 객체 사용 예**

![1_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_3.png)

- **표현언어의 기본객체 사용의 예**

**표현 언어의 데이터 타입**

- 불리언 타입 - true와 false
- 정수타입 - 0~9로 이루어진 정수 값 음수의 경우 '-'가 붙음
- 실수타입 - 0~9로 이루어져 있으며, 소수점('.')을 사용할 수 있고, 3.24e3과 같이 지수형으로 표현 가능하다.
- 문자열 타입 - 따옴표( ' 또는" )로 둘러싼 문자열. 만약 작은 따옴표(')를 사용해서 표현할 경우 값에 포함된 작은 따옴표는 \' 와 같이 \ 기호와 함께 사용해야 한다.
- \ 기호 자체는 \\ 로 표시한다.
- 널 타입 - null

 



![1_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_4.png)

- **객체 접근 규칙**

**객체 접근 규칙**

- 표현 1이나 표현 2가 null이면 null을 반환한다.
- 표현1이 Map일 경우 표현2를 key로한 값을 반환한다.
- 표현1이 List나 배열이면 표현2가 정수일 경우 해당 정수 번째 index에 해당하는 값을 반환한다.
- 만약 정수가 아닐 경우에는 오류가 발생한다.
- 표현1이 객체일 경우는 표현2에 해당하는 getter메소드에 해당하는 메소드를 호출한 결과를 반환한다.

 

**표현 언어의 수치 연산자**

- \+ : 덧셈
- \- : 뺄셈
- \* : 곱셈
- / 또는 div : 나눗셈
- % 또는 mod : 나머지
- 숫자가 아닌 객체와 수치 연산자를 사용할 경우 객체를 숫자 값으로 변환 후 연산자를 수행 : ${"10"+1} → ${10+1}
- 숫자로 변환할 수 없는 객체와 수치 연산자를 함께 사용하면 에러를 발생 : ${"열"+1} → 에러
- 수치 연산자에서 사용되는 객체가 null이면 0으로 처리 : ${null + 1} → ${0+1}

 

**비교 연산자**

- == 또는 eq
- != 또는 ne
- < 또는 lt
- \> 또는 gt
- <= 또는 le
- \>= 또는 ge
- 문자열 비교: ${str == '값'} str.compareTo("값") == 0 과 동일

 

**논리 연산자**

- && 또는 and
- || 또는 or
- ! 또는 not

 

**empty 연산자, 비교선택 연산자**

![1_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_5.png)

- **연산자, 비교선택 연산자**

**연산자 우선순위**

1. [] .
2. ()
3. \- (단일) not ! empty
4. \* / div % mod
5. \+ -
6. < > <= >= lt gt le ge
7. == != eq ne
8. && and
9. || or
10. ? :

 

**표현 언어 비활성화 : JSP에 명시하기**

- <%@ page isELIgnored = "true" %>

![1_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/1_6.png)

- 

  출처 https://docs.oracle.com/cd/E19316-01/819-3669/bnaic/index.html

------

**참고 자료**

[**[참고링크\] JSP Expression Language | EL - javatpoint**https://www.javatpoint.com](https://www.javatpoint.com/EL-expression-in-jsp)