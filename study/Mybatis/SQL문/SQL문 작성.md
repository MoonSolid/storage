### DDL

데이터베이스 생성

```
create database 데이터베이스명 옵션들...;
```

데이터베이스 삭제

```
drop database 데이터베이스명;
```

데이터베이스 변경

```
alter database 데이터베이스명 옵션들...;
```

테이블 생성

```
create table 테이블명 (
  컬럼명 타입 NULL여부 옵션,
  컬럼명 타입 NULL여부 옵션,
  ...
  컬럼명 타입 NULL여부 옵션
  );
```

테이블 정보 보기

```
describe 테이블명;
desc 테이블명;
```

테이블 삭제하기

```
drop table 테이블명;
```

데이터 입력

```
insert into test1(no, name) values(1, 'aaa');
```

테이블 데이터 기본값 지정

```
name varchar(20) default 'noname'
```

#### 컬럼타입

```
int
- 4바이트 크기의 정수 값 저장
- 기타 tinyint(1), smallint(2), mediumint(3), bigint(8)

float
- 부동소수점 저장

numeric = decimal
- 전체 자릿수와 소수점 이하의 자릿수를 정밀하게 지정할 수 있다.
- numeric(n,e) : 전체 n 자릿수 중에서 소수점은 e 자릿수다.

char(n)
- 최대 n개의 문자를 저장.
- 0 <= n <= 255 
- 고정 크기를 갖는다. 
- 한 문자를 저장하더라도 n자를 저장할 크기를 사용한다.
- 메모리 크기가 고정되어서 검색할 때 빠르다.  

varchar(n)
- 최대 n개의 문자를 저장.
- 0 ~ 65535 바이트 크기를 갖는다.
- n 값은 문자집합에 따라 최대 값이 다르다.
- 만약 UTF-8로 지정된 경우 n은 최대 21845까지 지정할 수 있다.
- 가변 크기를 갖는다.
- 한 문자를 저장하면 한 문자 만큼 크기의 메모리를 차지한다.
- 메모리 크기가 가변적이라서 데이터 위치를 찾을 때 시간이 오래 걸린다.
  그래서 검색할 때 위치를 계산해야 하기 때문에 검색 시 느리다.

고정 크기와 가변 크기 비교:
- insert into test1(c1) values('abc');
  insert into test1(c2) values('abc');
  select * from test1 where c1='abc'; 
  DBMS 중에는 고정 크기인 컬럼의 값을 비교할 때 빈자리까지 검사하는 경우도 있다.
  즉 c1='abc'에서는 데이터를 찾지 못하고, c1='abc  '여야만 데이터를 찾는 경우가 있다.
  그러나 mysql은 고정크기 컬럼이더라도 빈자리를 무시하고 데이터를 찾는다.

date
- 날짜 정보를 저장할 때 사용한다.
- 년,월,일 정보를 저장한다.
- 오라클의 경우 날짜 뿐만 아니라 시간 정보도 저장한다.

time
- 시간 정보를 저장할 때 사용한다.
- 시, 분, 초 정보를 저장한다.

datetime
- 날짜와 시간 정보를 함께 저장할 때 사용한다.

불린 타입
- 보통 true, false를 의미하는 값을 저장할 때는 정수 1 또는 0으로 표현한다.
- 또는 문자로 Y 또는 N으로 표현하기도 한다.
```

#### key

```
primary key

- 테이블의 데이터를 구분할 때 사용하는 컬럼들이다.
- 줄여서 PK라고 표시한다.
- PK 컬럼을 지정하지 않으면 데이터가 중복될 수 있다.

 unique key = alternate key(대안키)

- PK는 아니지만 PK처럼 중복을 허락하지 않는 컬럼을 지정할 때 사용한다.
- 그래서 PK를 대신해서 사용할 수 있는 key라고 해서 "대안키(alternate key)"라고 부른다.
유니크키 지정
- constraint test1_uk unique (name, age) (테이블 생성시)
```

### index

```
- 검색 조건으로 사용되는 컬럼은 정렬되어야만 데이터를 빨리 찾을 수 있다.
- 특정 컬럼의 값을 A-Z 또는 Z-A로 정렬시키는 문법이 인덱스이다.
- DBMS는 해당 컬럼의 값으로 정렬한 데이터 정보를 별도로 생성한다.
- 보통 책 맨 뒤에 붙어있는 색인표와 같다.  
- 인덱스로 지정된 컬럼의 값이 추가/변경/삭제 될 때 인덱스 정보도 갱신한다.
- 따라서 입력/변경/삭제가 자주 발생하는 테이블에 대해 인덱스 컬럼을 지정하면,
  입력/변경/삭제 시 인덱스 정보를 갱신해야 하기 때문에 입력/변경/삭제 속도가 느리다.
- 대신 조회 속도는 빠르다.
```

인덱스 생성

```
 fulltext index test1_name_idx (name)  (테이블생성시)
```

인덱스 컬럼의 활용

```
검색할 때 사용한다.
select * from test1 where name = 'bbb';
- test1 테이블의 name 컬럼중 'bbb'라는 이름을 가진 컬럼데이터 조회
```

테이블에 컬럼 추가

```
alter table test1
  add column no int;
```

컬럼 값 자동 증가
- 숫자 타입의 PK 컬럼인 경우 값을 1씩 자동 증가시킬 수 있다.
- 즉 데이터를 입력할 때 해당 컬럼의 값을 넣지 않아도 자동으로 증가된다.
- 단 삭제를 통해 중간에 비어있는 번호는 다시 채우지 않는다.
  즉 증가된 번호는 계속 앞으로 증가할 뿐이다.

```
특정 컬럼의 값을 자동으로 증가하게 선언
alter table test1
  modify column no int not null auto_increment;
```

### 뷰(view)

- 조회 결과를 테이블처럼 사용하는 문법
- select 문장이 복잡할 때 뷰로 정의해 놓고 사용하면 편리하다.

#### 뷰 생성

```
1) 테이블 생성
create table test1 (
  no int primary key auto_increment,
  name varchar(20) not null,
  class varchar(10) not null,
  working char(1) not null,
  tel varchar(20)
);
```

```
2) 직장인만 조회한 결과를 가상 테이블로 만들기
	create view worker
  	as select no, name, class from test1 where working = 'Y';
```

```
3) 참조 테이블 값 입력
insert into test1(name,class,working) values('ppp','java101','Y');

4) 직장인을 조회하는 테이블을 
select * from worker;
```



```



-
  	
  	insert into test1(name,class,working) values('ppp','java101','Y');
select * from worker;
  	
  	
 
```

