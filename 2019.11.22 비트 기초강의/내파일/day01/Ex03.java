package day01;
//���������
//+=*/%

public class Ex03 {
	public static void main(String[] args) {
		//������ ���� ���� �־��
		//������Ÿ�� ������ = ��;
		int myNumber1 = 5;
		int myNumber2 = 10;
		System.out.println(myNumber1 + myNumber2);
		System.out.println(myNumber1 - myNumber2);
		System.out.println(myNumber1 * myNumber2);
		System.out.println(myNumber1 / myNumber2);
		System.out.println(myNumber1 % myNumber2);
	
		//typecasting(����ȯ)
		//������ Ÿ���� �ٲ� ������ ����ȯ�� ����� �Ѵ�.
		//����ȯ���� 2���� ����� �ִ�.
		//����� ����ȯ vs �Ͻ��� ����ȯ
		long myNumber3 = myNumber2;
		System.out.println(myNumber3);
		int number2 = 128;
		//����� ����ȯ�� �ϴ� ���:
		//(�ٲ� ������Ÿ��)��
		byte number4 = (byte)number2;
		
		//��ū ������Ÿ�԰� ���� ������Ÿ���� ��������ϸ�?
		//�ڵ����� ��ū ������Ÿ���� ����� ������ �ȴ�.
		System.out.println(number4+ number2);
		double myDouble = 1.0;
		System.out.println(number4 * myDouble);
	}
}
