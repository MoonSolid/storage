package day02;
//무한루프를 이용한 메뉴 만들기
import java.util.Scanner;
public class Ex14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====비트 게임기====");
			System.out.println("1.새로시작 2.세이브 로드하기 3.종료하기");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("플레이해주셔서 감사합니다.");
				break;
			}
		}
		scan.close();
	}
}
