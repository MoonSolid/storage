package day02;
//for loop
//for loop �� ��Ȯ�� ��ȸ���� �ݺ��϶�� �����ϰ� �ȴ�.
//for(int i = ������; i < ��������; i��ȭ��){
//  	�ݺ��� �ڵ�
//}
public class Ex07 {
	public static void main(String[] args) {
		//������ ����Ǹ�
		//�ش� �ڵ� ��ϰ� �� �ڵ� ����� ���� �ڵ��Ͽ����� ��� �����ϴ�.
		//�ش� �ڵ� ����� ����� ���̻� ����� �Ұ����ϴ�.
		//�̰��� ������ ��ȿ����, �����ֱ� ��� ǥ���Ѵ�.
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
			System.out.println(i+"�� ¦���Դϴ�.");    
		}else {
			System.out.println(i+"�� Ȧ���Դϴ�.");
			
		}
	}
  }
}
