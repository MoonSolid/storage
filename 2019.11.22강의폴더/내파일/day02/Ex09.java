package day02;
//����ڷκ��� ���ڸ� �Է¹޾� �� ���ڱ����� ���丮���� ���ϴ�
//���α׷��� �ۼ��Ͻÿ�
//���丮���̶�? 1���� �� ���ڱ����� ��
import java.util.Scanner;
public class Ex09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���:");
		int userNumber = scan.nextInt();
		int factorial = 1;
		for(int i = 1; i < userNumber; i++) {
			factorial *= i;
		}
		
		System.out.println("���丮����:" +factorial);
		scan.close();
	}
}
