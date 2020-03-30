BufferedReader 

```java
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class Test1 {
  public static void main(final String[] args) throws Exception {  //예외처리
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //
     String tmp = br.readLine();
    System.out.println(tmp);
  }
}

```

