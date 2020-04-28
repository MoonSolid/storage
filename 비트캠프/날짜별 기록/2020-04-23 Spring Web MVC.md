Spring Web MVC

---

### 페이지 컨트롤러 만드는 방법

```java
@Controller //이 애노테이션을 붙인다.
@RequestMapping("/c01_1") //컨트롤러에 URL을 매핑한다.
public class Controller01_1 {

 @ResponseMapping //이 애노테이션을 붙여서 요청이 들어왔을 때 호출될 메서드임을 표시한다.
 @ResponseBody //메서드의 리턴 값이 클라이언트에게 출력할 내용임을 표시한다.
 public String  handler() {
     return "c901_1 -> handler()";
 }
 
 // URL 한 개당 한 개의 핸들러만 연결할 수 있다.
 // 같은 URL에 대해 다른 메서드를 또 정의하면 실행 오류가 발생한다.
 @RequestMapping
 @ResponseBody
 public String handler2() {
     return "c01_1 -> handler2()";
  }
}

테스트 해보기
```

---

Map으로 객체를 전달할 경우는 void와 같이 취급한다.

- map객체를 서블릿리퀘스트객체로 전달

---

### URL 에서 값 추출하기 - @PathVariable

메서드에 매핑되어있지않으면 파라미터값을 URL에 직접 값을 넣는다

쿼리스트링은 ? 다음에 오는값

ex) app2/c02_1? name=aaa      = name=aaa가 쿼리스트링

```java


```

Jav Config 설정

```
@EnableWebMvc 애노테이션을 활성화시킨다. (MVC 활성화)
WebMvcConfigurer 구현체를 정의한다.

```

### ※ 중요 - 세션 다루기  

```java
//세션 다루기 - HttpSession 직접 사용하기


//1) 값 보관하기

//HttpSession 객체를 사용하려면 아규먼트로 받아야 한다.
    
@GetMapping(value="h1", produces="text/plain;charset=UTF-8")
@ResponseBody
public String handler1(HttpSession session) { //세션을받아서
    session.setAttribute("name","홍길동");  //세션에 값을 저장
    session.setAttribute("age","20");
    
    return "세션에 값을 보관했음"; //저장한 값을 세션에 리턴
}

//2) 값 꺼내기
@GetMapping(value="h2", produces="text/plain;charset=UTF-8")
@ResponseBody
public String handler2(HttpSession session) {
    return String.format("name=%s,age=%s",
                        session.getAttribute("name"),
                        session.getAttribute("age"));
}
```

```java
상황에 따른 세션에 데이터를 저장하는 방법 
// 로그인을 할 경우
session.setAttribute();

// 로그아웃을 할 경우
@SessionAttributes({"name2","age2"})  //현재 페이지 컨트롤러에서만 사용 
//이 애노테이션을 등록하면 Model객체에 값을 감으면 프론트 컨트롤러는 
//ServletRequest 보관소에 값을 옮긴다.

세션자체를 날려버리는 방법 
현재 페이지 컨트롤러의 @SessionAttrubute 해당 항목만 지우는방법 setComplete() 사용



```



