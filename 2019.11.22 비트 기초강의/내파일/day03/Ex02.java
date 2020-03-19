package day03;

//별찍기 2번
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 줄 수를 입력하세요");
		int lineNumber = scan.nextInt();
			//
		for (int i = 1; i <=lineNumber; i++) {
			String stars ="";
			for (int j = i; j <= lineNumber; j++) {
				stars += '*';
			}
			System.out.println(stars);
		}
		scan.close();

	}
}
