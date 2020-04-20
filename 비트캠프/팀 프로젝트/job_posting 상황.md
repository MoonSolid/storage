list - 테스트 완료 

detail - 테스트 완료

update - 테스트 완료

delete - job_posting 이 apply를 참조하고 있어서 삭제가 안됨

- 해결방법 Mapper에서 job_posting 삭제시 apply를 먼저 삭제하도록 로직 변경??

add 

TypeMissMatch 

- 해결완료 - GlobalControllerAdvice 로 타입을 변환해줌

기업회원을 참조하고있기때문에 job_posting을 add하려면 기업회원이 증가해야한다.

- 기업회원데이터값 추가후 다시 테스트해보기

1) footer 와 header 출력문제

---

고용형태

- job_posting 에서 add를 하면  employment_status의 값이 증가

- job_posting에서 list를 할경우 고용형태의 