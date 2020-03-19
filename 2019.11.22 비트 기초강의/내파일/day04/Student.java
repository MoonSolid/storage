package day04;

public class Student {
	//field
	//해당 객체의 정보가 들어가는 곳
	//필요한 정보에 따라서 변수 선언하듯이 선언만 한다.
	private int id;
	
	//이제 모든 필드들이 private이 되었기 때문에
	//외부에서 직접적으로 값을 넣거나 뺄 수 없게 된다.
	//따라서 메소드를 만들어서 해당 클래스의 필드값을 관리할 수 있게 해야한다.
	
	
	//값을 외부에서 받아서 객체 내부에 저장할 때에는 setter 메소드를 사용한다.
	//setter는 public void set필드이름(필드데이터타입 필드이름)으로 선언한다.  set method는 private 필드 안에 넣어준다
	public void setId(int id) {
		//this란? 해당 메소드를 호출하는 객체 자신을 뜻한다.
		
		this.id = id;
	}
	//getter는 현재 필드에 저장된 값을 호출한 곳으로 보내주는 메소드이다.
	//getter는 public 필드데이터타입 get필드이름()으로 선언한다.
	public int getId() {
		return id;  
	}
	
	private String name;
	
	public void setName(String name) {
		
		
		this.name = name;
	}
	
	public String getName() {
		return name;  
	}
		
	private int kor;
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	
	
	private int eng;
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int  getEng() {
		return eng;
	}
	private int math;
	public void setMath(int math) {
		this.math = math;
	}
	public int  getMath() {
		return math;
	}
	
	
	
	//method는 이 클래스의 기능부분이다.
	//method는
	//접근제한자 리턴타입 메소드이름(파라미터 내용)으로 선언한다.   파라미터는 메소드  내용
	//리턴타입은 해당 메소드가 끝나고 나서 호출 된 곳으로 보내줄 값의 데이터타입
	//파라미터는 해당 메소드가 호출될때 받아서 메소드 내부에서 사용할 재료
	//파라미터의 이름은 호출된 곳에서 넘겨받을 변수 혹은 값의 이름과 같을 필요가 없다.
	//다만 이 메소드 내부에서는 해당 이름으로 쓰게 된다.
	
	public void showName(String name) {  //String은 문자열. 
		System.out.println("이름은"+name);	//
	}
	//접근제한자란? (Access Modifier)
	//해당 field 나 method가 어디서 접근한 수 있는지 정한다.
	//public, package(=default),protected,private 4단계가 있다.
	//public: 어디서든지 접근 가능
	//package:패키지 내부에서만 접근 가능. 만약 별도의 접근제한자를 써주지않으면
	//			자동으로 package 접근제한이 걸리게 된다.
	//protected: 패키지 내부 + 상속받는 클래스까지만 접근 가능
	//private: 외부의 접근을 모두 막는다.
	
	//근데 이제는 정말 외부에서 쓸 메소드만 public, 나머지는 모두다 private
	//여기서 말하는 나머지는 클래스 내부에서 쓰는 method들과 모든 field를 말함
	
	//생성자란?
	//해당 클래스의 객체가 만들어질때 호출되는 메소드이다.
	//해당 객체가 만들어질 때 해야하는 행동들이나 혹은 초기화값들을 정해줄 수 있다.
	//우리가 안만들어줘도 자바가 자동으로 만들어주는 생성자가 있는데
	//해당 생성자는 기본형 데이터타입의 필드들은 0으로 초기화하고
	//참조형 데이터타입의 필드들은 null로 초기화한다.
	//생성자는 public 클래스이름() 으로 선언한다.
	
	//생성자에는 파라미터가 있는 생성자와 파라미터가 없는 생성자가 있는데
	//파라미터가 있는 생성자를 만들어주면 기본 생성자와 파라미터가 없는 생성자는
	//쓸 수 없게 된다.
	//따라서 파라미터가 있는 생성자를 만들고 나서 파라미터가 없는 생성자도 필요하면
	//추가로 만들어줘야한다.
		public Student(String name, int id, int kor, int eng, int math) {
		System.out.println("기본 생성자 호출");
		this.name = name;
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		}
		public Student() {
			name = "학생";
			id = -1;
			kor = -1;
			eng = -1;
			math = -1;
		
		}
		public String toString() {
			return id+" "+name+" "+kor+" "+eng+" "+math;
		}

		//equals 메소드란?
		//해당 객체와 파라미터로 들어오는 모든 것을 비교하는 메소드이다.
		//만약 해당 객체와 데이터타입이 같고
		//해당 객체의 특정 필드와 값이 같으면 똑같은 객체로 판단하여
		//true를 리턴하고
		//만약 같은 종류가 아니거나 필드의 값이 다르면 false를 리턴해준다.
		public boolean equals(Object o) { //o가 스튜던트의 객체로 지정하고 
			if(o instanceof Student) {  //o가 스튜던트의 객체인지 비교하고 트루라면
				Student s = (Student)o;    //s라는 
				if(this.id == s.id && this.name.equals(s.name)) { //호출한 오브젝트와 호출한 
					return true;
				}
			}
			
			return false;
		}
}









