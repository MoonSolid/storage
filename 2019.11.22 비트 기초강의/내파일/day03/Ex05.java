package day03;
import java.util.Scanner;
public class Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("����� �� ���� �Է��ϼ���:");
		int lineNumber = scan.nextInt();
		for(int i = 1; i <=lineNumber; i++) {
			String star = "";                      //
			for(int j = i; j <= lineNumber -1; j++) {
				star += ' ';
			}
			for(int j = 1; j<= 2 * i -1; j++) {
				star +="*";
			}
			System.out.println(star);
		}
		scan.close();
	}
}
