package day02;

//���׿�����
//�ӵ��� ���� ��������
//�ڵ� �ܵ� ������ �Ұ�
//��� ���� �ʱ�ȭ�Ҷ� �ַ� ���ȴ�.
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 59;
		// ���׿����ڸ� ������
		// ���ǽ� ? ���϶� �� : �����϶� ��
		String result = score < 60 ? "����" : "�հ�";
		// score < 60? System.out.println("����") : System.out.println("�հ�");

		// ���� �Է¹޾Ƽ�
		// �������� ������� ����ϴ� ���α׷�
		// ������ ����: 4�� ������ ������ + 100���� ������ �������� ����, 400���� ������ ������
		//
		System.out.println("���� �Է��ϼ���:");
		int year = scan.nextInt();
		// if������ ���� ��
		if (year % 4 == 0) {
			// 4�� ������ ��������
			// 100�� üũ
			if (year % 100 == 0) {
				// �ٽ� 400���� ������ ���������� üũ
				if (year % 400 == 0) {
					System.out.println("����");
				}else {
					System.out.println("���");
				}
			}else {
				System.out.println("����");
			}
		}else {
			System.out.println("���");
		}
		if(year % 400 == 0 || (year % 4 ==0 && year % 100 !=0)) {
			System.out.println("����");
		}else {
			System.out.println("���");
		}
		
		String yoon = year % 400 ==0 ? "����" :
			year % 4 == 0 && year % 100 != 0 ? "����" : "���";
		System.out.println(yoon);
		scan.close();
	}
}
