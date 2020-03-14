# 스트림

## 목차

1. [스트림이란?](#스트림이란?)
2. [스트림 만들기](#스트림 만들기)
3. [스트림의 중간 연산](#스트림의 중간 연산)
4. [Optional<T>와 OptionalInt](#Optional<T>와 OptionalInt)
5. [스트림의 최종 연산](#스트림의 최종 연산)
6. [collect()](#collect())
7. [Collector 구현하기](#Collector 구현하기)
8. [스트림의 변환](#스트림의 변환)



## 스트림이란?

- 지금까지는 많은 수의 데이터를 다룰 때, 컬렉션이나 배열에 데이터를 담고 원하는 결과를 얻기 위해 for문 또는 iterator를 사용했다.
- 이러한 방식으로 작성된 코드는 너무 길고 알아보기 어려우며, 재사용성이 떨어진다.
- 또 다른 문제는, 데이터 소스마다 다른 방식으로 다루어진다는 점이다.
  - 리스트를 정렬하기 위해서 Collections.sort(), 배열을 정렬하기 위해서 Arrays.sort()
- 이러한 문제를 해결하기 위해 만든것이 스트림이다. 

## 스트림이란?  (+)

- 스트림은 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메소드들을 정의해 놓았다.
  - 여기서 추상화의 의미는, 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 하여 코드의 재사용성을 높인 것이다.
- 스트림을 이용하면 배열이나 컬렉션뿐만 아니라 파일에 저장된 데이터도 모두 같은 방식으로 다룰 수 있다.

```java
String[] strArr = {"aaa", "bbb", "ccc"};      // String Array
List<String> strList = Arrays.asList(strArr); // List for String Element

// Create a stream based on two data sources above
Stream<String> s1 = strList.stream();	
Stream<String> s2 = Arrays.stream(strArr);	 

// Read data from two data source from the stream, and sorts it, and prints it to the screen
// Note that the data source is not sorted
s1.sorted().forEach(System.out::println);
s2.sorted().forEach(System.out::println);
```

- 스트림의 특징

  - 스트림은 데이터 소스를 변경하지 않는다.

    - 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스 자체를 변경하지 않는다.
    - 필요하다면 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수 있다.
      - `List<String> sortedList = strStream.sorted().collect(Collectors.toList());`

    

  - 스트림은 일회용이다.

    - 이터레이터와 같이 일회용으로 사용됨, 즉 한번 사용하면 닫혀서 다시 사용할 수 없으며 다시 생성해야함

      

  - 스트림은 작업을 내부 반복으로 처리한다.

    - 반복문을 메소드 내부에 숨겨서 작업을 간결하게 만든다.

```java
for(String str : strList)            // same code
    System.out.println(str);
stream.forEach(System.out::println); // same code

// forEach() is a for-statement inside a method
// action is passed as a function parameter
void forEach(Consumer<? super T> action)
{
    Objects.requireNonNull(action); // check if action is null or not
    for(T t : src)                  // internal iteration
        action.accept(T);
}
```



- 스트림의 연산
  - 스트림의 연산은 중간 연산과 최종 연산으로 분류할 수 있다.
    - 중간 연산은 연산 결과를 스트림으로 반환하며, 중간 연산을 연속해 연결할 수 있다.
    - 최종 연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.
  - 중간연산은 map(), flatMap()이 핵심이며 최종연산은 reduce()와 collect()가 핵심이다.
  - Optional은 일종의 Wrapper 클래스로, 내부에 하나의 객체를 저장할 수 있다.

```java
/* intermediate operations */
Stream<T> distinct(){};						// remove duplicates
Stream<T> filter(Predicate<T> predicate){};   // exclude elements that do not meet the conditions
Stream<T> limit(long maxSize){};              // cut off part of the stream
Stream<T> skip(long n){};                     // skip part of the steram
Stream<T> peek(Consumer<T> action){};         // perform operations on elements of the stream

// sort the elements of the stream
Stream<T> sorted(){};
Stream<T> sorted(Comparator<T> comparator){};

// convert the elements of the stream
Stream<R>    map(Function<T, R> mapper){};
DoubleStream mapToDouble(ToDoubleFunction<T> mapper){};
IntStream    mapToInt(ToIntFunction<T> mapper){};
LongStream   mapToLong(ToLongFunction<T> mapper){};

Stream<R>    flatMap(Function<T, Stream<R>> mapper){};
DoubleStream flatMapToDouble(Function<T, DoubleStream> m){};
IntStream    flatMapToInt(Function<T, IntStream> m){};
LongStream   flatMapToLong(FunctionM<T, LongStream> m){};
```

```java
/* final operations */
// perform the action assigned to each element
void forEach(Consumer<? super T> action){};
void forEachOrdered(Consumer<? super T> action){};

long count(){}; // return number of elements in stream

// return the maximum and minimum value of the stream
Optional<T> max(Comparator<? super T> comparator){};
Optional<T> min(Comparator<? super T> comparator){};

// return one element of the stream
Optional<T> findAny(){};   // anything one
Optional<T> findFirst(){}; // first element
    
// check whether all elements satisfy a given condition
boolean allMatch(Predicate<T> p){}; 
boolean anyMatch(Predicate<T> p){}; 
boolean noneMatch(Predicate<> p){}; 

// return all elements of the stream as an array
Object[] toArray(){};
A[]      toArray(IntFunction<A[]> generator){};

// calculate by decreasing elements of a stream by one
Optional<T> reduce(BinaryOperator<T> accumulator){};
T           reduce(T identity, BinaryOperator<T> accumulator){};
U           reduce(U identity, BiFunction<U, T, U) accumulator, BinaryOperator<U> combiner){};

// collect elements of the stream
// it is mainly used to return the result of grouping or splitting elements into a collection
R collect(Collector<T, A, R> collector){};
R collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R, R> combiner){};
```

- 스트림의 특징 2

  - 지연된 연산

    - 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
    - 즉, 스트림에 sort()와 같은 중간연산을 호출해도 즉각적인 연산이 수행되는 것이 아니다.
    - 중간 연산을 호출하는 작업은 단지 어떤 작업이 수행되어야 하는지를 지정하는것
    - 최종 연산이 수행되어야 비로소 중간연산을 거쳐 스트림이 최종연산에서 소모된다.

    

  - Stream<Integer>와 IntStream

    - 오토박싱 & 언박싱으로 인한 비효율을 줄이기 위해 데이터 소스의 요소를 기본형으로 다루는 IntStream, LongStream, DoubleStream이 제공된다.
    - 일반적으로 Stream<Integer> 대신 IntStream을 사용하는 것이 더 효율적이며, IntStream에는 int 타입의 값으로 작업하는데 유용한 메소드를 포함하고 있다.

    

  - 병렬스트림

    - 스트림으로 데이터를 다룰 때의 장점 중 하나가 바로 병렬 처리가 쉽다는 것이다.
    - 앞의 13장에서 fork&join 프레임워크로 작업을 병렬처리 하는 것을 학습했는데, 병렬 스트림은 내부적으로 해당 프레임워크를 이용해서 자동적으로 연산을 병렬로 수행한다.
    - 우리가 할일은 그저 스트림에 parallel()이라는 메소드를 호출해서 병렬로 수행하도록 지시하는것 뿐이다.
    - 병렬로 처리되지 않게 하려면 sequential() 메소드를 호출한다.
      - 모든 스트림은 기본적으로 병렬 스트림이 아니므로 필요가 없을 수 있음
      - 단지 pararrel() 메소드의 취소를 위해 사용
    - ex) `int sum = strStream.parallel().mapToInt(s->s.length()).sum();`



## 스트림 만들기

- 스트림의 소스가 될 수 있는 대상은 배열, 컬렉션, 임의의 수 등 다양함



- 컬렉션
  - 컬렉션의 최고 조상인 Collection에 stream()이 정의되어 있다.
  - 따라서 컬렉션의 자손인 List와 Set을 구현한 컬렉션 클래스들은 모두 이 메소드로 스트림을 생성할 수 있다.
  - stream()은 해당 컬렉션을 소스로 하는 스트림을 반환한다.
  - `Stream<T> Collection.stream()`

```java
List<Integer> ilst = Arrays.asList(1,2,3,4,5); // variable parameter
Stream<Integer> s = list.stream();             // create stream with list
s.forEach(System.out::println);				 // print all element of stream
s.forEach(System.out::println);               // Error, stream is alreay closed
```



- 배열
  - 배열을 소스로 하는 스트림을 생성하는 메소드는 아래와 같이 Stream과 Arrays에 static 메소드로 정의되어 있다.

```java
Stream<T> Stream.of(T... values){};
Stream<T> Stream.of(T[]){};
Stream<T> Arrays.stream(T[]){};
Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive){};

// Also, there is a method to create a stream from a primitive array
IntStream IntStream.of(int... values){};
IntStream IntStream.of(int[]){};
IntStream Arrays.stream(int[]){};
IntStream Arrays.stream(int[] array, int startInclusive, int endExclusive){};
```



- 특정 범위의 정수
  - IntStream과 LongStream은 다음과 같이 지정된 범위의 연속된 정수를 스트림으로 생성해서 반환하는 range()와 rangeClosed()를 가지고 있다.

```java
IntStream IntStream.range(int begin, int end){};        // end is not in the range
IntStream IntStream.rangeClosed(int begin, int end){};  // end is in the range
```



- 임의의 수
  - 난수를 생성하는데 사용하는 Random 클래스에는 아래와 같은 인스턴스 메소드들이 포함되어 있다.
  - 해당 메소드들은 해당 타입의 난수들로 이루어진 스트림을 반환한다.
  - 아래의 메소드들은 스트림의 크기가 정해지지 않은 무한 스트림을 반환하므로 limit()으로 스트림의 크기를 제한해줘야 한다.

```java
IntStream     ints(){};
LongStream    longs(){};
DoubleStrema  doubles(){};

// ex
IntStream s = new Random().ints();          // infinite stream
s.limit(5).forEach(System.out::println);    // print only 5 elements

// finite stream example
// these method crate a finite stream by specifying the size of stream
// so there is no need to use limit().
IntStream    ints(long streamSize){};
LongStream   longs(long streamSize){};
DoubleStrema doubles(long streamSize){};

// in the above method, the random number of stream has the following range
// Integer.MIN_VALUE   <=   ints()     <=   Integer.MAX_VALUE
//    Long.MIN_VALUE   <=   longs()    <=   Long.MAX_VALUE
//               0.0   <=   doubles()   <   1.0

// see also methods below.
IntStream     ints(int begin, int end){};  // end is not in the range
LongStream    longs(long begin, long end){};
DoubleStream  doubles(double begin, double end){};

IntStream     ints(long stremaSize, int begin, int end){};
LongStream    longs(long streamSize, int begin, int end){};
DoubleStream  doubles(long streamSize, double begin, double end){};
```



- 람다식 - iterate(), generate()
  - Stream 클래스의 iterate()와 generate()는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.
  - iterate()는 seed값으로 지정된 값부터 시작해서, 람다식 f에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.
  - generate()도 iterate()처럼, 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성하여 반환하지만, 이전 결과를 이용해서 다음 요소를 계산하지 않는다.
  - 또한 generate()에 정의된 매개변수 타입이 Supplier\<T\>임에 유의하자.
    - 매개변수가 없는 람다식만 허용됨
  - 한 가지 주의할 점은 iterate()와 generate()에 의해 생성된 스트림을 아래와 같이 기본형 스트림 타입의 참조변수로 다룰 수 없다.
    - 굳이 필요하다면, mapToInt()와 같은 메소드로 변환해야 한다.
    - 반대로 IntStream 타입의 스트림을 Stream\<Integer\> 타입으로 변환하려면, boxed()를 사용한다.
    - 스트림간 변환에 대해서는 추후 다시 설명(p.864)

```java
// function definition
static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
static <T> Stream<T> generate(Supplier<T> s)
    
// see below example
Stream<Integer> evenStream = Stream.iterate(0, n->n+2); // 0, 2, 4, 6 ...

// see below example
Stream<Double>  rnadomStream = Stream.generate(Math::random);
Stream<Integer> oneStream    = Stream.generate(()->1);

// see below example
IntStream    evenStream   = Stream.iterate(0, n->n+2);     // Error
DoubleStream randomStream = Stream.generate(Math::random); // Error

IntStream       evenStream   = Stream.iterate(0, n->n+2).mapToInt(Integer::valueOf); // Ok
Stream<Integer> stream       = evenStream.boxed();         // IntStream -> Stream<Integer>
```



- 파일

  - java.nio.file.Files는 파일을 다루는데 필요한 메소드들을 제공하는데, list()는 지정된 디렉토리(dir)에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.

    `Stream<Path> Files.list(Path dir)`

  - 이 외에도 Files 클래스에는 Path를 요소로 하는 스트림을 생성하는 메소드가 더 있지만, 스트림의 범주를 벗어나므로 생략한다.

  - 그리고 파일의 한 행을 요소로 하는 스트림을 생성하는 메소드도 있다.

    - 아래의 세 번째 메소드는 BufferedReader 클래스(p.904)에 속한 것인데, 파일 뿐만 아니라 다른 입력대상으로부터도 데이터를 행단위로 읽어올 수 있다.

```java
Stream<String> Files.lines(Path path){};
Stream<String> Files.lines(Path path, Charset cs){};
Stream<String> lines(){}; // in BufferedReader class
```



- 빈 스트림
  - 요소가 하나도 없는 비어있는 스트림을 생성할 수 있다.
    - 스트림에 연산을 수행한 결과가 하나도 없을 때, null보다 빈 스트림을 반환하는 것이 낫다.
    - count()는 스트림 요소의 개수를 반환하며, 아래 문장에서 값은 0이된다.

```java
Stream emptyStream = Stream.empty(); // create and return empty stream
long count = emptySteram.count();    // count is zero
```



- 두 스트림의 연결
  - Stream의 static 메소드인 concat()을 사용하면, 두 스트림을 하나로 연결할 수 있다.
    - 연결하려는 두 스트림의 요소는 같은 값이어야 한다.

```java
String[] str1 = {"123", "456", "789"};
String[] str2 = {"abc", "def", "ghi"};

Stream<String> s1 = Stream.of(str1);
Stream<String> s2 = Stream.of(str2);
Stream<String> s3 = Stream.concat(s1, s2); // concatenate two stremas into one
```





## 스트림의 중간 연산

- 스트림 자르기 - skip(), limit()
  - 스트림의 일부를 잘라낼 때 사용하며, 사용법은 간단하다.
  - skip(n)은 처음 n개의 요소를 건너뛰고, limit(n)은 스트림의 요소를 n개로 제한한다.

```java
Stream<T> skip(long n){};
Stream<T> limit(long maxSize){};

IntStream skip(long n){};
IntStream limit(long maxSize){};

// ex) print five elements from the fourth element
IntStream is = IntStream.rangeClosed(1, 10);   // create stream with element 1~10
is.skip(3).limit(5).forEach(System.out::print) // 45678
```



- 스트림의 요소 걸러내기 - filter(), distinct()
  - distinct()는 스트림에서 중복된 요소들을 제거하고, filter()는 주어진 조건(Predicate)에 맞지 않는 요소를 걸러낸다.

```java
Stream<T> filter(Predicate<? super T> predicate){};
Stream<T> distinct(){};

// ex
IntStream is = IntStream.of(1,2,2,3,3,3,4,5,5,6);
is.distinct().forEach(System.out::print);         // 123456

// ex
// filter() requires a Predicate as a parameter, 
// but can use a lambda expression that should return boolean type results
IntStream is = IntStream.rangeClosed(1,10);       // 1 ~ 10
is.filter(i->i%2==0).forEach(System.out::print);  // 246810

// if necessary, filter() can be used multiple times with different conditions
// two statement below are same
is.filter(i->i%2!=0 && i%3!=0).forEach(System.out::print);         // 157
is.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::print); // 157
```



- 정렬 - sorted()

```java
Stream<T> sorted(){};
Stream<T> sorted(Comparator<? super T> comparator){};
```

- sorted()는 지정된 Comparator로 스트림을 정렬하는데, Comparator 대신 int 값을 반환하는 람다식을 사용하는 것도 가능하다.
- Comparator를 지정하지 않으면, 스트림 요소의기본 정렬 기준(Comparable)으로 정렬한다.
  - 단, 스트림의 요소가 Comparable을 구현한 클래스가 아니면 예외가 발생한다.

```java
Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
strStream.sorted().forEach(System.out::print);  // CCaaabccdd
```

- 위의 코드는 문자열 스트림을 String에 정의된 기본 정렬(사전순 정렬)로 정렬해서 출력하는 코드이다.



- 아래의 코드는 위의 문자열 스트림을 다양한 방법으로 정렬한 후에 출력한 결과를 보여준다.

```java
s.sorted();                             // default sort                // CCaaabccdd
s.sorted(Comparator.naturalOrder());    // default sort                // CCaaabccdd
s.sorted((s1, s2) -> s1.compareTo(s2)); // using lambda expression     // CCaaabccdd
s.sorted(String::compareTo);            // same as above statement     // CCaaabccdd

s.sorted(Comparator.reverseOrder());    // reverse order of default sort  // ddccbaaaCC
s.sorted(Comparator.<String>naturalOrder().reversed());                   // ddccbaaaCC

s.sorted(String.CASE_INSENSITIVE_ORDER); // not case sensitive      // aaabCCccdd
s.sorted(String.CASE_INSENSITIVE_ORDER.reversed());                 // ddCCccbaaa

s.sorted(Comparator.comparing(String::length));             // sort by length    // bddCCccaaa
s.sorted(Comparator.comparingInt(String::length));          // no auto-boxing    // bddCCccaaa
s.sorted(Comparator.comparing(String::length).reversed());                       // aaaddCCccb
```

- JDK 1.8부터 Comparator 인터페이스에 static 메소드와 default 메소드가 많이 추가되었다.
  - 이 메소드들을 이용하면 정렬이 편해짐
- 해당 메소드들은 모두 Comparator\<T\>를 반환하며, 아래의 메소드 목록은 와일드 카드를 제거하여 간단히 한 것이다.
  - 정확한 메소드의 선언을 보려면 자바 API 문서를 참조

>Comparator의 default 메소드
>///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
>reversed()
>thenComparing(Comparator<T> other)
>thenComparing(Function<T, U> keyExtractor)
>thenComparing(Function<T, U> keyExtractor, Comparator<U> keyComp)
>thenComparingInt(ToIntFunction<T> keyExtractor)
>thenComparingLong(ToLongFunction<T> keyExtractor)
>thenComparingDouble(ToDoubleFunction<T> keyExtractor)
>///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
>
>Comparator의 static 메소드
>///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
>naturalOrder()
>reverseOrder()
>comparing(Function<T, U> keyExtractor)
>comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)
>comparingInt(ToIntFunction<T> keyExtractor)
>comparingLong(ToLongFunction<T> keyExtractor)
>comparingDouble(ToDoubleFunction<T> keyExtractor)
>nullsFirst(Comparator<T> comparator)
>nullsLast(Comparator<T> comparator)
>///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

- 정렬에 사용되는 메소드의 개수가 많지만, 가장 기본적인 메소드는 comparing() 이다.

- 스트림의 요소가 Comparable을 구현한 경우, 매개변수 하나짜리를 사용하면 되고, 그렇지 않은 경우 추가적인 매개변수로 정렬기준(Comparator)을 따로 지정해줘야 한다.

  `comparing(Function<T, U> keyExtractor)`
  `comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)`

- 비교대상이 기본형인 경우, comparing() 대신 아래의 메소드를 사용하면 오토박싱과 언박싱 과정이 없어서 더 효율적이다.

  `comparingInt(ToIntFunction<T> keyExtractor)`
  `comparingLong(ToLongFunction<T> keyExtractor)`
  `comparingDouble(ToDoubleFunction<T> keyExtractor)`

- 정렬 조건을 추가할 때는 thenComparing()을 사용한다.

  `thenComparing(Comparator<T> other)`
  `thenComparing(Function<T, U> keyExtractor)`
  `thenComparing(Function<T, U> keyExtractor, Comparator<U> keyComp)`

```java
// print student stream sorted by class, grade, and name
studentStream.sorted(Comparator.comparing(Student::getBan)
                           .thenComparing(Student::getTotalScore)
                           .thenComparing(Student::getName))
                           .forEach(System.out::println);
```



- 다음 예제는 학생의 성적을 반별 오름차순, 총점별 내림차순으로 정렬하여 출력한다.

```java
import java.util.*;
import java.util.stream.*;
class StreamEx1 {
    public static void main(String[] args) {
         Stream<Student> studentStream = Stream.of(
                            new Student("LeeJava" , 3, 300),
                            new Student("KimJava" , 1, 200),
                            new Student("AhnJava" , 2, 100),
                            new Student("ParkJava", 2, 150),
                            new Student("SoJava"  , 1, 200),
                            new Student("NaJava"  , 3, 290),
                            new Student("GamJava" , 3, 180)
                        );
         studentStream.sorted(Comparator.comparing(Student::getBan) // sort by class
                      .thenComparing(Comparator.naturalOrder()))    // default sort
                      .forEach(System.out::println);
    }
}
class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    Student(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }
    String getName()     { return name;}
    int getBan()         { return ban;}
    int getTotalScore()  { return totalScore;}
    
    // descending order of total score is default sort
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
```



- 변환 - map()

  - 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나, 특정 형태로 변환해야 할 때 사용한다.
  - 메소드의 선언부는 아래와 같으며, 매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야 한다.

  `Stream<R> map(Function<? super T, ? extends R> mapper)`

  - 예를 들어, File의 스트림에서 파일의 이름만 뽑아서 출력하고 싶을 때, 아래와 같이 map()을 이용하면 간단하게 해결할 수 있다.

  ```java
  Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), 								 new File("Ex2.java"), new File("Ex1.txt"));
  
  // convert Stream<File> to Stream<String> using map()
  Stream<String> filenameStream = fileStream.map(File::getName);
  filenameStream.forEach(System.out::println); // print all file name of stream
  ```

  - map() 역시 중간 연산이므로, 연산 결과는 String을 요소로 하는 스트림이다.
    - map() 또한 filter() 처럼 하나의 스트림에 여러 번 적용할 수 있다.

  ```java
  fileStream.map(File::getName)                        // Stream<File> -> Stream<String>
            .filter(s -> s.indexOf('.') != -1)         // exclude if file has no extension
            .map(s -> s.substring(s.indexOf('.')+1))   // Stream<String> -> Stream<String>
            .map(String::toUpperCase)                  // convert to all uppercase letters
            .distinct()                                // remove duplication
            .forEach(System.out::print);               // JAVABAKTXT
  ```

  

- 조회 - peek()

  - 연산과 연산 사이에 올바르게 처리되었는지 확인하기 위해 사용한다.
  - forEach()와 달리 스트림의 요소를 소모하지 않으므로, 연산 사이에 여러 번 사용할 수 있다.
    - filter()나 map()의 결과를 확인할 때 유용하게 사용된다.

  ```java
  fileStream.map(File::getName)                        
            .filter(s -> s.indexOf('.') != -1)
            .peek(s->System.out.printf("filename = %s\n", s))
            .map(s -> s.substring(s.indexOf('.')+1))
            .peek(s->System.out.printf("extension = %s\n", s))
            .forEach(System.out::print);               
  ```

  

- mapToInt(), mapToLong(), mapToDouble()

  - map()은 연산의 결과로 Stream\<T\> 타입의 스트림을 반환하지만, 스트림의 요소를 숫자로 변환하는 경우 IntStream과 같은 기본형 스트림으로 변환하는 것이 더 유용할 수 있다.

    `DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)`
    `IntStream mapToInt(ToIntFunction<? super T> mapper)`
    `LongStream mapToLong(ToLongFunction<? super T> mapper)`

    

  - 앞서 사용했던 studentStream에서 스트림에 포함된 모든 학생의 성적을 합산해야 한다면, map()으로 학생의 총점을 뽑아서 새로운 스트림을 만들어 낼 수 있다.

    `Stream<Integer> studentScoreStream = studentStream.map(Student::getTotalScore);`

  

  - 하지만 이럴 때는 애초에 mapToInt()를 사용해서 Stream\<Integer\> 대신 IntStream 타입의 스트림을 생성해서 사용하는 것이 더 효율적이다.

    - 성적을 더할 때, Integer를 int로 변환할 필요가 없음

    `IntStream studentScoreStream = studentStream.mapToInt(Student::getTotalScore);`
    `int allTotalScore = studentScoreStream.sum();`

    

  - count()만 지원하는 Stream\<T\>와 달리 IntStream과 같은 기본형 스트림은 아래와 같이 숫자를 다루는데 편리한 메소드들을 제공한다.

```java
int            sum(){}         // sum of elements in the stream
OptionalDouble average(){};    // sum() / (double)count()
Optional       max(){};        // maximum value in the stream
Optional       min(){};        // minimum value in the stream
```

- 스트림의 요소가 하나도 없을 때, sum()은 0을 반환하면 그만이지만, 다른 메소드들은 단순히 0을 반환할 수 없다.
  - 여러 요소들을 합한 평균이 0일 수도 있기 때문
- 이를 구분하기 위해 단순히 double값을 반환하는 대신, double 타입의 값을 내부적으로 가지고 있는 OptionalDouble을 반환하는 것이다.
  - OptionalInt, OptionalDouble 등은 일종의 Wrapper 클래스로 각각 int 값과 double 값을 내부적으로 가지고 있다.
    - 추후에 자세히 설명
- 그리고 위의 메소드들은 최종 연산이기 때문에 호출 후에 스트림이 닫힌다는 점을 주의해야 한다.
  - 하나의 코드에서 sum()과 average()를 연속해서 호출할 수 없음

```java
IntStream scoreStream = studentStream.mapToInt(Student::getTotalScore);
long totalScore = scoreStream.sum();            // stream is closed
OptionalDouble average = scoreStream.average(); // Error, stream is already closed
double d = average.getAsDouble();               // save the value stored in OptionalDouble to d
```



- sum()과 average()를 모두 호출해야 할 때, summaryStatistics() 메소드를 사용할 수 있다.
  - 아래의 IntSummaryStatistics는 다양한 종류의 메소드를 제공하며, 필요한 것을 사용하면 된다.
  - 기본형 스트림 LongStream과 DoubleStream도 IntStream과 같은 연산을 지원한다.
    - 단, 반환타입은 다름

```java
IntSummaryStatistics stat = scoreStream.summaryStatistics();
long totalCount           = stat.getCount();
long totalScore           = stat.getSum();
double avgScore           = stat.getAverage();
int minScore              = stat.getMin();
int maxScore              = stat.getMax();
```



- IntStream을 Stream\<T\>로 변환할 때는 mapToObj()를, Stream\<Integer\>로 변환할 때는 boxed()를 사용한다.

  `Stream<U> mapToObj(IntFunction<? extends U> mapper)`
  `Stream<Integer> boxed()`

- 아래는 로또번호를 생성해서 출력하는 코드인데, mapToObj()를 이용해서 IntStream을 Stream\<String\>으로 변경했다.

```java
IntStream intStream = new Random().ints(1, 46); // integer between 1 and 45
Stream<String> lottoStream = intStream.distinct().limit(6).sorted().mapToObj(i->i+" ");
lottoStream.forEach(System.out::print);
```



- 참고로 CharSequence에 정의된 chars()는 String이나 StringBuffer에 저장된 문자들을 IntStream으로 다룰 수 있게 해준다.

```java
IntStream charStream = "12345".chars();
int charSum = charStream.map(ch->ch-'0').sum() // 15
```



- 더하여 mapToInt()와 함께 자주 사용되는 메소드로는 Integer의 parseInt()와 valueOf()가 있다.

```java
Stream<String>  -> IntStream // mapToInt(Integer::parseInt)
Stream<Integer> -> IntStream // mapToInt(Integer::valueOf)
```



- 예제

```java
import java.util.*;
import java.util.stream.*;
class StreamEx1 {
    public static void main(String[] args) {
         Stream<Student> studentStream = Stream.of(
                            new Student("LeeJava" , 3, 300),
                            new Student("KimJava" , 1, 200),
                            new Student("AhnJava" , 2, 100),
                            new Student("ParkJava", 2, 150),
                            new Student("SoJava"  , 1, 200),
                            new Student("NaJava"  , 3, 290),
                            new Student("GamJava" , 3, 180)
                        );
        Stream<Student> stuStream = Stream.of(stuArr);
        stuStream.sorted(Comparator.comparing(Student::getBan)
                 .thenComparing(Comparator.naturalOrder()))
                 .forEach(System.out::println);

        stuStream = Stream.of(stuArr); // regenerate stream
        IntStream stuScoreStream= stuStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count="+stat.getCount());
        System.out.println("sum="+stat.getSum());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min="+stat.getMin());
        System.out.println("max="+stat.getMax());
    }
}
class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban  = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
       return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName()    { return name;}
    int getBan()        { return ban;}
    int getTotalScore() { return totalScore;}

    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
```



- flatMap() - Stream<T[ ]>를 Stream\<T\>로 변환

  - 스트림의 요소가 배열이거나, map()의 연산 결과가 배열인 경우, 즉 스트림의 타입이 Stream<T[ ]>인 경우, Stream\<T\>로 다루는 것이 더 편리할 때가 있으며, 이런 경우 사용한다.
  - 아래와 같이 요소가 문자열 배열(String[ ])인 스트림이 있을 때, 각 요소의 문자열들을 합쳐서 문자열이 요소인 스트림, 즉 Stream\<String\>으로 만들기 위해 어떻게 할 수 있는가?

  `Stream<String[]> strArrStream = Stream.of(new String[]{"abc", "def"}, new String[]{"ABC", "DEF"});`

  

  - 먼저 스트림의 요소를 변환해야 하므로, map()을 써야할 것이고 여기에 배열을 스트림으로 만들어주는 Arrays.stream(T[ ])를 함께 사용하면?

  `Stream<Stream<String>> strStream = strArrStream.map(Arrays::stream);`

  - 예상한 것과 달리 변환 결과가 스트림의 스트림이다.
    - 이 상황을 그림으로 그려보면 아래와 같다.

  <img src="C:\Users\kyh\Desktop\study\과외\s01.PNG" alt="스트림01" style="zoom: 70%;" />

  

  - 간단히 map()을 flatMap()으로 바꾸기만 하면 우리가 원하는 결과를 얻을 수 있다.

  `Stream<String> strStream = strArrStream.flatMap(Arrays::stream);`

  - 위 코드를 그림으로 표현하면 아래와 같다.
    - flatMap()은 스트림의 스트림이 아닌 스트림을 만들어준다.

  <img src="C:\Users\kyh\Desktop\study\과외\s02.PNG" alt="스트림2" style="zoom: 70%;" />

- 예제2
  
  - 아래와 같이 여러 문장들을 요소로 하는 스트림이 있을 때, 이 문장들을 split()으로 나눠서 요소가 단어인 스트림을 만들고 싶다면 어떻게 해야 하는가?

```java
String[] lineArr = {"Belive or not It is true", "Do or do not there is no try"};
Stream<String> lineStream = Arrays.stream(lineArr);
Stream<Stream<String>> strArrStream = lineStream.map(line->Stream.of(line.split(" +")));
```

- 위의 코드에서 알 수 있듯이, map()은 Stream\<String\>이 아니라 Stream<Stream\<String\>\>을 결과로 돌려준다.

  - 아래와 같이 flatMap()으로 원하는 결과를 얻을 수 있다.

  `Stream<String> strStream = lineStream.flatMap(line->Stream.of(line.split(" +")));`

- strStream의 단어들을 모두 소문자로 변환하고, 중복된 단어들을 제거한 다음에 정렬해서 출력하는 문장은 아래와 같다.

```java
strStream.map(String::toLowerCase).distinct().sorted().forEach(System.out::println);
```

- 드문 경우지만, 스트림을 요소로 하는 스트림, 즉 스트림의 스트림을 하나의 스트림으로 합칠때도 flatMap()을 사용한다.

```java
Stream<String> strStream = Stream.of("abc", "def", "ghi");
Stream<String> strSteram2 = Stream.of("ABC", "DEF", "GHI");
Stream<Stream<String>> streamOfStream = Stream.of(strStream, strStream2);
```

- 위와 같이 요소의 타입이 Stream\<String>인 스트림(Stream<Stream\<String>>)이 있을때, 이 스트림을 Stream\<String>으로 변환하려면 map()과 flatMap()을 함께 사용해야 한다.

```java
Stream<String> strStream = 
    streamOfStream.map(s->s.toArray(String[]::new)) // Stream<Stream<String>> -> Stream<String[]>
                  .flatMap(Arrays::stream);         // Stream<String[]> -> Stream<String>
```

- toArray()는 스트림을 배열로 변환해서 반환한다.
  - 매개변수를 지정하지 않으면 Object[ ]를 반환하므로 위와 같이 특정 타입의 생성자를 지정해줘야 한다.
- 그 다음 flatMap()을 이용해 위와 같이 변환한다.



- 예제

```java
import java.util.*;
import java.util.stream.*;
class StreamEx4 {
    public static void main(String[] args) {

        Stream<String[]> strArrStrm = Stream.of(
            new String[]{"abc", "def", "jkl"},
            new String[]{"ABC", "GHI", "JKL"}
        );
        //Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
               .distinct()
               .sorted()
               .forEach(System.out::println);
        System.out.println();
        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                  .map(String::toLowerCase)
                  .distinct()
                  .sorted()
                  .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);

        Stream<String> strStream = strStrmStrm
                                    .map(s -> s.toArray(String[]::new))
                                    .flatMap(Arrays::stream);
        strStream.map(String::toLowerCase)
                 .distinct()
                 .forEach(System.out::println);
    }
}
```



## Optional\<T\>와 OptionalInt

- 최종 연산의 결과가 Optional인 경우가 있다.
- 최종 연산을 학습하기 앞서 Optional에 대해 알아본다.

- Optional\<T>은 제너릭 클래스로 "T 타입의 객체"를 감싸는 Wrapper 클래스이다.(JDK 1.8부터 추가)
  - 따라서 Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있다.

```java
public final class Optional<T>{
    private final T value; // reference variable of type T
    // ...
}
```

- 최종 연산의 결과를 그냥 반환하는게 아니라 Optional 객체에 담아서 반환하는 것이다.

  - 반환된 결과가 null인지 매번 조건문으로 체크하는 대신, Optional에 정의된 메소드를 통해서 간단히 처리할 수 있다.
  - 이제 null 체크를 위한 조건문 없이도 NullPointerException이 발생하지 않는, 보다 간결하고 안전한 코드를 작성하는 것이 가능해진 것이다.
  - 참고로, Objects 클래스에 있는 isNull(), nonNull(), requireNonNull()과 같은 메소드도 null 체크를 위한 조건문을 메소드 안으로 넣어서 코드의 복잡도를 낮추기 위한 방법이다.

  

- Optional 객체 생성하기

  - of() 또는 ofNullable() 사용

```java
String str = "abc";
Optional<String> optVal = Optional.of(str);
Optional<String> optVal = Optional.of("abc");
Optional<String> optVal = Optional.of(new String("abc"));

// if reference variable can be null, use ofNullable()
// in this case, using of() occurs NullPointerException when variable is null.
Optional<String> optVal = Optional.of(null);         // NullPointerException
Optional<String> optVal = Optional.ofNullable(null); // Ok

// Initialize a reference variable of type Optional<T> to default value
// Initialize to null is possible but using empty() is better
Optional<String> optVal = null;                     // initialize to null
Optional<String> optVal = Optional.<String>empty(); // initialize to empty object
```



- Optional 객체의 값 가져오기
  - Optional 객체에 저장된 값을 가져올 때는 get()을 사용
    - 값이 null이라면, NoSuchElementException이 발생하며 ofElse()로 대체할 값을 지정할 수 있다.

```java
Optional<String> optVal = Optional.of("abc");
String str1 = optVal.get();   // return value stored in optVal. if value is null, Exception occurs. 
String str2 = optVal.orElse(""); // if value stored in optVal is null, return ""
```

- orElse()의 변형으로 null을 대체할 값을 반환하는 람다식을 지정할 수 있는 orElseGet()과 null일 때 지정된 예외를 발생시키는 orElseThrow()가 있다.

```java
// function definition
T orElseGet(Supplier<? super T> other){};
T orElseThrow(Supplier<? extends X> exceptionSupplier){};

// usage
String str3 = optVal2.orElseGet(String::new);                 // () -> new String()
String str4 = optVal2.opElseThrow(NullPointerException::new); // if value is null, Exception occurs
```

- Stream처럼 Optional 객체에도 filter(), map(), flatMap()을 사용할 수 있다.
  - map()의 연산 결과가 Optional<Optional\<T>>일 때 flatMap()을 사용하면 Optional\<T>를 결과로 얻는다.
  - 만약 Optional 객체의 값이 null이면, 이 메소드들은 아무 일도 하지 않는다.

 ```java
int result = Optional.of("123").filter(x->x.length() > 0).map(Integer::parseInt).orElse(-1); // 123
int result = Optional.of("").filter(x->x.length() > 0).map(Integer::parseInt).orElse(-1);    // -1
 ```

- parseInt() 메소드는 예외가 발생하기 쉽다.
  - 만약 예외처리된 메소드를 만든다면 아래와 같을 것이다.

```java
public int optStrToInt(Optional<String> optStr, int defaultValue){
    try{
        return optStr.map(Integer::parseInt).get();
    }catch(Exception e){
        return defaultValue;
    }
}
```



- isPresent()는 Optional 객체의 값이 null이면 false를, 아니면 true를 반환한다.
- ifPresent(Consumer\<T> block)는 값이 있으면, 주어진 람다식을 실행하고, 없으면 아무일도 하지 않는다.

 ```java
// same code
if(str != null){
    System.out.println(str);
}

// same code using isPresent()
if(Optional.ofNullable(str).isPresent()){
    System.out.println(str);
}

// same code using ifPresent()
// if str is not null, print str
// if str is null, nothing happens
Optional.ofNullable(str).ifPresent(System.out::println);
 ```



- ifPresent()는 Optional\<T>를 반환하는 findAny()나 findFirst()와 같은 최종 연산과 자주 쓰인다.
  - Stream 클래스에 정의된 메소드 중에서 Optional\<T>를 반환하는 것들은 다음과 같다.

```java
Optional<T> findAny(){};
Optional<T> findFirst(){};
Optional<T> max(Comparator<? super T> comparator){};
Optional<T> min(Comparator<? super T> comparator){};
Optional<T> reduce(BinaryOperator<T> accumulator){};
```

- max()와 min() 메소드는 reduce()를 이용해 작성된 것이다.



- OptionalInt, OptionalLong, OptionalDouble
  - IntStream과 같은 기본형 스트림은 Optional도 기본형을 값으로 하는 OptionalInt를 반환한다.
  - 아래의 목록은 IntStream에 정의된 메소드들이다.

```java
OptionalInt findAny(){};
OptionalInt findFirst(){};
OptionalInt reduce(IntBinaryOperator op){};
OptionalInt max(){};
OptionalInt min(){};
OptionalInt average(){};
```

- 반환 타입이 Optional\<T>가 아니라는 것을 제외하고는 Stream에 정의된 것과 비슷하다.
  - 기본형 Optional에 저장된 값을 꺼낼 때 사용하는 메소드들의 이름이 조금씩 다른것에 주의

```java
T      get(){};         // Optional<T>
int    getAsInt(){};    // OptionalInt
long   getAsLong(){};   // OptionalLong
double getAsDouble(){}; // OptionalDouble
```

- OptionalInt는 아래와 같이 정의되어 있다.

```java
public final class OptionalInt{
    // ...
    private final boolean isPresent; // if value is stored, true
    private final int value;         // variable of type int
}
```

- 기본형 int의 기본값은 0이므로 아무런 값도 갖지 않는 OptionalInt에 저장되는 값은 0일 것이다.
  - 그럼 아래의 두 OptionalInt 객체는 같은가?
    - 저장된 값이 없는 것과 0이 저장된 것은 isPresent라는 인스턴스 변수로 구분이 가능하다.
    - isPresent() 메소드는 해당 인스턴스 변수의 값을 반환한다.

```java
OptionalInt opt1 = OptionalInt.of(0);   // initialize 0 to opt1
OptionalInt opt2 = OptionalInt.empty(); // initialize 0 to opt2

System.out.println(opt1.isPresent());   // true
System.out.println(opt2.isPresent());   // false

System.out.println(opt1.getAsInt());    // 0
System.out.println(opt2.getAsInt());    // NoSuchElementException occurs

System.out.println(opt1.equals(opt2));  // false
```

- 하지만 Optional 객체의 경우, null을 저장하면 비어있는 것과 동일하게 취급한다.

```java
Optional<String> opt1 = Optional.ofNullable(null);
Optional<String> opt2 = Optional.empty();
System.out.println(opt1.equals(opt2)); // true
```



- 예제

```java
import java.util.*;
import java.util.stream.*;
class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String>  optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr="+optStr.get());
        System.out.println("optInt="+optInt.get());

        int result1 = Optional.of("123")
                              .filter(x->x.length() >0)
                              .map(Integer::parseInt).get();
        int result2 = Optional.of("")
                              .filter(x->x.length() >0)
                              .map(Integer::parseInt).orElse(-1);
        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

        Optional.of("456").map(Integer::parseInt)
                          .ifPresent(x->System.out.printf("result3=%d%n",x));

        OptionalInt optInt1  = OptionalInt.of(0);   // initialize to 0
        OptionalInt optInt2  = OptionalInt.empty(); // crate empty object

        System.out.println(optInt1.isPresent());    // true
        System.out.println(optInt2.isPresent());    // false

        System.out.println(optInt1.getAsInt());     // 0
        //System.out.println(optInt2.getAsInt());   // NoSuchElementException
        System.out.println("optInt1 ="+optInt1);
        System.out.println("optInt2="+optInt2);
            System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));

        Optional<String> opt  = Optional.ofNullable(null); // initialize to null
        Optional<String> opt2 = Optional.empty();          // create empty object
        System.out.println("opt ="+opt);
        System.out.println("opt2="+opt2);
        System.out.println("opt.equals(opt2)?"+opt.equals(opt2)); // true
        
        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        System.out.println("result3="+result3);
        System.out.println("result4="+result4);
    }
    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e){
            return defaultValue;
        }
    }
}
```



## 스트림의 최종 연산

- 최종 연산은 스트림의 요소를 소모해서 결과를 만든다.
  
  - 최종 연산 이후에는 스트림이 닫힘
- 최종 연산의 결과는 스트림 요소의 합과 같은 단일 값이거나, 스트림의 요소가 담긴 배열 또는 컬렉션일 수 있다.

- forEach()

  - peek()과 달리 스트림의 요소를 소모하는 최종 연산이다.

    - 반환 타입이 void 이므로 스트림의 요소를 출력하는 용도로 많이 사용된다.

    `void forEach(Consumer<? super T> action)`

-  조건 검사 - allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
  - 스트림의 요소에 대해 지정된 조건에 모든 요소가 일치하는지, 일부가 일치하는지 아니면 어떤 요소도 일치하지 않는지 확인하는데 사용할 수 있다.
    - 모두 Predicate를 매개변수로 요구하며, 연산 결과로 boolean을 반환한다.

 ```java
boolean allMatch (Predicate<? suepr T> predicate){};
boolean anyMatch (Predicate<? suepr T> predicate){};
boolean noneMatch(Predicate<? suepr T> predicate){};
 ```

- 예를 들어, 학생들의 성적 정보 스트림 stuStream에서 총점이 낙제점(총점 100이하)인 학생이 있는지 확인하는 방법은 아래와 같다.

  `boolean noFailed = stuStream.anyMatch(s->s.getTotalScore()<=100);`

- 이외에도 스트림의 요소 중에서 조건에 일치하는 첫 번째 것을 반환하는 findFirst()가 있는데, 주로 filter()와 함께 사용되어 조건에 맞는 스트림의 요소가 있는지 확인하는데 사용된다.
  
  - 단, 병렬스트림인 경우, findFirst() 대신 findAny()를 사용

```java
Optional<Student> stu = stuStream.filter(s->s.getTotalScore()<=100).findFirst();
Optional<Student> stu = parallelStream.filter(s->s.getTotalScore()<=100).findAny();
```

- findAny()와 findFirst()의 반환 타입은 Optional\<T>이며, 스트림의 요소가 없을 때는 비어있는 Optional 객체를 반환
  - 비어있는 Optional 객체는 내부적으로 null을 저장하고 있다.

- 통계 - count(), sum(), average(), max(), min()
  - IntStream과 같은 기본형 스트림에는 스트림의 요소들에 대한 통계 정보를 얻을 수 있는 메소드들이 있다.
  - 그러나 기본형 스트림이 아닌 경우에는 통계와 관련된 메소드들이 아래의 3개 뿐이다.

```java
long        count(){};
Optional<T> max(Comparator<? super T> comparator){};
Optional<T> min(Comparator<? super T> comparator){};
```

- 대부분의 경우 위의 메소드를 사용하기보다, 기본형 스트림으로 변환하거나, 아니면 앞으로 배우게 될 reduce()와 collect()를 사용한다.



- 리듀싱 - reduce()

  - 스트림의 요소를 줄여나가면서 연산을 수행하고, 최종 결과를 반환한다.

  - 매개변수 타입이 BinaryOperator\<T>이다.

    - 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산한다.
    - 이 과정에서 스트림의 요소를 하나씩 소모하게 되며, 스트림의 모든 요소를 소모하게 되면 그 결과를 반환한다.

    `Optional<T> reduce(BinaryOperator<T> accumulator)`

  - 이 외에도 연산결과의 초기값을 갖는 reduce()도 있는데, 이 메소드들은 초기값과 스트림의 첫 번째 요소로 연산을 시작한다.
    
    - 스트림의 요소가 하나도 없는 경우, 초기값(identity)이 반환되므로, 반환 타입은 Optional\<T>가 아닌 T이다.

```java
T reduce(T identity, BinaryOperator<T> accumulator){};
U reduce(U identity, Bifunction<U, T, U> accumulator, BinaryOperator<U> combiner){};
```

- 위의 두 번째 메소드의 마지막 매개변수인 combiner는 병렬 스트림에 의해 처리된 결과를 합칠 때 사용하기 위해 사용하는 것이며, 후에 병렬 스트림에서 설명

```java
// example
int count = intStream.reduce(0, (a,b)->a+1);
int sum   = intStream.reduce(0, (a,b)->a+b);
int max   = intStream.reduce(Integer.MIN_VALUE, (a,b)->a>b?a:b);
int min   = intStream.reduce(Integer.MAX_VALUE, (a,b)->a<b?a:b);
```

- 사실 max()와 min()의 경우, 초기값이 필요없으므로 Optional\<T>를 반환하는 매개변수 하나짜리 reduce()를 사용하는 것이 낫다.
  - 단, intStream의 타입이 IntStream인 경우 OptionalInt를 사용해야 한다.
    - Stream\<T>와 달리 IntStream에 정의된 reduce()의 반환 타입이 OptionalInt이기 때문이다.

```java
// OptionalInt reduce(IntBinaryOperator accumulator)
OptionalInt max = intStream.reduce((a,b)->a>b?a:b);
OptionalInt min = intStream.reduce((a,b)->a<b?a:b);

// convert lambda expression to method reference using static method
OptionalInt max = intStream.reduce(Integer::max);
OptionalInt min = intStream.reduce(Integer::min);

// how to get value from OptionalInt
int maxValue = max.getAsInt();
```

- 아래는 reduce 함수가 어떻게 생겼는지 추측해본 것.

```java
T reduce(T identity, BinaryOperator<T> accumulator){
    T a = identity;
    for(T b : stream)
        a = accumulator.apply(a, b);
    return a;
}
```



- 예제

```java
import java.util.*;
import java.util.stream.*;
class StreamEx5 {
    public static void main(String[] args) {
        String[] strArr = {
            "Inheritance", "Java", "Lambda", "stream",
            "OptionalDouble", "IntStream", "count", "sum"
        };
        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
        Optional<String> sWord = Stream.of(strArr)
                                       .filter(s->s.charAt(0)=='s').findFirst();
        System.out.println("noEmptyStr="+noEmptyStr);
        System.out.println("sWord="+ sWord.get());

        // convert Stream<String[]> to IntStream
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum   = intStream2.reduce(0, (a,b) -> a + b);
        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count="+count);
        System.out.println("sum="+sum);
        System.out.println("max="+ max.getAsInt());
        System.out.println("min="+ min.getAsInt());
    }
}

```



## collect()

- 스트림의 최종 연산중에서 가장 복잡하면서도 유용하게 활용될 수 있는 것
  
  - 별도의 챕터로 분리
- collect()는 스트림의 요소를 수집하는 최종 연산으로, reducing과 유사하다.
- collect()는 스트림의 요소를 수집하기 위해, 어떻게 수집할 것인가에 대한 방법을 정의해야 한다.
  
- 이 방법을 정의한 것이 바로 컬렉터(collector)이다.
  
- 컬렉터는 Collector 인터페이스를 구현한 것으로, 직접 구현할 수도 있고 미리 작성된 것을 사용할 수도 있다.

  - Collectors 클래스는 미리 작성된 다양한 종류의 컬렉터를 반환하는 static 메소드를 가지고 있으며, 이 클래스를 통해 제공되는 컬렉터만으로도 많은 일들을 할 수 있다.

  > collect()    : 스트림의 최종 연산, 매개변수로 컬렉터를 필요로 한다.
  > Collector   : 인터페이스, 컬렉터는 이 인터페이스를 구현해야 한다.
  > Collectors  : 클래스, static 메소드로 미리 작성된 컬렉터를 제공한다.

- Collector 인터페이스를 직접 구현해서 컬렉터를 만드는 방법은 다음 챕터에서 진행
  
- 이번 챕터에서는 Collectors 클래스가 제공하는 컬렉터들을 사용하는 방법에 대해 학습
  
- collect()는 매개변수의 타입이 Collector인데, 매개변수가 Collector를 구현한 클래스의 객체여야 한다는 것이다.
  - collect()는 이 객체에 구현된 방법대로 스트림의 요소를 수집한다.
  - sort()를 위해 Comparator가 필요한 것처럼 collect()를 위해 Collector가 필요하다.

```java
Object collect(Collector collector){};
Object collect(Supplier supplier, BiConsumer accmulator, BiConsumer combiner){};
```

- 위에서 매개변수가 3개인 collect()는 Collector 인터페이스를 구현하지 않고 간단히 람다식으로 수집할 때 사용하면 편리

- 스트림을 컬렉션과 배열로 변환 - toList(), toSet(), toMap(), toCollection(), toArray()
  - 스트림의 모든 요소를 컬렉션에 수집하려면, Colletors 클래스의 toList()와 같은 메소드를 사용한다.
  - List나 Set이 아닌 특정 컬렉션을 지정하려면, toCollection()에 해당 컬렉션의 생성자 참조를 매개변수로 넣어준다.

```java
List<String> names = stuStream.map(Student::getName).collect(Collectors.toList());
ArrayList<String> list = names.stream().collect(Collectors.toCollection(ArrayList::new));
```

- Map은 키와 값의 쌍으로 저장해야하므로, 객체의 어떤 필드를 키로 사용할지와 값으로 사용할지를 지정해야한다.

```java
Map<String, String> map = personStream.collect(Collectors.toMap(p->p.getRegId(), p->p));
```

- 위의 문장은 요소의 타입이 Person인 스트림에서 사람의 주민번호를 키로 하고, 값으로 객체 자체를 그대로 저장한다.
  - 항등 함수를 의미하는 람다식 `p->p`대신 `Function.identity()`를 사용할 수 있다.

- 스트림에 저장된 요소들을 T[ ] 타입의 배열로 변환하려면 toArray()를 사용한다.
  - 해당 타입의 생성자 참조를 매개변수로 지정해줘야 한다.
    - 만약 지정하지 않으면, 반환되는 배열의 타입은 Object[ ]를 반환한다.

```java
Student[] stuNames = studentStream.toArray(Student[]::new); // Ok
Student[] stuNames = studentStream.toArray();               // Error
Object[]  stuNames = studentStream.toArray();               // Ok
```



- 통계 - counting(), summingInt(), averagingInt(), maxBy(), minBy()
  - 앞에서 살펴본 최종 연산들이 제공하는 통계 정보를 collect()로 똑같이 얻을 수 있다.
  - collect()를 사용하지 않고도 통계 정보를 쉽게 얻을 수 있는데, 왜 collect()를 사용한 방법을 보여주는가?
    - collect()를 사용하는 방법을 보여주기 위함
    - 추후에 groupingBy()와 함계 사용할 때 비로소 이 메소드들이 왜 필요한지 알게 될 것이다.
  - summingInt() 외에도 summingLong(), summingDouble()이 있다.
  - summingInt()와 summarizingInt()를 혼동하지 않도록 주의

- 리듀싱 - reducing()
  - 리듀싱 역시 coolect()로 가능하다.
    - IntStream에는 매개변수 3개짜리 collect()만 정의되어 있으므로 boxed() 통해서 IntStream을 Stream\<Integer>로 변환해야 매개변수 한 개 짜리 collect()를 쓸 수 있다.

```java
IntStream intStream = new Random().ints(1,46).distinct().limit(6);

OptionalInt max = intStream.reduce(Integer::max);
Optional<Integer> max = intStream.boxed().collect(reducing(Integer::max));

long sum = intStream.reduce(0, (a,b)->a+b);
long sum = intStream.boxed().collect(reducing(0, (a,b)->a+b));

int grandTotal = stuStream.map(Student::getTotalScore).reduce(0, Integer::sum);
int grandTotal = stuStream.collect(reducing(0, Student::getTotalScore, Integer::sum));
```

- Collectors.reducing()에는 아래와 같이 세 가지 종류가 있다.
  - 세 번째 메소드를 제외하고는 reduce()와 같음
  - 세 번째 메소드는 map()과 reduce()를 하나로 합쳐놓은것

```java
// simplified by removing generic wildcard.
Collector reducing(BinaryOperator<T> op){};
Collector reducing(T identity, BinaryOperator<T> op){};
Collector reducing(U identity, Function<T, U> mapper, BinaryOperator<U>){};
```



- 문자열 결합 - joining()
  - 문자열 스트림의 모든 요소를 하나씩 문자열로 연결해서 반환한다.
    - 구분자를 지정해줄 수 있고, 접두사와 접미사도 지정 가능하다.
  - 스트림의 요소가 String이나 StringBuffer처럼 CharSequence의 자손인 경우에만 결합이 가능하므로, 스트림의 요소가 문자열이 아닌 경우에는 먼저 map()을 이용해서 스트림의 요소를 문자열로 변환해야 한다.

```java
String studentNames = stuStream.map(Student::getName).collect(joining());
String studentNames = stuStream.map(Student::getName).collect(joining(","));
String studentNames = stuStream.map(Student::getName).collect(joining(",", "[", "]"));
```

- 만약 map()이 없이 스트림에 바로 joining()을 하면, 스트림의 요소에 toString()을 호출한 결과를 결합한다.

- 예제

```java
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
class StreamEx6 {
    public static void main(String[] args) {
        Student[] stuArr = {
            new Student("LeeJava", 3, 300),
            new Student("KimJava", 1, 200),
            new Student("AnJava", 2, 100),
            new Student("ParkJava", 2, 150),
            new Student("SoJava", 1, 200),
            new Student("NaJava", 3, 290),
            new Student("GamJava", 3, 180)
        };

        // store student name to List<String>
        List<String> names = Stream.of(stuArr).map(Student::getName)
                                              .collect(Collectors.toList());
        System.out.println(names);

        // convert stream to array
        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);

        for(Student s : stuArr2)
            System.out.println(s);

        // convert stream to Map(String, Student> with the key is name
        Map<String,Student> stuMap = Stream.of(stuArr)
                                           .collect(Collectors.toMap(s->s.getName(), p->p));
        for(String name : stuMap.keySet())
            System.out.println(name +"-"+stuMap.get(name));

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                                .collect(summingInt(Student::getTotalScore));
        System.out.println("count="+count);
        System.out.println("totalScore="+totalScore);

        totalScore = Stream.of(stuArr)
                           .collect(reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println("totalScore="+totalScore);

        Optional<Student> topStudent = Stream.of(stuArr)
            .collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println("topStudent="+topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuArr)
                                          .collect(summarizingInt(Student::getTotalScore));
        System.out.println(stat);

        String stuNames = Stream.of(stuArr)
                                .map(Student::getName)
                                .collect(joining(",", "{", "}"));
        System.out.println(stuNames);
    }
}
class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }
    String getName() { return name;}
    int getBan() { return ban;}
    int getTotalScore() { return totalScore;}
    public String toString() {
       return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}

```



- 그룹화와 분할 - groupingBy(), partitioningBy()
  - 지금까지는 기존의 다른 연산으로도 대체가능한 경우에 대해서 설명했기 때문에, collect()가 왜 필요한지 잘 느끼지 못했을 것이다.
    - 이제부터는 본격적으로 collect()의 유용함을 배워본다.
  - 그룹화는 스트림의 요소를 특정 기준으로 그룹화 하는 것을 의미한다.
  - 분할은 스트림의 요소를 두 가지, 지정된 조건에 일치하는 그릅과 일치하지 않는 그룹으로의 분할을 의미한다.
  - 아래의 메소드 정의에서 알 수 있듯이, groupingBy()는 스트림의 요소를 Function으로, partitioningBy()는 Predicate로 분류한다.

```java
Collector groupingBy(Function classifier){};
Collector groupingBy(Function classifier, Collector downstream){};
Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream){};

Collector partitioningBy(Predicate predicate){};
Collector partitioningBy(Predicate predicate, Collector downstream){};
```

- 스트림을 두 개의 그룹으로 나눠야 한다면 partitioningBy(), 그 외에는 groupingBy()를 사용
  - 두 가지 메소드는 분류를 Function으로 하느냐, Predicate로 하느냐의 차이만 있을 뿐 나머지는 동일
  - 또한, 그룹화와 분할의 결과는 Map에 담겨 반환된다.

```java
// resource for example
class Student{
    String  name;
    boolean isMale;
    int     grade;
    int     classNum;
    int     score;
    
    Student(String name, boolean isMale, int grade, int classNum, int score){
        this.name     = name;
        this.isMale   = isMale;
        this.grade    = grade;
        this.classNum = classNum;
        this.score    = score;
    }
    String  getName()     { return this.name; }
    boolean isMale()      { return this.isMale; }
    int     getGrade()    { return this.grade; }
    int     getClassNum() { return this.classNum; }
    int     getScore()    { return this.score; }
    public String toString(){
        return String.format("[%s, %s, %d, %d, %3d]", name, isMale?"Male":"Female", grade, classNum, score);
    }
    enum Level{ HIGH, MID, LOW }
}

Stream<Student> stuStream = Stream.of(
					new Student("NaJava"   , true , 1, 1, 300),
					new Student("KimJimi"  , false, 1, 1, 250),
					new Student("KimJava"  , true , 1, 1, 200),
					new Student("LeeJimi"  , false, 1, 2, 150),
					new Student("NamJava"  , true , 1, 2, 100),
					new Student("AnJimi"   , false, 1, 2, 50),
					new Student("HwangJimi", false, 1, 3, 100),
					new Student("GangJimi" , false, 1, 3, 150),
					new Student("Leejava"  , true , 1, 3, 200),
					
					new Student("NaJava"   , true , 2, 1, 300),
					new Student("KimJimi"  , false, 2, 1, 250),
					new Student("KimJava"  , true , 2, 1, 200),
					new Student("LeeJimi"  , false, 2, 2, 150),
					new Student("NamJava"  , true , 2, 2, 100),
					new Student("AnJimi"   , false, 2, 2, 50),
					new Student("HwangJimi", false, 2, 3, 100),
					new Student("GangJimi" , false, 2, 3, 150),
					new Student("Leejava"  , true , 2, 3, 200));
```

- partitioningBy()에 의한 분류
  - 먼저 상대적으로 간단한 분할부터 시작
    - 분할을 이해하고 나면 그룹화는 쉽게 이해가 될 것이다.
    - 가장 기본적인 분할은 학생들을 성별로 나누어 List에 담는 것이다.

```java
// basic partitioning with sex
Map<Boolean, List<Student>> stuBySex = stuStream.collect(partitioningBy(Student::isMale));
List<Student> maleStudent   = stuBySex.get(true);
List<Student> femaleStudent = stuBySex.get(false);
```



- counting()을 추가해서 남학생의 수와 여학생의 수를 구해본다.

```java
// basic partitioning + statistics
Map<Boolean, Long> stuNumBySex = stuStream.collect(partitioningBy(Student::isMale, counting()));
System.out.println("number of male : " + stuNumBySex.get(true));
System.out.println("number of female : " + stuNumBySex.get(false));
```



- counting() 대신 summingLong()을 사용하면, 남학생과 여학생의 총점을 구할 수 있다.

```java
Map<Boolean, Long> totalScoreBySex = stuStream.collect(
    Collectors.partitioningBy(
        Student::isMale, Collectors.summingLong(Student::getScore)
    ));
```



- 그렇다면 여학생 1등과 남학생 1등은 어떻게 구하는가?

```java
Map<Boolean, Optional<Student>> topScoreBySex = stuStream.collect(
    Collectors.partitioningBy(Student::isMale, maxBy(comparingInt(Student::getScore))
    ));
```

- maxBy()는 반환 타입이 Optional\<Student>이기 때문에, 위와 같은 결과가 나온다.
  - Optional\<Student>가 아닌  Student를 반환 결과로 얻으려면, 아래와 같이 collectingAndThen()과 Optional::get을 함께 사용한다.

```java
Map<Boolean, Student> topSocreBySex = stuStream.collect(
    Collectors.partitioningBy(
        Student::isMale, Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparingInt(Student::getScore)), Optional::get)
    ));

System.out.println(topScoreBySex.get(true));
System.out.println(topScoreBySex.get(false));
```



- 성적이 150점 아래인 학생들은 불합격 처리하고 싶다.
  - 불합격자를 성별로 분류하여 얻어내려면?
    - partitioningBy()를 한번 더 사용해서 이중 분할을 한다.

```java
Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = stuStream.collect(
    Collectors.partitioningBy(Student::isMale, Collectors.partitioningBy(
        s->s.getScore()<150)));

List<Student> failedMaleStu   = failedStuBySex.get(true).get(true);
List<Student> failedFemaleStu = failedStuBySex.get(false).get(true);
```



- 예제

```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student{
    String  name;
    boolean isMale;
    int     grade;
    int     classNum;
    int     score;

    Student(String name, boolean isMale, int grade, int classNum, int score){
        this.name     = name;
        this.isMale   = isMale;
        this.grade    = grade;
        this.classNum = classNum;
        this.score    = score;
    }
    String  getName()     { return this.name; }
    boolean isMale()      { return this.isMale; }
    int     getGrade()    { return this.grade; }
    int     getClassNum() { return this.classNum; }
    int     getScore()    { return this.score; }
    public String toString(){
        return String.format("[%s, %s, %d, %d, %3d]", name, isMale?"Male":"Female", grade, classNum, score);
    }
    enum Level{ HIGH, MID, LOW }
}
class StreamEx7 {
    public static void main(String[] args) {
        Stream<Student> stuStream = Stream.of(
                new Student("NaJava"   , true , 1, 1, 300),
                new Student("KimJimi"  , false, 1, 1, 250),
                new Student("KimJava"  , true , 1, 1, 200),
                new Student("LeeJimi"  , false, 1, 2, 150),
                new Student("NamJava"  , true , 1, 2, 100),
                new Student("AnJimi"   , false, 1, 2, 50),
                new Student("HwangJimi", false, 1, 3, 100),
                new Student("GangJimi" , false, 1, 3, 150),
                new Student("Leejava"  , true , 1, 3, 200),

                new Student("NaJava"   , true , 2, 1, 300),
                new Student("KimJimi"  , false, 2, 1, 250),
                new Student("KimJava"  , true , 2, 1, 200),
                new Student("LeeJimi"  , false, 2, 2, 150),
                new Student("NamJava"  , true , 2, 2, 100),
                new Student("AnJimi"   , false, 2, 2, 50),
                new Student("HwangJimi", false, 2, 3, 100),
                new Student("GangJimi" , false, 2, 3, 150),
                new Student("Leejava"  , true , 2, 3, 200));
        System.out.printf("1. Basic partitioning with sex\n");
        Map<Boolean, List<Student>> stuBySex =  Stream.of(stuArr)
                .collect(partitioningBy(Student::isMale));

        List<Student> maleStudent   = stuBySex.get(true);
        List<Student> femaleStudent = stuBySex.get(false);

        for(Student s : maleStudent)   System.out.println(s);
        for(Student s : femaleStudent) System.out.println(s);

        System.out.printf("%n2. Basic partitioning + Statistics(number of student with sex\n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student::isMale, counting()));

        System.out.println("male :"+ stuNumBySex.get(true));
        System.out.println("female :"+ stuNumBySex.get(false));


        System.out.printf("%n3. Basic partitioning + Statistics(top score with sex\n");
        Map<Boolean, Optional<Student>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student::isMale,
                    maxBy(comparingInt(Student::getScore))
                ));
        System.out.println("male :"+ topScoreBySex.get(true));
        System.out.println("female :"+ topScoreBySex.get(false));

        Map<Boolean, Student> topScoreBySex2 = Stream.of(stuArr)
            .collect(partitioningBy(Student::isMale,
                collectingAndThen(
                    maxBy(comparingInt(Student::getScore)), Optional::get
                )
            ));
        System.out.println("male :"+ topScoreBySex2.get(true));
        System.out.println("female :"+ topScoreBySex2.get(false));

        System.out.printf("%n4. Multiple partitioning(failed with sex, less than 100\n");

        Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex =
            Stream.of(stuArr).collect(partitioningBy(Student::isMale,
                partitioningBy(s -> s.getScore() <= 100))
            );
        List<Student> failedMaleStu   = failedStuBySex.get(true).get(true);
        List<Student> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(Student s : failedMaleStu)   System.out.println(s);
        for(Student s : failedFemaleStu) System.out.println(s);
    }
}

```



- groupingBy()에 의한 분류
  - stuStream()을 반 별로 그룹지어 Map에 저장하는 방법

```java
Map<Integer, List<Student>> stuByClass = stuStream.collect(groupingBy(Student::getBan));
```

- 그룹화를 하면 기본적으로 List\<T>에 담는다.
  - 그래서 위의 문장은 아래 문장의 생략된 형태이다.
  - 만일 원한다면, toList() 대신 toSet()이나 toCollection(HashSet::new)을 사용할 수 있다.
  - 단 Map의 제너릭 타입도 적절히 변경해야 한다.

```java
Map<Integer, List<Student>> stuByClass = stustream.collect(groupingBy(Student::getBan, toList()));

Map<Integer, HashSet<Student>> stuByGrade = stuStream.collect(groupingBy(Student::getHak, toCollection(HashSet::new)));
```



- 좀 더 복잡하게, stuStream을 성적의 등급(Student.Level)으로 그룹화 한다.
  - 아래의 문장은 모든 학생을 세 등급(HIGH, MID, LOW)로 분류하여 집계한다.

```java
Map<Student.Level, Long> stuByLevel = stuStream.collect(groupingBy(s->{
    if(s.getScore() >= 200) return Student.Level.HIGH;
    else if(s.getSocre() >= 100) return Student.Level.MID;
    else return Student.Level.LOW;
}, counting()));
```

- groupingBy()를 여러 번 사용하면, 다수준 그룹화가 가능하다.
  - 만일 학년별로 그룹화 한 후에 다시 반별로 그룹화 하고 싶으면 아래와 같은 코드를 작성한다.

```java
Map<Integer, Map<Integer, List<Student>>> stuByGradeAndClass = stuStream.collect(groupingBy(Student::getGrade, groupingBy(Student::getClassNum)))
```

- 위의 코드를 발전시켜서 각 반의 1등을 출력하고 싶다면, collectingAndThen()과 maxBy()를 아래와 같이 사용한다.

```java
Map<Integer, Map<Integer, Student>> topStuByGradeAndClassNum = stuStream.collect(groupingBy(Student::getGrade, groupingBy(Student::getClassNum, collectingAndThen(maxBy(comparingInt(Student::getScore)), Optional::get))));
```



- 아래의 코드는 학년별, 반별로 그룹화한 다음에, 성적 그룹으로 변환하여 Set에 저장한다.

```java
Map<Integer, Map<Integer, Set<Student.Level>>> stuByGradeAndClassNum = stuStream.collect(Collectors.groupingBy(Student::getGrade, Collectors.groupingBy(Student::getClassNum, Collectors.mapping(s->{
    if(s.getScore() >= 200) return Student.Level.HIGH;
    else if(s.getScore() >= 100) return Student.Level.MID;
    else return Student.Level.LOW;
}, Collectors.toSet()))));
```



- 예제

```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student{
    String  name;
    boolean isMale;
    int     grade;
    int     classNum;
    int     score;

    Student(String name, boolean isMale, int grade, int classNum, int score){
        this.name     = name;
        this.isMale   = isMale;
        this.grade    = grade;
        this.classNum = classNum;
        this.score    = score;
    }
    String  getName()     { return this.name; }
    boolean isMale()      { return this.isMale; }
    int     getGrade()    { return this.grade; }
    int     getClassNum() { return this.classNum; }
    int     getScore()    { return this.score; }
    public String toString(){
        return String.format("[%s, %s, %d, %d, %3d]", name, isMale?"Male":"Female", grade, classNum, score);
    }
    enum Level{ HIGH, MID, LOW }
}
class StreamEx7 {
    public static void main(String[] args) {
        Stream<Student> stuStream = Stream.of(
                new Student("NaJava"   , true , 1, 1, 300),
                new Student("KimJimi"  , false, 1, 1, 250),
                new Student("KimJava"  , true , 1, 1, 200),
                new Student("LeeJimi"  , false, 1, 2, 150),
                new Student("NamJava"  , true , 1, 2, 100),
                new Student("AnJimi"   , false, 1, 2, 50),
                new Student("HwangJimi", false, 1, 3, 100),
                new Student("GangJimi" , false, 1, 3, 150),
                new Student("Leejava"  , true , 1, 3, 200),

                new Student("NaJava"   , true , 2, 1, 300),
                new Student("KimJimi"  , false, 2, 1, 250),
                new Student("KimJava"  , true , 2, 1, 200),
                new Student("LeeJimi"  , false, 2, 2, 150),
                new Student("NamJava"  , true , 2, 2, 100),
                new Student("AnJimi"   , false, 2, 2, 50),
                new Student("HwangJimi", false, 2, 3, 100),
                new Student("GangJimi" , false, 2, 3, 150),
                new Student("Leejava"  , true , 2, 3, 200));

        System.out.printf("1. Basic grouping with Class\n");
        Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
                                                     .collect(groupingBy(Student::getBan));

        for(List<Student> ban : stuByBan.values()) {
            for(Student s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. Basic grouping with Score\n");
        Map<Student.Level, List<Student>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                         if(s.getScore() >= 200) return Student.Level.HIGH;
                    else if(s.getScore() >= 100) return Student.Level.MID;
                    else                         return Student.Level.LOW;
                }));

        TreeSet<Student.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(Student.Level key : keySet) {
            System.out.println("["+key+"]");

            for(Student s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. Basic grouping + statistics(number of student with score\n");
        Map<Student.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                         if(s.getScore() >= 200) return Student.Level.HIGH;
                    else if(s.getScore() >= 100) return Student.Level.MID;
                    else                         return Student.Level.LOW;
                }, counting()));

        for(Student.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d¸í, ", key, stuCntByLevel.get(key));
        System.out.println();
/*
        for(List<Student> level : stuByLevel.values()) {
            System.out.println();
            for(Student s : level) {
                System.out.println(s);
            }
        }
*/
        System.out.printf("%n4. multiple grouping(with grade, with ClassNum\n");
        Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan =
          Stream.of(stuArr)
                .collect(groupingBy(Student::getHak,
                         groupingBy(Student::getBan)
                ));

        for(Map<Integer, List<Student>> hak : stuByHakAndBan.values()) {
            for(List<Student> ban : hak.values()) {
                System.out.println();
                for(Student s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. multiple grouping + statistics(top of grade and classNum");
        Map<Integer, Map<Integer, Student>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student::getHak,
                         groupingBy(Student::getBan,
                            collectingAndThen(
                                maxBy(comparingInt(Student::getScore)),
                                Optional::get
                            )
                        )
                ));
        for(Map<Integer, Student> ban : topStuByHakAndBan.values())
            for(Student s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. multiple grouping + statistics(group of score with grade and classNum\n");
        Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(stuArr)
            .collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
                    mapping(s-> {
                         if(s.getScore() >= 200) return Student.Level.HIGH;
                    else if(s.getScore() >= 100) return Student.Level.MID;
                         else                    return Student.Level.LOW;
                    } , toSet())
            ));

         Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }
    }
}

```



## Collector 구현하기

- 지금까지 Collectors 클래스가 제공하는 컬렉터를 사용하는 방법에 대해서 배웠으니, 이제 직접 컬렉터를 구현한다.
  - 컬렉터를 작성한다는 것은 Collector 인터페이스를 구현한다는 것을 의미하는데, Collector 인터페이스는 다음과 같이 정의되어 있다.

```java
public interface Collector<T, A, R>{
    Supplier<A> 		 supplier();
    BiConsumer<A, T> 	 accumulator();
    BynaryOperator<A> 	 combiner();
    Function<A, R> 		 finisher();
    Set<Characteristics> characteristics(); // return Set include characteristic of Collector
    // ...
}
```

- 직접 구현해야 하는것은 위의 5개의 메소드인데, chracteristics()를 제외하면 모두 반환 타입이 함수형 인터페이스이다.

  - 즉, 4개의 람다식을 작성하면 된다.

  > supplier()        : 작업 결과를 저장할 공간을 제공
  >
  > accumulator() : 스트림의 요소를 수집(collect)할 방법을 제공
  >
  > combiner()      : 두 저장공간을 병합할 방법을 제공(병렬 스트림)
  >
  > finisher()         : 결과를 최종적으로 변환할 방법을 제공



- supplier()는 수집 결과를 저장할 공간을 제공하기 위한 것이고, accumulator()는 스트림의 요소를 어떻게 supplier()가 제공한 공간에 누적할 것인지를 정의한다.
- combiner()는 병렬 스트림인 경우, 여러 쓰레드에 의해 처리된 결과를 어떻게 합칠 것인가를 정의한다.
- 그리고 finisher()는 작업결과를 변환하는 일을 하는데, 변환이 필요없다면, 항등 함수인 Function.identity()를 반환하면 된다.

```java
public Function finisher(){
    return Function.identity();
}
```



- 마지막으로 characteristics()는 컬렉터가 수행하는 작업의 속성에 대한 정보를 제공하기 위한 것이다.

>Characteristics.CONCURRENT      : 병렬로 처리할 수 있는 작업
>Characteristics.UNORDERED        : 스트림의 요소의 순서가 유지될 필요가 없는 작업
>Characteristics.IDENTITY_FINISH : finisher()가 항등 함수인 작업
>
>Note) 열거형 Characteristics는 Collector 내에 정의되어 있다.

- 위 세 가지 속성 중에서 해당하는 것을 다음과 같이 Set에 담아서 반환하도록 구현하면 된다.

```java
public Set<Characteristics> characteristics(){
    return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNOREDERED));
}
```

- 아무런 속성도 지정하고 싶지 않으면 아래와 같이 하면 된다.

```java
public Set<Characteristics> characteristics(){
    return Collections.emptySet(); // empty Set
}
```



- finisher()를 제외하고, supplier(), accumulator(), combiner()는 모두 앞서 리듀싱에 대해서 배울 때 등장했던 개념들이다.
  - 결국 Collector도 내부적으로 처리하는 과정이 리듀싱과 같다는 것을 의미한다.
  - IntSteam의 count(), sum(), max(), min()등이 reduce()로 구현되어 있다는 것을 기억할 것이다.
  - 그리고 collect()로도 count()등의 메소드와 같은 일을 할 수 있었다.

```java
long count = stuStream.count();
long count = stuStream.collect(Collectors.counting());
```

- 이쯤에서 reduce()와 collect()의 차이에 대해서 궁금할 것인데, 이 둘은 근본적으로 하는 일이 같다.
  - collect()는 앞서 살펴 본 것처럼, 그룹화와 분할, 집계 등에 유용하게 쓰이고, 병렬화에 있어서 reduce()보다 collect()가 더 유리하다.
- 결론적으로 reduce()에 대해서 잘 이해했으면, Collector를 구현하는 일이 그리 어렵지 않을 것이다.

- 만약 String 배열의 모든 문자열을 하나의 문자열로 합치려면?

```java
String[] strArr = {"aaa","bbb","ccc"};
StringBuffer sb = new StringBuffer(); // supplier(), create  space to store
for(Stirng tmp : strArr)
    sb.append(tmp);                   // accumulator(), store element to sb
String result = sb.toString();        // finisher(), convert StringBuffer to String
```



- 예제

```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
class CollectorEx1 {
    public static void main(String[] args) {
        String[] strArr = { "aaa","bbb","ccc" };
        Stream<String> strStream = Stream.of(strArr);

        String result = strStream.collect(new ConcatCollector());

        System.out.println(Arrays.toString(strArr));
        System.out.println("result="+result);
    }
}
class ConcatCollector implements Collector<String, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        System.out.println("Supplier");
        return () -> new StringBuilder();
//      return StringBuilder::new;
    }
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, s) -> sb.append(s);
//      return StringBuilder::append;
    }
    @Override
    public Function<StringBuilder, String> finisher() {
        return sb -> sb.toString();
//      return StringBuilder::toString;
    }
    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb, sb2)-> {
            sb.append(sb2);
            return sb;
        };
    }
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}

```



## 스트림의 변환

- 스트림 간의 변환은 변환하는 방법이 어려운 것이 아니라, 언제 어떤 메소드를 써야하는지 매번 찾아보는 것이 어려웠기 때문에 스트림 간의 변환을 정리한다.

<img src="C:\Users\kyh\Desktop\study\과외\스트림간변환1.PNG" alt="스트림간변환1" style="zoom:80%;" />

<img src="C:\Users\kyh\Desktop\study\과외\스트림간변환2.PNG" alt="스트림간변환2" style="zoom:80%;" />













