```
count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count > 50) // 50 넘어가면 합을 수행하지 않지만 100까지 계속 반복
 continue; 건너뛰고 반복  , break; 는 반복문 종료하고 나간다 
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("------------------------");


```



while 문의 break 활용

```
라벨명: 반복문1 {반복문2 {break 라벨명;}}
라벨 문법:
  라벨 문장:
  라벨: {문장1, 문장2, ...} 

myloop: 
        while (x <= 9) {
            while (y <= 9) {
                System.out.printf("%d * %d = %d\n", x, y, x * y);

                if (x == 5 && y == 5)
                    //break; // 이 break는 자신이 소속된 가장 가까운 반복문을 나간다.
                    //break myloop; // myloop 라벨에 소속된 문장을 나간다.
                y++;
            }
            System.out.println();
            x++;
            y = 1;
```

do ~ while 반복문



```
int i = 0;
//1부터 10까지 출력
do
 System.out.println(++i);
 while (i < 10);
 
```

