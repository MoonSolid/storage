### 1)도메인 생성

```java
---------------------JobPosting------------------------
  private int jobPostingNumber;
  private int companyMemberNumber;
  private String title;
  private String content;
  private int workPlaceNumber;
  private int minimumCareer;
  private int viewCount;
  private Date postingRegistration;
  private Date startDated;
  private Date endDated;
  private String job;
  private String thumnail;
  private int yearSalary;
  private int readable;
  private int minimumEducationNumber;
  private int employmentStatNumber;
  List<JobPostingFile> files;
---------------------JobPostingFile-------------------
  private int jobPostingFileNumber;
  private int jobPostingNumber;
  private String filePath;

  public JobPostingFile() {}

  public JobPostingFile(String filePath, int jobPostingNumber) {
    this.filePath = filePath;
    this.jobPostingNumber = jobPostingNumber;
  }

  public JobPostingFile(int jobPostingFileNumber, String filePath, int jobPostingNumber) {
    this(filePath, jobPostingNumber);
    this.jobPostingFileNumber = jobPostingFileNumber;
  }    
```

---

### 2)DB 테이블 생성

```sql
-- 채용공고
CREATE TABLE pf_job_posting (
  job_posting_no       INTEGER      NOT NULL COMMENT '채용공고번호', -- 채용공고번호
  company_member_no    INTEGER      NOT NULL COMMENT '기업회원번호', -- 기업회원번호
  title                VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  content              TEXT         NOT NULL COMMENT '내용', -- 내용
  work_place_no        INTEGER      NOT NULL COMMENT '근무지번호', -- 근무지번호
  minimum_career       INTEGER      NULL     COMMENT '최소경력년수', -- 최소경력년수
  view_count           INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  posting_registration DATETIME     NOT NULL COMMENT '등록일', -- 등록일
  start_dated          DATETIME     NOT NULL COMMENT '시작일', -- 시작일
  end_dated            DATETIME     NOT NULL COMMENT '마감일', -- 마감일
  job                  TEXT         NOT NULL COMMENT '직무', -- 직무
  thumbnail            VARCHAR(255) NOT NULL COMMENT '섬네일', -- 섬네일
  year_salary          INTEGER      NULL     COMMENT '연봉', -- 연봉
  readable             INTEGER      NOT NULL COMMENT '공개여부', -- 공개여부
  minimum_education_no INTEGER      NOT NULL COMMENT '최소학력번호', -- 최소학력번호
  employment_stat_no   INTEGER      NOT NULL COMMENT '고용형태번호' -- 고용형태번호
)
COMMENT '채용공고';
---------------------------------------------------------------------------------------
-- 채용공고첨부파일
CREATE TABLE pf_job_posting_file (
  job_posting_file_no INTEGER      NOT NULL COMMENT '채용공고첨부파일번호', -- 채용공고첨부파일번호
  job_posting_no      INTEGER      NOT NULL COMMENT '채용공고번호', -- 채용공고번호
  file_path           VARCHAR(255) NOT NULL COMMENT '파일경로' -- 파일경로
)
COMMENT '채용공고첨부파일';
--------------------------------------------------------------------------------------- 

```

---

### 3) DB 제약조건 설정

```sql
-- 채용공고
ALTER TABLE pf_job_posting
  ADD CONSTRAINT PK_pf_job_posting -- 채용공고 기본키
    PRIMARY KEY (
      job_posting_no -- 채용공고번호
    );
    
    
ALTER TABLE pf_job_posting         --NOT NULL 및 PK자동증가 설정
  MODIFY COLUMN job_posting_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '채용공고번호';
  
  
-- 채용공고첨부파일
ALTER TABLE pf_job_posting_file
  ADD CONSTRAINT PK_pf_job_posting_file -- 채용공고첨부파일 기본키
    PRIMARY KEY (
      job_posting_file_no -- 채용공고첨부파일번호
    );
    
    -- 채용공고첨부파일 유니크 인덱스
CREATE UNIQUE INDEX UIX_pf_job_posting_file
  ON pf_job_posting_file ( -- 채용공고첨부파일
    job_posting_no ASC, -- 채용공고번호
    file_path ASC       -- 파일경로
  );
  
  ALTER TABLE pf_job_posting_file
  MODIFY COLUMN job_posting_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '채용공고첨부파일번호';
  
  
  -- ※ 외래키는 상황에 따라 설정한다.
  
  -------------외래키 설정 --------------
  
  ALTER TABLE pf_job_posting                   
  ADD CONSTRAINT FK_pf_company_member_TO_pf_job_posting -- 기업회원 -> 채용공고  
    FOREIGN KEY (
        company_member_no -- 기업회원번호
    )
    REFERENCES pf_company_member ( -- 기업회원
        company_member_no -- 기업회원번호
    );
    
    
   
ALTER TABLE pf_job_posting
  ADD CONSTRAINT FK_pf_final_education_TO_pf_job_posting -- 학력 -> 채용공고
    FOREIGN KEY (
        minimum_education_no -- 최소학력번호
    )
    REFERENCES pf_final_education ( -- 학력
        education_no -- 학력번호
    );
    
  
  ALTER TABLE pf_job_posting
  ADD CONSTRAINT FK_pf_employment_status_TO_pf_job_posting -- 고용형태 -> 채용공고
    FOREIGN KEY (
      employment_stat_no -- 고용형태번호
    )
    REFERENCES pf_employment_status ( -- 고용형태
      employment_stat_no -- 고용형태번호
    );
    
    
    ALTER TABLE pf_job_posting
  ADD CONSTRAINT FK_pf_county_district_TO_pf_job_posting -- 군구 -> 채용공고
    FOREIGN KEY (
      work_place_no -- 근무지번호
    )
    REFERENCES pf_county_district ( -- 군구
      county_district_no -- 군구번호
    );
    
    
    ALTER TABLE pf_job_posting_file
  ADD CONSTRAINT FK_pf_job_posting_TO_pf_job_posting_file -- 채용공고 -> 채용공고첨부파일
    FOREIGN KEY (
      job_posting_no -- 채용공고번호
    )
    REFERENCES pf_job_posting ( -- 채용공고
      job_posting_no -- 채용공고번호
    );
    
    
    ALTER TABLE pf_company_required_major
  ADD CONSTRAINT FK_pf_job_posting_TO_pf_company_required_major -- 채용공고 -> 기업요구전공
    FOREIGN KEY (
      job_posting_no -- 채용공고번호
    )
    REFERENCES pf_job_posting ( -- 채용공고
      job_posting_no -- 채용공고번호
    );
    
    
    ALTER TABLE pf_company_required_certificate
  ADD CONSTRAINT FK_pf_job_posting_TO_pf_company_required_certificate -- 채용공고 -> 기업요구자격증
    FOREIGN KEY (
      job_posting_no -- 채용공고번호
    )
    REFERENCES pf_job_posting ( -- 채용공고
      job_posting_no -- 채용공고번호
    );
    
    
    ALTER TABLE pf_apply
  ADD CONSTRAINT FK_pf_job_posting_TO_pf_apply -- 채용공고 -> 회원기업공고지원
    FOREIGN KEY (
      job_posting_no -- 채용공고번호
    )
    REFERENCES pf_job_posting ( -- 채용공고
      job_posting_no -- 채용공고번호
    );
    
    
    ALTER TABLE pf_job_recommendation
  ADD CONSTRAINT FK_pf_job_posting_TO_pf_job_recommendation -- 채용공고 -> 채용추천
    FOREIGN KEY (
      job_posting_no -- 채용공고번호
    )
    REFERENCES pf_job_posting ( -- 채용공고
      job_posting_no -- 채용공고번호
    );
```

---

### 4) Mapper  프로퍼티에 job_posting_file 컬렉션 추가

```xml
<resultMap type="JobPosting" id="JobPostingMap">
		<id column="job_posting_no" property="jobPostingNumber" />
		<result column="company_member_no" property="companyMemberNumber"/>
		<result column="title" property="title" />
		<result column="content" property="content" />
		<result column="work_place_no" property="workPlaceNumber" />
		<result column="minimum_career" property="minimumCareer" />
		<result column="view_count" property="viewCount" />
		<result column="posting_registration" property="postingRegistration" />
		<result column="start_dated" property="startDated" />
		<result column="end_dated" property="endDated" />
		<result column="job" property="job" />
		<result column="thumbnail" property="thumnail" />
		<result column="year_salary" property="yearSalary" />
		<result column="readable" property="readable" />
		<result column="minimum_education_no" property="minimumEducationNumber" />
		<result column="employment_stat_no" property="employmentStatNumber" />
		
		<collection property="files" ofType="JobPostingFile">          //프로퍼티로
      <id column="job_posting_file_no" property="jobPostingFileNumber"/>//file_path와 file_no
      <result column="file_path"  property="filePath"/>                 //받기
    </collection>
	</resultMap>
```

---

### 5) DAO 를 통해 DB와 연동

```java
//JobPostingDao
public interface JobPostingDao {

  public int insert(JobPosting jobPosting) throws Exception; //add

  public List<JobPosting> findAll() throws Exception; //list

  public List<JobPosting> findMore(int lastNo) throws Exception; //list 더보기

  public JobPosting findByNo(int no) throws Exception; //detail

  public int update(JobPosting jobPosting) throws Exception; //update

  public int delete(int no) throws Exception; //delete

  List<JobPosting> findByKeyword(String keyword) throws Exception; //검색

  int plusCnt(int jobPostingNumber) throws Exception;  //조회수처리
}

```

```java
//JobPostingFileDao
public interface JobPostingFileDao {

  public int insert(JobPosting jobPosting) throws Exception; //add

  List<JobPostingFile> findAll(int jobPostingNumber) throws Exception; //list

  int deleteAll(int jobPostingNumber) throws Exception; //delete

}

```

---

### 6) Service 인터페이스 생성

```java
//인터페이스는 실제작업을 처리하지않고 파라미터를 전달할 메서드를 구현해서
//이 인터페이스를 구현한 구현체를 통해 DAO로 파라미터를 전달한다.

public interface JobPostingService {

  void add(JobPosting jobPosting) throws Exception; //add

  List<JobPosting> list() throws Exception; //list 

  List<JobPosting> list2(int lastNo) throws Exception; //list더보기 

  void delete(int no) throws Exception; //delete

  JobPosting get(int no) throws Exception; //detail

  List<JobPosting> search(String keyword) throws Exception; //검색

  void update(JobPosting jobPosting) throws Exception; //update

  int plusCnt(int jobPostingNumber) throws Exception; //조회수처리

}
```

---

### 7) 인터페이스 구현체 생성

```java
@Component
public class JobPostingServiceImpl implements JobPostingService {

  TransactionTemplate transactionTemplate; //트렌젝션 처리
  JobPostingDao jobPostingDao; //DAO를 통해 작업해서 DB와 연계작업
  JobPostingFileDao jobPostingFileDao; //DAO를 통해 작업해서 DB와 연계작업

  public JobPostingServiceImpl( //생성자 추가
      PlatformTransactionManager txManager, 
      JobPostingDao jobPostingDao, 
      JobPostingFileDao jobPostingFileDao) { 
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.jobPostingDao = jobPostingDao;
    this.jobPostingFileDao = jobPostingFileDao;
  }

  //이 메서드들은 Service인터페이스를 상속받았다.
    
  @Transactional //트랜잭션을 위한 애노테이션
  @Override  //add기능 
  public void add(JobPosting jobPosting) throws Exception { //객체전체를 파라미터로 받음
    if (jobPostingDao.insert(jobPosting) == 0) {  //파라미터로 받은 객체를 DAO를 통해 insert시킨다.
      throw new Exception("게시글 등록에 실패했습니다.");
    }
    jobPostingFileDao.insert(jobPosting); //파라미터로 받은 객체를 DAO를 통해 insert시킨다.(파일)
  }

  @Override  //list기능
  public List<JobPosting> list() throws Exception {  //list를 받아서 DAO를 통해 리스트 출력
    return jobPostingDao.findAll();
  }

  @Override  //list더보기 기능
  public List<JobPosting> list2(int lastNo) throws Exception { 
            //파라미터로 lastNo를 받아서 더보기처리
    return jobPostingDao.findMore(lastNo);       
  }

  @Transactional
  @Override //delete
  public void delete(int no) throws Exception { //파라미터로 no를 받아서 해당 no 게시글 삭제처리
    jobPostingFileDao.deleteAll(no);
    if (jobPostingDao.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
  }

  @Override      //detail
  public JobPosting get(int no) throws Exception { //파라미터로 no를 받아서 해당 no의 게시글을 조회
    return jobPostingDao.findByNo(no); 
  }

  @Transactional
  @Override   //update
  public void update(JobPosting jobPosting) throws Exception { //파라미터로 객체를 받아 
    if (jobPostingDao.update(jobPosting) == 0) {               //객체를 통해 업데이트
      System.out.println(jobPosting);
      throw new Exception("게시글 수정에 실패했습니다.");
    }
    if (jobPosting.getFiles() != null) {                       //file을 입력받았다면
      jobPostingFileDao.deleteAll(jobPosting.getJobPostingNumber());  //기존 파일을 전부삭제하고
      jobPostingFileDao.insert(jobPosting); //입력받은 파일을 인서트시킨다.
    }
  }

  @Override
  public List<JobPosting> search(String keyword) throws Exception { //파라미터로 keyword를 입력받아
    return jobPostingDao.findByKeyword(keyword);  //DAO로 전달해서 처리
  }

  @Override
  public int plusCnt(int jobPostingNumber) throws Exception { //파라미터로 jobPostingNumber를받아
    System.out.println("plusCnt 호출!");                      //해당 번호에 해당되는 게시글의
    return jobPostingDao.plusCnt(jobPostingNumber);           //조회수를 증가시키도록 DAO로 
  }                                                           //jobPostingNumber를 넘겨줌
}

```

---

### 8) 실제 작업을 하는 Controller 생성

```java
//애노테이션을 통해 Controller임을 명시한다.
//@Controller 애노테이션을 붙이면 해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용할 수 있다.
//@RequestMapping은 URL을 컨트롤러의 메서드와 매핑할 때 사용하는 스프링 프레임워크의 애노테이션이다.
@Controller 
@RequestMapping("/jobposting") //요청될 URL 설정
public class JobPostingController {

  static Logger logger = LogManager.getLogger(JobPostingController.class); //해당 클래스의 로그출력

  @Autowired //@Autowired애노테이션은 의존성 객체를 자동 주입해준다.
  ServletContext servletContext; 
    //웹 어플리케이션내에 있는 모든 서블릿들을 관리하며 
    //정보공유 할 수 있게 도와주는 역할 (웹 어플리케이션의 등록정보)
    //서블릿의 가상데릭토리상의 실제경로를 얻는 작업 => getRealPath()
    //log file 기록  => log()
    // 파일의 MIME 타입을 얻은 작업 => getmimeType()
    // 모든 서블릿은 ServletContext 객체를 사용할 수 있다.

  @Autowired
  JobPostingService jobPostingService; //Service를 통해 작업

  public JobPostingController() { //컨트롤러가 생성됬는지를 debug로 출력할 생성자
    logger.debug("JobPostingController 생성");
  }

  @GetMapping("form")  //@GetMapping 애노테이션은 Get으로 RequestMapping을 한다
  public void form() throws Exception {} //입력폼을 받을 form() 메서드

  @PostMapping("add")  //@PostMapping 애노테이션은 Post으로 RequestMapping을 한다
  public String add(//
      JobPosting jobPosting,//객체와 파일을 파라미터로 받는다
      MultipartFile[] jobPostingFiles) throws Exception {

    System.out.println(jobPosting + "1111");

    ArrayList<JobPostingFile> files = new ArrayList<>();  //file의 리스트생성
    String dirPath = servletContext.getRealPath("/upload/jobposting"); //파일의 실제경로를 알아낸다
    for (MultipartFile photoFile : jobPostingFiles) { //입력받은 파일을 반복문을 통해 변수에 담는다.
      if (photoFile.getSize() <= 0) {  //입력받은 파일이 없을경우 넘어감
        continue;
      }
      String filename = UUID.randomUUID().toString();//파일명의 중복방지를 위해 이름을 식별자로 저장
      photoFile.transferTo(new File(dirPath + "/" + filename));
      //파일을 원하는  경로/이름 으로 저장
      files.add(new JobPostingFile().setFilePath(filename)); 
      //위에서 만든 식별자이름을 JobPostingFile의 filePath로 셋팅후 JobPosting의 files변수에 저장
        
      //-------------------------------------  
      //썸네일처리 코드 (썸네일 라이브러리 필요함)
      Thumbnails.of(dirPath + "/" + filename)  //위에서 저장한 파일의 경로와 이름을 썸네일로 변환
          .size(300, 300)//  //사이즈설정
          .outputFormat("jpg")//포맷설정
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_300x300"; //위에서 저장한 이름에 _300x300을 붙여서 저장한다.
            }
          });
      //-------------------------------------
    }

    jobPosting.setFiles(files); //파일을 jobPosting의 files에 저장
    System.out.println(jobPosting + "2222");
    jobPostingService.add(jobPosting); //files를 저장한 객체를 Service를 통해 DAO로 보냄
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception { //파라미터로 no를 받아 Serivce를 통해 DAO로 
    jobPostingService.delete(no);
    return "redirect:list";
  }

  //@RequestParam(defaultValue = "1")은 파라미터의 값이 없을 경우 dafaultValue를 설정해준다.
  @GetMapping("detail") //
  public void detail(@RequestParam(defaultValue = "1") int no, Model model) throws Exception {
    jobPostingService.plusCnt(no);
    model.addAttribute("jobPosting", jobPostingService.get(no));
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    List<JobPosting> jobPostings = jobPostingService.list();
    model.addAttribute("list", jobPostings);
  }

  @GetMapping("list2")
  public void list2(@RequestParam(defaultValue = "1") int lastNo, Model model) throws Exception {
    List<JobPosting> jobPostings = jobPostingService.list2(lastNo);
    model.addAttribute("list", jobPostings);
  }

  @GetMapping("search")
  public void search(String keyword, Model model) throws Exception {
    model.addAttribute("list", jobPostingService.search(keyword));
  }

  @GetMapping("updateForm")
  public void updateForm(int no, Model model) throws Exception {
    model.addAttribute("jobPosting", jobPostingService.get(no));
  }

  @PostMapping("update")
  public String update(//
      int no, //
      JobPosting jobPosting, //
      MultipartFile[] jobPostingFiles) throws Exception {

    jobPosting = jobPostingService.get(no);

    ArrayList<JobPostingFile> files = new ArrayList<>();
    String dirPath = servletContext.getRealPath("/upload/jobposting");
    for (MultipartFile jobPostingFile : jobPostingFiles) {
      if (jobPostingFile.getSize() <= 0) {
        continue;
      }
      String filename = UUID.randomUUID().toString();
      jobPostingFile.transferTo(new File(dirPath + "/" + filename));
      files.add(new JobPostingFile().setFilePath(filename));

      Thumbnails.of(dirPath + "/" + filename)//
          .size(300, 300)//
          .outputFormat("jpg")//
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_300x300";
            }
          });

    }

    if (files.size() > 0) {
      jobPosting.setFiles(files);
    } else {
      jobPosting.setFiles(null);
    }

    jobPostingService.update(jobPosting);
    return "redirect:list";
  }
}

```



