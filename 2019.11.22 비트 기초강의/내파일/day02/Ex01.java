package day02;
//if�� ���� 01
//if���̶�? ���ǽ��� true�� ������ ����,false�� ������ ������� �ʴ�
//����̴�.
//if - else if -else �� ������ �̷������.
//if�� ������ �����ϸ� �Ʒ��� else if+else�� ���ð��ǰ�
//if�� ������ �������������� else if��üũ
//else if�� �������� �����ÿ� else�� ����ȴ�
//else if�� �������� ���� �� �ִ�.
public class Ex01 {
	public static void main(String[] args) {
		int number = 52;
		if(number >= 100) {
			//if���� ���ǽ��� true �� ������
			//�ش� code block �� ����ȴ�.
			//code block�� {}���� ������ �κ��� code block�̶�� �Ѵ�.
			System.out.println("number�� 100���� ũ�ų� �����ϴ�.");
		}else if (number >= 10){
			System.out.println("number�� 100���� �۰� 10����ũ�ų� �����ϴ�.");
		}else if(number >=0) {
			System.out.println("number�� 10���� �۰� 0���� ũ�ų� �����ϴ�");
		}else {
			System.out.println("number�� ���� �����Դϴ�.");
		}
		
		}
		
	}

