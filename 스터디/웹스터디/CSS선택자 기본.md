# CSS 선택자 기본

- [CSS 선택자란?](#CSS 선택자란?)
- [선택자 종류 개요](#선택자 종류 개요)
- [전체 선택자](#전체 선택자)
- [태그 선택자](#태그 선택자)
- [아이디 선택자와 클래스 선택자](#아이디 선택자와 클래스 선택자)
- [속성 선택자](#속성 선택자)
- [후손 선택자와 자손 선택자](#후손 선택자와 자손 선택자)
- [동위 선택자](#동위 선택자)
- [반응 선택자](#반응 선택자)
- [상태 선택자](#상태 선택자)
- [구조 선택자](#구조 선택자)
- [문자 선택자](#문자 선택자)
- [링크 선택자](#링크 선택자)
- [부정 선택자](#부정 선택자)

---

## CSS 선택자란?

- 요소에 스타일을 적용하기 위해 문서 내부의 특정 요소를 선택할 수 있어야 한다. 
- CSS3 선택자는 특정한 HTML 태그를 선택할 때 사용하는 기능이다.
- 아래의 코드는 선택자를 사용해서 h1 태그를 선택하고 color 속성에 red 키워드를 적용하는 예이다.

```html
<head>  
  <title>Document</title>
  <style>
    h1{
      color: red;
      background-color: orange;
    }
  </style>
</head>
<body>
  <h1>CSS3 Selector Basic</h1>
</body>
```

- 위의 `<style>` 코드 블럭 내부를 CSS 블럭이라 부르며, h1이 선택자, color이 스타일 속성, red는 스타일 값이다.
- 이번 절에서는 선택자만 다루고 스타일 속성과 스타일은 다음절에서 설명한다. 
- CSS3는 디자인 뿐만아니라 jQuery에서도 사용된다.

---

## 선택자 종류 개요

선택자의 종류는 아래와 같다.

| 선택자 종류   | 선택자 형태                   | 선택자 예                 |
| ------------- | ----------------------------- | ------------------------- |
| 전체 선택자   | *                             | *                         |
| 태그 선택자   | 태그                          | h1                        |
| 아이디 선택자 | #아이디                       | #header                   |
| 클래스 선택자 | .클래스                       | .item                     |
| 후손 선택자   | 선택자 선택자                 | header h1                 |
| 자손 선택자   | 선택자 > 선택자               | header > h1               |
| 속성 선택자   | 선택자[속성=값]               | input[type=test]          |
|               | 선택자[속성~=값]              | div[data-role~=row]       |
|               | 선택자[속성\|=값]             | div[data-role\|=row]      |
|               | 선택자[속성^=값]              | div[data-role^=row]       |
|               | 선택자[속성$=값]              | div[data-role$=9]         |
|               | 선택자[속성*=값]              | div[data-role*=row]       |
| 동위 선택자   | 선택자 + 선택자               | h1 + div                  |
|               | 선택자 ~ 선택자               | h1 ~ div                  |
| 구조 선택자   | 선택자:first-child            | li:first-child            |
|               | 선택자:last-child             | li:last-child             |
|               | 선택자:nth-childl(수열)       | li:nth-child(2n+1)        |
|               | 선택자:nth-last-child(수열)   | li:nth-last-child(2n+1)   |
|               | 선택자:first-of-type          | h1:first-of-type          |
|               | 선택자:last-of-type           | h1:last-of-type           |
|               | 선택자:nth-of-type(수열)      | h1:nth-of-type(2n+1)      |
|               | 선택자:nth-last-of-type(수열) | h1:nth-last-of-type(2n+1) |
| 반응 선택자   | 선택자:active                 | div:active                |
|               | 선택자:hover                  | div:hover                 |
| 상태 선택자   | :checked                      | input:checked             |
|               | :focus                        | input:focus               |
|               | :enabled                      | input:enabled             |
|               | :disabled                     | input:disabled            |
| 링크 선택자   | :link                         | a:link                    |
|               | :visited                      | a:visited                 |
| 문자 선택자   | ::first-letter                | p::first-letter           |
|               | ::first-line                  | p::first-line             |
|               | ::after                       | p::after                  |
|               | ::before                      | p::before                 |
|               | ::selection                   | p::selection              |
| 부정 선택자   | 선택자:not(선택자)            | li:not(.item)             |

- : 기호를 사용하는 선택자를 가상 클래스 선택자라 함
- :: 기호를 사용하는 선택자를 가상 요소 선택자라 함

---

## 전체 선택자

HTML 문서 안에 있는 모든 태그를 선택할 때 사용하는 선택자이다. 전체 선택자는 모든 웹 페이지에서 빠지지 않고 사용하는 선택자이다. 아래의 코드는 전체 선택자를 사용해 모든 태그의 color 속성에 red 키워드를 적용한다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    * {color: red;}
  </style>
</head>
<body>
  <h1>Lorem ipsum</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
</body>
```



##### 전체 선택자의 범위

일반적으로 전체 선택자의 범위를 `<body>` 태그 내부에 있는 모든 요소를 선택한다고 생각하기 쉽지만, 전체 선택자를 사용하면 `<html>` 태그를 비롯해 `<head>`, `<title>`, `<style>` 태그까지 선택한다. 아래 예제는 jQuery를 사용해 전체 선택자로 선택된 모든 태그에 스타일을 적용하는 코드이다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <script src="http://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script>
    /* 웹 페이지가 모두 준비되면 */
    $(document).ready(function() {
      /* 모든 태그의 border 속성에 5px solid black을 적용한다. */
      $('*').css('border', '5px solid black');
    })
  </script>
</head>
<body>
  <h1>Lorem ipsum</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
</body>
```

- html 태그와 body 태그에도 border 속성이 적용되므로 테두리가 많이 생긴다. 개발자 도구에서 요소 검사를 사용해 모든 요소에 스타일이 적용된것을 확인할 수 있다.

---

## 태그 선택자

태그 선택자는 html 페이지 내부에서 특정 종류의 태그를 모두 선택할 때 사용한다.

- 아래는 h1 태그의 color 속성에 red 키워드를 적용하고, p 태그의 color 속성에 blue 키워드를 적용한다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    h1 { color: red; }
    p { color: blue; }
  </style>
</head>
<body>
  <h1>Lorem ipsum</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  <p>Nunc nisl turpis, aliquet et gravida non, facilisis a sem.</p>
</body>
```



여러 개의 선택자를 사용할 때 다음과 같이 한꺼번에 선택해서 속성을 적용할 수 있다.

```html
<style>
    body, p, h1, h2, h3, h4, h5, h6 { margin: 0; padding: 0;}
</style>
```

---

## 아이디 선택자와 클래스 선택자 

위의 선택자들은 스타일시트에서 가장 많이 사용하는 선택자이다. 웹 페이지의 레이아웃을 구성하고 디자인을 적용할 때 사용되는 태그이므로 반드시 기억한다.

### 아이디 선택자

아이디 선택자는 특정한 id 속성을 가지고 있는 태그를 선택할 때 사용한다. 웹 표준에 id 속성은 웹 페이지 내부에서 중복되면 안 된다라는 규정이 있으므로 특정한 하나의 태그를 선택할 때 사용한다.

```html
head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    #header {
      width: 800px; margin: 0 auto;
      background: red;
    }
    #wrap {
      width: 800px; margin: 0 auto;
      overflow: hidden;
    }
    #aside {
      width: 200px; float: left;
      background: blue;
    }
    #content {
      width: 600px; float: left;
      background: green;
    }
  </style>
</head>
<body>
  <div id="header">
    <h1>Headeer</h1>
  </div>
  <div id="wrap">
    <div id="aside">
      <h1>Aside></h1>
    </div>
    <div id="content">
      <h1>Content</h1>
    </div>
  </div>
</body>
```



##### id 속성의 중복

- 실제로 id 속성을 중복으로 작성하고 스타일을 적용시켜도 문제가 되지 않는다.
- 하지만 이는 HTML일 경우이며, 자바스크립트에서는 문제가 발생하므로 중복하여 사용하지 않도록 한다.



### 클래스 선택자

id 선택자와 비슷하지만, 특정한 클래스를 가지고 있는 태그를 선택할 때 사용한다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    .select { color: red; }  
  </style>
</head>
<body>
  <ul>
    <li class="select">Lorem ipsum</li>
    <li>Lorem ipsum</li>
    <li class="select">Lorem ipsum</li>
    <li>Lorem ipsum</li>
  </ul>
</body>
```

- 클래스 선택자는 웹 페이지를 개발할 때 가장 많이 사용하는 선택자이다. 
- 이 절을 마치고 부록 A를 참고하면, 클래스 선택자가 얼마나 많이 사용되는지 확인할 수 있다.



##### 여러 개의 클래스 선택자 사용

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    .item { color: red; }
    .header { background-color: blue; }
  </style>
</head>
<body>
  <h1 class="item header">Lorem Ipsum</h1>>
</body>
```



##### 태그 선택자와 클래스 선택자

class 속성은 중복될 수 있고, 만약 class 속성이 서로 다른 태그에 사용된다면 태그 선택자와 클래스 선택자를 함께 사용해서 더 정확하게 태그를 선택할 수 있다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    li.select { color: red; }
  </style>
</head>
<body>
  <h1 class="select">Lorem ipsum</h1>
  <ul>
    <li class="select">Lorem ipsum</li>
    <li>Lorem ipsum</li>
    <li>Lorem ipsum</li>
    <li>Lorem ipsum</li>
  </ul>
</body>
```

---

## 속성 선택자

속성 선택자를 사용하여 특정 속성을 가진 HTML 태그를 선택할 수 있다. 속성 선택자는 지금까지 배운 다른 선택자들과 함께 사용되는 선택자이다. 기본 속성 선택자와 문자열 속성 선택자로 나뉘며, 문자열 속성 선택자는 특별한 경우에 사용된다.

### 기본 속성 선택자

| 선택자 형태               | 설명                                                       |
| ------------------------- | ---------------------------------------------------------- |
| 선택자[속성]              | 특정한 속성이 있는 태그를 선택한다.                        |
| 선택자\[속성=값][속성=값] | 특정한 속성 안의 값이 특정 값과 같은 문서 객체를 선택한다. |

input 태그는 이름이 모두 input이지만 type 속성값에 따라 형태가 달라진다. 따라서 input 태그를 선택할 때는 기본 속성 선택자를 많이 사용한다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    input[type=text]{ background: red; }
    input[type=password]{ background: blue; }
  </style>
</head>
<body>
  <form>
    <input type="text" />
    <input type="password" />
  </form>
</body>
```



### 문자열 속성 선택자

문자열 속성 선택자는 태그에 지정한 속성의 특정 문자열을 확인한다.

| 선택자 형태       | 설명                                                 |
| ----------------- | ---------------------------------------------------- |
| 선택자[속성~=값]  | 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택 |
| 선택자[속성\|=값] | 속성 안의 값이 특정 값을 단어로 포함하는 태그를 선택 |
| 선택자[속성^=값]  | 속성 안의 값이 특정 값으로 시작하는 태그를 선택      |
| 선택자[속성$=값]  | 속성 안의 값이 특정 값으로 끝나는 태그를 선택        |
| 선택자[속성*=값]  | 속성 안의 값이 특정 값을 포함하는 태그를 선택        |



상위의 선택자 형태 2개의 설명이 같은 것을 볼 수 있다. 하이픈(-)이 들어간 단어의 구분 방법이 다르며, 예를 들어 ko-kr 글자를 다음과 같이 인식한다.

| 선택자            | 단어 인식 |
| ----------------- | --------- |
| 선택자[속성~=값]  | ko-kr     |
| 선택자[속성\|=값] | ko와 kr   |

문자열 속성 선택자는 거의 사용하지 않지만, 파일 형태에 따라 스타일을 적용할 때 가끔 사용한다.

```html
<!-- 예시는 도서 121 ~ 122쪽 참조 -->
```



---

## 후손 선택자와 자손 선택자

특정 태그의 자손과 후손을 선택할 때 사용된다.

```html
<body>
  <div>
    <h1>CSS3 Selector Basic</h1>
    <h2>Lorem ipsum</h2>
    <ul>
      <li>univer selector</li>
      <li>type selector</li>
      <li>id & class selector</li>
    </ul>
  </div>
</body>
```

위 구조에서 div 태그를 기준으로 바로 한 단계 아래에 위치한 태그를 자손이라 부르고 div 아래에 위치한 모든 태그를 후손이라 부른다. 즉 h1, h2, ul은 자손이며 h1, h2, ul, li, li, li는 후손이다.



### 후손 선택자

- `선택자A 선택자B` 의 형태로 사용한다.
- 아래는 id 속성값으로 header를 가지는 태그의 후손 위치에 있는 h1 태그의 color 속성에 red를 적용한다.
- 아래는 id 속성값으로 section을 가지는 태그의 후손 위치에 있는 h1 태그의 color 속성에 orange 키워드를 적용한다.

```html
<head>  
  <title>CSS3 Selector Basic Page</title>
  <style>
    #header h1 { color: red; }
    #section h1 { color: orange; }
  </style>
</head>
<body>
  <div id="header">
    <h1 class="title">Lorem ipsum</h1>
    <div id="nav">
      <h1>Navigation</h1>
    </div>
  </div>
  <div id="section">
    <h1 class="title">Lorem ipsum</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  </div>
</body>
```



##### 후손 선택자와 관련된 주의 사항

- 아래의 차이를 확인한다.

```html
/* #header 태그의 후손 위치에 있는 h1 태그와, 일반 h2 태그를 선택한다. */
<style>
    #header h1, h2 { color: red; }
</style>

/* #header 태그의 후손에 위치하는 h1 태그와 #header 태그의 후손에 위치하는 h2 태그를 선택 */
<style>
    #header h1, #header h2 { color: red; }
</style>


<body>
  <div id="header">
    <h1 class="title">Lorem ipsum</h1>
    <div id="nav">
      <h2>Navigation</h2>
    </div>
  </div>
  <div id="section">
    <h2 class="title">Lorem ipsum</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  </div>
</body>
```



### 자손 선택자

- 선택자A > 선택자 B의 형태로 사용한다.
- 아래의 코드로 바로 확인한다.

```html
  <head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      #header > h1 { color: red; }
      #section > h1 { color: orange; }
    </style>
  </head>
  <body>
    <div id="header">
      <h1 class="title">Lorem ipsum</h1>
      <div id="nav">
        <h1>Navigation</h1>
      </div>
    </div>
    <div id="section">
      <h1 class="title">Lorem ipsum</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
  </body>
```



##### 테이블 태그와 자손 선택자 사용 시 주의 사항

table 태그의 요소를 선택할 때는 자손 선택자를 사용하는 것이 좋지 않다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      table > tr > th { color: red; }
    </style>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>Name</th>
        <th>Region</th>
      </tr>
      <tr>
        <td>윤인성</td>
        <td>서울특별시 강서구 내발산동</td>
      </tr>
    </table>
  </body>
```

- 스타일이 적용되지 않는다.
- 앞에서 배웠던 것을 떠올려보며 개발자도구에서 요소 검사를 사용해 HTML 페이지의 계층 구조를 확인해보자.
- table 태그 하위에 tbody 태그가 자동으로 추가되어 스타일이 적용되지 않는 것이다.
- 코드에서 자손 선택 단계에 tbody를 추가하고 결과를 확인한다.

---

## 동위 선택자

동위 선택자는 동위 관계에서 뒤에 위치한 태그를 선택할 때 사용하는 선택자이다.

```html
<body>
    <ul>
        <li>CSS3 Selector Basic</li>
        <li>CSS3 Selector Basic</li>
        <li>CSS3 Selector Basic</li>
        <li>CSS3 Selector Basic</li>
        <li>CSS3 Selector Basic</li>
    </ul>
</body>
```

위 코드에서 li 태그는 동위 상태에 있다.

| 선택자 형태       | 설명                                            |
| ----------------- | ----------------------------------------------- |
| 선택자A + 선택자B | 선택자A 바로 뒤에 위치하는 선택자 B를 선택한다. |
| 선택자A ~ 선택자B | 선택자A 뒤에 위치하는 선택자B를 선택한다.       |



- 아래 코드에서 h1 태그와 모든 h2 태그는 동위 상태에 위치한다.
- h1 태그의 바로 뒤에 위치하는 h2 태그 하나를 선택할 때는 + 선택자를 사용한다.
- 비슷하게 h1 태그 뒤에 위치하는 모든 h2 태그를 선택할 때는 ~ 선택자를 사용한다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      h1 + h2 { color: red; }
      h1 ~ h2 { background-color: orange; }
    </style>
  </head>
  <body>
    <h1>Header - 1</h1>
    <h2>Header - 2</h2>
    <h2>Header - 2</h2>
    <h2>Header - 2</h2>
    <h2>Header - 2</h2>
  </body>
```

- 동위 선택자는 CSS3 애니메이션을 사용해 동적으로 움직이는 레이아웃을 구성할 때 사용한다.
  - 추후에 다시 설명

---

## 반응 선택자

반응 선택자는 사용자의 반응으로 생성되는 특정한 상태를 선택하는 선택자이다.

- 어렵지 않으므로 아래 코드로 바로 확인한다.

| 선택자 형태 | 설명                                      |
| ----------- | ----------------------------------------- |
| :active     | 사용자가 마우스로 클릭한 태그를 선택한다. |
| :hover      | 사용자가 마우스를 올린 태그를 선택한다.   |

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      h1:hover { color: red; }
      h1:active { color: blue; }
    </style>
  </head>
  <body>
    <h1>User Action Selector</h1>
  </body>
```

---

## 상태 선택자

상태 선택자는 입력 양식의 상태를 선택할 때 사용하는 선택자이다.

| 선택자 형태 | 설명                                 |
| ----------- | ------------------------------------ |
| :checked    | 체크 상태의 input 태그를 선택한다.   |
| :focus      | 초점이 맞춰진 input 태그를 선택한다. |
| :enabled    | 사용 가능한 input 태그를 선택한다.   |
| :disabled   | 사용 불가능한 input 태그를 선택한다. |

- checked 상태는 type 속성값이 checkbox 또는 radio인 input 태그가 `선택된` 상태를 의미한다.
- focus 상태는 사용자가 초점을 맞추고 있는 입력 양식에 적용되는 상태이다.
  - 참고로 웹 페이지당 하나의 input 태그에만 초점을 맞출 수 있다.

```html
<body>
    <!-- input 태그에 type을 지정하지 않으면 text -->
    <input value="enabled" />
    <input value="disabled" disabled="disabled" />
</body>
```



상태 선택자는 쉬운 내용이므로 아래의 코드로 확인한다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      /* input 태그가 사용 가능할 경우에
         background-color 속성에 white 키워드를 적용한다. */
      input:enabled { background-color: white; }

      input:disabled { background-color: gray; }
      input:focus { background-color: orange; }
    </style>
  </head>
  <body>
    <h2>Enabled</h2>
    <input />
    <h2>Disabled</h2>
    <input disabled="disabled" />
</body>
```



아래는 좀 더 심화된 내용으로, 속성 선택자, 상태 선택자, 동위 선택자를 함께 사용해 아코디언 위젯을 생성하는 예제이다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      /* input 태그의 type 속성값이 checkbox인 태그가 체크됐을때,
         바로 뒤에 위치한느 div 태그의 height 속성에 0픽셀을 적용한다. */
      input[type=checkbox]:checked + div {
        height: 0px;
      }

      div { 
        overflow: hidden;
        width: 650px; height: 300px;

        /* 변환 효과 적용 */
        -ms-transition-duration: 1s;
        -webkit-transition-duration: 1s;
        -moz-transition-duration: 1s;
        -o-transition-duration: 1s;
      }
    </style>
  </head>
  <body>
    <input type="checkbox" />
    <div>
      <h1>Lorem ipsum</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
</body>
```

- 익스플로러 8 버전 이하의 웹 브라우저는 동위 선택자를 사용할 수 없으므로 제대로 실행되지 않는다.

---

## 구조 선택자

구조 선택자는 CSS3부터 지원하는 선택자이다. 일반적으로 자손 선택자와 병행해서 많이 사용한다.

- 유용하다

### 일반 구조 선택자

일반 구조 선택자는 특정한 위치에 있는 태그를 선택하는 선택자이다. :first-child 선택자는 CSS2.1에서 지정한 선택자이므로 인터넷 익스플로러 8 버전에서도 사용할 수 있다.

| 선택자 형태           | 설명                                                 |
| --------------------- | ---------------------------------------------------- |
| :first-child          | 형제 관계 중에서 첫 번째에 위치하는 태그를 선택한다. |
| :last-child           | 형제 관계 중에서 마지막에 위치하는 태그를 선택한다.  |
| :nth-child(수열)      | 형제 관계 중에서 앞에서 수열 번째에 태그를 선택한다. |
| :nth-last-child(수열) | 형제 관계 중에서 뒤에서 수열 번째에 태그를 선택한다. |



마찬가지로 어려운 내용이 아니므로 아래의 코드로 바로 이해한다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      ul { overflow: hidden; }
      li {
        list-style: none;
        float: left; padding: 15px;
      }
      li:first-child { border-radius: 10px 0 0 10px;}
      li:last-child { border-radius: 0 10px 10px 0; }

      li:nth-child(2n) { background-color: #FF0003;}
      li:nth-last-child(2n+1) { background-color: yellow; }
    </style>
  </head>
  <body>
    <ul>
      <li>First</li>
      <li>Second</li>
      <li>Third</li>
      <li>Fourth</li>
      <li>Fifth</li>
      <li>Sixth</li>
      <li>Seventh</li>
    </ul>
  </body>
```



##### 구조 선택자와 관련된 주의 사항

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      li > a:first-child { color: red; }
    </style>
  </head>
  <body>
    <ul>
      <li><a href="#">Condrasa</a></li>
      <li><a href="#">Condrasa</a></li>
      <li><a href="#">Condrasa</a></li>
      <li><a href="#">Condrasa</a></li>
      <li><a href="#">Condrasa</a></li>
    </ul>
  </body>
```

위 코드를 예측해보고 실행 결과가 맞게 나오는지 확인한다.

- 아래의 코드로 스타일을 변경한다.

```html
<style>
    li:first-child > a { color: red; }
</style>
```



### 형태 구조 선택자

일반 구조 선택자와 비슷하지만 태그 형태를 구분한다.

| 선택자 형태             | 설명                                                         |
| ----------------------- | ------------------------------------------------------------ |
| :first-of-type          | 형제 관계 중에서 첫 번째로 등장하는 특정 태그를 선택한다.    |
| :last-of-type           | 형제 관계 중에서 마지막으로 등장하는 특정 태그를 선택한다.   |
| :nth-of-type(수열)      | 형제 관계 중에서 앞에서 수열 번째로 등장하는 특정 태그를 선택한다. |
| :nth-last-of-type(수열) | 형제 관계 중에서 뒤에서 수열 번째로 등장하는 특정 태그를 선택한다. |

- 말로 설명하기 굉장히 어려운 선택자이므로 코드와 실행 결과를 보고 직접 이해한다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      h1:first-of-type { color: red; }
      h2:first-of-type { color: red; }
      h3:first-of-type { color: red; }
    </style>
  </head>
  <body>
    <h1>Header - 1</h1>
    <h2>Header - 2</h2>
    <h3>Header - 3</h3>
    <h3>Header - 3</h3>
    <h2>Header - 2</h2>
    <h1>Header - 1</h1>
  </body>
```



- 바로 이해되지 않았다면 아래의 코드를 살펴본다.
- 아래의 코드는 body 태그의 자손 중 첫 번째로 등장하는 모든 형제의 태그를 선택하게 했다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      body > *:first-of-type { color: red; }
    </style>
  </head>
  <body>
    <h1>Header - 1</h1>
    <h2>Header - 2</h2>
    <h3>Header - 3</h3>
    <h4>Header - 3</h4>
    <h5>Header - 2</h5>
    <h6>Header - 1</h6>
    <h1>Header - 1</h1>
    <h2>Header - 2</h2>
    <h3>Header - 3</h3>
  </body>
```

---

## 문자 선택자

문자 가상 요소 선택자는 태그 내부 특정 조건의 문자를 선택하는 선택자이다. 문자 선택자는 가상 요소 선택자로 `::` 기호를 사용하는 것이 표준이지만 `:` 기호를 사용해도 정상 작동한다. 하지만 표준을 따르도록 한다.

### 시작 문자 선택자

| 선택자 형태    | 설명                     |
| -------------- | ------------------------ |
| ::first-letter | 첫 번째 글자를 선택한다. |
| ::first-line   | 첫 번째 줄을 선택한다.   |

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      p::first-letter { font-size: 3em; }
      p::first-line { color: red; }
    </style>
  </head>
  <body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsumdolor sit amet, consectetur adipiscing elit.</p>>
    <p>Aenean ac erat et massa vehicula laoreet consequat et sem.</p>>
  </body>
```

- 첫 번째 글자는 세 배 커진것이다.



### 전후 문자 선택자

| 선택자 형태 | 설명                                |
| ----------- | ----------------------------------- |
| ::after     | 태그 뒤에 위치하는 공간을 선택한다. |
| ::before    | 태그 앞에 위치하는 공간을 선택한다. |

- 전후 문자 선택자에는 content 속성을 사용할 수 있다.
  - 다른 선택자에는 불가능
- 아래  코드에는 복잡한 속성을 함께 사용했는데 죽을때까지 한 번 쓸까 말까 한 속성이니 외우지 않는다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      p {counter-increment: rint; }
      p::before { content: counter(rint) "."; }
      p::after { content: " - " attr(data-page) " page"; }
      p::first-letter { font-size: 3em; }
    </style>
  </head>
  <body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p data-page="52">Lorem ipsumdolor sit amet, consectetur adipiscing elit.</p>>
    <p data-page="273">Aenean ac erat et massa vehicula laoreet consequat et sem.</p>>
  </body>
```

- 주의 깊게 살펴볼 부분은 ::first-letter 선택자를 사용해 첫 번째 글자를 선택했을 때 전후 문자 선택자로 생성한 글자도 스타일이 적용되었다는 것이다.



###### data 속성

웹 표준에 따르면 지정된 속성 이외의 것을 사용하면 안된다. 하지만 속성 앞에 문자열 data- 를 붙이면 사용자 지정 속성으로 인정해준다. 위 코드에서 data-page가 그 예시이다. 웹과 관련된 기술을 접할수록 사용자 지정 속성은 굉장히 많이 사용된다. 본 서의 146 페이지를 참고하도록 하자.



### 반응 문자 선택자

반응 문자 선택자는 사용자가 문자와 반응해서 생기는 영역을 선택하는 선택자이다. `::selection`은 사용자가 드래그한 글자를 선택한다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      p::selection { background: black; color: red; }
    </style>
  </head>
  <body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsumdolor sit amet, consectetur adipiscing elit.</p>>
    <p>Aenean ac erat et massa vehicula laoreet consequat et sem.</p>>
  </body>
```

---

## 링크 선택자

링크 선택자는 href 속성을 가지고 잇는 a 태그에 적용되는  선택자이다. 한 번 이상 다녀온 링크를 선택할 수 있게 해준다. 별로 사용할 일은 없다.

| 선택자 형태 | 설명                                           |
| ----------- | ---------------------------------------------- |
| :link       | href 속성을 가지고 있는 a 태그를 선택한다.     |
| :visited    | 방문했던 링크를 가지고 있는 a 태그를 선택한다. |

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      a { text-decoration: none;}
      a:visited  { color: red; }
      
      /* href 속성을 가지고 있는 a 태그 뒤의 공간에 "-(href 속성)"을 추가 */
      a:link::after { content: ' - ' attr(href); }
    </style>
  </head>
  <body>
    <h1><a>Nothing</a></h1>
    <h1><a href="http://hanbit.co.kr">Hanbit Media</a></h1>
    <h1><a href="https://github.com/">Github</a></h1>
  </body>
```

---

## 부정 선택자

부정 선택자는 지금까지 배운 선택자를 모두 반대로 적용할 수 있게 만들며, `:not`으로 사용한다.

- 지금까지 사용하던 모든 선택자와 함께 사용할 수 있다.

```html
<head>  
    <title>CSS3 Selector Basic Page</title>
    <style>
      /* input 태그 중에서 type 값이 password가 아닌 태그의
         background 속성에 red를 적용한다. */
      input:not([type=password]) {
        background: red;
      }
    </style>
  </head>
  <body>
    <input type="password" />
    <input type="text" />
    <input type="password" />
    <input type="text" />
  </body>
```



- 굉장히 많은 선택자를 배웠으며, 중요한 개념이니 충분히 복습하고 다음장으로 넘어가도록 한다.

---