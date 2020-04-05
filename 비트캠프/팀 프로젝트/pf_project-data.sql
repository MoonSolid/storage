

 
  
-- pf_major 전공 데이터
insert into pf_major(major_no, name)
  values(1,'손영국');
insert into pf_major(major_no, name)
  values(2,'김용휘');
insert into pf_major(major_no, name)
  values(3,'전은혜');
insert into pf_major(major_no, name)
  values(4,'송율리아');
insert into pf_major(major_no, name)
  values(5,'문국대');
  
  
-- pf_company_required_major 기업요구전공 데이터(pf_major , pf_job_posting 인서트 후) 
insert into pf_company_required_major(major_no, job_posting_no)
  values(1,1);
insert into pf_company_required_major(major_no, job_posting_no)
  values(2,2);
insert into pf_company_required_major(major_no, job_posting_no)
  values(3,3);
insert into pf_company_required_major(major_no, job_posting_no)
  values(4,4);
insert into pf_company_required_major(major_no, job_posting_no)
  values(5,5); 
  

-- pf_general_mem_edu 일반회원학력 데이터(pf_final_education 인서트 후)
insert into pf_general_mem_edu(general_member_no,education_no,school_name)
  values(1,1,'서울대학교');
insert into pf_general_mem_edu(general_member_no,education_no,school_name)
  values(1,1,'고려대학교');
insert into pf_general_mem_edu(general_member_no,education_no,school_name)
  values(1,1,'연세대학교');
insert into pf_general_mem_edu(general_member_no,education_no,school_name)
  values(1,1,'세종대학교');
insert into pf_general_mem_edu(general_member_no,education_no,school_name)
  values(1,1,'한양대학교');

  
-- pf_job_posting_file 채용공고첨부파일 데이터(pf_job_posting 인서트 후)
insert into pf_job_posting_file(job_posting_file_no,job_posting_no,file_path)
  values(1,1,'/file/path'); 
insert into pf_job_posting_file(job_posting_file_no,job_posting_no,file_path)
  values(2,2,'/file/path'); 
insert into pf_job_posting_file(job_posting_file_no,job_posting_no,file_path)
  values(3,3,'/file/path'); 
insert into pf_job_posting_file(job_posting_file_no,job_posting_no,file_path)
  values(4,4,'/file/path'); 
insert into pf_job_posting_file(job_posting_file_no,job_posting_no,file_path)
  values(5,5,'/file/path');
  

-- pf_employment_status 고용형태
insert into pf_employment_status(employment_stat_no,employment_stat_name)
  values(1,'정규직');
insert into pf_employment_status(employment_stat_no,employment_stat_name)
  values(2,'계약직');
insert into pf_employment_status(employment_stat_no,employment_stat_name)
  values(3,'인턴');
insert into pf_employment_status(employment_stat_no,employment_stat_name)
  values(4,'경력직');
insert into pf_employment_status(employment_stat_no,employment_stat_name)
  values(5,'파견직');
  
-- pf_general_mem_edu_major 일반회원학력전공(pf_general_mem_edu 인서트 후)
insert into pf_general_mem_edu_major (general_member_no,education_no,major_no)
  values(1,1,1);
insert into pf_general_mem_edu_major (general_member_no,education_no,major_no)
  values(2,2,2);
insert into pf_general_mem_edu_major (general_member_no,education_no,major_no)
  values(3,3,3);
insert into pf_general_mem_edu_major (general_member_no,education_no,major_no)
  values(4,4,4);
insert into pf_general_mem_edu_major (general_member_no,education_no,major_no)
  values(5,5,5);
 
-- pf_job_recommendation 채용추천 (pf_job_posting 인서트 후)
insert into pf_job_recommendation (general_member_no,job_posting_no)
  values(1,1);
insert into pf_job_recommendation (general_member_no,job_posting_no)
  values(2,2);
insert into pf_job_recommendation (general_member_no,job_posting_no)
  values(3,3);
insert into pf_job_recommendation (general_member_no,job_posting_no)
  values(4,4);
insert into pf_job_recommendation (general_member_no,job_posting_no)
  values(5,5);

-- pf_company_required_certificate 기업요구자격증 (pf_certificate 인서트 후)
insert into pf_company_required_certificate  (certificate_no,job_posting_no)
  values(1,1);
insert into pf_company_required_certificate  (certificate_no,job_posting_no)
  values(2,2);
insert into pf_company_required_certificate  (certificate_no,job_posting_no)
  values(3,3);
insert into pf_company_required_certificate  (certificate_no,job_posting_no)
  values(4,4);
insert into pf_company_required_certificate  (certificate_no,job_posting_no)
  values(5,5);  
 
   
-- pf_job_posting 채용공고 (pf_company_member 인서트 후)
insert into pf_job_posting (job_posting_no,company_member_no,title,content,work_place_no,
minimum_education,view_count,posting_registration,start_dated,end_dated,job,thumbnail,
year_salary,readable,minimum_education_no,employment_stat_no)
  values(1,1,'제목1','내용1',1,1,1,'2020-1-1','2020-1-1','2020-2-2','프론트엔드','www.google.com',
  26000000,1,1,1);  
insert into pf_job_posting (job_posting_no,company_member_no,title,content,work_place_no,
minimum_education,view_count,posting_registration,start_dated,end_dated,job,thumbnail,
year_salary,readable,minimum_education_no,employment_stat_no)
  values(2,2,'제목2','내용2',2,2,2,'2020-2-2','2020-2-2','2020-3-3','백엔드','www.google.com',
  28000000,2,2,2);  
insert into pf_job_posting (job_posting_no,company_member_no,title,content,work_place_no,
minimum_education,view_count,posting_registration,start_dated,end_dated,job,thumbnail,
year_salary,readable,minimum_education_no,employment_stat_no)
  values(3,3,'제목3','내용3',3,3,3,'2020-3-3','2020-3-3','2020-4-4','프론트엔드','www.google.com',
  30000000,3,3,3);  
insert into pf_job_posting (job_posting_no,company_member_no,title,content,work_place_no,
minimum_education,view_count,posting_registration,start_dated,end_dated,job,thumbnail,
year_salary,readable,minimum_education_no,employment_stat_no)
  values(4,4,'제목4','내용4',4,4,4,'2020-4-4','2020-4-4','2020-5-5','백엔드','www.google.com',
  32000000,4,4,4);  
insert into pf_job_posting (job_posting_no,company_member_no,title,content,work_place_no,
minimum_education,view_count,posting_registration,start_dated,end_dated,job,thumbnail,
year_salary,readable,minimum_education_no,employment_stat_no)
  values(5,5,'제목5','내용5',5,5,5,'2020-5-5','2020-5-5','2020-6-6','프론트엔드','www.google.com',
  34000000,5,5,5);  
  