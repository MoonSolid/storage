package day02;

import java.util.Scanner;

//����ڷκ��� �̸��� ���������� �Է¹޾Ƽ�
//A,B,C,D,F�� ��µǴ� ���α׷��� ���弼��.
public class Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������� �̸�:");
		String name = scan.nextLine();
		System.out.println("������� ��������: ");
		int kor = scan.nextInt();
		if(kor >=90 && kor <= 100) {
			System.out.println(name+"�л��� A");
		}else if(kor >=80 && kor <= 89) {
			System.out.println(name+"�л��� B");
		}else if(kor >=70 && kor <= 79) {
			System.out.println(name+"�л��� C");
		}else if(kor >=60 && kor <= 69) {
			System.out.println(name+"�л��� D");
		}else if(kor >= 0 && kor <= 59) {
			System.out.println(name+"�л��� F");
		}else {
			System.out.println(name+"������ �߸� �Է��ϼ̽��ϴ�.");
		}
		scan.close();
	}
}
