print() 사용법



```
System.out.println(100);
System.out.println(3.14);

=> 100
   3.14
      println은 자동줄바꿈
      
 System.out.print(100);
System.out.print(3.14);

=>
1003.14

print는  이스케이프문자 \n를 사용해줘야한다.

ex) System.out.print("3.14\n");  <- 줄바꿈
```



printf()사용법

```
//printf()사용법
      // => printf("형식", 값1, 값2, ...);
      System.out.printf("\n이름: %s","홍길동");
      System.out.printf("\n나이: %d", 20);

      System.out.printf("\n이름(나이) : %s(%d)","홍길동",20);
      => 출력값 이름(나이) 홍길동(20)
      
      
```

출력할 공간 확보

```
//출력할 공간 확보
      System.out.printf("\n이름: [%s]" , "홍길동");
      System.out.printf("\n이름: [%20s]", "홍길동"); //오른쪽 정렬
      System.out.printf("\n이름: [%-20s]", "홍길동"); //왼쪽정렬
      
      System.out.printf("\n숫자: [%d]" , 12345);
      System.out.printf("\n숫자: [%10d]" , 12345); //오른쪽 정렬
      System.out.printf("\n숫자: [%-10d]" , 12345); //왼쪽정렬
      System.out.printf("\n숫자: [%010d]" , 12345); //빈자리를 0으로 채움
      System.out.printf("\n숫자: [%+010d], [%+010d]", 12345, -12345);  
```

정수 삽입 

```
정수 삽입

   // %d: decimal

   // %x: hexadecimal

   // %c: character
```

