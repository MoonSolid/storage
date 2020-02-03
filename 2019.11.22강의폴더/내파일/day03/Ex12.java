package day03;

import java.util.Scanner;

public class Ex12 {
	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 줄 수를 입력하세요: ");
		int lineNumber = scan.nextInt();
		for (int i = 1; i <= 2 * lineNumber - 1; i++) {
			String stars = "";
			if (i == 1 || i == 2 * lineNumber - 1) {
				for (int j = 1; j <= 2 * lineNumber - 1; j++) {
					stars += "*";
				}
			} else if (i <= lineNumber - 1) {
				for (int j = i; j <= lineNumber; j++) {
					stars += "*";
				}
				for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
					stars += " ";
				}
				for (int j = i; j <= lineNumber; j++) {
					stars += "*";
				}
			} else {
				int lowerI = i - lineNumber + 1;
				for (int j = 1; j <= lowerI; j++) {
					stars += "*";
				}

				for (int j = 1; j <= 2 * (lineNumber - lowerI) - 1; j++) {
					stars += " ";
				}
				for (int j = 1; j <= lowerI; j++) {
					stars += "*";
				}

			}
			System.out.println(stars);
		}

		scan.close();
	}

}
