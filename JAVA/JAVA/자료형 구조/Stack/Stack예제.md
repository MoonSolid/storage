```java
public class StackTest {  
  public static void main(String[] args) {
    Stack stack = new Stack();              // 빈 스택 생성
    System.out.println(stack.isEmpty());    // 스택이 비어있는지 확인
    
    stack.push("A1"); // 스택에 A1 삽입    
    stack.push("B1"); // 스택에 B1 삽입
    stack.push("C1"); // 스택에 C1 삽입
    stack.push("C2"); // 스택에 C2 삽입
    stack.push("C3"); // 스택에 C3 삽입    
    System.out.printf("stack.pop() : %s\n", stack.pop());
    System.out.printf("stack.pop() : %s\n", stack.pop());
    System.out.printf("stack.pop() : %s\n", stack.pop());
    stack.printStack();
    
  }
}

class Node {
  public Object element; // 각 노드에서 저장할 요소
  public Node next;      // 다음 노드를 가리킬 link
  
  public Node(Object element) {  // 생성자
    this.element = element;
    this.next = null;
  }
}

class Stack {
  public Node top; // LIFO 자료구조에서 마지막 요소를 가리킬 변수
  
  public Stack() { // 생성자
    this.top = null; // 초기 스택이 생성되면, 해당 스택은 비어있다.
  }
  
  public boolean isEmpty() {
    return this.top == null;
  }
  
  public void push(Object element) {
    Node newNode = new Node(element);
    newNode.next = top;
    top = newNode;    
  }
  
  // pop() 메소드 구현
  // pop() 메소드는 top이 가리키는 노드를 반환
  // 반환후에도 스택은 변함없이 top이 제일 상단의 노드를 가리키고 있어야 한다.
  public Object pop() {
    Object element = peek();
    if(element == null) {
      return null;
    }
    top = top.next;
    return element;
  }
  public Object peek() {
    if(isEmpty()) {
      System.out.println("스택이 비어있습니다.");
      return null;
    }
    return top.element;
  }
  
  public void printStack() {
    Node curr = top;
    while(curr != null) {
      System.out.println(curr.element);
      curr = curr.next;
    }
  }
}
```

