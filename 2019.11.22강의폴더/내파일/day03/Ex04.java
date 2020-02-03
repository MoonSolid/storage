package day03;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 줄 수를 입력하세요");
		int lineNumber = scan.nextInt();

		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			for (int j = 1; j <= i - 1; j++) {
				stars += ' ';
			}
			for (int j = i; j <= lineNumber; j++) {
				stars += '*';
			}
			System.out.println(stars);
		}

		scan.close();

	}
}
