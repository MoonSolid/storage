package day02;
//switch ������ �ǵ������� break �� �����Ͽ�
//Ư�� ��������� �����ڵ带 ��Ʈ�� �ϴ� ���
public class Ex04 {
	public static void main(String[] args) {
		int month = 5;
		switch(month) {
		case 1:
		case 3:
		case 5:  //�����̸´� case 5������ǰ� 
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31"); //break�� ������ ���� �����Ǵٰ� break�� �ɾ� 31�� �������
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;
		case 2:
			System.out.println("28");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            break;		
            //break���� �Ϻη� ����ϴ� ��
		}
	}
}
