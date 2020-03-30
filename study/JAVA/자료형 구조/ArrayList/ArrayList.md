# ArrayList

1) 최소 클래스 정의

```java
package com.eomcs.algorithm.data_structure.array;
public class ArrayList {  
}
```

2) 객체 목록을 다룰 때 사용할 인스턴스 변수 준비

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {  
  Object[] elementData = new Object[100];
  int size;  
}

```

3) 인스턴스 변수 초기화를 생성자로 옮긴다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    super();
    
    this.elementData = new Object[100];
  }
}
```

4) 배열의 초기 크기를 설정할 수 있는 생성자를 추가한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    super();
    
    this.elementData = new Object[100];
  }
  
  public ArrayList(int initialCapacity) {
    super();
    
    this.elementData = new Object[initialCapacity];
  }
}
```

5) 생성자에 있는 수퍼 클래스의 기본 생성자 호출 문장을 생략한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[100];
  }
  
  public ArrayList(int initialCapacity) {
    this.elementData = new Object[initialCapacity];
  }
}
```

6) 배열의 기본 크기를 직접 지정하지 않고 상수로 정의한 후 그 상수를 사용한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    this.elementData = new Object[initialCapacity];
  }
}
```

7) 생성자에서 배열을 만들 때 초기 크기가 기본 크기 보다 작다면 기본 크기로 배열을 만든다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
}
```

8) 객체를 목록에 저장하는 add() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    this.elementData[this.size++] = e;
  }
}
```

9) 객체를 목록에서 꺼내는 get() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementData[index];
  }
}
```

10) 목록의 저장된 특정 위치의 값을 변경하는 set() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    this.elementData[index] = e;
  }
}
```

11) 목록에 저장된 특정 위치의 값을 삭제하는 remove() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    this.elementData[index] = e;
  }
  
  public void remove(int index) {
    
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

12) add() 변경: 배열이 꽉 차면 50% 증가시킨다. 

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    this.elementData[index] = e;
  }
  
  public void remove(int index) {
    
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

13) get() 변경: 유효한 인덱스가 아니면 null을 리턴한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    this.elementData[index] = e;
  }
  
  public void remove(int index) {
    
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

14) set() 변경: 유효한 인덱스가 아니면 메서드를 실행하지 않는다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return;
    }
    this.elementData[index] = e;
  }
  
  public void remove(int index) {
    
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

15) set() 변경: 변경한 후 변경 전의 값을 리턴한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public void remove(int index) {
    
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

16) remove() 변경: 유효한 인덱스가 아니면 메서드를 실행하지 않는다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public void remove(int index) {
    if (index < 0 || index >= this.size) {
      return;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    
    this.size--;
  }
}
```

17) remove() 변경: 삭제한 후 삭제 전의 값을 리턴한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    Object oldValue = this.elementData[index];
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    this.size--;
    return oldValue;
  }
}
```

18) size 필드 값을 리턴할 size() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    Object oldValue = this.elementData[index];
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
}
```

19) remove() 변경: System.arraycopy()를 사용하여 삭제를 처리한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    Object oldValue = this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
}
```

20) 목록에 저장된 객체를 배열로 리턴하는 toArray() 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    Object oldValue = this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
  }
}
```

21) toArray() 변경: Arrays.copyOf()를 사용하여 리턴할 배열을 만든다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return this.elementData[index];
  }
  
  public Object set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    Object oldValue = this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
}
```

22) ArrayList에 제네릭(generic)을 적용한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
}
```

23) 제네릭으로 지정된 타입의 배열을 리턴하는 toArray()를 추가한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
  }
}
```

24) toArray(E[] arr) 변경: 파라미터로 받은 배열이 넉넉하다면 새로 배열을 만들지 않고 그대로 사용한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때는 새 배열을 만들어 리턴.
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr; // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴. 
  }
}
```

25) 목록 중간에 값을 삽입하는 add(int,E) 메서드를 정의한다.

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때는 새 배열을 만들어 리턴.
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr; // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴. 
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
}
```

26) add()와 add(int,E)에 중복 작성된 배열을 늘리는 코드를 grow() 메서드로 분리한다.  

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      grow();
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때는 새 배열을 만들어 리턴.
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr; // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴. 
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      grow();
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
  
  private Object[] grow() {
    int oldSize = this.elementData.length;
    int newSize = oldSize + (oldSize >> 1);
    
    return this.elementData = Arrays.copyOf(this.elementData, newSize);
  }
}
```

27) grow() 메서드에서 새 배열의 크기를 계산 코드를 newCapacity() 메서드로 분리한다. 

```java
package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList<E> {
  
  private static final int DEFAULT_CAPACITY = 2;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      grow();
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, 
        this.elementData, index, this.size - (index + 1) );
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때는 새 배열을 만들어 리턴.
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr; // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴. 
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      grow();
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
  
  private Object[] grow() {
    return this.elementData = Arrays.copyOf(this.elementData, 
        newCapacity());
  }
  
  private int newCapacity() {
    int oldSize = this.elementData.length;
    return oldSize + (oldSize >> 1);
  }
}
```

