# Queue

1) 최소 클래스를 작성한다.

```java
package com.eomcs.util;

public class Queue {
}
```

2) LinkedList를 상속 받는다.

```java
package com.eomcs.util;

public class Queue<E> extends LinkedList<E> {
}
```

3) offer() 추가 

```java
package com.eomcs.util;

public class Queue extends LinkedList<Object> {
  
  public void offer(Object value) {
    this.add(value);
  }
}
```

4) poll() 추가

```java
package com.eomcs.util;

public class Queue extends LinkedList<Object> {
  
  public void offer(Object value) {
    this.add(value);
  }
  
  public Object poll() {
    return this.remove(0);
  }
}
```

5) Object의 clone() 메서드 재정의 : shallow copy 

```java
package com.eomcs.util;
public class Queue extends LinkedList<Object> implements Cloneable {  
  public void offer(Object value) {
    this.add(value);
  }  
  public Object poll() {
    return this.remove(0);
  }  
  @Override
  public Queue clone() {
    try {
      // 단순히 객체의 인스턴스 변수를 복제하는 'shallow copy' 수행
      // => Object의 clone()은 'shallow copy'를 수행한다.
      // => Queue에서 poll()을 수행하면 first 노드를 삭제하게 되고,
      //    이때 원본 객체의 노드의 링크 정보를 변경하게 된다.
      // => 따라서 다음에 다시 복제를 수행하면,
      //    원본 노드의 링크 정보가 제거되었기 때문에 제대로 작업을 수행할 수 없다.
      //
      // 해결책?
      // => 원본 객체가 사용하는 노드도 함께 복제해야 한다.
      // => 즉 'deep copy'를 수행해야 한다.
      //
      return (Queue) super.clone();
      
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
}
```

6) Object의 clone() 메서드 변경 : deep copy

```java
package com.eomcs.util;

public class Queue extends LinkedList<Object> implements Cloneable {  
  public void offer(Object value) {
    this.add(value);
  }  
  public Object poll() {
    return this.remove(0);
  }  
  /*
  @Override
  public Queue clone() {
    try {
      // 단순히 객체의 인스턴스 변수를 복제하는 'shallow copy' 수행
      // => Object의 clone()은 'shallow copy'를 수행한다.
      // => Queue에서 poll()을 수행하면 first 노드를 삭제하게 되고,
      //    이때 원본 객체의 노드의 링크 정보를 변경하게 된다.
      // => 따라서 다음에 다시 복제를 수행하면,
      //    원본 노드의 링크 정보가 제거되었기 때문에 제대로 작업을 수행할 수 없다.
      //
      // 해결책?
      // => 원본 객체가 사용하는 노드도 함께 복제해야 한다.
      // => 즉 'deep copy'를 수행해야 한다.
      //
      return (Queue) super.clone();
      
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */  
  @Override
  public Queue clone() {
    // 'deep copy' 수행
    // => 스택의 경우 배열을 복사하면 되기 때문에,
    //    기존의 'shallow copy'를 수행한 후 배열을 따로 복사하였다.
    // => LinkedList의 경우 노드와 노드 사이를 연결해야 하기 때문에 
    //    단순히 'shallow copy'를 수행해서는 안된다.
    // => 그냥 다음과 같이 새 Queue를 만들고, 
    //    기존 Queue에 저장된 값을 꺼내서 새 Queue에 저장해야 한다.
    //
    Queue temp = new Queue();
    
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}
```

7) 제네릭 적용

```java
package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {  
  public void offer(E value) {
    this.add(value);
  }  
  public E poll() {
    return this.remove(0);
  }  
  /*
  @Override
  public Queue clone() {
    try {
      // 단순히 객체의 인스턴스 변수를 복제하는 'shallow copy' 수행
      // => Object의 clone()은 'shallow copy'를 수행한다.
      // => Queue에서 poll()을 수행하면 first 노드를 삭제하게 되고,
      //    이때 원본 객체의 노드의 링크 정보를 변경하게 된다.
      // => 따라서 다음에 다시 복제를 수행하면,
      //    원본 노드의 링크 정보가 제거되었기 때문에 제대로 작업을 수행할 수 없다.
      //
      // 해결책?
      // => 원본 객체가 사용하는 노드도 함께 복제해야 한다.
      // => 즉 'deep copy'를 수행해야 한다.
      //
      return (Queue) super.clone();
      
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */  
  @Override
  public Queue<E> clone() {
    // 'deep copy' 수행
    // => 스택의 경우 배열을 복사하면 되기 때문에,
    //    기존의 'shallow copy'를 수행한 후 배열을 따로 복사하였다.
    // => LinkedList의 경우 노드와 노드 사이를 연결해야 하기 때문에 
    //    단순히 'shallow copy'를 수행해서는 안된다.
    // => 그냥 다음과 같이 새 Queue를 만들고, 
    //    기존 Queue에 저장된 값을 꺼내서 새 Queue에 저장해야 한다.
    //
    Queue<E> temp = new Queue<E>();
    
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}
```

위에서 만든 Queue적용한 App

```java
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);
  
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();
  
  public static void main(String[] args) {
    
    Prompt prompt = new Prompt(keyboard);
    
    BoardHandler boardHandler = new BoardHandler(prompt);
    LessonHandler lessonHandler = new LessonHandler(prompt);
    MemberHandler memberHandler = new MemberHandler(prompt);
    
    String command;
    
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      
      if (command.length() == 0)
        continue;
      
      commandStack.push(command);
      
      commandQueue.offer(command);
      
      switch (command) {
        case "/lesson/add":
          lessonHandler.addLesson();
          break;
        case "/lesson/list":
          lessonHandler.listLesson();
          break;
        case "/lesson/detail":
          lessonHandler.detailLesson();
          break;
        case "/lesson/update":
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete":
          lessonHandler.deleteLesson();
          break;
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/member/detail":
          memberHandler.detailMember();
          break;
        case "/member/update":
          memberHandler.updateMember();
          break;
        case "/member/delete":
          memberHandler.deleteMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;  
        case "/board/update":
          boardHandler.updateBoard();
          break; 
        case "/board/delete":
          boardHandler.deleteBoard();
          break; 
        case "history":
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
      
    } while (!command.equalsIgnoreCase("quit"));
    
    System.out.println("안녕!");
    
    keyboard.close();
  }
  
  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;
    
    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());
      
      if ((++count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }    
  }
  private static void printCommandHistory() {
    Stack<String> historyStack = commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;
      
      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }  
}
```



