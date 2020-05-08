## AJAX 

---

### AJAX - XMLHttpRequest 

```jsp
<script>
XMLHttpRequest()
    => 동기/비동기 HTTP 요청을 할때 사용한다.
    => 전체 페이지를 갱신하지 않고 페이지의 일부만 갱신하는 용도로 쓴다.
    => 서버는 요청에 대한 응답으로 HTML 일부 코드나 XML, JSON 데이터를 전송한다.
    => 이런 기법을 AJAX(Asynchronous JavaScript And XML)이라 부른다.
    버튼을 클릭할 때 서버에 HTTP 요청하여 응답 결과를 textarea 태그에 출력한다.
    var ta = document.querySelector("#ta");
    
    document.querySelector("#btn1").onclick = () => {
        1) AJAX 객체 준비
        var xhr = new XMLHttpRequest();
        2) 서버에 소켓 연결(동기 방식으로 요청)
        // => 1번 파라미터: HTTP 요청 method    ex) GET , POST , HEAD 
        // => 2번 파라미터: URL
        // => 3번 파라미터: 비동기 여부
        xhr.open("GET","test1.jsp",false);
        3) 서버에 HTTP 요청을 보낸다.
        // => 동기 방식으로 연결되었을 경우 서버에서 응답할 때까지 리턴하지 않는다.
        xhr.send();        
        4) 서버가 응답한 콘텐츠를 꺼낸다.
        ta.value = xhr.responseText;
    };
</script>    
```

---

#### AJAX 요청의 제약

```
// AJAX 요청의 제약
// => HTML을 다운로드 받은 서버로만 AJAX로 HTTP 요청을 할 수 있다.
// => 이유? 보안 때문이다.
//    - 웹브라우저는 서버로부터 HTML을 다운로드 받으면 HTML에 들어있는 JavaScript를 자동으로 실행한다.
//    - HTML페이지는 반드시 신뢰할 수 있는 것은 아니다.
//      페이지의 링크를 이리저리 따라가다 보면 임의의 사용자가 만든 페이지에 방문할 수 있고,
//      그 사용자가 신뢰할 수 있는 사용자인지 알 수 없다. 
//    - 이런 상황에서 누군가 게시글 속에 다른 사이트에 AJAX 요청을 하는 자바스크립트 코드를 넣었다고 가정해 보자.
//      그 게시글을 보는 사용자는 자신의 의도와 상관없이 특정 사이트에 대해 AJAX 요청을 할 것이다.
//      이 요청이 동시에 많은 사람들에 의해 수행된다면 요청 받는 서버는 느려질 것이다.
//      이것이 DDOS 공격이다.
//    - 즉 본인의 의사와 상관없이 DDOS 공격에 참여자가 될 수 있다.
//    - 이런 상황을 방지하고자 HTML을 보낸 서버로만 AJAX 요청을 하도록 제한하고 있다.
//    - 실제는 요청을 하고 응답까지 받는데 다만 응답헤더에 허락한다는 키워드가 없으면 
//      웹브라우저는 응답 결과를 리턴하지 않는다.
//    - 현재는 요청을 제한하기 위함이 아니라, 
//      허락하지 않은 응답 결과에 대해 가져가지 말도록 제한하는데 의미를 둔다.    
```

ex) 

```html
// 버튼을 클릭할 때 서버에 HTTP 요청하여 응답 결과를 textarea 태그에 출력한다.
var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://www.zdnet.co.kr", false);
    xhr.send();
    ta.value = xhr.responseText;
    
    // 이 HTML 문서는 www.zdnet.co.kr 에서 다운로드 받은 것이 아니기 때문에
    // 웹브라우저는 응답받은 결과를 리턴하지 않는다.
    // => 실행하면 다음과 같은 오류가 뜬다.
    // No 'Access-Control-Allow-Origin' header is present on the requested resource.
    // 개발자도구의 console 확인.
};
```

---

### AJAX의 제약 해소

```java
AJAX 요청에 대해 응답을 하는 서버 쪽에서 다음과 같은 응답 헤더를 포함한다면
웹브라우저는 응답결과를 리턴해 줄 것이다.
//Access-Control-Allow-Origin: 허락할 도메인
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - AJAX의 제약 해소</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"
 var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => { 
    //버튼을 클릭할 때 서버에 HTTP 요청하여 응답 결과를 textarea 태그에 출력한다.
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:9999/bitcamp-java-web/javascript/ex07/test1.jsp", false);
    xhr.send();
    ta.value = xhr.responseText;
};
    
```

---

### AJAX - 프록시 기법으로 AJAX의 제약 해소

```java
AJAX로 요청하는 서버를 자신이 통제할 수 있다면,
언제든 응답 헤더에 "Access-Control-Allow-Origin"을 붙여
다른 사이트에서 AJAX 요청을 할 수 있도록 허락할 수 있다.
문제는 자신이 통제할 수 없는 서버는 어떻게 처리할 것인가?
=> 프록시 기법을 사용한다.
=> 웹브라우저는 HTML을 다운로드 받은 서버에 AJAX 요청을 하고,
   그 서버는 중간에서 실제 목적지 서버로 요청을 대행한다.
   목적지 서버로부터 받은 응답을 그대로 AJAX 요청자에게 전달한다.             
   
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - 프록시 기법으로 AJAX의 제약 해소</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"
var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "proxy.jsp", false); //직접 url을 지정하지않고 jsp에서 대행한다.
    xhr.send();
    ta.value = xhr.responseText;
};
</script>
    ---------------------proxy.jsp 코드 --------------------
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="http://www.etnews.co.kr" var="url1"/> //proxy에서 대신 etnews을 불러온다.
<c:import url="${url1}"/>
```

---

### AJAX - GET 요청

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - GET 요청</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"

var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    
    // GET 요청은 데이터를 URL에 붙인다. 
    xhr.open("GET", "test2.jsp?name=홍길동&age=20", false);
    xhr.send();
    ta.value = xhr.responseText;
};

</script>
</body>
</html>
```

### AJAX - POST 요청

```
주의
서버에 POST 요청으로 데이터를 보낼 때는 반드시 Content - Type 헤더를 설정하여
어떤 타입의 데이터를 보내는지 서버에 알려줘야 한다.
=> 일반적인 form 데이터의 형식(이름=값&이름=값&...)은 다음과 같이 MIME 타입을 선언해야 한다.
"application/x-www-form-urlencoded"
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - POST 요청</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"

var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    
    // POST 요청은 데이터를 send()를 호출할 때 넘긴다. 
    xhr.open("POST", "test2.jsp", false);
       
    xhr.setRequestHeader(
        "Content-Type", 
        "application/x-www-form-urlencoded");
    
    var data = "name=" + window.encodeURIComponent("홍길동") + "&age=20";
    console.log(data);
    
    xhr.send(data);
    
    ta.value = xhr.responseText;
};
</script>
</body>
</html>
```

---

### AJAX - 동기 요청의 한계

```
동기 요청의 문제점
=> 서버에서 응답을 할 때까지 send() 메서드는 리턴하지 않는다.
=> 따라서 작업 시간이 오래 걸리는 경우 send() 메서드가 리턴하지 않아서
다른 작업을 수행하지 못하는 상황이 발생한다.
```

```html
<h1>AJAX - 동기 요청의 한계</h1>
<button id="btn1">요청</button><br>
<a href="http://www.google.com">구글로 이동</a><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"
var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    // 클라이언트 쪽의 반응을 확인해 보기 위해 
    // test3.jsp는 일부로 응답시간을 지연시킬 것이다. 
    xhr.open("GET", "test3.jsp", false);
    xhr.send();
    // 서버에서 응답할 때 까지 send()는 리턴하지 않기 때문에 
    // 다음 라인을 실행할 수 없다. 
    // 즉 그 이후의 사용자 행위에 응답하지 못하는 상황이 발생한다.
    // 일종의 "벽돌" 화면이 된다. 
    // 해결 방법? 다음 예제를 보라!
    ta.value = xhr.responseText;
};

</script>
</body>
</html>

```

---

### AJAX - 동기 요청의 한계를 해결

```html
동기 요청의 문제점 해결
=> 웹브라우저는 서버에 요청을 별도의 스레드에서 실행하게 하고,
   서버의 응답에 상관없이 즉시 다음 작업을 수행한다.
=> 이것을 "비동기(asynchronous) 요청" 이라 부른다.

var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => { 
var xhr = new XMLHttpRequest();

// 비동기 요청을 하려면 3번 파라미터를 true로 설정해야 한다.
xhr.open("GET", "test3.jsp".true);
xhr.send();
console.log("send() 리턴함.");
//별도의 스레드를 통해 요청을 수행하게 시키고
//다음 작업을 즉시 실행한다.
//따라서 다음과 같은 코드를 조심해야한다.
// 서버가 응답하기 전에 다음 코드를 실행한다면,
// responseText 변수에는 아직 서버가 응답한 결과가 들어있지 않아서 
// 결과를 제대로 출력할 수 없을 것이다.
ta.value = xhr.responseText;

//해결하려면 서버에서 응답을 완료했을 때 결과를 꺼내야한다.
//해결책은 다음 예제에서 다룬다.

};
```

### AJAX - 동기 요청의 한계를 해결

```html
//서버의 응답을 기다리기 위해서 응답을 10초 정도 지연시킨다.

var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    
    // 비동기 요청을 하려면 3번 파라미터를 true로 설정해야 한다.
    xhr.open("GET", "test3.jsp", true);
    xhr.send();
    console.log("send() 리턴함.");
    
    // 지금 바로 꺼내봐야 소용없다. 
    // 서버에 아직 응답하지 않았기 때문이다.
    // => 서버에서 일부로 10초 정도 응답을 지연시켰다.
    // 
    // 해결책?
    // => 10초 후에(넉넉하게 잡아서 15초 후에) responseText 변수를 사용하게 한다.
    // => 타임아웃에 함수를 등록해서 15초가 지난 후에 호출되면 
    //    responseText 변수의 값을 꺼내게 한다.
    window.setTimeout(() => {
      ta.value = xhr.responseText;
    }, 15000);
    
    // 이 해결 방식의 문제점은
    // 서버의 응답 시간이 바뀌더라도 무조건 15초를 기다렸다가 값을 꺼낸다는 것이다.
    // 서버가 15보다 빨리 응답해도 15초 후에 값을 꺼낸다.
    // 더 큰 문제는 서버가 15를 초과한 경우에는 
    // responseText에 값이 없기 때문에 이전과 같이 서버의 응답 결과를 제대로 
    // 출력하지 못하는 문제가 발생한다.
    // 
    // 해결책!
    // => 다음 예제에서...
    // 
};
//값을 기다리기위해 타임아웃을 걸어두는경우 값이 있어도 무조건 정해진 시간을 기다려야하는 문제가 있다.
```

---

### AJAX - onreadystatechange

```
onreadystatechange
=> 비동기로 AJAX 요청을 하게 되면 작업 상태가 바뀔 때 마다 onreadystatechange로 등록한
   메서드가 호출된다.
=> 작업 상태는 메서드가 호출될 때 마다 readyState 값을 검사해 보면 알 수 있다.
=> readyState의 값:
   0 : XMLHttpRequest 준비
   1 : open() 호출됨 => 서버에 연결됨.
   2 : send() 호출됨 => 서버에 요청을 보낸 후 응답 상태와 헤더 값을 받음.
   3 : 서버에서 콘텐츠를 받고 있는 중.
       아직 responseText에는 완전한 데이터가 들어 있지 않음.
       서버에서 받은 일부 데이터가 들어 있을 수는 있음.
   4 : 서버에서 콘텐츠를 모두 받음. 즉 응답이 완료됨.
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - onreadystatechange</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"
var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    // 서버에서 응답이 왔을 때 호출될 메서드를 등록한다.
    // 서버에 연결하기 전에 등록해야 한다.
    // 즉 open()을 호출하기 전에 등록해야 한다.
    xhr.onreadystatechange = () => {
        console.log("현재 요청 상태: ", xhr.readyState);
    };
    
    xhr.open("GET", "test3.jsp", true);
    xhr.send();
    console.log("send() 리턴함.");
    
    // 비동기로 요청할 때는 서버에서 응답이 왔을 때 값을 꺼내도록 한다.
    // 서버에서 응답이 왔는지 알아내는 방법은?
    // => 현재의 요청 상태를 보고 받는 것이다.
    // => 위의 onreadystatechange() 함수 등록을 참고하라!
};

</script>
</body>
</html>
-----------console 결과 --------------

현재 요청 상태:  1                              - 서버에 연결됨.
   exam03-3-1.html:42 send() 리턴함.
   exam03-3-1.html:37 현재 요청 상태:  2        - 서버에 요청을 보낸 후 응답 상태와 헤더 값을 받음.
2  exam03-3-1.html:37 현재 요청 상태:  3        - 서버에서 콘텐츠를 받고 있는 중.
                                                아직 responseText에는 완전한 데이터가 들어 있지 않음.
   exam03-3-1.html:37 현재 요청 상태:  4        - 서버에서 콘텐츠를 모두 받음. 즉 응답이 완료됨.

실행순서 1 → 2 → 3 → 4 → 3
//상태가 바뀔때마다 등록된 메서드가 호출된다. 서버에서 콘텐츠를 전부 받자 다시 3 이 요청됬다.
```

```java
//실제 우리가 관심을 두는 것은 서버가 응답을 완료했는지 여부이다.
//응답이 완료되었을 때 우리는 서버가 보낸 값을 꺼내 사용한다.
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - onreadystatechange</h1>
<button id="btn1">요청</button><br>
<textarea id="ta" cols="80" rows="10"></textarea>

<script>
"use strict"
var ta = document.querySelector("#ta");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        console.log("readyState=", xhr.readyState);
       
        if (xhr.readyState == 4) { 
            //readyState가 4라는것은 응답을 완료했다는뜻이다.
        	ta.value = xhr.responseText;
            //조건문을통해 readyState가 4일경우 값을 넣도록 했다.
        }
    };
    
    xhr.open("GET", "test3.jsp", true);
    xhr.send();
    console.log("send() 리턴함.");
};

</script>
</body>
</html>
```

### AJAX - readyState와 status

```java
//서버에서 응답을 완료했다고 해서 그 응답 결과를 가지고 작업할 문제는 아니다.
//=> 서버에서 실핼 중에 오류가 발생하더라도 응답을 하기 때문이다.
//=> 즉 서버가 응답한 결과를 가지고, 웹브라우저에서 작업을 수행하기 전에
//   정상적인 응답인지 검사해야 한다.

//   서버에 존재하지 않는 자원을 요청했을 때,
//   또는 서버의 자원을 실행 중에 오류가 발생했을 때
//   그때는 정상적인 응답이 아니기 때문에 responseText를 사용해서는 안된다.
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - readyState와 status</h1>
<input type="text" id="a"> + <input type="text" id="b">
<button id="btn1">=</button>
<input type="text" id="r">

<script>
"use strict"

var a = document.querySelector("#a");
var b = document.querySelector("#b");
var r = document.querySelector("#r");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {    
        	// 다음의 출력 결과를 확인해보라! 
        	r.value = xhr.responseText;     

        }
    };
    
    xhr.open("GET", "test4.jsp?a=" + a.value + "&b=" + b.value, true);
    xhr.send();
    console.log("send() 리턴함.");
};

</script>
</body>
</html>

test4.jsp에는 정수값을 더하기연산을 하는 코드가 있다.
이 예제의 문제는 정수값이 아닌 문자열을 입력해서 오류가 발생해도 응답을 한다.          
다음 예제에서 이 문제를 해결해본다.
```

```java
document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
        	// 서버의 실행이 정상적인지 여부에 따라 처리를 분리하기
        	if (xhr.status == 200) {
        	  // a와 b 값을 정상적으로 입력했을 때 서버는 정상적으로 실행한다. 
        	  r.value = xhr.responseText;
        	  
        	} else {
        	  // a 또는 b 값이 숫자가 아닐 때 서버는 오류를 응답한다.
        	  // HTTP 응답 상태코드 값은 500이 될 것이다.
        	  // 
        	  alert("실행 오류 입니다!");
        	  
        	  // 현재 이 예제의 문제점은 오류가 발생한 후 
        	  // 입력 폼의 값을 초기화시키지 않는다는 것이다.
        	  // 해결책?
        	  // => 다음 예제를 확인하라!
        	}
        }
    };
    //이 예제는 입력 폼의 값을 초기화시키지 않는 문제가 있음
```

### AJAX - 이벤트 발생시키기

```java
서버에서 실행 오류가 발생했을 때 입력 폼을 초기화시키기
=> 프로그램에서 리셋 버튼에 대해 click 이벤트를 발생시킨다.
```

```java
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - 이벤트 발생시키기</h1>
<form>
<input type="text" id="a"> + <input type="text" id="b">
<button type="button" id="btn1">=</button>
<input type="text" id="r"><br>
<button id="btn2" type="reset">초기화</button>
</form>

<script>
"use strict"
var a = document.querySelector("#a");
var b = document.querySelector("#b");
var r = document.querySelector("#r");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
        	// 서버의 실행이 정상적인지 여부에 따라 처리를 분리하기
        	if (xhr.status == 200) {
        	  // a와 b 값을 정상적으로 입력했을 때 서버는 정상적으로 실행한다. 
        	  r.value = xhr.responseText;
        	  
        	} else {
        	  // a 또는 b 값이 숫자가 아닐 때 서버는 오류를 응답한다.
        	  // HTTP 응답 상태코드 값은 500이 될 것이다.
        	  // 
        	  alert("실행 오류 입니다!");
        	  
        	  // 오류 안내창을 닫으면 reset 버튼을 자동으로 누르게 해보자!
        	  // => reset 버튼에 대해 click 이벤트를 프로그램에서 발생시킨다.
        	  
        	  // 먼저 클릭 이벤트 객체를 만든다.
        	  var e = new MouseEvent("click");
        	  
        	  // 그리고 클릭 이벤트 객체를 reset 버튼에 보낸다.
        	  // => 그러면 reset 버튼에 대해 click 이벤트가 발생된다.
        	  document.querySelector("#btn2").dispatchEvent(e);
        	}
        }
    };
    
    xhr.open("GET", "test4.jsp?a=" + a.value + "&b=" + b.value, true);
    xhr.send();
    console.log("send() 리턴함.");
};

</script>
</body>
</html>
//값을 잘못입력한 경우 경고창을 띄우고 경고창을 닫으면 초기화버튼이 눌려진다
// 자동으로 이벤트 객체 눌리게하는 방법
   1) 클릭 이벤트 객체를 만든다. ex) var e = new MouseEvent("click");
   2) 리셋버튼에 아이디를 지정한다. ex) <button id="btn2" type="reset">초기화</button> 
   3) 이벤트관리객체에 click이벤트를 담아서 ex) dispatchEvent(e); 
   4) 리셋버튼에 대해 click 이벤트를 발생시킨다. 
       ex) document.querySelector("#btn2").dispatchEvent(e); 
```

### AJAX - 응용 I : HTML 일부분 가져오기

```html
웹페이지를 만들 때 AJAX를 이용하여 여러 조각을 붙여서 만들 수 있다.
```

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
<style>
div {
  min-height: 50px;
  border: 1px solid red;
}
</style>
</head>
<body>
<div id="header"></div>

<h1>AJAX - 응용 I : HTML 일부분 가져오기</h1>
<button id="btn1">상단, 하단의 내용을 가져와라!</button>

<div id="footer"></div>
<script>
"use strict"
// 웹페이지를 만들 때 AJAX를 이용하여 여러 조각을 붙여서 만들 수 있다.
//       
var header = document.querySelector("#header"),
    footer = document.querySelector("#footer");

document.getElementById("btn1").onclick = () => { //버튼을 클릭했을때 
  prepareHeader(); //헤더와
  prepareFooter(); //푸터의 값을 가져오는 함수를 호출한다 
               //즉, 버튼을 클릭하는것으로 다른 구역의 값을 같이 가져올수있다. 
};

function prepareHeader() {  //헤더의 값을 가져오는 함수
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                header.innerHTML = xhr.responseText;
            }
        }
    };
    xhr.open("GET", "test5.jsp", true);
    xhr.send();
};

function prepareFooter() { //푸터의 값을 가져오는 함수
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                footer.innerHTML = xhr.responseText;
            }
        }
    };
    xhr.open("GET", "footer.html", true);
    xhr.send();
};

</script>
</body>
</html>
```

---

### AJAX - 응용 I : HTML 일부분 가져오기 + 익명함수 즉시 호출

```html
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<div id="header"></div>

<h1>AJAX - 응용 I : HTML 일부분 가져오기 + 익명함수 즉시 호출</h1>

<div id="footer"></div>
<script>
"use strict"
// 웹페이지를 만들 때 AJAX를 이용하여 여러 조각을 붙여서 만들 수 있다.
//       
var header = document.querySelector("#header"),
    footer = document.querySelector("#footer");

(function() { // 머리말 가져오기
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
      if (xhr.readyState == 4) {
          if (xhr.status == 200) {
              header.innerHTML = xhr.responseText;
          }
      }
  };
  xhr.open("GET", "test5.jsp", true);
  xhr.send();
})();

(function() { // 꼬리말 가져오기
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                footer.innerHTML = xhr.responseText;
            }
        }
    };
    xhr.open("GET", "footer.html", true);
    xhr.send();
})();
</script>
</body>
</html>
```

---

### AJAX - 응용 II : 서버에서 JSON 데이터 받아오기

```java
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>AJAX - 응용 II : 서버에서 JSON 데이터 받아오기</h1>
<table border="1">
<thead>
    <tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
</thead>
<tbody>
</tbody>
</table>
<button id="btn1">데이터 가져오기!</button>
<script>
"use strict"
// 웹페이지를 만들 때 AJAX를 이용하여 여러 조각을 붙여서 만들 수 있다.
//       
var tbody = document.querySelector("tbody");

document.querySelector("#btn1").onclick = () => {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
            	// 서버에서 받은 JSON 문자열을 자바스크립트 객체로 변환한다.
                var list = JSON.parse(xhr.responseText);
            	
            	// 배열을 반복하여 값을 꺼낸다.
                for (var b of list) {
                	// tr 태그를 만든다.
                	var tr = document.createElement("tr");
                	
                	// tr 태그에 게시물 데이터를 넣는다.
                	tr.innerHTML = "<td>" + b.no + "</td>" + 
                	   "<td>" + b.title + "</td>" + 
                	   "<td>" + b.writer + "</td>" +
                	   "<td>" + b.viewCnt + "</td>";
                	
                	// tr 태그를 tbody의 자식 태그로 붙인다.
                	tbody.appendChild(tr);
                }
            }
        }
    };
    xhr.open("GET", "test6.jsp", true);
    xhr.send();
};

</script>
</body>
</html>
```







