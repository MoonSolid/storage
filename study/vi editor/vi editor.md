vi 에디터 설정하기

```java
~/.vimrc
```

설정하기

```java
리눅스에서 사용하는 메모장 사용법
esc : 명령모드
i : 입력모드

명령모드 상태에서 : 입력하시면 명령행 모드

잘 안되면 esc부터 하고 입력

---------------------------------
입력모드에서 설정
set nu
set ts=2
set sw=2
set sts=2
set smartindent
set cindent

syntax on
filetype indent plugin on

전부 입력후  esc누름 ->  :누름  -> 명령모드
:에서 w는 저장 q는 나가기
:wq 는 저장하고 나가기
---------------------------------	
```

- esc 누르고 커서옮긴후 dd누르면 해당 라인 삭제
- esc 누르고 커서옮긴후 uu누르면 작업 되돌리기