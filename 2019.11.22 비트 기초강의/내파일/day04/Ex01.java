package day04;
//�迭
//�迭�̶�? �Ȱ��� ������Ÿ���� ���ִ� ����
import java.util.Random; 			//������ ����Ҷ��� ���

public class Ex01 {
	private static final int SIZE = 6;
	private static final int MAX = 45;
	public static void main(String[] args) {
		//�迭�� 
		//������Ÿ��[] �迭�̸� - new ������Ÿ��[ũ��]
		//���� �����Ѵ�.
		int[] lottoNumber = new int[SIZE];
		//���� �ڵ忡�� 6�� magic number�̴�.
		//�̷��� '������ ����'�� ����� �����ؾ� �Ѵ�.
		//���� �̷��� ũ�⸦ ��������Ѵٸ�
		//����� ���� ����Ѵ�.
		
		//�迭�� �� ��ҿ� �����Ҷ����� index��ȣ�� �Ἥ �����Ѵ�
		lottoNumber[0] =5;
		//���� �ڵ�� �迭�� 0��°�� 5�� ����ִ´ٴ� �ǹ�
		System.out.println(lottoNumber[0]);
		//�迭�� 0��° ��ҿ� ����� ���� ����϶�
		
		//�Ʒ� �ڵ�� ������ ����.
		//lottoNumber[6] = 11;
		//�ֳ��ϸ� ��ǻ�ʹ� ���ڸ� 0���� ���� ������
		//��¡ ������ �ε�����ȣ�� ũ�� -1 �̴�.
		//���� ���� lottoNumber�� ũ��� 6�̱� ������
		//������ �ε����� 5�̰�, 6�� ������ ����.
		
		//���������� �ζ� ��ȣ ��÷�⸦ ������
		//����Ŭ������ 0~1 ���̿� �Ǽ��� ���� �ְ� �װɷ� ������ �����Ѵ�.
		Random random = new Random();
		
		//������� ����Ŭ������ lottoNumbers�� ���ʴ�� ������ ����־��.
		lottoNumber[0] = random.nextInt(45)+1;
		//nextInt(����)�� �ϰԵǸ� 0~���� -1���� ������ ������ ������
		//+1�� ���༭ 1~���� ������ ������ ������ ������ش�.
		lottoNumber[1] = random.nextInt(45)+1;
		lottoNumber[2] = random.nextInt(45)+1;
		lottoNumber[3] = random.nextInt(45)+1;
		lottoNumber[4] = random.nextInt(45)+1;
		lottoNumber[5] = random.nextInt(45)+1;
		
		//������ ���� �ڵ�� �ſ� ���� �ڵ��̴�.
		//�ϵ��ڵ��� ��ǥ���� ����
		for(int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(MAX) +1;
		}
		
		//������ ���� �ڵ忡���� �ߺ��� �߻��� �� �ִ�.
		//2�� for���� �̿��ؼ� �ߺ��� ���ڸ� ���� �����ϴ� �ڵ带 ������.		
		for(int i =0; i < lottoNumber.length; i++) {
			for(int j =0; j< lottoNumber.length; j++) {
				if(lottoNumber[i] == lottoNumber[j] && i != j) {  //&& i != j i�� j�� ��ġ�� �ٸ���
					//{1 12 38 49 33 22}
					lottoNumber[i] = random.nextInt(MAX)+1;
					j = -1;
				}
			}
		}
		
		
		//2�� for������ �ߺ����� �Ϸ� ��
		//������ �ϴ� �ڵ�
		//������ �Ҷ� ���� i��°�� i+1��°�� ���ؼ� i�� �� ũ��
		//2���� ������ �ٲ��ش�.
		
		for(int i = 0; i < lottoNumber.length - 1; i++) {
			if(lottoNumber[i] > lottoNumber[i+1]) {
				int temp = lottoNumber[i];
				lottoNumber[i] = lottoNumber[i+1];
				lottoNumber[i+1] = temp;
				i = -1;
			}
			
		}
		
		
		for(int i = 0; i < lottoNumber.length; i++) {
			System.out.println(lottoNumber[i]);
		}
	}
}
