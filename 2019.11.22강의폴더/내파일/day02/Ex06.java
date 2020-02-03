package day02;

//삼항연산자
//속도가 제일 빠르지만
//코드 단독 실행이 불가
//대신 값을 초기화할때 주로 사용된다.
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 59;
		// 삼항연산자를 쓸때는
		// 조건식 ? 참일때 값 : 거짓일때 값
		String result = score < 60 ? "낙제" : "합격";
		// score < 60? System.out.println("낙제") : System.out.println("합격");

		// 년을 입력받아서
		// 윤년인지 평년인지 출력하는 프로그램
		// 윤년의 조건: 4로 나누어 떨어짐 + 100으로 나누어 떨어지지 않음, 400으로 나누어 떨어짐
		//
		System.out.println("연을 입력하세요:");
		int year = scan.nextInt();
		// if문으로 만들 때
		if (year % 4 == 0) {
			// 4로 나누어 떨어지니
			// 100을 체크
			if (year % 100 == 0) {
				// 다시 400으로 나누어 떨어지는지 체크
				if (year % 400 == 0) {
					System.out.println("윤년");
				}else {
					System.out.println("평년");
				}
			}else {
				System.out.println("윤년");
			}
		}else {
			System.out.println("평년");
		}
		if(year % 400 == 0 || (year % 4 ==0 && year % 100 !=0)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
		String yoon = year % 400 ==0 ? "윤년" :
			year % 4 == 0 && year % 100 != 0 ? "윤년" : "평년";
		System.out.println(yoon);
		scan.close();
	}
}
