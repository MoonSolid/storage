package day02;
//���ѷ����� �̿��� �޴� �����
import java.util.Scanner;
public class Ex14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====��Ʈ ���ӱ�====");
			System.out.println("1.���ν��� 2.���̺� �ε��ϱ� 3.�����ϱ�");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("�÷������ּż� �����մϴ�.");
				break;
			}
		}
		scan.close();
	}
}
