package day02;
//����ڷκ��� �Է��� �޾Ƽ�
//1���� �� �������� �ñ׸��� ���ϴ�
//���α׷��� ���弼��
import java.util.Scanner;
public class Ex08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���:");
		int userNumber = scan.nextInt();
		int sigma = 0;
		for(int i = 0; i <= userNumber; i++) {
			sigma = sigma+i;
		}
		System.out.println("1����" +userNumber+"������ ����"+sigma);
		
		scan.close();
	}
}
