# CSS3 스타일 속성 기본

이 장에서는 이전 장에서 배운 CSS 선택자로 선택한 HTML 요소에 스타일을 적용하는 방법에 대해 배운다.

- CSS에서 사용하는 단위를 학습한다.
- 어떤 스타일 속성을 사용할 수 있는지 학습한다.
- 스타일 속성을 활용해서 레이아웃을 잡는 기본적인 방법을 알아본다.
- 레퍼런스는 [W3Schools](https://www.w3schools.com/)를 참조

---

### 목차

- ###### [CSS3 단위](#CSS3 단위)

- [가시 속성](#가시 속성])

- [박스 속성](#박스 속성)

- [테두리 속성](#테두리 속성)

- [배경 속성](#배경 속성)

- [폰트 속성](#폰트 속성)

- [위치 속성](#위치 속성)

- [float 속성](#float 속성)

- [clear: both를 사용한 레이아웃](#clear: both를 사용한 레이아웃)

- [그림자 속성](#그림자 속성)

- [그레디언트](#그레디언트)

- [벤더 프리픽스](#벤더 프리픽스)

---

## CSS3 단위

스타일 속성은 아래와 같이 입력한다. 이 때 오른쪽에 입력하는 값은 특정한 단위를 가지며, 이번 절에서는 해당 단위에 대해 알아본다. 또한 각각의 스타일 속성에 따라 별도의 **키워드**가 존재한다. 키워드는 너무 많이 존재해서 다 설명할 수 없으므로, 레퍼런스를 참조한다.

```html
<style>
    h1 {
        margin: 10px;
        font-size: 200%;
        line-height: 2em;
    }
</style>
```



### 크기 단위

크기 단위는 css3에서 가장 많이 사용하는 단위이다. 크기 단위에는 %, em, cm, mm,inch, px 등이 많이 사용되지만 특히 자주 사용되는 단위는 아래와 같다.

| 단위 | 설명        |
| ---- | ----------- |
| %    | 백분율 단위 |
| em   | 배수 단위   |
| px   | 픽셀 단위   |

- 아래와 같이 기본 페이지 구성을 한다.

```html
<html>
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      

    </style>
  </head>
  <body>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>>
  </body>
</html>
```



- 첫 번째로 알아볼 크기 단위는 퍼센트 단위이다.
- 퍼센트 단위는 기본 설정된 크기에서 상대적으로 크기를 지정한다.

```html
<style>
      p:nth-child(1) { }
      p:nth-child(2) { font-size: 100%; }
      p:nth-child(3) { font-size: 150%; }
      p:nth-child(4) { font-size: 200%; }
</style>
```



- 두 번째로 알아볼 단위는 em이다.
  - 배수를 나타내는 단위이며, 1배 = 1em = 100%이다.

```html
<style>
      p:nth-child(1) { }
      p:nth-child(2) { font-size: 1.0em; }
      p:nth-child(3) { font-size: 1.5em; }
      p:nth-child(4) { font-size: 2.0em; }
</style>
```



- 위의 개념과 반대로 상대적인 크기가 아닌 절대적인 크기를 취하고 싶다면 px 단위를 사용한다.

```html
<style>
      p:nth-child(1) { }
      p:nth-child(2) { font-size: 16px; }
      p:nth-child(3) { font-size: 24px; }
      p:nth-child(4) { font-size: 32px; }
</style>
```

- p 태그의 기본 font-size 속성이 16픽셀이다.



##### 크기 단위의 복합 사용

전체 폰트 크기에 절대 크기를 지정하고 각각의 태그에 상대 크기를 지정하는 방법은 굉장히 많이 사용된다.

```html
<head>  
  <title>CSS3 Style Property Basic</title>
  <style>
    * { font-size: 12px; }

    h1 { font-size: 3.0em; }
    h2 { font-size: 2.0em; } 
  </style>
</head>
<body>
  <h1>Lorem ipsum dolor sit amet</h1>
  <h2>consectetur adipiscing elit. Sed nec purus elit, nec cursus dolor.</h2>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec purus elit.</p>
</body>
```



### 색상 단위

색상을 입력하는 가장 간단한 방법은 아래와 같이 키워드를 입력하는 것이다.

```html
<style>
    h1 { background-color: red; }
    h2 { background-color: green; }
</style>
```



- 하지만 단어로 표현할 수 있는 색상은 제한되어 있으며, 다양한 색상 표현을 위해 CSS3는 아래와 같은 단위를 제공한다.

| 단위 형태                               | 설명           |
| --------------------------------------- | -------------- |
| #000000                                 | HEX 코드 단위  |
| rgb(red, green, blue)                   | RGB 색상 단위  |
| rgba(red, green, blue, alpha)           | RGBA 색상 단위 |
| hsl(hue, saturation, lightness)         | HSL 색상 단위  |
| hsla(hue, saturation, lightness, alpha) | HSLA 색상 단위 |

- alpha 값은 0.0부터 1.0까지 숫자를 입력하며, 투명도를 의미한다.
  - 0.0은 완전히 투명한 상태를 나타내고 1.0은 불투명한 상태를 나타낸다.



RGB는 빨간색, 초록색, 파란색의 조합을 사용하여 색상을 표현한다.

- HEX 코드 단위는 RGB 색상 단위를 짧게 입력하는 방법이다.
  - #뒤의 두 자리수씩 각각 R, G, B의 형태로 0~255값을 저장할 수 있다.

```html
<style>
    h1 { background-color: rgb(255, 255, 255); }
    h2 { background-color: #FFFFFF; }
</style>
```



HSL 색상 단위는 색상(Hue), 채도(Saturation), 명도(Lightness)를 사용한다.

```html
<style>
   h1 { background-color: hsl(33, 100%, 50%); }
</style>
```



### URL 단위

CSS3에서 이미지 파일이나 폰트 파일을 불러올 때는 URL 단위를 사용한다. 어렵지 않으므로 코드로 바로 확인한다.

```html
<style>
    body {
        /* 현재 폴더의 이미지 */
        background-image: url('Desert.jpg');
    }
    body {
        /* 현재 폴더 내부에 있는 Other 폴더의 이미지 */
        background-image: url('Other/Desert.jpg');
    }
    body {
        /* 루트 폴더의 이미지 */
        background-image: url('/Desert.jpg');
    }
</style>

```

---

## 가시 속성

학습을 위해 아래와 같은 페이지를 구성한다.

```html
<head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>
    <span>Dummy</span>
    <div id="box">
      <span>Lorem ipsum dolor sit amet, consectetur adipscing elit.</span>
    </div>
    <span>Dummy</span>
  </body>
```



### display 속성

HTML5에서는 굉장히 많은 display 속성이 등장했다. 하지만 모든 display 속성을 제대로 지원하는 웹브라우저가 없다. 따라서 아래와 같이 중요한 속성만 살펴본다.

| 키워드       | 설명                                   |
| ------------ | -------------------------------------- |
| none         | 태그를 화면에서 보이지 않게 만든다.    |
| block        | 태그를 block 형식으로 지정한다.        |
| inline       | 태그를 inline 형식으로 지정한다.       |
| inline-block | 태그를 inline-block 형식으로 지정한다. |

- 2장에서 div 태그는 block 형식이고 span 태그는 inline 형식이라 학습했다.
- 우선 none 키워드를 적용해 태그가 화면에서 보이지 않는 경우를 본다.

```html
    <style>
      #box { display: none; }
    </style>
```



- 아래와 같이 block 키워드를 적용해 확인한다.

```html
    <style>
      #box { display: block; }
    </style>
```



위와 동일하게 inline과 inline-block 형식을 취해 확인해보면, 차이가 없어보인다. 하지만 width 속성과 height, margin 속성을 사용할 때 두 가지 형식의 차이를 확인할 수 있다.

```html
    <style>
      #box { 
        display: inline; 

        background-color: red;
        width: 300px; height:50px;
        margin: 10px;
      }
    </style>
```

```html
    <style>
      #box { 
        display: inline-block; 

        background-color: red;
        width: 300px; height:50px;
        margin: 10px;
      }
    </style>
```

- inline을 적용한 코드는 width와 height 속성이 적용되지 않았다.
- 또한 margin 속성이 div 태그의 좌, 우로만 지정된다.



- inline-block 키워드를 적용하면 모든 키워드가 적용되며, margin 속성 또한 상, 하, 좌, 우 모두 적용된다.
- block 형식도 모든 속성이 적용됨을 확인하고 넘어간다.



### visibility 속성

해당 속성은 대상을 보이거나 보이지 않게 지정하는 스타일 속성이다.

| 키워드 이름 | 설명                             |
| ----------- | -------------------------------- |
| visible     | 태그를 보이게 만든다.            |
| hidden      | 태그를 보이지 않게 만든다.       |
| collapse    | table 태그를 보이지 않게 만든다. |

- 방금 살펴본 display 속성에도 none 키워드를 통해 대상을 화면에서 보이지 않게 만들 수 있었다.
  - 두 방식의 차이를 아는 것이 중요하다.

아래와 같이 hidden 키워드를 적용한다.

```html
<style>
      #box { 
        visibility: hidden;
      }
</style>
```

display 속성을 사용하면  화면에서 태그가 제거되지만, visibility 속성을 사용하면 화면에서 보이지 않을 뿐이다.

- 따라서 빈 공간이 생성된 것처럼 볼 수 있다.



##### collapse 키워드

- 해당 키워드는 익스플로러와 파이어폭스에만 작동하며, table 태그에 사용한다.
- table 태그가 차지하는 영역 자체가 사라지며 마찬가지로 hidden 키워드와 비교해 볼 수 있다.
- 자세한 내용은 본 서의 172 페이지를 참조한다.



### opacity 속성

태그의 투명도를 조절하는 스타일 속성이다. 0.0 ~ 1.0 사이의 숫자를 입력할 수 있다.

```html
    <style>
      #box { 
        background-color: black;
        color: white;
        opacity: 0.2;
      }
    </style>
```

---

## 박스 속성

박스 속성은 웹 페이지의 레이아웃을 구성할 때 가장 중요한 스타일 속성이다. 아래의 속성을 모두 합쳐 박스 속성이라 이야기한다.

- margin, border, padding, height, width

테두리 속성은 내용이 많으므로, 다음 절에서 다루고 이 절에서는 width, height, margin, padding 속성을 살펴본다.



### width, height

- 글자를 감싸는 영역의 크기를 지정하는 스타일 속성이다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      div { 
        width: 100px; height: 100px;
        background-color: green;
      }
    </style>
  </head>
  <body>
    <div></div>
  </body>
```



### margin, padding

- 각각의 속성은 마진과 패딩의 너비를 지정하는 속성이다. 마진과 패딩은 대체할 한국어가 없다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      div { 
        width: 100px; height: 100px;
        background-color: green;

        border: 20px solid black;
        margin: 10px; padding:30px;
      }
    </style>
  </head>
  <body>
    <div>Hello CSS3, Hello CSS3, Hello CSS3</div>
  </body>
```

- border 속성은 아직 배우지 않았지만 짚고 넘어갈 사항이 있어 사용한다.
- 요소 검사를 사용해 코드를 분석해보자.

- 태그 전체의 크기는 아래의 공식으로 나타낼 수 있다.

`전체 너비 = width + 2 x (margin + border + padding)`
`전체 높이 = height + 2 x (margin + border + padding)`



margin과 padding 속성은 상, 하, 좌, 우를 각각 지정할 수 있다.

`margin: [margin-top] [margin-right] [margin-bottom] [margin-left]`

아래의 코드처럼 margin과 padding 속성에 2개의 값을 적용하는 경우도 있다.

- 4개의 방향을 2개씩 묶어 지정하는 것이므로 어렵게 생각하지 않도록 한다.

```html
<style>
      div { 
        width: 100px; height: 100px;
        background-color: green;

        margin: 0 30px; padding: 0 30px;
      }
</style>
```



### box-sizing 속성

위에서 width 속성과 height 속성은 글자를 감싸는 영역의 크기를 지정하는 스타일 속성이라 했다. box-sizing 속성은 이러한 공식을 변경할 수 있는 속성이다. 해당 속성은 width와 height 속성이 차지하는 범위를 결정한다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      div { 
        margin: 10px; padding: 10px;
        width: 100px; height: 100px;
        border: 10px solid black;
      }
      div:first-child { 
        background: red;
        box-sizing: content-box;
      }
      div:nth-child(3) {
        background: orange;
        box-sizing: border-box;
      }
    </style>
  </head>
  <body>
    <div></div>
    <div></div>
    <div></div>
  </body>
```

- content-box는 기본적으로 적용되는 키워드이다.

  - 해당 키워드를 적용하면 너비와 높이 속성이 글자가 들어가는 영역의 크기를 지정하게 만든다.
  - 따라서 빨간색 사각형의 전체 너비와 높이는 아래의 공식으로 표현할 수 있다.

  `박스 너비 = width + 2 x (margin + border + padding)`
  `박스 높이 = height + 2 x (margint + border + padding)`



- border-box 키워드는 width 속성과 height 속성이 테두리를 포함한 영역의 크기를 지정하게 만든다.

  - 따라서 노란색 사각형의 전체 너비와 높이는 아래 공식으로 표현할 수 있다.

  `박스 너비 = width + 2 x margin`
  `박스 높이 = height + 2 x margin`

- 따라서 빨간색 사각형이 노란색 사각형보다 크다.

  - 반드시 개발자 도구로 확인

---

## 테두리 속성

테두리 속성은 박스 속성에 포함되어야 하지만, 분량이 많은 관계로 별도로 학습한다. 아래의 코드를 입력하고 테두리 속성을 살펴본다.

```html
<head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .box {

      }
    </style>
  </head>
  <body>
    <div class="box">
      <h1>Lorem ipsum dolor amet</h1>
    </div>
  </body>
```



### border-width 속성과 border-style 속성

- 각각의 단위는 VSCode의 자동완성을 참조한다. 
- 테두리를 넣을 때는 border-width 속성, border-style 속성, border-color 속성을 모두 사용해야 한다.

```html
    <!-- 두꺼운 dashed 형태의 검은색 테두리 생성 -->
   <style>
      .box {
        border-width: thick;
        border-style: dashed;
        border-color: black;
      }
    </style>
<!-- or -->
   <style>
      .box {
        border: thick dashed black;
      }
    </style>
```

- border 속성은 margin, padding과 같이 left, top, right, bottom 부분의 값을 적용할 수 있다.
  - 예시 작성해볼 것



### border-radius 속성

CSS3에서 추가된 속성으로, 둥근 사각형 또는 원 형태의 테두리를 만들 수 있다. 이 속성이 등장하기 전에는 테두리가 둥근 버튼을 만들 때, 테두리가 둥근 이미지를 따로 만들어서 사용했다. 해당 속성은 크기 단위를 적용한다.

```html
    <style>
      .box {
        border: thick dashed black;
        border-radius: 20px;
      }
    </style>
<!-- 크기 단위는 각각 지정할 수 있다. -->
border-radius: 50px 40px 20px 10px
```

---

## 배경 속성

배경 속성은 특정 태그의 배경 이미지 또는 색상을 지정하는 스타일 속성이다.

### background-image 속성

URL 단위 또는 그레디언트 등을 입력한다.

```html
    <style>
      body {
        background-image: url('BackgroundFront.png');
      }
    </style>
<!-- CSS3 이후에는 여러 개의 배경 이미지를 적용할 수 있다. -->
    <style>
      body {
        background-image: url('BackgroundFront.png'), url('BackgroundBack.png');
      }
    </style>
```

- 위의 두 번째 방법으로 배경을 적용하면 왼쪽에 위치한 이미지가 앞으로 나오고 두 개의 이미지가 층을 이루어 출력된다.



### background-size 속성

그림의 크기를 조절할 때 사용하며, CSS3에서 추가된 속성이므로 익스플로러 8 이하에서 사용할 수 없다. 해당 속성은 1개 또는 2개의 크기 단위를 적용하며, 각각 너비와 높이를 나타낸다.

```html
    <style>
      body {
        background-image: url('BackgroundFront.png');
        background-size: 100% 250px;
      }
    </style>
```

속성의 값을 띄어쓰기로 구분하는 것과 쉼표로 구분하는 것은 다르다. 쉼표를 사용하면 각각의 배경에 서로 다른 크기를 적용하겠다는 것으로 인식한다.

```html
<style>
      body {
        background-image: url('BackgroundFront.png'), url('BackgroundBack.png');
        backgorund-size: 100%, 200%
      }
</style>
```

- background-size 속성에 contain 키워드를 설정하면 너비를 100%로 적용하고 cover 키워드를 적용하면 높이를 100%로 적용한다.



### background-repeat 속성

- 위의 그림을 살펴보면 패턴을 이루어 여러번 출력된다. 이는 해당 속성의 기본 키워드가 repeat이므로 나타나는 현상이다.

| 키워드    | 설명                       |
| --------- | -------------------------- |
| repeat    | 기본 값, 반복하여 나타남   |
| repeat-x  | X축 방향으로 이미지가 반복 |
| repeat-y  | Y축 방향으로 이미지가 반복 |
| no-repeat | 이미지가 반복되지 않음     |

```html
    <style>
      body {
        background-image: url('BackgroundFront.png');
        background-size: 100% 200%;
        background-repeat: no-repeat;
      }
    </style>
```



### background-attachment 속성

해당 속성은 배경이미지를 어떠한 방식으로 붙일 것인지를 지정하는 스타일 속성이다. 우선 아래처럼 body 태그 내부에서 스크롤을 형성할 수 있을 정도로 HTML 페이지를 작성한다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      body {
        background-color: #e7e7e8;
        background-image: url('BackgroundFront.png'), url('BackgroundBack.png');
        background-size: 100%;
        background-repeat: no-repeat;
      }
    </style>
  </head>
  <body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  </body>
```

- 코드를 실행하고 스크롤을 내리면 배경이미지가 위로 올라가 사라져버린다.

- background-attachment 속성의 기본 키워드는 scroll이다. 

- 스크롤 키워드는 화면 스크롤에 따라 배경 이미지가 함께 이동한다.

- 속성에 fixed 키워드를 적용해본다.

  - 이미지가 고정됨을 확인할 수 있다.

    

### background-position 속성

해당 속성은 아래와 같이 값을 적용한다.
`background-position: 키워드;`
`background-position: X축크기;`
`background-position: X축크기 Y축크기;`

- 위의 코드에 해당 속성을 bottom으로 적용하면, 배경 이미지가 아래에 붙는다.
  - X축을 0픽셀로, Y축을 50%로 하여 결과를 확인한다.

---

## 폰트 속성

폰트 속성은 글자와 관련된 스타일 속성을 의미한다. 원래 HTML 페이지는 대학에서 원격으로 논문을 제출하고 확인하는 용도로 만들어졌다. 따라서 HTML 페이지에는 글자와 관련된 속성이 굉장히 많다.

### font-size 속성

글자의 크기를 지정하는 스타일 속성이다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .a { font-size: 32px; }
      .b { font-size: 2em; }
      .c { font-size: large; }
      .d { font-size: small; }
    </style>
  </head>
  <body>
    <h1>Lorem ipsum</h1>
    <p class="a">Lorem ipsum</p>
    <p class="b">Lorem ipsum</p>
    <p class="c">Lorem ipsum</p>
    <p class="d">Lorem ipsum</p>
  </body>
```



### font-family 속성

해당 속성은 폰트를 지정하는 스타일 속성이다. 사용자 컴퓨터에 설치된 폰트를 사용한다.

- 주의할 점은 폰트 이름이 여러 단어일 경우 반드시 따옴표로 묶어준다.

```html
  <head>  
      <title>CSS3 Style Property Basic</title>
    <style>
      .font_arial { font-family: Arial; }
      .font_roman { font-family: 'Times New Roman'; }
    </style>
  </head>
  <body>
    <h1 class="font_arial">Lorem ipsum</h1>
    <p class="font_roman">Lorem ipsum</p>    
  </body>
```

- 한 가지 더 주의할 점은 개발하는 컴퓨터에는 설치되어 있지만 사용하는 사용자에게는 폰트가 설치되어 있지 않을 수 있다.
  - 이를 방지하기 위해 아래 코드처럼 속성을 여러 개 사용한다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .font_arial { font-family: '없는 폰트', Arial;}
      .font_roman { font-family: 'Times New Roman', Arial;}
    </style>
  </head>
  <body>
    <h1 class="font_arial">Lorem ipsum</h1>
    <p class="font_roman">Lorem ipsum</p>    
  </body>
```

- 다국어 웹 페이지를 제공할 경우 사용자에게 무슨 폰트가 있는지 확인할 길이 없다. 
- 이러한 문제를 해결하고자 font-family의 마지막 폰트에는 Serif(명조체), Sans-serif(고딕체), 'Mono space(고정폭 글꼴)' 를 사용한다.
  - 위의 폰트를 웹 브라우저에서 지정하는 generic-family 폰트라 부른다.
  - 인터넷 익스플로러에서는 sans-serif 폰트와 serif 폰트에 따옴표를 적용하면 안된다.



### font-style 속성과 font-weight 속성

폰트의 기울기 또는 두께를 조정하는 속성이다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .font_big { font-size: 2em; }
      .font_italic { font-style: italic; }
      .font_bold { font-weight: bold; }
    </style>
  </head>
  <body>    
    <p class="font_big font_italic font_bold">Lorem ipsum dolor amet</p>    
  </body>
```



### line-height 속성

해당 속성은 글자의 높이를 지정한다. 현대의 HTML 페이지는 문서 형태보다 어플리케이션 형태로 사용하므로 글자의 높이를 지정하는 기능보다 글자를 수직 중앙 정렬할 때 사용한다.

- 아래는 div 태그를 사용해서 간단한 버튼을 만드는 코드이다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .font_big { font-size: 2em; }
      .font_italic { font-style: italic; }
      .font_bold { font-weight: bold; }
      .font_center { text-align: center; }

      .button { 
        width: 150px;
        height: 70px;
        background-color: #FF6A00;
        border: 10px solid #FFFFFF;
        box-shadow: 5px 5px 5px #A9A9A9;
      }

      .button > a {
        display: block;
      }
    </style>
  </head>
  <body>    
    <div class="button">
      <a href="#" class="font_big font_italic font_bold font_center">Click</a>
    </div>
  </body>
```

- 위 코드는 글자가 수평으로는 중앙 정렬되지만 수직으로는 중앙 정렬되지 않는다.
  - CSS는 block 형식을 가지는 태그를 수직 정렬할 수 있는 스타일 속성이 없다.
  - 대체 방안으로 아래처럼 line-height 속성을 사용한다.

```html
      .button { 
        width: 150px;
        height: 70px;
        background-color: #FF6A00;
        border: 10px solid #FFFFFF;
        box-shadow: 5px 5px 5px #A9A9A9;
      }

      .button > a {
        display: block;
        line-height: 70px;
      }
```

- 글자를 감싸는 박스의 높이와 같은 크기를 사용했다.

지금까지 배운 폰트 속성은 한꺼번에 사용할 수 있다.



### text-align 속성

정렬과 관련된 속성이다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .font_big { font-size: 2em; }
      .font_italic { font-style: italic; }
      .font_bold { font-weight: bold; }
      .font_center { text-align: center; }
      .font_right { text-align: right; }
    </style>
  </head>
  <body>    
    <p class="font_big font_italic font_bold font_center">Lorem ipsum dolor amet</p>
    <p class="font_bold font_right">2019.02.14</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  </body>
```



##### text-align 속성과 영역

아래의 코드 결과를 예측해본다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .font_center { text-align: center; }
    </style>
  </head>
  <body>    
    <span class="font_center">Lorem ipsum dolor amet</span>
    <p class="font_center">Lorem ipsum dolor amet</p>
  </body>
```

span 태그는 inline 형식이므로 너비가 존재하지 않는다. 따라서 중앙이라는 개념이 없다.



### text-decoration 속성

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      a { text-decoration: none; }
    </style>
  </head>
  <body>    
    <h1>
      <a href="#">Lorem ipsum dolor amet</a>
    </h1>
  </body>
```

- 코드를 실행하면 링크가 밑줄만 제거되며 색상은 color를 사용해 별도로 적용해야 한다.

---

## 위치 속성

페이지를 만들 때 요소의 위치를 두 가지 방법으로 설정한다.

- 절대 위치 좌표 : 요소의 X 좌표와 Y 좌표를 설정해 절대 위치를 지정한다.
- 상대 위치 좌표 : 요소를 입력한 순서를 통해 상대적으로 위치를 지정한다.

우리는 지금까지 절대 위치 좌표를 설정한 적이 없다. 

- 일반적으로 절대 위치 좌표는 특정 크기의 영역을 지정한 태그 내부에서만 사용한다.
  - 사용자가 다양한 해상도를 사용하며, 다양한 화면 크기로 실행할 수 있으므로 대부분 상대 위치 좌표를 사용
    - ex) 안드로이드 스마트폰

### position 속성

HTML 태그의 위치 설정 방법을 변경할 때는 position 속성을 사용한다.

- 상대 위치 좌표를 사용할 때는 static 키워드 또는 relative 키워드를 적용
  - static 키워드는 태그가 `위에서 아래로` `왼쪽에서 오른쪽으로` 순서에 맞게 배치된다.
    - direction 속성을 통해 `오른쪽에서 왼쪽` 으로 변경할 수 있다.
  - relative 키워드는 static 키워드로 초기 위치가 지정된 상태에서 상하좌우로 이동할 수 있다.
- 절대 위치 좌표를 사용할 때는 absolute 키워드 또는 fixed 키워드를 적용

| 키워드   | 설명                                           |
| -------- | ---------------------------------------------- |
| static   | 태그가 위에서 아래로 순서대로 배치된다.        |
| relative | 초기 위치 상태에서 상하좌우로 위치를 이동한다. |
| absolute | 절대 위치 좌표를 설정한다.                     |
| fixed    | 화면을 기준으로 절대 위치 좌표를 설정한다.     |

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .box { 
        width: 100px; height: 100px;
        position: absolute;
      }
      .red { background-color: red; }
      .green { background-color: green; }
      .blue { background-color: blue; }
    </style>
  </head>
  <body>    
    <div class="box red"></div>
    <div class="box green"></div>
    <div class="box blue"></div>
  </body>
```

- 익스플로러에서는 세 개의 박스가 보이지만, 나머지 브라우저에서는 모든 박스가 겹쳐있다.
- style 속성을 아래와 같이 바꾼다.

```html
    <style>
      .box { 
        width: 100px; height: 100px;
        position: absolute;
      }
      .red { 
        background-color: red; 
        left: 10px; top: 10px;
      }
      .green {
         background-color: green; 
         left: 50px; top: 50px;
        }
      .blue {
         background-color: blue; 
         left: 90px; top: 90px;
        }
    </style>
```

- 일반적으로 뒤에 입력된 태그가 상위로 올라간다.



### z-index 속성

위의 예제에서 파란색 박스가 제일 위에 있다. 이러한 순서를 변경하기 위해 해당 속성을 사용한다. z-index 속성에는 숫자를 적용하며, 숫자가 클수록 앞에 위치한다.

```html
    <style>
      .box { 
        width: 100px; height: 100px;
        position: absolute;
      }
      .red { 
        background-color: red; 
        left: 10px; top: 10px;
        z-index: 100;
      }
      .green {
         background-color: green; 
         left: 50px; top: 50px;
         z-index: 10;
        }
      .blue {
         background-color: blue; 
         left: 90px; top: 90px;
         z-index: 1;
        }
    </style>
```

- 일반적으로 반드시 앞에 있어야 하는 태그라면, 해당 속성을 터무니 없게 적용하면 되지만 브라우저가 인식하는 한도 내에서 적용해야 한다.



### 위치 속성과 관련된 공식

위치 속성을 사용할 때는 몇 가지 공식이 있다. 중요하므로 꼭 암기하도록 한다.

- 먼저 지금 만들고 있는 예제의 body 태그에 h1 태그와 div 태그를 추가한다.

```html
  <body>    
    <h1>Lorem ipsum dolor amet</h1>
    <div>
      <div class="box red"></div>
      <div class="box green"></div>
      <div class="box blue"></div>
    </div>
    <h1>Lorem ipsum dolor amet</h1>
  </body>
```

- 실행하면 두 가지 문제가 있다.

  - h1 태그 두 개가 붙어있다, 즉 div 태그가 영역을 차지하지 않는다.
  - 색상이 적용된 상자가 자신의 부모를 기준으로 위치를 잡지 않는다.

- position 속성에 absolute 키워드를 적용할 경우 부모 태그가 영역을 차지하지 않는다.

  - 개발자 도구에서 확인 가능
  - 따라서 자손의 position 속성에 absolute 키워드를 적용할 경우는 부모 태그에 몇 가지 처리를 해야 한다.

- 첫 번째 문제를 해결하기 위해 아래의 공식을 사용한다.

  **`자손의 position 속성에 absolute 키워드를 적용하면 부모는 height 속성을 사용한다.`**

- 위의 방법으로 부모 태그가 영역을 차지하게 만들 수 있다.

```html
      body > div { 
        width: 400px; height: 100px;
        border: 3px solid black;
      }
```



- 두 번째 문제를 해결하기 위해 아래의 공식을 사용한다.

  **`자손의 position 속성에 absolute 키워드를 적용하면 부모의 position 속성에 relative 키워드를 적용한다.`**

```html
      body > div { 
        width: 400px; height: 100px;
        border: 3px solid black;
        position: relative;
      }
```



### overflow 속성

해당 속성은 내부의 요소가 부모의 범위를 벗어날 때 처리하는 방법을 지정하는 속성이다.

| 키워드 이름 | 설명                                       |
| ----------- | ------------------------------------------ |
| hidden      | 영역을 벗어나는 부분을 보이지 않게 만든다. |
| scroll      | 영역을 벗어나는 부분을 스크롤로 만든다.    |

- 위의 예제에서 색상이 적용된 박스가 부모의 범위를 벗어나 있다. 
  - 위의 코드에서 overflow 속성으로 hidden과 scroll을 적용하고 결과를 확인한다.

```html
      body > div { 
        width: 400px; height: 100px;
        border: 3px solid black;
        position: relative;
        overflow: scroll or hidden;
        overflow-y: scroll;
      }
```

- overflow 속성을 scroll로 지정하면 모든 축에 스크롤이 생성된다.
  - 만약 특정한 방향으로만 스크롤을 생성할 ㅏ때는 overflow-x 속성과 overflow-y 속성을 사용한다.

- 방금 다룬 것은 overflow 속성의 기본 사용 방법이다. 
  - 프로그래밍 요소를 사용해 애니메이션을 구현할 때 많이 사용한다.
- 하지만 다음 절에서 배울 float 속성과 함께 다른 용도로 더 많이 쓰인다.

---

## float 속성

웹 페이지를 만들 때 가장 많이 사용하는 스타일 속성이다. 

- 내용이 어렵지만, 중요하므로 반드시 학습해야함

| 키워드 | 설명                    |
| ------ | ----------------------- |
| left   | 태그를 왼쪽에 붙인다.   |
| right  | 태그를 오른쪽에 붙인다. |



### float 속성 개요

float 속성은 직역한것처럼 부유하는 대상을 만들 때 사용하는 스타일 속성이다.

- 원래 img 태그에 사용하는 것을 기본으로 만들어졌다.
  - img 태그는 inline 형식이고 p 태그는 block 형식이기 때문에 그림과 글자가 분리되어 출력된다.
  - 하지만 float 속성으로 이미지를 글자위에 띄울 수 있다. 
  - 본 서의 220 ~ 221 페이지 참조
- 현대에는 웹 페이지의 레이아웃을 만들 때 더 많이 사용한다.



### float 속성을 사용한 수평 정렬

해당 속성을 사용하면 태그를 수평으로 정렬할 수 있다. 단 주의할점이 있으므로 아래와 같이 div 태그에 각각의 태그를 구분할 수 있는 숫자를 입력한다.

```html
  <body>    
    <div class="box">1</div>
    <div class="box">2</div>
  </body>
```

스타일 시트에는 아래를 적용하며, float 속성의 키워드를 left, right로 적용하여 결과를 확인한다.

```html
    <style>
      .box { 
        width: 100px; height: 100px;
        background-color: red;
        margin: 10px; padding: 10px;
        float: right or left;
      }
    </style>
```

- right 속성에서 1번 박스가 제일 오른쪽에 붙었음을 확인한다.
  - 반드시 알아둬야 하는 내용



### float 속성을 사용한 레이아웃 구성

공식부터 확인하고 넘어간다.

- **`자손에 float 속성을 적용하면 부모의 overflow 속성에 hidden 키워드를 적용한다.`**

본 서의 223 페이지의 레이아웃을 구성한다.

``` html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>    
    <div id="header"></div>
    <div id="navigation"></div>
    <div id="wrap">
      <div id="aside"></div>
      <div id="section"></div>
    </div>
    <div id="footer"></div>
  </body>
```

- 결과를 확인하고 아래의 코드를 덧붙인다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>    
    <div id="header"><h1>Header</h1></div>
    <div id="navigation"><h1>Navigation</h1></div>
    <div id="wrap">
      <div id="aside">
        <h1>Aside</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
      <div id="section">
        <h1>Section</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    </div>
    <div id="footer"><h1>Footer</h1></div>
  </body>
```



- 이제 스타일을 적용한다.
  - 먼저 태그에 width 속성을 사용하고 margin-left 속성과 margin-right  속성을 auto로 지정하면 자동으로 중앙 정렬된다.

```html
    <style>
      body {
        width: 960px;
        margin: 0 auto;
      }
    </style>
```



- #wrap 태그 내부의 영역은 왼쪽과 오른쪽으로 구분되므로, 아래와 같이 입력한다.

```html
    <style>
      body {
        width: 960px;
        margin: 0 auto;
      }
      #aside { 
        width: 200px;
        float: left;
      }
      #section { 
        width: 760px;
        float: left;
      }
    </style>
```

- #footer 태그가 #section 태그 아래에 붙어 있는 것을 볼 수 있다.
  - 원래 float 속성은 이미지를  글자 위에 띄우기 위해 만들어진 스타일 속성이었다.
  - 현재 예제에서는 #wrap 태그 내부의 요소(#aside, #section)에 float 속성을 사용했다.
  - img 태그에 float 속성을 사용해서 이미지가 부유했던 것처럼 #footer 태그의 글자 위에 #wrap 태그 내부의 요소가 부유하는 것이다.
- 이러한 부유를 막기 위해 float 속성을 사용한 태그의 부모에 overflow 속성을 사용하고 hidden 키워드를 적용한다.

```html
    <style>
      body {
        width: 960px;
        margin: 0 auto;
      }
      #wrap {
        overflow: hidden;
      }
      #aside { 
        width: 200px;
        float: left;
      }
      #section { 
        width: 760px;
        float: left;
      }
    </style>
```

- #footer 태그의 clear 속성에 both 키워드를 사용해도 마찬가지 기능을 수행할 수 있다.
  - 하지만 요즘은 overflow 속성을 더 많이 사용한다.
  - 이 방법을 One True Layout 방식이라 부른다.

---

## clear: both를 사용한 레이아웃

본 서에서는 레이아웃을 만들 때 대부분 overflow: hidden을 사용한다. 이 외에도 clear: both가 많이 사용되는데, float으로 일그러진 레이아웃을 쉽게 초기화할 수 있는 방법이다.

이전과 비슷한 방법으로 레이아웃을 만든다. 이전 코드와의 차이점이라면 #aside 태그와 #section 태그를 따로 감싸주지 않았다는 것이다. clear: both를 사용할 때는 이처럼 사용할 수 있다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>    
    <div id="header"><div>
    <div id="navigation"><div>
    <div id="aside"></div>
    <div id="section"></div>
    <div id="footer"><div>
  </body>
```

- 이어서 가로로 자를 수 있는 부분에 `<div class="clear"><div>` 를 넣어준다.
- clear: both는 실제로 float으로 일그러진 레이아웃을 초기화할 때 사용하기 때문에 float을 적용할 대상들 뒤에만 적어주면 된다.
  - 하지만 코드를 조금 더 일관성 있게 볼 수 있도록 가로로 자를 수 있는 부분에 모두 넣었다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>    
    <div id="header"><div>
    <div id="navigation"><div>
    <div class="clear"></div> <!-- 사용하지 않아도 됨 -->

    <div id="aside"></div>
    <div id="section"></div>
    <div class="clear"></div>

    <div id="footer"><div>
    <div class="clear"></div> <!-- 사용하지 않아도 됨 -->
  </body>
```



- 아래와 같이 간단히 내용을 입력한다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      
    </style>
  </head>
  <body>    
    <div id="header"><h1>Header</h1><div>
    <div id="navigation"><h1>Navigation</h1><div>
    <div class="clear"></div>

    <div id="aside">
      <h1>Aside</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div id="section">
      <h1>Section</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div class="clear"></div>

    <div id="footer"><h1>Footer</h1><div>
    <div class="clear"></div>
  </body>
```

- 이제 clear: both를 적용하는데, 레이아웃의 일그러짐을 초기화할 부분 `<div class="class"><div>`에 적용한다는 것이 포인트이다.
- 다른 요소들에는 너비 지정, 왼쪽으로 붙이기, 오른쪽으로 붙이기 정도만 적용했다.

```html
    <style>
      body { 
        width: 960px;
        margin: 0 auto;
      }
      .clear {
        clear: both;
      }
      #aside {
        float: left;
        width: 260px;
      }
      #section { 
        float:right;
        width: 700px;
      }
    </style>
```

- 부모 요소에  overflow: hidden을 적용하는 것과 이 방법 모두 많이 사용되니 둘 다 알아두도록 한다.

---

## 그림자 속성

태그에 그림자를 부여하는 스타일 속성이다.

### text-shadow 속성

글자에 그림자를 부여하며, 쉬운 내용이므로 아래의 코드를 확인한다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      h1 { 
        /* 오른쪽 아래 흐림도 색상 */
        text-shadow: 5px 5px 5px black;
      }
    </style>
  </head>
  <body> 
    <h1>Lorem ipsum dolor amet</h1>
  </body>
```



### box-shadow 속성

박스에 그림자를 부여하는 속성, 흐림도와 색상 사이에 inset 키워드를 적용하면 그림자가 태그 안쪽에 생성된다.

- 잠시후에 살펴보면 CSS3 Generator를 사용하면 쉽게 생성할 수 있다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      div {
        border: 3px solid black;
        box-shadow: 10px 10px 30px black;
        text-shadow: 5px 5px 5px black;
      }
    </style>
  </head>
  <body> 
    <div>
      <h1>Lorem ipsum dolor amet</h1>
    </div>
  </body
```



##### 중첩 그림자

그림자 속성은 쉼표를 사용해 여러 개의 그림자 키워드를 사용할 수 있다.

```html
  <head>  
    <title>CSS3 Style Property Basic</title>
    <style>
      .box {
        border: 3px solid black;
        box-shadow: 10px 10px 10px black, 10px 10px 20px orange, 10px 10px 30px red;
        text-shadow: 10px 10px 10px black, 10px 10px 20px orange, 10px 10px 30px red;
      }
    </style>
  </head>
  <body> 
    <div class="box">
      <h1>Lorem ipsum dolor amet</h1>
    </div>
  </body>
```

[CSS Generator](https://css3generator.com/) 에서 box-shadow 와 text-shadow 속성을 쉽게 생성할 수 있다.

---

## 그레디언트

두 가지 이상의 색상을 혼합해서 채색하는 기능이다.

[Ultimate CSS Gradient Generator](https://www.colorzilla.com/gradient-editor/) 에서 쉽게 생성할 수 있다.

- 원하는 형태의 그레디언트를 생성하고 오른쪽에 생성된 CSS 코드를 복사한다.
- 선형 그레디언트 이외에 원형 그레디언트도 쉽게 생성할 수 있다.

```html
<head>
  <title>CSS3 Style Property Basic</title>
  <style>
    div {
      font-family: 'Times New Roman';
      height: 60px;
      line-height: 60px;
      text-align: center;

      /* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#d4e4ef+0,86aecc+100;Grey+Gloss */
      background: #d4e4ef;
      /* Old browsers */
      background: -moz-linear-gradient(top, #d4e4ef 0%, #86aecc 100%);
      /* FF3.6-15 */
      background: -webkit-linear-gradient(top, #d4e4ef 0%, #86aecc 100%);
      /* Chrome10-25,Safari5.1-6 */
      background: linear-gradient(to bottom, #d4e4ef 0%, #86aecc 100%);
      /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
      filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#d4e4ef', endColorstr='#86aecc', GradientType=0);
      /* IE6-9 */

    }
  </style>
</head>

<body>
  <div>
    <h1>Lorem ipsum dolor amet</h1>
  </div>
</body>
```

- 선형 그레디언트의 첫 번째 매개변수에는 진행될 각돌르 입력한다.
- 두 번째 변수부터는 색상과 위치 블록을 입력한다.
- 원형 그레디언트는 radial-gradient() 함수를 사용한다.



---

## 벤더 프리픽스

위에서 살펴본 그레디언트를 보면, background 속성이 굉장히 많이 지정되어 있다. 각각의 속성에 지정된 값을 보면 `-moz`, `-webkit`등의 글자가 써있다. 이를 벤더 프리픽스라 한다.

벤더 프리픽스는 웹 브라우저 공급 업체(MS, 모질라, 구글, 애플, 오페라)에서 제공하며, 실험적인 기능이 필요할 때 사용한다. 과거에는 CSS3 자체가 매우 실험적인 기능이라 벤더 프리픽스를 굉장히 많이 사용해야 했다. 하지만 현재는 대부분의 실험적인 기능이 실제 표준으로 들어가면서 벤더 프리픽스를 많이 사용하지 않아도 되게 바뀌었다.

하지만 현재도 추가되고 있는 새로운 실험적인 기능들에는 벤더 프리픽스를 사용해야 한다. 또한 구 버전의 인터넷 익스플로러나 게임기 등에 내장된 웹 브라우저, 과거의 스마트폰에 내장된 웹 브라우저들은 아직도 벤더 프리픽스를 필요로 하는 경우가 많다. 아래는 벤더 프리픽스를 사용해 변환 효과를 적용하는 스타일 시트이다.

```html
  <style>
    input[type=checkbox]:checked + div {
      height: 0px;
    }

    div { 
      overflow: hidden;
      width: 650px;
      height: 300px;

      -ms-transition-duration: 1s;
      -webkit-transition-duration: 1s;
      -moz-transition-duration: 1s;
      transition-duration: 1s;
    }
  </style>
```

- 위 코드에서 벤더 프리픽스가 적용된 스타일 속성을 사용한 이후에 벤더 프리픽스를 적용하지 않은 스타일 속성을 사용했다.
  - 스타일시트는 뒤에 위치한 스타일을 적용한다. 
  - 현재 transition-duration 속성의 경우, 웹 브라우저에서 정식 지원하므로 벤더 프리픽스가 붙지 않은 스타일 속성을 사용할 수 있게 만들어도 된다.

##### -webkit-

> 웹킷은 애플에서 개발하고 있는 레이아웃 엔진이다. 코드가 와나전히 공개된 오픈 소스라서 웹킷을 기반으로 사파리, 크롬, 오페라 등의 웹 브라우저가ㅏ 구현되어 있기 때문에 사파리, 크롬, 오페라 모두 웹킷이라는 벤더 프리픽스를 사용한다.

> 조금 더 자세히 보면 크롬과 오페라는 정확하게 말해서 웹킷이 아니라 웹킷 기반으로 마나들어진 블링크라는 조금 다른 엔진을 사용한다. 웹킷 개발에 구글 직원들이 대거 유입되는 현상이 벌어지자 웹킷 2.0을 배포하면서 애플이 이와 관련해 제재를 실시했고, 이로 인해 구글이 웹킷을 기반으로 블링크라는 별도의 엔진을 새로 개발해서 사용하고 있는 것이다.

> 하지만 일단 모두 웹킷을 기반으로 하기 때문에 벤더 프리픽스는 모두 -webkit-을 붙여 사용한다.



2011년 정도에는 border-radius 속성과 text-shadow 속성, box-shadow 속성 모두 벤더 프리픽스를 사용했다. 최신 웹 브라우저에선느 벤더 프리픽스 없이도 많은 속성을 사용할 수 있다. 하지만 구형 브라우저 환경 지원 여부도 고려해야 하므로 본 서에서는 필요한 경우 벤더 프리픽스를 계속 사용한다.