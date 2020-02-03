package day02;

import java.util.Scanner;

//사용자로부터 이름과 국어점수를 입력받아서
//A,B,C,D,F가 출력되는 프로그램을 만드세요.
public class Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("사용자의 이름:");
		String name = scan.nextLine();
		System.out.println("사용자의 국어점수: ");
		int kor = scan.nextInt();
		if(kor >=90 && kor <= 100) {
			System.out.println(name+"학생은 A");
		}else if(kor >=80 && kor <= 89) {
			System.out.println(name+"학생은 B");
		}else if(kor >=70 && kor <= 79) {
			System.out.println(name+"학생은 C");
		}else if(kor >=60 && kor <= 69) {
			System.out.println(name+"학생은 D");
		}else if(kor >= 0 && kor <= 59) {
			System.out.println(name+"학생은 F");
		}else {
			System.out.println(name+"점수를 잘못 입력하셨습니다.");
		}
		scan.close();
	}
}
