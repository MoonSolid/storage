### 프로젝트를 이클립스IDE용 프로젝트로 전환

---

build.gradle 파일변경

- build gradle 파일에 eclipse 플러그인추가

  ```
  plugins {
      id 'java'
      id 'application'
      id 'eclipse'
  }
  ```

  

이클립스 IDE에서 사용할 프로젝트 설정 파일 생성ㄴ

- gradle eclipse

이클립스 워크스페이스로 프로젝트 가져오기

이클립스로 프로젝트 import하기 

- 이클립스에서 import후 Existing Projects into Workspace > 브라우저에서 프로젝트파일선택