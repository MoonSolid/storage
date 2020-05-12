# HTML

- [HTML 개요](#HTML 개요)
- [HTML 태그 기본](#HTML 태그 기본)



---

## HTML 개요

#### 페이지 작성하기

- VSCode에서 확장자가 `.html`인 파일을 만들고 `"html"`이라는 텍스트를 입력하면 자동 완성 기능이 나온다.
  - 이 중 `html:5`가 앞으로 사용할 HTML 코드의 기본적인 형태를 만들어주는 자동완성이다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
  
</body>
</html>

<!-- 위의 코드에는 많은 정보가 있지만, 당분간 아래와 같이 간략하게 만든다 -->

<!DOCTYPE html>
<html>
<head>
  <title>Document</title>
</head>
<body>
  
</body>
</html>
```

---

#### 실행하기

- 실행을 위해 Visual Studio Code의 Extensions에서 Live Server를 install 한다.
- 이후 명령 팔레트(Ctrl + Shift + P)에서 Live Server로 해당 파일을 실행할 수 있다.
- 만약 브라우저가 크롬으로 실행되지 않는다면, 명령 팔레트 - Settings - Live Server 검색 - 변경 순으로 진행한다.



#### 크롬 개발자 도구

- 앞으로 크롬 개발자 도구를 많이 사용하게 될 것이다.
- 개발자 도구는 F12 또는 Ctrl+Shift+I로 실행할 수 있다.

---

## HTML 태그 기본

- Tag, Element, Attribute의 의미를 학습한다.
- HTML5에서 사용할 수 있는 기본적인 태그를 학습한다.
- 공간 분할 태그와 시멘틱 태그의 용도를 학습한다.



#### HTML 기본 용어 정리

- 태그는 HTML 페이지에서 객체를 만들 때 사용하는 것
- 요소는 태그를 사용해 만들어진 객체를 칭함

```html
<h1>Hello HTML5</h1>
<!-- 위의 요소는 시작 태그와 끝 태그를 별도로 입력한다. -->

<br>
<!-- 위의 요소는 단독으로 사용되며 아래와 같이 XHTML5 표기법을 사용할 수 있다. -->

<br> 왼쪽은 HTML 표기, 오른쪽은 XHTML 표기 <br />
<!-- 대부분의 개발자는 XHTML 표기를 선호한다. -->
```



- 일부 태그는 태그 내부에 다른 태그를 넣을 수 있다.
  - 이 말은 일부 태그는 태그 내부에 다른 태그를 넣을 수 없다는 뜻도 통용된다.

```html
<article>
    <h1>
        Article Header
    </h1>
    <p>
        Lorem ipsum dolor sit amet
    </p>
</article>
```



- 태그에 추가 정보를 부여할 때는 속성을 사용한다.

```html
<h1 title="header">Hello HTML5</h1>
<!-- 위 태그에서 속성은 title이며, 속성 값은 header이다. -->

<img src="image.png">
<!-- 태그와 속성에 대한 표준은 W3C 재단에서 정해놓았으므로 확인하도록 한다. -->
```

- 코드의 목적을 설명하기 위해 주석을 사용할 수 있다.
- 주석은 프로그램읭 실행에 영향을 미치지 않는다.
- 주석의 형태는 `<!-- 주석 내용 -->`과 같다.

---

## HTML 페이지 구조

#### HTML 5 페이지 구조 

```html
<!DOCTYPE html>
<html>
<head>
  <title>Document</title>
</head>
<body>
  
</body>
</html>
```

- `<!doctype html>`태그는 웹브라우저에게 현재 웹 페이지가 HTML5 문서임을 알린다.
  - 모든 HTML5 문서는 반드시 해당 라인을 처음에 표기해야 한다.

- `<html>`태그는 모든 HTML 페이지의 루트 요소이다.
  - 해당 태그에는 속성으로 `lang`을 입력할 수 있다.
  - 언어 속성은 실제 웹 브라우저가 동작하는 데 어떠한 영향도 끼치지 않는다.
    - 구글과 같은 검색 엔진이 웹 페이지를 탐색할 때 해당 웹 페이지가 어떠한 언어로 만들어져 있는지 쉽게 인식하게 한다.

- `<html>` 태그 안에는 `<head>` 태그와 `<body>` 태그를 입력한다. 
  - `<body>`태그는 사용자에게 보이는 실제 부분이며, `<head>`태그는 `<body>`태그에서 필요한 스타일시트와 자바스크립트를 제공하는 데 사용한다.



- `<head>`태그 내부에는 아래의 태그들만 입력할 수 있다.

| 태그 이름 | 설명                                |
| --------- | ----------------------------------- |
| meta      | 웹 페이지에 추가 정보를 전달한다.   |
| title     | 웹 페이지의 제목                    |
| script    | 웹 페이지에 스크립트를 추가한다.    |
| link      | 웹 페이지에 다른 파일을 추가한다.   |
| style     | 웹 페이지에 스타일 시트를 추가한다. |
| base      | 웹 페이지의 기본 경로를 지정한다.   |



- `<title>` 태그는 `<lang>`속성처럼 검색엔진에게 웹 페이지의 제목과 관련된 정보를 주는 데 사용되므로 입력하도록 한다.

```html
<!DOCTYPE html>
<html>
<head>
  <title>Document</title> <!-- 제목 태그를 사용한 것과 아닐 때의 차이를 확인 -->
</head>
<body>
  
</body>
</html>
```

---

## 글자 태그

글자 태그는 웹 페이지에서 가장 많은 비중을 차지하는 태그이다.



#### 제목

HTML5의 대표적인 글자 태그는 제목을 입력할 때 사용하는 제목 글자 태그이다.

```html
<!DOCTYPE html> <!-- 제목 태그, 결과 확인 -->
<html>
<head>
  <title>HTML5 + CSS Text</title> 
</head>
<body>
  <h1>Heading 1</h1>
  <h2>Heading 2</h2>
  <h3>Heading 3</h3>
  <h4>Heading 4</h4>
  <h5>Heading 5</h5>
  <h6>Heading 6</h6>
</body>
</html>
```



#### 본문

본문은 `<p>`태그를 사용한다. 여기서 p는 paragraph의 약자로 단락을 의미하며, 해당 태그를 이용해 하나의 단락을 만들 수 있다.

```html
<!DOCTYPE html> <!-- 본문 태그, 결과 확인 -->
<html>
<head>
  <title>HTML5 Text Basic Page</title> 
</head>
<body>
  <h1>Lorem ipsum</h1> <!-- https://lipsum.com의 단어를 무작위로 추출 -->
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  <p>Nam commodo mi a lorem congue id rutrum leo venenatis.</p>
</body>
</html>
```

- 위의 각 단락의 예문의 길이를 늘려보면, 두 개의 단락이 만들어졌음을 확인할 수 있다.



- `<p>`태그 외에도 아래에 있는 본문 태그도 제공된다.

```html
<!DOCTYPE html> <!-- br, hr 태그, 결과 확인 -->
<html>
<head>
  <title>HTML5 Text Basic Page</title> 
</head>
<body>
  <h1>Lorem ipsum</h1>
  <h2>dolor sit amet</h2>
  <hr />
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
  <br />
  <p>Nam commodo mi a lorem congue id rutrum leo venenatis.</p>
</body>
</html>

```

- 결과로 볼 수 있듯이 `<hr>`은 수평선, `<br>`은 개행을 의미한다.



#### 앵커 태그

HyperText Markup Language에서 가장 중요한 단어는 HyperText이다. 하이퍼텍스트는 사용자의 선택에 따라 특정한 정보와 관련된 부분으로 이동할 수 있게 조직화된 문서를 의미한다.

HTML 웹 페이지가 이렇게 조직화된 문서 형태를 가질 수 있는 이유가 앵커 덕분이다. 앵커 태그는 서로 다른 웹 페이지 사이를 이동하거나 웹 페이지 내부에서 특정한 위치로 이동할 때 사용한다.

```html
<!DOCTYPE html> <!-- a 태그와 href 속성의 사용 -->
<html>
<head>
  <title>HTML5 Text Basic Page</title> 
</head>
<body>
  <a href="https://google.com/">Google</a>
  <a href="http://naver.com/">Naver</a>
</body>
</html>

```



##### 빈 링크

- `<a>` 태그는 본래 가지고 있는 하이퍼링크 기능을 제거하고 사용하는 경우도 많다.
  - 이 때, href 속성은 반드시 입력해야 하므로 #을 입력하는 것이 관례이다.
    - 이를 빈 링크라 부른다.
  - 추후에 자세히 설명

```html
<div class="nctg">
    <a id="news_press_menu" href="#" class="btn_nctg">언론사 전체보기</a>
    <ul id="press_dropdown" class="cpress_lst hide">
        <li><a href="#">언론사 전체보기</a></li>
        <li><a href="#">종합지</a></li>
        <li><a href="#">방송/통신</a></li>
        <!-- .... -->
    </ul>
</div>

```



##### 페이지 내부 이동

`<a>` 태그를 이용하면 현재 페이지 내부에서 원하는 장소로 이동할 수 있다. 이 때, 원하는 장소에 id 속성을 부여해야 한다. 단, id 속성의 중복은 웹 표준에 어긋나는 일이므로 추후에 CSS3에서 다시 생각한다.

```html
<body>
  <a href="#alpha">Move to Alpha</a>
  <a href="#beta">Move to Beta</a>
  <a href="#gamma">Move to Gamma</a>
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <h1 id="alpha">Alpha</h1>
  <p>Alpha Test</p>
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <h1 id="beta">Beta</h1>
  <p>Beta Test</p>
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <hr /><hr /><hr /><hr /><hr /><hr /><hr /><hr />
  <h1 id="gamma">Gamma</h1>
  <p>Gamma Test</p>
</body>

```





#### 글자 형태

글자 형태 태그를 사용해서 웹 페이지의 글자에 형태와 의미를 부여할 수 있다. 글자에 형태 및 의미를 부여하는 태그는 아래와 같다.

| 태그 이름 | 설명                         |
| --------- | ---------------------------- |
| b         | 굵은 글자 태그               |
| i         | 기울어진 글자 태그           |
| small     | 작은 글자 태그               |
| sub       | 아래에 달라 붙는 글자 태그   |
| sup       | 위에 달라 붙는 글자 태그     |
| ins       | 밑줄 글자 태그               |
| del       | 가운데 줄이 그어진 글자 태그 |

어려운 내용이 아니므로 아래의 예제로 바로 확인한다.

```html
<!DOCTYPE html> 
<html>
<head>
  <title>HTML5 Text Basic Page</title> 
</head>
<body>
  <h1><b>Lorem ipsum dolor sit amet</b></h1>
  <h1><i>Lorem ipsum dolor sit amet</i></h1>
  <h1><small>Lorem ipsum dolor sit amet</small></h1>
  <h1><sub>Lorem ipsum dolor sit amet</sub></h1>
  <h1><sup>Lorem ipsum dolor sit amet</sup></h1>
  <h1><ins>Lorem ipsum dolor sit amet</ins></h1>
  <h1><del>Lorem ipsum dolor sit amet</del></h1>
  <hr />
  <b>Lorem ipsum dolor sit amet</b><br />
  <i>Lorem ipsum dolor sit amet</i><br />
  <small>Lorem ipsum dolor sit amet</small><br />
  <sub>Lorem ipsum dolor sit amet</sub><br />
  <sup>Lorem ipsum dolor sit amet</sup><br />
  <ins>Lorem ipsum dolor sit amet</ins><br />
  <del>Lorem ipsum dolor sit amet</del><br />
</body>
</html>

```

- 위의 글자 형태를 지정하는 태그들은 최근에 스타일시트로 처리하므로 잘 사용되지 않는다.



#### 루비 문자

루비문자는 일본어에서 자주 사용되는 글자 형식으로 한자 위에 표시되는 글자를 의미한다.
루비문자는 아래의 태그를 이용해서 표시할 수 있다.

| 태그 이름 | 설명                                       |
| --------- | ------------------------------------------ |
| ruby      | 루비 문자 선언 태그                        |
| rt        | 위에 위치하는 작은 문자 태그               |
| rp        | ruby 태그를 지원할 경우 출력되지 않는 태그 |

```html
<body>
    <ruby>
        <span>大韓民國</span>
        <rt>대한민국</rt>
    </ruby>
</body>

```

- 루비 태그를 지원하지 않는 일부 웹 브라우저(파이어 폭스 등)에서는 어떻게 표시되는지 개인적으로 확인해볼것

- ruby 태그를 지원하지 않는 웹 브라우저에서 태그가 정상적으로 출력될 수 있게 만든 태그가 `<rp>` 태그이다.
  - 해당 태그는 ruby 태그를 지원하는 웹 브라우저에서는 출력되지 않는다.
  - 하지만 ruby 태그를 지원하지 않는 웹 브라우저에서는?
    - 위의 각각의 결과 다 확인해볼것

---

## 목록 태그

웹 페이지에 빼놓지 않고 등장하는 요소 중 메뉴가 있다. 일반적으로 페이지를 이동할 때 사용되는 메뉴를 네비게이션 메뉴라 한다. 네비게이션 메뉴를 만들 때 이 절에서 배울 목록 태그를 사용하는 것이 일반적이다.

#### 기본 목록

| 태그 이름 | 설명                  |
| --------- | --------------------- |
| ul        | 순서가 없는 목록 태그 |
| ol        | 순서가 있는 목록 태그 |
| li        | 목록 요소             |

```html
<body>
    <h1>ol tag</h1>
    <ol>
        <li>Facebook</li>
        <li>Tweeter</li>
        <li>Linked In</li>
    </ol>
    <h1>ul tag</h1>
    <ul>
        <li>Facebook</li>
        <li>Tweeter</li>
        <li>Linked In</li>
    </ul>
</body>

```

- ol 태그는 글머리에 숫자가 붙은 목록이 생성되고 ul 태그는 그럼리에 기호가 붙은 목록이 생성된다.



##### 중첩 목록

중첩해서 목록을 만들고 싶을 때는 li 태그 안에 목록 태그를 아래 코드처럼 중첩해서 입력한다.

```html
<body>
    <ul>
        <li>HTML5
            <ol>
                <li>Multimedia Tag</li>
                <li>Connectivity</li>
                <li>Device Access</li>
            </ol>
        </li>
        <li>CSS3
            <ul>
                <li>Animation</li>
                <li>3D Transform</li>
            </ul>
        </li>
    </ul>
</body>

```



#### 정의 목록

정의 목록은 특정 용어와 그 정의를 표현할 때 사용하는 태그이다. 

| 태그 이름 | 설명           |
| --------- | -------------- |
| dl        | 정의 목록 태그 |
| dt        | 정의 용어 태그 |
| dd        | 정의 설명 태그 |

각각의 뜻은 definition list, definition term, definition description이다.

```html
<body>
    <dl>
        <dt>HTML5</dt>
        <dd>Multimedia Tag</dd>
        <dd>Connectivity</dd>
        <dd>Device Access</dd>
        
        <dt>Milk</dt>
        <dd>Animation</dd>
        <dd>3D Transform</dd>
    </dl>
</body>

```

- 웹 표준에 따르면 기본 목록과 ㅈ어의 목록의 사용 용도가 다르지만, 실제 개발할 때는 대부분 용도 구분 없이 사용한다.

---

## 테이블 태그

테이블 태그는 HTML에서 표를 만들 때 사용하는 태그이다. 과거에는 테이블 태그를 이용해 레이아웃도 구성했지만 요즘은 뒤에서 살펴볼 `<div>` 태그가 레이아웃을 구성하는 용도로 사용된다.

#### 테이블 태그 기본

```html
<body>
    <table>
        
    </table>
</body>

```

| 태그 이름 | 설명                   |
| --------- | ---------------------- |
| tr        | 표 내부의 행 태그      |
| th        | 행 내부의 제목 셀 태그 |
| td        | 행 내부의 일반 셀 태그 |

tr은 table row를 뜻하며 th는 table header, td 태그는 table data를 뜻한다.

```html
<body>
    <table border="1">
        <tr>
            <th>Header1</th>
            <th>Header2</th>
        </tr>
        <tr>
            <td>Data1</td>
            <td>Data2</td>
        </tr>
        <tr>
            <td>Data3</td>
            <td>Data4</td>
        </tr>
    </table>    
</body>

```

- 위 페이지를 실행하고 개발자 도구에서 살펴본다.
  - 코드와 다르게 자동으로 `<tbody>` 태그가 삽입되었음을 볼 수 있다.
  - 이러한 웹 브라우저의 특성으로 가끔 문제가 발생하는데, 이는 추후에 다룬다.



##### 테이블 태그 내부에 넣을 수 있는 다른 태그

많이 사용하지는 않지만, `<table>` 태그 내부에는 caption, colgroup, thead, tbody, tfoot 등의 태그를 넣을 수 있다. 아래 코드는 각 영역을 구분하기 위해 아직 배우지 않은 style 속성을 사용했지만, 배경 색상을 적용하는 내용이므로 쉽게 이해할 수 있다.

```html
 <body>
  <table border="1">
      <caption>Caption</caption>
      <colgroup>
        <col span="2" style="background:red" />
        <col style="background:blue" />
      </colgroup>
      <thead style="background:green">
        <tr>
          <th>Table Header</th>
          <th>Table Header</th>
          <th>Table Header</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Table Date</td>
          <td>Table Date</td>
          <td>Table Date</td>
        </tr>
        <tr>
          <td>Table Date</td>
          <td>Table Date</td>
          <td>Table Date</td>
        </tr>
        <tr>
          <td>Table Date</td>
          <td>Table Date</td>
          <td>Table Date</td>
        </tr>
      </tbody>
      <tfoot style="background:yellow">
        <tr>
          <td>Table Date</td>
          <td>Table Date</td>
          <td>Table Date</td>
        </tr>
      </tfoot>
  </table>    
</body>

```



##### 테이블 태그의 속성

HTML5 이전의 table 태그는 속성이 종류가 많았지만, 지금은 `border` 속성 하나만 존재하며 이 속성은 표의 테두리 두께를 지정한다.

`tr, td` 태그는 셀의 높이를 지정하는 rowspan 속성과 너비를 지정하는 colspan 속성을 가진다. 역시나 어렵지 않으므로 아래의 코드로 관찰한다.

```html
<body>
  <table border="1">
    <tr>
      <th colspan="3">Table Data</th>
      <th rowspan="3">Table Data</th>
    </tr>
    <tr>
      <td>Table Data</td>
      <td rowspan="2">Table Data</td>
      <td>Table Data></td>
    </tr>
    <tr>
      <td>Table Data</td>
      <td>Table Data</td>
    </tr>
  </table>
</body>

```

---

## 이미지 태그

HTML은 `<img>` 태그를 사용해 이미지를 넣는다. 이미지 태그는 많은 속성을 가지지만, 아래의 표에 있는 속성은 특히 자주 사용되는 속성이다. 하지만, 요즘은 스타일 시트로 너비와 높이를 지정하기 때문에 `width, height`는 잘 사용되지 않는다.

| 속성 이름 | 설명                              |
| --------- | --------------------------------- |
| src       | 이미지의 경로 지정                |
| alt       | 이미지가 없을 때 나오는 글자 지정 |
| width     | 이미지의 너비 지정                |
| height    | 이미지의 높이 지정                |

```html
<body>
  <img src="https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_160x56dp.png" alt="Google" width="300" />
  <img src="Nothing" alt="No Image" width="300" />
</body>

```

###### 

##### placehold.it

웹 페이지를 디자인 할 때 이미지가 완성되지 않았을 경우, 필요한 크기의 이미지를 만들어 제공해주는 사이트이다. 아래 코드처럼 `http://placehold.it/widthxheight` 형태로 사용할 수 있다.

```html
<body>
    <img src="http://placehold.it/300x200" />
    <img src="http://placehold.it/200x150" />
    <img src="http://placehold.it/100x100" />
</body>

```

비슷한 사이트로 [http://dummyimage.com](http://dummyimage.com) 가 있다.

---

## 오디오 태그

오디오 태그는 브라우저에서 플러그인의 도움 없이 음악을 재생할 수 있게 만들어주는 태그이다. HTML5에서 추가된 기능이므로 익스플로러 8이하에서는 사용할 수 없다.



#### audio 태그

많은 속성을 가지고 있지만, 아래의 중요한 속성이 있다.

| 속성 이름 | 설명                                    |
| --------- | --------------------------------------- |
| src       | 음악 파일의 경로 지정                   |
| preload   | 음악을 재생하기 전에 모두 불러올지 지정 |
| autoplay  | 음악을 자동 재생할지 지정               |
| loop      | 음악을 반복할지 지정                    |
| controls  | 음악 재생 도구를 출력할지 지정          |

```html
<body>
  <audio src="Test.mp3" controls="controls" autoplay="autoplay"></audio>
  <!-- or -->
  <audio src="Test.mp3" controls autoplay></audio>
</body>

```

- Test.mp3 파일을 html 파일과 같은 위치에 놓고 위의 코드를 테스트한다.
- 위의 코드는 XHTML5 방식이고 아래는 HTML5 방식이다.



#### source 태그

인터넷 익스플로러는 .mp3 파일을 지원하지 않는다. 각 브라우저의 종류마다 지원하는 확장자가 다르며, 이를 해결하기 위해 등장한게 source 태그이다.

```html
<audio src="Test.mp3" controls="controls">
    <source src="Test.mp3" type="audio/mp3" />
    <source src="Test.ogg" type="audio/ogg" />
</audio>

```

- ogg와 mp3를 사용하면 모든 브라우저에서 재생할 수 있다.
- type 속성은 지정하지 않으면 브라우저가 음악 파일을 내려받은 뒤에 재생 가능한 파일인지 확인하는 작업이 필요해 트래픽이 낭비된다.

---

## 비디오 태그

비디오 태그는 웹 페이지에서 동영상을 볼 수 있게 해준다. HTML5 이전에는 우니도우 미디어 플레이어 또는 플래시와 같은 플러그인이 필요했지만, 현잰느 웹 표준만으로 동영상을 볼 수 있다. 웹 브라우저는 .wmv 파일을 지원하지 않으므로, 예제 사이트에서 제공되는 파일을 사용하거나 직접 영상 변환 프로그램을 사용해서 mp4 형식과 WebM 형식으로 변환한다.

#### video 태그

| 속성 이름 | 설명                                        |
| --------- | ------------------------------------------- |
| src       | 비디오 파일의 경로 지정                     |
| poster    | 비디오 준비 중일 때의 이미지 파일 경로 지정 |
| preload   | 비디오를 재생하기 전에 모두 불러올지 지정   |
| autoplay  | 비디오를 자동 재생할지 지정                 |
| loop      | 비디오를 반복할지 지정                      |
| controls  | 비디오 재생 도구를 출력할지 지정            |
| width     | 비디오의 너비 지정                          |
| height    | 비디오의 높이 지정                          |

```html
<body>
  <video controls="controls">
    <source src="Test.mp4" type="video/mp4" />
    <source src="Test.webm" type="video/webm" />
  </video>  
</body>

```



- 아래와 같이 poster 속성을 사용해 동영상이 대기 상태일 때 표시할 이미지를 지정할 수 있다.

```html
<body>
  <video poster="http://placehold.it/640x360" width="640" height="360" controls="controls">
    <source src="Test.mp4" type="video/mp4" />
    <source src="Test.webm" type="video/webm" />
  </video>  
</body>

```



###### video.js 플러그인

웹 브라우저마다 표시되는 비디오 태그의 형태가 일관되지 않으므로, 디자인시에 상당한 에러를 겪는다. 또한 익스플로러 8이하 버전에서는 비디오 태그가 동작하지 않는다. 이러한 문제를 해결하기 위해 등장한 플러그인이 video.js 이다.

- 우선 아래처럼 head 태그에 link 태그와 script 태그를 입력한다.
- 이어서 video 태그를 생성하고 class 속성과 data-setup 속성을 입력하면 된다.
- 이후 코드를 모든 웹 브라우저에서 테스트해도 동일한 형태로 영상이 출력됨을 확인할 수 있다.
  - 익스플로러 8에서는 자동으로 플래시에 담겨 동영상이 재생된다.

```html
<head>
  <title>HTML5 Text Basic Page</title>
  <link href="https://vjs.zencdn.net/7.2.3/video-js.css" rel="stylesheet" />
  <script src="https://vjs.zencdn.net/7.2.3/video.js"></script> 
</head>
<body>
  <video poster="http://placehold.it/640x360" width="640" height="360" class="video-js" data-setup="{}">
    <source src="Test.mp4" type="video/mp4" />
    <source src="Test.webm" type="video/webm" />
  </video>  
</body>

```

---

## 입력 양식 태그

입력 양식은 사용자에게 입력을 받는 공간을 의미한다. 입력 양식을 제대로 다루려면 서버와 관련된 기술을 알아야 하지만, 이번 절에서는 기본적인 내용만 살펴본다.

#### 입력 양식 개요

기본적인 `<form>` 태그에 대해 살펴본다.

```html
<body>
  <form>
    <input type="text" name="search" />
    <input type="submit" />
  </form>
</body>

```

텍스트 박스에 데이터를 입력하고 제출 버튼을 누르면 데이터가 지정된 저장소에 지정된 방법으로 전달된다. 장소와 방법은 아래의 속성을 사용해 지정한다.

| 속성 이름 | 설명                           |
| --------- | ------------------------------ |
| action    | 입력 데이터의 전달 위치를 지정 |
| method    | 입력 데이터의 전달 방식을 선택 |



예를 들어 회원 가입 양식을 하나의 시나리오로 생각해보자.

- 개인 정보를 입력하고 회원 가입 버튼을 누르면 정보가 서버로 전달된다.
- 이 때 정보는 from 태그에 지정된 action 속성의 장소로 method 속성에 적힌 방식으로 전달된다.
- 더 깊게 들어가면, 클라이언트와 관련된 내용이 아니므로 이정도의 내용만 파악한다.

- action 속성과 관련된 내용은 깊은 내용이 필요해 다룰 수 없으며, 이 절에서는 간단하게 method 속성만 언급한다.
  - `<form method="">` 에서 자주 사용되는 것은 GET과 POST이다.

```html
<body>
  <form method="get">
    <input type="text" name="search" />
    <input type="submit" />
  </form>
  <form method="post">
    <input type="text" name="search" />
    <input type="submit" />
  </form>
</body>

```

위의 코드를 실행하고, 각 양식에 입력 값을 넣은 뒤에 제출 버튼을 눌러본다.

- get 방식은 주소에 데이터를 입력해서 보내는 방식이다.
  - URL 이 변한것을 볼 수 있다.
  - URL 길이에 제한이 있으므로 크기가 한정되어 있다.
- 반면에 post 방식은 주소가 변경되지 않는다.
  - get에 비해 비밀스럽게 데이터를 전달하는 방식이다.
  - 별도의 첨부를 통해 데이터를 전달하므로 데이터 용량에 제한이 없다.



#### 기본 input 태그

input 태그는 사용자에게 정보를 입력받는 기능을 수행한다.

```html
<body>
  <form>
    <input type="text" name="name" /><br />
    <input type="password" name="password" /><br />
    <input type="file" name="file" /><br />
    <input type="submit" />
  </form>
</body>

```



input 태그의 type 속성 값들은 아래와 같다.

- 추가적으로 input 태그의 내부에 글자를 넣고 싶으면 value 속성값을 입력한다(예시 확인해볼것).

| 속성값   | 설명                      |
| -------- | ------------------------- |
| button   | 버튼을 생성               |
| checkbox | 체크박스를 생성           |
| file     | 파일 입력 양식을 생성     |
| hidden   | 보이지 않음               |
| image    | 이미지 형태를 생성        |
| password | 비밀번호 입력 양식을 생성 |
| radio    | 라디오 버튼을 생성        |
| reset    | 초기화 버튼을 생성        |
| submit   | 제출 버튼을 생성          |
| text     | 글자 입력 양식을 생성     |



###### label 태그

label 태그는 input 태그를 설명하는 데 사용한다.

```html
<body>
  <form>
    <label>이름</label>
    <input type="text">
  </form>
</body>

<!-- label 태그는 어떠한 input 태그를 설명하고 있는지 표시해줘야 하므로 id 속성과 for 속성을 입력한다. 아래의 코드에서 레이블을 클릭하면 자동으로 input 태그에 포커스가 맞춰진다. -->
<body>
  <form>
    <label for="name">이름</label>
    <input id="name" type="text">
  </form>
</body>

```



#### HTML5 입력 양식 태그

HTML5에서는 아래의 속성값을 추가로 지원한다.

| 속성값         | 설명                       |
| -------------- | -------------------------- |
| color          | 색상 선택 양식을 생성      |
| date           | 일 선택 양식을 생성        |
| datetime       | 날짜 선택 양식을 생성      |
| datetime-local | 지역 날짜 선택 양식을 생성 |
| email          | 이메일 입력 양식을 생성    |
| month          | 월 선택 양식을 생성        |
| range          | 범위 선택 양식을 생성      |
| search         | 검색어 입력 양식을 생성    |
| tel            | 전화번호 입력 양식을 생성  |
| time           | 시간 선택 양식을 생성      |
| url            | URL 주소 입력 양식을 생성  |
| week           | 주 선택 양식을 생성        |

```html
<body>
  <form>
    <input type="color" /><br />
    <input type="date" /><br />
    <input type="datetime" /><br />
    <input type="datetime-local" /><br />
    <input type="email" /><br />
    <input type="month" /><br />
    <input type="number" /><br />
    <input type="range" /><br />
    <input type="search" /><br />
    <input type="tel" /><br />
    <input type="time" /><br />
    <input type="url" /><br />
    <input type="week" /><br />
  </form>
</body>

```



#### textarea 태그

input 태그가 아닌 입력 양식이 두 개 있는데, textarea 태그와 select 태그이다.

- cols 속성과 rwos 속성을 이용하여 너비와 높이를 지정할 수 있다.

```html
<body>
    <textarea>TextArea Text</textarea>
</body>

<body>
    <textarea>
        TextArea Text
        TextArea Text2
    </textarea>
</body>

<body>
    <textarea>TextArea Text
TextArea Text2</textarea>
</body>

```



#### select 태그

해당 태그는 여러 개의 목록에서 몇 가지를 선택할 수 있는 입력 양식 요소이다.

| 태그 이름 | 설명             |
| --------- | ---------------- |
| select    | 선택 양식을 생성 |
| optgroup  | 옵션을 그룹화    |
| option    | 옵션을 생성      |

```html
<body>
  <select>
    <option>김밥</option>
    <option>라면</option>
    <option>순대</option>
    <option>오뎅</option>
  </select>
</body>

```

여러 개의 목록을 선택하고 싶을 때는 multiple 속성을 이용한다.

```html
<body>
  <select multiple="multiple">
    <option>김밥</option>
    <option>라면</option>
    <option>순대</option>
    <option>오뎅</option>
  </select>
</body>

```



optgroup 태그는 선택 옵션을 묶을 때 사용하는 태그이다.

```html
<body>
  <select multiple="multiple">
    <optgroup label="HTML5">
      <option>Multimedia Tag</option>
      <option>Connectivity</option>
      <option>Device</option>
    </optgroup>
    <optgroup label="CSS3">
      <option>Animation</option>
      <option>3D Transform</option>
    </optgroup>
  </select>
</body>

```

- 최근에는 이 select 태그 또한 많이 사용하지 않는다. 
  - 자바 스크립트를 이용해 하나하나 만들어 웹 페이지와 어울리게 제작하는 경우가 많다.
  - 즉 옵션을 선택할 수 있는 수단이 select 태그만이 아니라는 것이다.



#### fieldset 태그와 legend 태그

위의 태그들은 입력 양식을 설명하는 태그이다. legend 태그는 fieldset 태그 내부에서만 사용할 수 있다.

```html
<body>
  <form>
    <fieldset>
      <legend>입력 양식</legend>
      <table>
        <tr>
          <td><label for="name">이름</label></td>
          <td><input id="name" type="text" /></td>
        </tr>
        <tr>
          <td><label for="mail">이름</label></td>
          <td><input id="mail" type="email" /></td>
        </tr>
      </table>
      <input type="submit" />
    </fieldset>
  </form>>

```

---

## 공간 분할 태그

과거에는 웹 페이지에서 공간 분할을 하지 않았다. 하지만 현대의 웹 페이지는 공간 분할 태그를 사용하여 웹 페이지를 분할한다. 대표적인 공간 분할 태그는 `<div>`이다. 공간을 분할하는 이유는 3, 4장에서 배울 CSS를 활용해 우리가 원하는 레이아웃을 구성하기 위함이다. 실제 네이버 메인페이지를 보면 408개의 div 태그가 사용되고 있다.

#### div 태그와 span 태그

| 태그 이름 | 설명                             |
| --------- | -------------------------------- |
| div       | block 형식으로 공간을 분할한다.  |
| span      | inline 형식으로 공간을 분할한다. |

```html
<body>
  <div>Lorem ipsum</div>
  <div>Lorem ipsum</div>
  <div>Lorem ipsum</div>
  <div>Lorem ipsum</div>
  <div>Lorem ipsum</div>
</body>

```

위 코드는 다섯 개의 block 형식으로 공간을 분할한 것이다. block 형식은 내용이 탑처럼 쌓아 올려지는 형식을 말한다. 개발자 도구에서 각 블럭이 차지하는 크기를 확인할 수 있다.

반면 아래와 같은 span 태그는 inline 형식으로 공간을 분할한다. inline 형식은 한 줄 안에 차례차례 위치하는 형식을 말하며 개발자 도구를 보면 div와 차이가 있음을 확인할 수 있다.

```html
<body>
  <span>Lorem ipsum</span>
  <span>Lorem ipsum</span>
  <span>Lorem ipsum</span>
  <span>Lorem ipsum</span>
  <span>Lorem ipsum</span>
</body>

```



#### display 속성

block 형식과 inline 형식은 일반 태그에도 적용된다.

```html
<body>
  <h1>Header - 1 tag</h1>
  <p>Paragraph tag</p>
  <hr />
  <a href="#">Anchor tag</a>
  <i>italic tag</i>
</body>

```

위 코드에서 h1 태그와 p 태그는 block 형식이고 a 태그와 i 태그는 inline  형식임을 볼 수 있다.

| block 형식 태그 | inline 형식 태그 |
| --------------- | ---------------- |
| div             | sapn             |
| h1 ~ h6         | a                |
| p               | input            |
| 목록            | 글자형식         |
| 테이블          |                  |
| form            |                  |

- 이미지 태그와 멀티미디어 태그는 inline-block 형식으로 뒤에서 자세히 배운다.



#### HTML5 시멘틱 구조 태그

일반적으로 HTML5의 가장 큰 변화를 시멘틱 태그라고 한다. 그리고 이 때문에 HTML5로 만들어진 웹 페이지를 시멘틱 웹 페이지라 한다. 웹 페이지는 글자로 입력한다. 스타일 시트를 적용하고 사용자가 눈으로 볼 때 "이것은 제목이고, 이것은 본문이다."를 구분할 수 있다. 즉, 사람은 눈으로 레이아웃을 구분하므로 빠르게 구분할 수 있지만 컴퓨터는 그렇지 않다. 기계적인 검색 엔진은 어떠한 태그가 어떠한 기능을 하는지 분별할 수 없고 웹 페이지에서 데이터를 효율적으로 추출할 수 없다. 이를 해결하고자 특정한 태그에 의미를 부여해서 웹 페이지를 만드는 시도가 있었고, 이를 시멘틱 웹이라고 표현한다.

시멘틱 웹을 구현하고자 많은 기술이 등장했다. HTML5는 시멘틱 태그를 사용해 시멘틱 웹을 구현한다. 아래는 HTML5의 시멘틱 구조 태그이다.

| 태그 이름 | 설명                                |
| --------- | ----------------------------------- |
| header    | 헤더를 의미                         |
| nav       | 네비게이션을 의미                   |
| aside     | 사이드에 위치하는 공간을 의미       |
| section   | 여러 중심 내용을 감싸는 공간을 의미 |
| article   | 글자가 많이 들어가는 부분을 의미    |
| footer    | 푸터를 의미                         |

사실 시멘틱 태그는 모두 div 태그와 같은 기능을 수행하는 태그이다. 사용의 의미는 검색 엔진이나 그 이외의 기계적인 동작들이 웹 페이지를 쉽게 이해할 수 있게 하는 데 있다.

아래의 코드는 HTML5 이전의 레이아웃 구성 방식이다.

```html
<body>
  <div>
    <h1>HTML5 Header</h1>
  </div>
  <div>
    <ul>
      <li><a href="#">Menu - 1</a></li>
      <li><a href="#">Menu - 2</a></li>
      <li><a href="#">Menu - 3</a></li>
    </ul>
  </div>
  <div>
    <div>
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div>
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
  </div>
  <div>
    <span>서울특별시 강서구 내발산동</span>
  </div>
</body>

```



아래의 코드는 HTML5에서 시멘틱 태그를 이용해 레이아웃을 구성한 방식이다.

- 직관적으로도 훨씬 의미를 구별하기 쉽다.

```html
<body>
  <header>
    <h1>HTML5 Header</h1>
  </header>
  <nav>
    <ul>
      <li><a href="#">Menu - 1</a></li>
      <li><a href="#">Menu - 2</a></li>
      <li><a href="#">Menu - 3</a></li>
    </ul>
  </nav>
  <section>
    <article>
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </article>
    <article>
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </article>
  </section>
  <footer>
    <address>서울특별시 강서구 내발산동</address>
  </footer>
</body>

```

- 시멘틱 태그가 마음에 들지 않으면 div 태그를 사용해도 된다.
- 다음 장부터는 스타일 시트를 적용해 웹 페이지를 꾸미는 방법을 학습한다.