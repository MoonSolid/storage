package day04;
//�ʵ�: ��ȣ�ǹ�ȣ, ���� ����, ����,�ְ�ӵ�
//�޼ҵ�: toString, equals , ����/����
//�޼ҵ�(method)�� ���������
//------------------------����1-1 Ŭ������ �ʵ带 �������ִ� ����------------------------------------------------
//�ϴ� ���� : �⺻ Ʋ�� ������ֱ�����
public class Car {
	private String plateNumber;							
	private String type;
	private String color;
	private int maxSpeed;
	
	//------------------------����1-2 toString���� �ʵ��� �޸� �ּҰ��� �����ִ� ����------------------------------------------------
	//�ϴ� ���� : to String�� ���ϸ� �ʵ��� �޸� �ּҰ��� ����ڰ� ���������� �ڵ�� ��µǱ⶧����
	public String toString() {
		return plateNumber +" "+type+" "+color+" "+maxSpeed;
	}
	
	//------------------------����1-3 �ش� ������Ʈ�� �ش� Ŭ������ �´��� Ȯ���ϴ� ����------------------------------------------------
	//�ϴ� ���� : ���� ������Ʈ���� �ٸ� ������ȣ�� ������Ʈ�� ���ϱ� ���ؼ�   -��������� �´��� Ȯ���ϱ�
	public boolean equals(Object o) {  
		if (o instanceof Car) {				//�ش簴ü�´��� Ȯ��
		Car c = (Car)o;						//��ü�� �´ٸ� CarŬ������ c�� Car�� ������Ʈ����
		if(this.plateNumber.equals(c.plateNumber)){
			return true;						
			}
		}
		return false;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	//------------------------����1-4 getter(�����ͺ���),�� setter(�����ͺҷ�����) ����------------------------------------------------
	//�ϴ� ���� : �����͸� �����ؼ� �ʿ��Ҷ� �ҷ���������. �̰����� ���ϸ� private���������ڰ� �ִ� �ʵ带 Ŭ�������ο����ۿ� ����������Ѵ�. 
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
}
