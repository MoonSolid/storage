package day01;
//��������
// && || !
public class Ex06 {
	public static void main(String[] args) {
	boolean isTrue = true;
	boolean isFalse = false;
	//&& = �ص� ������
	//�Ѵ� Ʈ�� �϶��� Ʈ�簡 ���´�.
	System.out.println(isTrue && isFalse);
  
	// || = or ������
	//�� �� �ϳ��� true���� true�� ���´�.
	System.out.println(isTrue || isFalse);
	
	//! = ���� ������
	//true�� false�� false�� true�� �ٲ��ش�.
	System.out.println(!isTrue);
	System.out.println(!isFalse);
	int a = 10;
	System.out.println(a > 0 && a < 100);
  }
}