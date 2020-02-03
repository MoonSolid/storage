package day05;
//��ü���� ���α׷��ֿ���
//5���� ��Ģ�� �ִ�. (SOLID)
//���� ù��° ��Ģ�� �ٷ� Single Responsibility Principle
//���� å�� ��Ģ�̴�.
//�� ��Ģ�� �������� �����ϴ�.
//Ŭ������ �Ѱ��� ��ɸ� å������ �Ѵٴ� ���̴�.
//��ǥ���� ���� POJO Ŭ�����̴�. POJOŬ������ �ٸ� ����� ����
//���� �����͸� ��� Ʋ�� ���Ҹ� �Ѵ�.
//�� ���α׷��� ����� ��Ʈ���ϴ°� �ٸ� Ŭ������ ����ؾߵǰ�
//���α׷��� UI�� �� �ٸ� Ŭ������ ����ؾ��ϴ� ���̴�.

import java.util.ArrayList;

//controller Ŭ������
//ArrayList�� �̿��ؼ�
//ParkDTO�� �����ϴ� Ŭ������ �ȴ�.
//���� DB�� ����Ǹ� ArrayList�� �ʵ�� ������ ����
//�ʿ䰡 ������ �츮�� DB�� �����Ƿ�
//field�� ArrayList�� ���� DB�� �� ���̴�.

public class ParkController {						

	private final int MAX = 5;
	private final int UNUT_MINUTE = 10;
	private final int UNIT_PRICE = 1000; 
	private ArrayList<ParkDTO> list;				//ParkDTO��� ArrayList�� �ҷ���

	public ParkController() {									//			
		// �̷��� �ϸ� �����ڸ� ȣ���ص� list�� ���� �غ� �ȴ�.
		list = new ArrayList<ParkDTO>();
	}

	public boolean checkNumberExist(String number) {					//�����Ҷ� ������ �ִ��������� �ߺ��˻�
		// Ŭ���� ����(=��ü)�� �ʿ��Ҷ� ���� ���� ���ָ� �ȴ�.
		ParkDTO p = new ParkDTO();
		p.setNumber(number);
		return list.contains(p);
	}

	public boolean validateTime(int time) {							//�ð��� 24�ð��� �ѱ����ʰ� ���� 60���� �ѱ����ʰ� �ϴ°���
		int hour = time / 100;
		int min = time % 100;
		if (hour > -1 && hour < 24 && min > -1 && min < 60) {
			return true;
		}
		return false;
	}

	public boolean findEmpty() {			//�����忡 ���ڸ��� �ִ��� ã�� ����
		return list.size() < MAX;
	}
	

	public void insert(ParkDTO p) {			//�����忡 ���� �ִ°���
		list.add(p);
	}
	public boolean isEmpty() {			//����Ʈ�� �ش��� �ִ��������� Ȯ��
		return list.isEmpty();
		}	
	
	//2���� ����� ����
	//1. parkDTO ��ü �����ֱ�
	//2. inTime�� �����ֱ�
	public ParkDTO selectOne(ParkDTO p) {
		return list.get(list.indexOf(p));
	}
	
	public int calcRate(ParkDTO p, int outTime) {
		int hourDifference = outTime / 100 - p.getInTime() / 100;
		int minuteDifference = outTime % 100 - p.getInTime() % 100;
		int totalDifference = 60 * hourDifference + minuteDifference;
		return totalDifference / UNUT_MINUTE * UNIT_PRICE;
	}
	
	public void remove(ParkDTO p) {
		list.remove(p);
	}
}