package day05;

import java.util.Scanner;

//refactoring
//�����丵�̶�? ���α׷��� ���� ����� �״��������
//���� �ҽ��� �� ȿ�����̰ų� ���׷��̵� ��Ű�°�.
public class ParkViewer {
	private ParkController controller;
	public ParkViewer() {
		controller = new ParkController();
	}
	public void showMenu() {
		System.out.println("==================");
		System.out.println("��Ʈ ���� ���� ���α׷�");
		System.out.println("==================");
		System.out.println("1.���� 2.���� 3.����");
	}
	public void insertPark(Scanner scan) {
		// ��������.
		// ���� ���� �� �ڸ��� �ִ��� üũ�Ѵ�.
		if (controller.findEmpty()) {
			// ���ڸ��� �����ϹǷ� ���� ��ȣ �Է��� �޴´�.
			scan.nextLine();
			System.out.println("������ ���� ��ȣ�� �Է��ϼ���:");
			ParkDTO p = new ParkDTO();
			p.setNumber(scan.nextLine());
			while (controller.checkNumberExist(p.getNumber())) {
				// while���� �ݺ��ȴ� = �ߺ��� ������ȣ�̴�!
				System.out.println("�̹� ������ ��ȣ�Դϴ�.");
				System.out.println("������ ���� ��ȣ�� �Է��ϼ���:");
				p.setNumber(scan.nextLine());
			}
			// while���� �Ѱ�� = �ߺ��� ������ȣ�� �ƴϴ� -> �ð� �Է¹ޱ�
			System.out.println("���� �ð��� �Է����ּ���:");
			int inTime = scan.nextInt();
			while (controller.validateTime(inTime) == false) {
				System.out.println("������ �߸��Ǿ����ϴ�.");
				System.out.println("���� �ð��� �Է����ּ���:");
				inTime = scan.nextInt();
			}
			// �̹� while���� �� = �ð��� �ùٸ� ����
			// ���� p�� ��Ƽ� controller.insert()ȣ��
			p.setInTime(inTime);
			controller.insert(p);
		} else {
			System.out.println("�� �ڸ��� �����ϴ�.");
		}
	}
	
	
	public void deletePark(Scanner scan) {
		// ���� ������ ������ �ִ���Ȯ���Ѵ�.
		if (controller.isEmpty()) {
			// ����Ʈ�� ��������Ƿ�
			// ��� �޽����� ���
			System.out.println("������ ������ �����ϴ�.");
		} else {
			// ����Ʈ�� ������ ParkDTO�� �����ϹǷ�
			// ���� ����
			scan.nextLine();
			System.out.println("���� ��ȣ�� �Է����ּ���: ");
			ParkDTO p = new ParkDTO();
			p.setNumber(scan.nextLine());
			while (!controller.checkNumberExist(p.getNumber())) {
				System.out.println("������ ����� �����ϴ�.");
				System.out.println("���� ��ȣ�� �Է����ּ���: ");
				p.setNumber(scan.nextLine());
			}
			// ������ȣ�� ���� -> ������ inTime��?
			// ����Ʈ�� �ش� ������ȣ�� ���� ParkDTO ��ü�� ������ �����ϱ�
			// �װ� �ҷ��;� �ȴ�.

			p = controller.selectOne(p);

			// �����ð��� �Է��� �޴´�.
			// �����ð��� �ð��� ��ȿ�� �Ӹ��� �ƴ϶�
			// �����ð����� �ʾ�� �Ѵٴ� Ư¡�� �ִ�.
			System.out.println("���� �ð��� �Է����ּ���:");
			int outTime = scan.nextInt();
			while (controller.validateTime(outTime) == false || // while���� outTime���� false�� ������ ���� while���� ����Ǵ°�
																// �̿���
					p.getInTime() > outTime) { // outTime�� true����false���� Ȯ��
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("���� �ð��� �Է����ּ���: ");
				outTime = scan.nextInt();
			}
			System.out.println("�� �����" + controller.calcRate(p, outTime) + "���Դϴ�.");
			controller.remove(p);

		}
	}
}
