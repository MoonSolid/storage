package day02;

//������ �Է¹޾Ƽ�
//switch���� �̿��ؼ�
//A B C D F�� ����Ͻÿ�.
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� :");
		int score = scan.nextInt();
		if(score > 100) { //���ھ 100���� ũ�� if���� �����ϰ��ؼ� else���� ��µǰԸ���(int�� �������̶� �Ҽ����������ϱ⶧���� 10���� �����ָ�  
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");  //case�� 1���� 100���� �ϳ��ϳ� �Է������ʿ䰡���� 101~109�� 10���� �������� ������ ���ܼ�  if������� )
		}else {
			switch(score / 10) { //score�� 10���� �����༭ 
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
			case 6:
				System.out.println("D");
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				System.out.println("F");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;	
		}
		}
		scan.close();
	}
}
