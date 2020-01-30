# LinkedList

1) 최소 클래스를 작성한다.

```java
package com.eomcs.util;

public class LinkedList {
}
```

2) 값과 다음 값의 주소를 저장할 Node 클래스를 정의한다.

```java
package com.eomcs.util;

public class LinkedList {
  static class Node {
    Object value;
    Node next;
  }
}
```

3) 링크드리스트의 첫 번째 노드와 마지막 노드의 주소, 크기를 저장할 인스턴스 필드를 선언한다.

```java
package com.eomcs.util;

public class LinkedList {  
  Node first;  
  Node last;  
  int size;
  
  static class Node {
    Object value;
    Node next;
  }
}
```

4) add(Object) 추가 

```java
package com.eomcs.util;

public class LinkedList {  
  Node first;  
  Node last;  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }    
    this.size++;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

5) get(int) 추가 

```java
package com.eomcs.util;

public class LinkedList {
  
  Node first;
  
  Node last;
  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }    
    this.size++;
  }  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }    
    return cursor.value;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

6) add(int,Object) 추가

```java
package com.eomcs.util;

public class LinkedList {
  
  Node first;
  
  Node last;
  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size)
      return;
    
    Node newNode = new Node();
    newNode.value = value;    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }    
    this.size++;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

7) remove(int) 추가

```java
package com.eomcs.util;

public class LinkedList {
  
  Node first;
  
  Node last;
  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size)
      return;
    
    Node newNode = new Node();
    newNode.value = value;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }    
    this.size++;
  }  
  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

8) set(int,Object) 추가

```java
package com.eomcs.util;

public class LinkedList {
  
  Node first;
  
  Node last;
  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size)
      return;
    
    Node newNode = new Node();
    newNode.value = value;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }    
    Object oldValue = cursor.value;
    cursor.value = value;    
    return oldValue;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

9) toArray() 추가

```java
package com.eomcs.util;

public class LinkedList {
  
  Node first;
  
  Node last;
  
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size)
      return;
    
    Node newNode = new Node();
    newNode.value = value;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }    
    Object oldValue = cursor.value;
    cursor.value = value;    
    return oldValue;
  }  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    Node cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }    
    return arr;
  }  
  static class Node {
    Object value;
    Node next;
  }
}
```

10) 제네릭 적용

```java
package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  
  Node<E> first;
  
  Node<E> last;
  
  int size;
  
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;
    
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }    
    E oldValue = cursor.value;
    cursor.value = value;    
    return oldValue;
  }  
  public Object[] toArray() {
    Object[] arr = new Object[size];    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }    
    return arr;
  }  
  static class Node<T> {
    T value;
    Node<T> next;
  }
}
```

11) toArray(E[]) 추가 

```java
package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  
  Node<E> first;
  
  Node<E> last;
  
  int size;
  
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;
    
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }    
    return arr;
  }  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    
    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }    
    return arr;
  }  
  static class Node<T> {
    T value;
    Node<T> next;
  }
}
```

12) size() 추가

```java
package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  
  Node<E> first;
  
  Node<E> last;
  
  int size;
  
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;
    
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    
    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }    
    return arr;
  }  
  public int size() {
    return this.size;
  }  
  static class Node<T> {
    T value;
    Node<T> next;
  }
}
```

