Mariadb  문자 깨질경우 

1 .mariadb 접속후  $ show variables like 'c%'; 로 캐릭터셋 확인

2.UTF-8 이 아닐경우 MariaDB 설치폴더 -> data 폴더에서 my.ini 파일 확인

3.캐릭터셋이 UTF-8이 아니라면 UTF-8 항목 추가

```java
[mysqld]
datadir=C:/Program Files/MariaDB 10.4/data
port=3306
innodb_buffer_pool_size=2033M
init_connect="SET collation_connection = utf8_general_ci" //이거
init_connect="SET NAMES utf8"  //이거 
character-set-server = utf8
collation-server = utf8_general_ci //이거

```

4.서비스앱에서 MariaDB 재실행후 다시 mariadb 접속해서   $ show variables like 'c%'; 로 캐릭터셋 확인

