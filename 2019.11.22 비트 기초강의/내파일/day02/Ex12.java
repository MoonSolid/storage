package day02;
//1~100������ �Ҽ��� ���ϴ� ���α׷�
//�Ҽ���? 1�� �ڱ��ڽ��� ������ ����� ���� ��
//���ڿ����� ���� ū ��� =�ڱ��ڽ�
//�� 2���� ������ �̿��ؼ� �Ҽ��� ����ϴ� ���α׷��� �����ô�.
public class Ex12 {
	public static void main(String[] args){
		
		for(int i = 1; i <= 100; i++) {
			//i = 1 count = 0  j = 1
			int count = 0;  
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i+"�� �Ҽ��Դϴ�!");
			}
		}
	}
}
