package day02;
//사용자로부터 숫자를 입력받아 그 숫자까지의 팩토리얼을 구하는
//프로그램을 작성하시오
//팩토리얼이란? 1부터 그 숫자까지의 곱
import java.util.Scanner;
public class Ex09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요:");
		int userNumber = scan.nextInt();
		int factorial = 1;
		for(int i = 1; i < userNumber; i++) {
			factorial *= i;
		}
		
		System.out.println("팩토리얼은:" +factorial);
		scan.close();
	}
}
