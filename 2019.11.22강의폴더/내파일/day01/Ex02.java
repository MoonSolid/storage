package day01;
//������Ÿ��
//������Ÿ���� ũ�� 2������ ������ : �⺻���� ������
//�⺻��:stack�޸𸮿� ����ǰ� ���� �ش� �ּҿ� ����.
//�⺻������ byte short int long float double char boolean 8������ �ִ�.
//byte, short, int, long: ������ ������Ÿ��(8��Ʈ, 16��Ʈ, 32��Ʈ, 64��Ʈ)
//float, double:�Ǽ���
//char: ������
//boolean: ��/����
//������: heap �޸𸮿� ����ǰ� �ش� �ּҿ��� �� ������ ���� �޸� �ּҰ� ����ȴ�.
//�������� ũ�� class, interface, �迭 3���� ������ ������ �ִ�.
public class Ex02 {
	public static void main(String[] args) {
		//���� ������Ÿ���� ǥ���� �� �ִ� �ִ� ������ ������
		//������ -�� ���� �Ǵµ�
		//�̷��� ���׸� overflow��� �Ѵ�.
		
		//�ݴ�� ǥ���� �� �ִ� �ּ� ������ ������
		//+�� �ٲ�µ�
		//�̷��� ���׸� underflow��� �Ѵ�.
		byte max = (byte)(127+1);
		System.out.println(max);
	}
}
