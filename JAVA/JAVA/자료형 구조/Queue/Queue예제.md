```java
public class StackTest {  
  public static void main(String[] args) {
    Queue queue = new Queue();
    System.out.println(queue.isEmpty());
    
    queue.enqueue("A1");
    queue.enqueue("B1");
    queue.enqueue("C1");
    queue.enqueue("D1");
    queue.enqueue("E1");
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}

class Node {
  public Object element; // 노드가 가질 원소
  public Node next;      // 다음 노드를 가리키는 링크
  
  public Node(Object element) {
    this.element = element;
    this.next = null;
  }
}
class Queue {
  public Node front; // 맨 앞의 노드를 가리킬 포인터
  public Node rear;  // 맨 뒤의 노드를 가리킬 포인터
  
  public Queue() {
    this.front = null;
    this.rear = null;
  }  
  public boolean isEmpty() {
    return this.front == null;
  }
  public void enqueue(Object element) {
    Node newNode = new Node(element);
    if(isEmpty()) {
      front = newNode;
      rear = newNode;  
      return;
    }
    rear.next = newNode;
    rear = newNode;
  }
  public Object peek() {
    if(isEmpty()) {
      System.out.println("큐가 비었습니다.");
      return null;      
    }
    return front.element;
  }
  public Object dequeue() {    
    Object element = peek();
    if(element == null)
      return null;
          
    front = front.next;    
    return element;
  }
  public void printQueue() {
    Node curr = this.front;
    while(curr != null) {
      System.out.println(curr.element);
      curr = curr.next;
    }
  }
}

```

