package day01;
//����ڷκ��� �̸�, Ű(���ʹ���), �����Ը� �Է¹޾Ƽ�
//�̸�: ~~~ BMI: ~~~~�� ��µǴ� ���α׷��� �����ô�.
//BMI ����: ������ / Ű�� ���� = ������ / Ű / Ű
import java.util.Scanner;
public class Ex09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���:");
		String name = scan.nextLine();
		//������ nextLine���� �����ϱ� ������
		//���۸޸𸮿� ����Ű�� ���� ���� nextLine�� �ܵ����� ������ �ʿ䰡 ����.
		System.out.println("Ű�� ���ʹ����� �Է��ϼ���:");
		double height = scan.nextDouble();
		System.out.println("�����Ը� �Է��ϼ���:");
		double weight = scan.nextDouble();
		
		double bmi = weight / height / height;
		System.out.println("�̸�:"+name+" BMI:"+bmi);
		//��ĳ�ʴ� �޸𸮸� ������ �����ϱ� ������
		//������ �ݾ����� ������ �׻� ��� ����.
		//�ݾ��ִ� ����� close() �޼ҵ带 �����ϸ� �ȴ�.
		
	}

}
