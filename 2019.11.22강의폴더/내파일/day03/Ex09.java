package day03;

import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 줄 수를 입력하세요:");
		int lineNumber = scan.nextInt();
		for (int i = 1; i <= lineNumber * 2 - 1; i++) {
			String stars = "";
			if (i <= lineNumber - 1) {
				for (int j = i; j <= lineNumber; j++) {
					stars += "*";
				}
			} else {
				int lowerI = i - lineNumber + 1;
				for (int j = 1; j <= lowerI; j++) {
					stars += "*";
				}
			}
			System.out.println(stars);
		}
		scan.close();
	}

}
