package day04;

public class Ex02 {
	public static void main(String[] args) {
		Car[] arrayCar = new Car[5];
		//���� �ڵ�� �迭�� ���ؼ��� �޸� Ȯ���� �Ǿ��� ������
		//�� ��Ҵ� �ٽ��ѹ� new�� �ʱ�ȭ�����
		//��밡���ϴ�.
		System.out.println(arrayCar.length);
		for(int i = 0; i < arrayCar.length;i++) {
			arrayCar[i] = new Car();
		}
		arrayCar[0].setPlateNumber("01�� 0000");
		//2��°, �迭�� ����ִµ��� ã������ �迭 ��ü�� �� ���ƴٳ���Ѵ�.
		for(int i = 0; i < arrayCar.length; i++) {
			if(arrayCar[i].getPlateNumber() == null) {
				System.out.println(i+"��°�� ����ֽ��ϴ�.");
			}
		}
	}
}
