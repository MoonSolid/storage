package day01;
//��ĳ�� Ŭ���� ����
//��ĳ�� Ŭ������ �ܺ� Ŭ�����̱� ������
//import ��ɾ ���ؼ� �����;� �Ѵ�.
import java.util.Scanner;
public class Ex08 {
	public static void main(String[] args) {
		//Ŭ���� ���� �����
		//Ŭ�����̸� �����̸� = new Ŭ�����̸�();
		Scanner scan = new Scanner(System.in);
		
		//������ �Է� ������: ��ĳ�� ��ü�� nextInt() �޼ҵ�� �Է¹޴´�.
		System.out.println("������ȣ�� �Է��ϼ���: ");
		int manageNumber = scan.nextInt();
		System.out.println("������ȣ:" +manageNumber);
		
		//String�� �Է� ������: ��ĳ�� ��ü�� nextLine() �޼ҵ�� �Է¹޴´�.
		System.out.println("�̸��� �Է��ϼ���: ");
		scan.nextLine();//*nextLine�� ������ �ٹٲ��� ���� �ν��� �Է��� ���������Ƿ� nextLine�� ���� ����Ѵ�
		String name = scan.nextLine();
		System.out.println("�̸�:"+name);
	}
}
