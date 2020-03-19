- ### cp5.원격 저장소와 git

- git clone 로컬 저장소 내용 복사

- git remote 로컬 저장소와 원격 저장소를 연결하기

- git push 로컬 작업 내역을 원격 저장소에 올리기

- git fetch , git pull 원격 저장소와 로컬 저장소의 간격 메꾸기(최신화)

- fetch : 로컬 저장소와 원격 저장소의 변경 사항이 다를 때 이를 비교 대조하고

 git merge 명령어와 함께 최신 데이터를 반영하거나 충돌 문제 등을 해결한다.

- pull : git remote명령을 통해 서로 연결된 원격 저장소의 최신 내용을 로컬 저장소로 가져오면서 병합한다(push와 반대)

---

fork 하고 clone해오는게 안전함

빈 원격 저장소 생성> 책임자가 기본 프로젝트 구저 생성 > 협업자들 모두가 빈 원격 저장소를 clone하여 작업 진행

 

git tag: 특정 commit을 참조하는 이름 붙이기

git commit --amend : git commit 메세지 수정하기

git revert: 공개된 commit의 변경 내역을 되돌리기

git reset:이전 작업 결과를 저장한 상태로 되돌리기

git checkout HEAD -filename:특정 파일을 최종 commit 시점으로 되돌리기

git rebase : branch 이력을 확인하면서 병합하기

