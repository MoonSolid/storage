# git

---

※ conflict resolved - 병합시 겹치는부분 수정메시지로 자주 쓰임

※ Github와 연동하려면 git remote로 원격 저장소와 연결해야함

※ gitignore는 커밋되지않을 목록 설정파일

- http://gitignore.io/ ignore설정파일을 생성해주는 사이트
- 사이트에서 입력창에 eclipse 등을 입력후 create를 하면 
  해당 ignore 파일을 만들어준다

※ fast - forward 

- 사용하려면 합치려는 쪽과 합쳐지는 쪽의 commit 조상이 같아야 한다.

---

## 명령어

#### git init

- 깃 저장소로 초기화

#### rm -r .git

- init을 취소한다

#### ls -all   

- 숨김파일도 전부 보여줌

#### git config (최초 1회 실행)

#### git config --global user.name "your_name"  

- git commit에 사용될 username

#### git config --global user.email "your_email@example.com"

- git commit에 사용될 email

#### git config --list

- 설정한 내용을 확인할 수 있다.

```java
user.email=rnreo20@gmail.com //이메일
user.name=MoonSolid  //아이디
core.autocrlf=true //true인경우 깃에서 개행문자를 알아서 처리해줌
```

#### git add 

- 파일을 준비영역(Staging Area)로 옮긴다. 
- . 옵션은 워킹 디렉토리 내 모든 파일을 추가

#### git rm -r --cached .

- 진행중인 파일일 경우 , Staging Area에서 워킹 디렉터리로 옮겨온다.

#### git commit

- 준비영역(Staging Area)의 파일을 로컬저장소에 저장

#### git commit --amend

- 가장 최신의 commit의 내용을 변경할수있다
 - 가장 최신의 commit 밖에 변경이 안되고 push 했을경우는 사용하지 못한다.

#### git status

- 로컬저장소의 현재 상태를 보여준다.

#### git log

- git의 history 출력 
- q로 나갈 수 있다.

#### git log --graph

- 어느시점에 브런치 따져서 어느시점에 합쳐졌는지 보여줌

#### git branch 

- 현재 브런치 확인

#### git branch -a

- 현재 브런치 상세 확인

#### git branch -d branch명

- 브런치 지우기

#### git branch hotfix

- hotfix 브런치를 생성한다
- 버그잡는용도로 주로 쓰이는 브런치다.
- -b 옵션을 넣으면 브런치생성과 동시에 해당 브런치로 이동 ex) git branch -b hotfix
- 브런치를 따면 현재 위치한 브런치를 복사한다.
-  마스터브런치를 수정하려면 마스터브런치에서 브런치를 따면된다

#### git checkout

- 해당 checksum 혹은 브런치 로 이동한다.

#### git checkout master

- 마스터 브런치로 이동한다.

#### git merge hotfix

- 현재 브런치에 hotfix 브런치를 병합한다.

#### git remote

- 현재 저장소가 어느 저장소와 연결되어있는지 보여준다

#### git remote -v

- 현재 저장소가 어느 저장소와 연결되어있는지 자세하게 보여준다

#### git remote remove 별칭 

- 연결된 저장소를 지운다

#### git remote add origin URL (origin 은 원격통로별칭)

- origin 이라는 통로를 현재 저장소에 연결한다

####  git remote add upstream URL (upstream은 원격통로별칭)

 - 포크해온 저장소를 원격저장소와 연결

#### git push origin master

- origin에 master를 push (내 원격저장소에 push하는것)

#### git log --pretty=oneline

- 로그를 보기좋게 보여줌

#### git log --decorate "태그명" 

- 특정태그를 로그에서 확인가능

#### git tag -l

- 현재 저장소에 있는 태그 리스트

#### git show-ref --tags    

- 태그와 commit checksum 값을 같이 확인

#### git log -2 

-   로그를 최신순으로 2개만 보여준다

#### git tag 0.9 48eb7

- checksum값인 48eb7의 commit에  "0.9" 태그를붙인다 (특정commit에  태그붙임)

#### git reset --hard 48eb7

- checksum값인 48eb7의 commit까지 commit 을 되돌린다

#### git reset --hard ORIG_HEAD

- (git reset 명령을 실행했을 때 지운 commit 내역보관)

#### git revert 48eb7

- 해당checksum값의 commit을 되돌린상태의 commit을 새로만든다 
- 기존의 48eb7 commit은 그대로 존재하고 commit 전의 새로운 commit 을 만드는 것이다.

#### git fetch 

- 원격저장소에서 패치를 받아온다
- remote 가 여러개라면 fetch 뒤에 저장소이름을 붙여줘야한다
- ex)git fetch origin 혹은 git fetch upstream

#### git merge origin/master

- 원격저장소의 패치를 로컬저장소에 병합한다

git push origin master

- 원격저장소에 master브런치의 작업내용을 올린다

---

## 커밋메세지

[category] - [message]

branch 이름 작성규칙

숫자로만된 이름 , 설명조인 이름 사용 지양

ex) 

  1 [add] add a README.md
  2   - initialize project repository
  3   - add a README.md

 : 하고 wq 로 저장 하면 커밋됨 

---

## 협업하기

#### 1.마스터브런치 저장소 fork 해오기

#### 2.fork해온 저장소를 clone 하기 

- fork해온 내 저장소를 clone해야한다.

#### 3.저장소 연결하기

- git remote add origin URL
- git remote add upstream URL
-  remote가 여러개이므로  fetch 를 받을때 받아올 별칭을 입력해야한다
- ex) git fetch origin 혹은 git fetch upstream

#### 4.Upstream에서 패치받기

- git fetch upstream 

#### 5.Upstream에서 받은 패치를 master에 병합하기

- git merge upstream/master

#### 6.작업후 origin에 작업물 올리기

- git push origin master 

#### 7.origin에 올라간 작업물을 pull request 보내기

※ base가 관리자   compare가 작업자

※ 충돌 발생시 수정후 다시 add ,  commit

협업시 브런치따는것외에 checkout할 필요??

---

## 버전 관리하기

커밋을 버전으로 관리하기

#### 1.commit을 한다.

#### 2.push전 tag명을 정한다.

#### 3.push한다

- 이렇게되면 서버에서 버전별로 파일목록이나 소스등을 확인할수있다.

- 고객에 납품할때마다 보통 releases버전을 제공하는데 태그등록후 push하게되면

  이 버전이 releases버전이 된다.

  태그 명령어  -       git tag -a "버전명 -m "메세지" 

  태그 push하기 -    git push origin "버전명"


#### 4.태그 지우기

- 원격서버에서 태그 지우기  git push origin :"태그명"          

- 로컬에서 태그 지우기 git tag -d "태그명"

#### 5.태그 수정하기

- git tag new old

  git tag -d old

  git push origin :refs/tags/old

  git push --tags

---

watch 누르면 원격저장소의 활동 내역을 사용자에게 알려줌

base에 관리자   compare가 작업

GitHub의 협업 도구

- 이슈 트래커
- 위키
- 풀 리퀘스트
- git hub에서의 코드 리뷰

프로젝트를 위한 협업 준비 규칙

- 커밋 단위
- 커밋 메시지 작성 규칙
- 브렌치 이름 작성 규칙
- 태그와 버전 이름 작성 규칙

프로젝트 유형별 협업 흐름

- git - flow : 게임이나 SI 개발 환경에 권장
- github-flow- 웹어플리케이션
- gitlab-flow 게임

이슈 트래커는 말하자면 게시판이나

- 버그 보고, 기능 개선 건의 그 외 프로젝트에 관련된 주제를 등록할 수 있는 공간

  

일반 적인 게시판과의 차이

- 담당장 : issue 담당자 지정 가능
- 알림: @ <name> 형식으로 특정 그룹이나 특정 사용자에게 알림
- 라벨: 카테고리 역할의 라벨 지정가능
- 커밋 ㅍ레퍼런스: 커밋해시를 써두면 자동으로 해당 커밋에 링크
- 마일스톤 : 이슈들을 그룹으로 만드는 표식을 지정

이슈 트래커

- new issue
- title : first issue

마일스톤

- 한 이슈에는 하나의 마일스톤만 할당할 수 있다.
- 같은 마일스톤을 지정한 이슈가 해결될 때마다 막대의 진행률이 올라간다

위키 


풀 리퀘스트

- 

fork > 본인계정 > local로 clone  

여기서 원래 내 저장소와 동기화 - git fetch upstream   ,   git merge upstream/master 

git push origin master

수정

여기서

git push origin 하면 - 로컬에 반영

base fort: 병합의 기반

head 내 저장소

커밋 메시지 작성 규칙

category - simple message

detailded message





왜 커밋을 했는가

버그 수정의 경우 원래 어떤 문제가 있었는지

사용중인 이슈 트래커가 있다면 해당 이슈의 하이퍼링크를 포함해야 한다.



위의 규칙들을 염두에 두면서 커밋을 작성하면, 작성된ㅇ 커밋만 복소도

많은 정보를 얻을 수 있다.

새로 협엽에 참여하는 사람이 이전의 커밋 로그만을 보고도 전체적인 프로젝트를 잘 이해할 수 있다



커밋 메시지와 마찬가지로 몇 가지 카테고리를 만들어서 분류하는 것이 좋다

new 새 기능 추가가 목적인 브랜치

test 무언가를 테스트하는 브랜치 (새 라이브러리, 배포 환경, 실험 등) 

bug 버그 수정이 목적인 브렌치

