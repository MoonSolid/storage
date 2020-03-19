package day05;

public class ParkDTO { // DTO = Data Transfer Object ��
	// �� �ȿ��� field �� ���ͼ���, equals, toString������ ����
	private String number;
	private int inTime;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	// ArrayList�� contains, indexOF ���� �޼ҵ����
	// template���� ���� class�� equals �޼ҵ带 ȣ���ؼ�
	// �� ������� �޼ҵ� ���ο��� ����Ѵ�.
	// �츮 ���α׷����� ���� ��ȣ�� ������ ���� �����̹Ƿ�
	// number�� �������� �� equals �޼ҵ带 ������ش�.

	public boolean equals(Object o) { // boolean���� Ʈ������ �޽����� equals���� Object o()
		if (o instanceof ParkDTO) {
			ParkDTO p = (ParkDTO) o;
			if (this.number.equals(p.number)) {
				return true;   
			}
		}
		return false;
	}

}
