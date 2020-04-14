도메인

Number

password



Major 완료

```
Major 완료  -  pf_major 전공 
- major_no int 
- name varchar(255) 

EmploymentStatus 완료 - pf_	employment_status 고용형태
- employment_stat_no int PK
- employment_stat_name varchar(40)

CompanyRequiredMajor 완료 - pf_company_required_major 기업요구전공
FK (pf_major , pf_job_posting)
- major_no   int  PK
- job_posting_no  int PK

CompanyRequiredCertificate 완료 - pf_company_required_certificate 기업요구자격증
FK (pf_certificate)
- certificate_no int PK
- job_posting_no int PK

GeneralMemEdu 완료 - pf_general_mem_edu 일반회원학력
FK (pf_final_education)
- general_member_no int(11) PK
- education_no  int(11) PK
- school_name varchar(40) 

JobRecommendation  완료 - pf_job_recommendation 채용추천
FK (pf_job_posting)
- general_member_no  int(11)  PK
- job_posting_no  int(11) PK

GeneralMemEduMajor 완료 - pf_general_mem_edu_major 일반회원학력전공
FK (pf_general_mem_edu)
- general_member_no  int(11)  PK
- education_no int (11)  PK
- major_no int(11) Pk

JobPostingFile  완료 - pf_job_posting_file 채용공고첨부파일
FK (pf_job_posting)
- job_posting_file_no int pk
- job_posting_no int  mul
- file_path varchar(255)

JobPosting 완료 - pf_job_posting 채용공고
 FK (pf_company_member)
- job_posting_no  int PK
- company_member_no  int MUL
- title varchar(255)  
- content text 
- work_place_no   int(11)
- minimum_career int(11) 
- view_count int (11)
- posting_registration   
- start_dated datetime
- end_dated datetime
- job text
- thumbnail  varchar(255)
- year_salary int(11)
- readable int(11)
- minimum_education_no int(11)
- employment_stat_no int(11)
```

