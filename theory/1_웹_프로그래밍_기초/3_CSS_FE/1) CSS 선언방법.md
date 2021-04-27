# 1) CSS 선언방법

**들어가기 전에**

CSS를 HTML안에 선언하는 방식은 크게 3가지가 있습니다.

이를 잘 이해하고 활용하는 것이 좋습니다.



 

------

**학습 목표**

1. CSS선언 방식을 이해하고 활용할 수 있다.



 

------

**핵심 개념**

- inline
- internal
- external



 

------

**학습하기**

**CSS의 구성**

```css
span {
  color : red;
  }
```

- span : selector(선택자)
- color : property
- red : value



**style을 HTML페이지에 적용하는 3가지 방법**



**1. inline**

HTML태그 안에다가 적용합니다.

다른 CSS파일에 적용한 것 보다 가장 먼저 적용합니다.

```html
<p style="border:1px solid gray;color:red;font-size:2em;">
```

 

**2. internal**

style 태그로 지정합니다.

구조와 스타일이 섞이게 되므로 유지보수가 어렵습니다.

별도의 CSS파일을 관리하지 않아도 되며 서버에 CSS파일을 부르기 위해 별도의 브라우저가 요청을 보낼 필요가 없습니다.

```html
<head>
<style>
p  {
  font-size : 2em;
  border:1px solid gray;
  color: red;
}
</style>
</head>

<body>
<div>...</div>
</body>
```

 

**3. external**

외부파일(.css)로 지정하는 방식입니다.

CSS 코드가 아주 짧지 않다면 가급적 이 방법으로 구현하는 것이 가장 좋습니다.

현업에서는 여러개의 CSS 파일로 분리하고 이를 합쳐서 서비스에서 사용하기도 합니다.

internal 코드와 같은 css코드를 구현하고, style.css와 같은 별도 파일로 만듭니다. 

이후에 아래처럼 link태그로 추가하면 됩니다.

```html
<html>
	<head>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<div>
			<p>
				<ul>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</p>
		</div>
	</body>
</html>
```



**4. 우선순위** 

inline은 별도의 우선순위를 갖지만, internal 과 external은 우선순위가 동등합니다. 따라서 겹치는 선언이 있을 경우 나중에 선언된 속성이 반영됩니다.

 

 

------

**생각해보기**

1. javascript로 동적으로 css코드를 수정하려고 하면 어떻게 해야 할까요? 나중에 차츰 알게 되지만, 미리 어떤 방법이 있을지 고민해보세요. 
2. 구글 웹사이트는 어떻게 css를 선언하고 있을까요? 구글 웹사이트(구글 내 여러가지 웹사이트중 하나)에서 소스보기를 해서 CSS 코드를 한번 찾아보세요. internal 방식이나 external 방식 등을 목격할 수 있을 겁니다.

 

 

------

**참고 자료**

[**[참고링크\] Difference Between Inline, External and Internal CSS Styles**https://www.hostinger.com세 가지 방식에 대한 예제와 설명입니다.](https://www.hostinger.com/tutorials/difference-between-inline-external-and-internal-css)