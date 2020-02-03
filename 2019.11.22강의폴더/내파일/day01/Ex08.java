package day01;
//스캐너 클래스 예제
//스캐너 클래스는 외부 클래스이기 때문에
//import 명령어를 통해서 가져와야 한다.
import java.util.Scanner;
public class Ex08 {
	public static void main(String[] args) {
		//클래스 변수 만들기
		//클래스이름 변수이름 = new 클래스이름();
		Scanner scan = new Scanner(System.in);
		
		//정수를 입력 받을때: 스캐너 객체의 nextInt() 메소드로 입력받는다.
		System.out.println("관리번호를 입력하세요: ");
		int manageNumber = scan.nextInt();
		System.out.println("관리번호:" +manageNumber);
		
		//String을 입력 받을때: 스캐너 객체의 nextLine() 메소드로 입력받는다.
		System.out.println("이름을 입력하세요: ");
		scan.nextLine();//*nextLine이 있으면 줄바꿈을 먼저 인식해 입력을 끝내버리므로 nextLine을 먼저 사용한다
		String name = scan.nextLine();
		System.out.println("이름:"+name);
	}
}
