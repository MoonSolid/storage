package day03;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("출력할 줄 수를 입력하세요.");
	int lineNumber = scan.nextInt();
	for(int i = 1; i <= 2*lineNumber - 1; i++) {
		String stars = "";
		if(i <= lineNumber -1) {
			for(int j = i; j <= lineNumber -1; j++) {
				stars += " ";
			
			}
			for(int j = 1; j <= 2*i -1; j++) {
				stars += "*";
			}
			
		}else {
			//lowerI는 1 2 3 4 5 ....lineNumber 가 된다.
			int lowerI = i - lineNumber +1;
			//위의 나온 lowerI를 역순으로 바꿔주기 위해
			//lineNumber - lowerI + 1을 해준다.
			//reversedI는 lineNumber lineNumber -1....1이 된다.
			int reversedI = lineNumber - lowerI +1 ;
			for(int j= reversedI; j <=lineNumber -1; j++) {
				stars +=" ";
			}
			for(int j = 1; j <= 2* reversedI - 1; j++) {
				stars +="*";
			}
		}
		System.out.println(stars);
	}
	scan.close();
	}
	
}
