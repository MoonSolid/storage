package day02;

//char ascii ���� �̿��� 5x5 ü���� �����
public class Ex11 {
	public static void main(String[] args) {
		// println�� print�� ����
		// println�� () ���� ������ ����ϰ� �ڵ����� �ٹٲ��Ѵ�.
		// print�� () ���� ������ ����ϰ� �� ������ Ŀ���� �ű��.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print((char) ('A' + i) + Integer.toString(j + 1));
			}
			System.out.println();
		}

	}

}
