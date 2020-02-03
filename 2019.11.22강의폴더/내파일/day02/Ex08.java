package day02;
//사용자로부터 입력을 받아서
//1부터 그 수까지의 시그마를 구하는
//프로그램을 만드세요
import java.util.Scanner;
public class Ex08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요:");
		int userNumber = scan.nextInt();
		int sigma = 0;
		for(int i = 0; i <= userNumber; i++) {
			sigma = sigma+i;
		}
		System.out.println("1부터" +userNumber+"까지의 합은"+sigma);
		
		scan.close();
	}
}
