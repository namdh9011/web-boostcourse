# 5) Element가 배치되는 방법(CSS layout)-2

**들어가기 전에**

CSS의 배치를 위해서는 중요한 여러 가지 개념을 알고 있어야 합니다.

그중에서 block과 inline의 차이 그리고 position 속성을 이해해야 합니다.

또한, 많이 사용되고 있는 float의 성질도 알아둘 필요가 있습니다.

 



------

**학습 목표**

1. layout의 방식에 대해서 이해합니다.



 

------

**핵심 개념**

- 박스 모델 (Box model)
- margin
- border
- padding
- position



 

------

**학습하기**

**엘리먼트가 배치되는 방식**

엘리먼트를 화면에 배치하는 것을 layout 작업이라고도 하고, Rendering 과정이라고도 합니다.

편의상 우리는 배치라고 할 겁니다.

기본 엘리먼트는 위에서 아래로 배치되는 것이 기본입니다.

하지만 웹사이트의 배치는 다양하게 표현 가능해야 하므로, 이를 다양한 방식으로 배치할 수 있도록 다양한 속성을 활용합니다.

중요하게 이해해야 할 속성은 다음과 같습니다.

```css
display(block, inline, inline-block)
position(static, absolute, relative, fixed)
float(left, right)
```

이 속성을 중심으로 엘리먼트의 배치를 이해할 겁니다.


**엘리먼트가 배치되는 방식 - (display:block)**

display속성이 block이거나 inline-block인 경우 그 엘리먼트는 벽돌을 쌓든 블록을 가지고 쌓입니다.

```html
<div>block1</div>
<p>block2</p>
<div>block3</div>
```


**엘리먼트가 배치되는 방식 - (display:inline)**

display 속성이 inline인 경우는 우측으로, 그리고 아래쪽으로 빈자리를 차지하며 흐릅니다.

높이와 넓이를 지정해도 반영이 되지 않습니다.

```html
<div>
  <span>나는 어떻게 배치되나요?</span>
  <span>좌우로 배치되는군요</span>
  <a>링크는요?</a>
  <strong>링크도 강조도 모두 좌우로 흐르는군요</strong>
  모두다 display속성이 inline인 엘리먼트이기 때문입니다.
</div>
```

[code 바로가기](http://jsbin.com/wacukuf/edit?html,output)



**엘리먼트가 배치되는 방식 (position:static, relative, absolute)**

엘리먼트 배치가 순서대로만 위아래로 또는 좌우로 흐르면서 쌓이기만 하면, 다양한 배치를 하기 어렵습니다.

position 속성을 사용하면 상대적/절대적으로 어떤 위치에 엘리먼트를 배치하는 것이 수월합니다.

 

**1. position 속성으로 특별한 배치를 할 수 있습니다.**

position 속성은 기본 static입니다.

그냥 순서대로 배치됩니다.

 

**2. absolute는 기준점에 따라서 특별한 위치에 위치합니다.**

top / left / right / bottom 으로 설정합니다.

기준점을 상위엘리먼트로 단계적으로 찾아가는데 static이 아닌 position이 기준점입니다.

 

**3. relative는 원래 자신이 위치해야 할 곳을 기준으로 이동합니다.**

top / left / right / bottom로 설정합니다.

 

**4 fixed는 viewport(전체화면) 좌측, 맨 위를 기준으로 동작합니다.**

[code 바로가기](http://jsbin.com/vegowut/edit?html,css,output)


**엘리먼트가 배치되는 방식 (margin:10px)**

margin으로 배치가 달라질 수 있습니다.

margin은 위 / 아래 / 좌 / 우 엘리먼트와 본인 간의 간격입니다.

따라서 그 간격만큼 내 위치가 달라집니다.


**엘리먼트가 배치되는 방식 (float:left)**

float 속성으로 원래 flow에서 벗어날 수 있고 둥둥 떠다닐 수 있습니다.

일반적인 배치에 따라서 배치된 상태에서 float는 벗어난 형태로 특별히 배치됩니다.

따라서 뒤에 block엘리먼트가 float 된 엘리먼트를 의식하지 못하고 중첩돼서 배치됩니다.

[code 바로가기](http://jsbin.com/cutivij/2/edit?html,css,output)

float의 속성은 이런 특이성 때문에 웹사이트의 전체 레이아웃 배치에서 유용하게 활용됩니다.


**엘리먼트가 배치되는 방식 (box-model)**

블록 엘리먼트의 경우 box의 크기와 간격에 관한 속성으로 배치를 추가 결정합니다.

margin, padding, border, outline으로 생성되는 것입니다.

[code 바로가기](https://www.w3schools.com/css/css_boxmodel.asp)

box-shadow 속성도 box-model에 포함지어 설명할 수 있습니다.

box-shadow는 border 밖에 테두리를 그릴 수 있는 속성입니다.


**엘리먼트의 크기**

block엘리먼트의 크기는 기본적으로는 부모의 크기만큼을 가집니다.

예를 들어, width:100%는 부모의 크기만큼을 다 갖는 것과 같습니다.


**box-sizing과 padding**

padding 속성을 늘리면 엘리먼트의 크기가 달라질 수 있습니다.

box-sizing 속성으로 이를 컨트롤 할 수 있습니다.

box-sizing 속성을 border-box로 설정하면 엘리먼트의 크기를 고정하면서 padding 값만 늘릴 수 있습니다.

[code 바로가기](http://jsbin.com/wosuwop/edit?html,css,output)

 

**layout 구현방법은?**

전체 레이아웃은 float를 잘 사용해서 2단, 3단 컬럼 배치를 구현합니다.

최근에는 css-grid나 flex 속성 등 layout을 위한 속성을 사용하기 시작했으며 브라우저 지원범위를 확인해서 사용하도록 합니다.

특별한 위치에 배치하기 위해서는 position absolute를 사용하고, 기준점을 relative로 설정합니다.

네비게이션과 같은 엘리먼트는 block 엘리먼트를 inline-block으로 변경해서 가로로 배치하기도 합니다.

엘리먼트안의 텍스트의 간격과 다른 엘리먼트간의 간격은 padding과 margin 속성을 잘 활용해서 위치시킵니다.



 

------

**생각해보기**

1. 여러분들이 자주 사용하는 웹사이트의 배치를 살펴봅니다.
2. 크롬 개발자도구의 element 패널을 열어서 소스코드를 살펴봅니다.
3. CSS의 어떤 속성을 주로 사용해서 좌/우로 배치를 하고 있는지 찾아보면 좋습니다.
4. 실제로 많은 웹사이트도 float와 같은 전통적 방식을 사용하는 것을 찾아볼 수도 있습니다.

[ ![img](https://cphinf.pstatic.net/mooc/20191203_273/1575305095783dhaDm_PNG/OXTf7hHSWkisgFI4CeDx.png?type=ffn199_148)**<강좌 추천> 예비 개발자의 좋은 시작, [부스트코스 : 웹 UI 개발\]**https://www.edwith.org부스트코스는 NAVER 계열사 등과 함께 만들어가는 현장 중심 온라인 교육 프로그램입니다.
현업 전문가들이 고민하여 만들고 1:1 코드리뷰도 받을 수 있는 부스트코스에서 기업이 원하는 유능한 개발자로 boost하세요!](https://www.edwith.org/boostcourse-ui)