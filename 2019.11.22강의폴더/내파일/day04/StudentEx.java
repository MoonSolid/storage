package day04;

public class StudentEx {
	public static void main(String[] args) {
		Student s = new Student("문국대", 0, 80, 90, 100);
		String str = "abc";
		s.showName(str);
		s.showName("문국대");
		s.setId(0);
		Student s2 = new Student();
		s2.showName(str);
		s2.setId(2);
		
		s.setId(0);
		s.setName("문국대") ;
		s.setKor(80);
		s.setEng(90);
		s.setMath(100);
		System.out.println("이 학생의 이름은:"+s.getName());
		System.out.println("이 학생의 이름은:"+s2.getName());
		
		//System.out.println 메소드는
		//파라미터로 calss 객체가 들어오면
		//해당 객체의 toString()이라는 메소드를 실행시켜서
		//그 결과값을 화면에 출력한다.
		
		//우리가 따로 toString()메소드를 만들지 않아도
		//자바에서 만들어준 toString()메소드를 실행시켜서
		//출력해주는데
		//자바에서 만들어주는 toString()메소드는
		//패키지명.클래스이름@메모리주소값 을 보여준다.
		
		//따라서 우리가 객체의 필드값을 println으로 보여주려면
		//getter을 호출하거나 toString()메소드를 만들어서 보여줘야 한다.
		
		System.out.println(s);
		System.out.println(s2);
		
		//equals 메소드 실행결과
		System.out.println(s.equals(s2));
		s2.setId(0);
		s2.setName("문국대");
		System.out.println(s.equals(s2));
	}
}





