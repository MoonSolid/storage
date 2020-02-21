#### mariadb 사용법

---

 mariadb 설치 및 실행 

- ### windows 

설치

```java
* windows
scoop 패키지 관리자를 이용하여 mariadb 설치
$ scoop install mariadb 
---------------------------
* mac
$ brew install mariadb
---------------------------
* linux
$ sudo apt update
$ sudo apt install mariadb-server
$ sudo systemctl status mariadb
$ mysql -V
   
```

실행

```java
서비스 앱에서 실행    
```

로컬 MySQL 서버에 접속

```java
mysql -u root -p
Enter password: 암호입력
```







### 데이터베이스 생성

```mariadb

```





---

#### 테이블 생성 및 삭제

```mariadb
-- 수업 테이블 생성
create table lms_lesson (
  lesson_id int not null auto_increment primary key comment '수업 데이터 식별 번호', 
  sdt datetime not null comment '수업 시작일',
  edt datetime not null comment '수업 종료일',
  tot_hr int not null comment '총 수업 시간',
  day_hr int not null comment '일 수업 시간',
  titl varchar(255) not null comment '수업명',
  conts text not null comment '수업 내용'
) comment '수업'; 

-- 회원 테이블 생성
create table lms_member (
  member_id int not null auto_increment primary key comment '회원 데이터 식별 번호',
  name varchar(30) not null comment '이름',
  email varchar(50) not null comment '이메일',
  pwd varchar(255) not null comment '암호',
  cdt datetime default now() comment '등록일', 
  tel varchar(20) comment '전화',
  photo varchar(255) comment '사진'
) comment '회원';

create unique index UIX_lms_member_email
  on lms_member ( -- 회원
    email asc    -- 이메일
  );
  
-- 게시물 테이블 생성
create table lms_board (
  board_id int not null auto_increment primary key comment '게시물 식별 번호',
  conts text not null comment '내용',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수' 
) comment '게시물';

-- 사진 게시물 테이블 생성
create table lms_photo (
  photo_id int not null auto_increment primary key comment '사진 게시물 식별 번호',
  lesson_id int not null comment '수업 번호',
  titl varchar(255) not null comment '제목',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수',
  -- lesson_id에 저장되는 값은 lms_lesson 테이블의 lesson_id 값으로 제한하는 조건을 추가한다.
  constraint fk_photo_to_lesson foreign key (lesson_id)
    references lms_lesson (lesson_id)
) comment '사진게시물';

-- 사진 게시물에 첨부하는 사진 파일 테이블 생성
create table lms_photo_file (
  photo_file_id int not null auto_increment primary key comment '사진 파일 식별 번호',
  photo_id int not null,
  file_path varchar(255) not null,
  constraint fk_photo_file_to_photo foreign key (photo_id)
    references lms_photo (photo_id)
) comment '사진 게시물 첨부파일 테이블'; 

```

```mariadb

-- 수업 테이블 삭제 
drop table if exists lms_lesson;

-- 회원 테이블 삭제
drop table if exists lms_member;

-- 게시판 테이블 삭제 
drop table if exists lms_board;


-- 사진 게시판 테이블 삭제
drop table if exists lms_photo;

-- 사진 게시물 첨부 파일 테이블 삭제
drop table if exists lms_photo_file;
```

---

### 테이블에  데이터 삽입

```mariadb
-- 수업 예제 데이터 
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
  values(101, '자바 프로그래밍', '자바 프로그래밍 배우기', '2019-1-1', '2019-2-28', 200, 6);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
  values(102, 'C/C++ 프로그래밍', '프로그래밍 배우기', '2019-2-1', '2019-3-28', 200, 6);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
  values(103, '파이썬 프로그래밍', '프로그래밍 배우기', '2019-3-1', '2019-4-28', 300, 7);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
  values(104, '웹 프로그래밍', '프로그래밍 배우기', '2019-1-4', '2019-5-28', 300, 7);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
  values(105, 'IoT 프로그래밍', '프로그래밍 배우기', '2019-5-1', '2019-6-28', 400, 8);

-- 회원 예제 데이터
insert into lms_member(member_id, name, email, pwd) 
  values(11, 'user1', 'user1@test.com', password('1111'));
insert into lms_member(member_id, name, email, pwd) 
  values(12, 'user2', 'user2@test.com', password('1111'));
insert into lms_member(member_id, name, email, pwd) 
  values(13, 'user3', 'user3@test.com', password('1111'));

-- 게시물 예제 데이터
insert into lms_board(board_id, conts) values(1, '내용1');
insert into lms_board(board_id, conts) values(2, '내용2');
insert into lms_board(board_id, conts) values(3, '내용3');
insert into lms_board(board_id, conts) values(4, '내용4');
insert into lms_board(board_id, conts) values(5, '내용5');

-- 수업 사진 게시물 예제 데이터
insert into lms_photo(photo_id, lesson_id, titl) 
  values(1, 101, '자바 컴파일러 구동 원리');
insert into lms_photo(photo_id, lesson_id, titl) 
  values(2, 101, '자바 클래스 실행하는 방법');
insert into lms_photo(photo_id, lesson_id, titl) 
  values(3, 101, '옵저버 패턴 클래스 다이어그램');
insert into lms_photo(photo_id, lesson_id, titl) 
  values(4, 104, 'HTML/CSS/JavaScript 관계');
insert into lms_photo(photo_id, lesson_id, titl) 
  values(5, 104, '자바 스크립트 구동 원리');

-- 수업 사진 게시물 첨부 파일 예제 데이터
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(1, 1, 'a1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(2, 1, 'a2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(3, 1, 'a3.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(4, 2, 'b1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(5, 3, 'c1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(6, 3, 'c2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(7, 4, 'd1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(8, 5, 'e1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(9, 5, 'e2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(10, 5, 'e3.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
  values(11, 5, 'e4.gif');

```



```mariadb


-- 게시판 테이블 삭제
drop table if exists x_board restrict;

-- 게시물 첨부파일 테이블 삭제
drop table if exists x_board_file restrict;


-- 게시판 테이블 생성
create table x_board (
  board_id int not null primary key auto_increment,
  title varchar(255) not null,
  contents text null,
  created_date datetime null default now(),
  view_count int null default 0
);

-- 게시물 첨부파일 테이블 생성
create table x_board_file (
  board_file_id int not null primary key auto_increment,
  file_path varchar(255) not null,
  board_id int not null,
  constraint fk_board_file foreign key (board_id) references x_board(board_id)
);

-- 게시물 데이터 입력 
insert into x_board(board_id, title, contents)
values(1, '제목1', '내용');

insert into x_board(board_id, title, contents)
values(2, '제목2', '내용');

insert into x_board(board_id, title, contents)
values(3, '제목3', '내용');

insert into x_board(board_id, title, contents)
values(4, '제목4', '내용');

insert into x_board(board_id, title, contents)
values(5, '제목5', '내용');

insert into x_board(board_id, title, contents)
values(6, '제목6', '내용');

-- 게시물 첨부파일 데이터 입력
insert into x_board_file(board_file_id, file_path, board_id) 
values(101, 'a1.gif', 1);
insert into x_board_file(board_file_id, file_path, board_id) 
values(102, 'a2.gif', 1);
insert into x_board_file(board_file_id, file_path, board_id) 
values(103, 'a3.gif', 1);

insert into x_board_file(board_file_id, file_path, board_id) 
values(104, 'b1.gif', 2);
insert into x_board_file(board_file_id, file_path, board_id) 
values(105, 'b2.gif', 2);


insert into x_board_file(board_file_id, file_path, board_id) 
values(106, 'c1.gif', 3);
insert into x_board_file(board_file_id, file_path, board_id) 
values(107, 'c2.gif', 3);
insert into x_board_file(board_file_id, file_path, board_id) 
values(108, 'c3.gif', 3);

insert into x_board_file(board_file_id, file_path, board_id) 
values(109, 'd1.gif', 4);

insert into x_board_file(board_file_id, file_path, board_id) 
values(110, 'e1.gif', 5);

-- 데이터 조회 
select
  board_id,
  title,
  created_date
from 
  x_board
order by board_id desc;

select
  board_id,
  title,
  contents,
  created_date,
  view_count
from 
  x_board
where 
  board_id = 3;

-- 데이터 변경
update x_board set
  view_count = view_count + 1,
  created_date = now()
where
  board_id = 3;

-- 데이터 삭제
delete from x_board
where
  board_id = 3;

-- 게시물 데이터와 첨부파일 데이터를 함께 조회하기
select
  b.board_id,
  b.title,
  b.contents,
  b.created_date,
  b.view_count,
  f.board_file_id,
  f.file_path
from x_board b
  left outer join x_board_file f on b.board_id = f.board_id
where
  b.board_id = 1;
```



