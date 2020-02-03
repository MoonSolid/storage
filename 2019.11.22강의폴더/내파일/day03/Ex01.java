package day03;
//별찍기 1번
import java.util.Scanner;

public class Ex01 {
	public static void main(String[]args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 줄 수를 입력하세요: ");
		int lineNumber = scan.nextInt();
		for(int i = 1; i <= lineNumber; i++) {
			for(int j= 1; j<= i; j++) {
				System.out.print("*");
			
		}
			System.out.println();
			
		scan.close();
		}
		
	}
	
	
}
