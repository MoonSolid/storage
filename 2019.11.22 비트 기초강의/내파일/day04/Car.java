package day04;
//필드: 번호판번호, 차량 종류, 색깔,최고속도
//메소드: toString, equals , 겟터/셋터
//메소드(method)는 기능을뜻함
//------------------------순서1-1 클래스에 필드를 선언해주는 과정------------------------------------------------
//하는 이유 : 기본 틀을 만들어주기위해
public class Car {
	private String plateNumber;							
	private String type;
	private String color;
	private int maxSpeed;
	
	//------------------------순서1-2 toString으로 필드의 메모리 주소값을 보여주는 과정------------------------------------------------
	//하는 이유 : to String을 안하면 필드의 메모리 주소값이 사용자가 읽을수없는 코드로 출력되기때문에
	public String toString() {
		return plateNumber +" "+type+" "+color+" "+maxSpeed;
	}
	
	//------------------------순서1-3 해당 오브젝트가 해당 클래스가 맞는지 확인하는 과정------------------------------------------------
	//하는 이유 : 같은 오브젝트지만 다른 고유번호인 오브젝트를 비교하기 위해서   -강사님한테 맞는지 확인하기
	public boolean equals(Object o) {  
		if (o instanceof Car) {				//해당객체맞는지 확인
		Car c = (Car)o;						//객체가 맞다면 Car클래스의 c는 Car의 오브젝트가됨
		if(this.plateNumber.equals(c.plateNumber)){
			return true;						
			}
		}
		return false;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	//------------------------순서1-4 getter(데이터보관),과 setter(데이터불러오기) 생성------------------------------------------------
	//하는 이유 : 데이터를 저장해서 필요할때 불러오기위해. 이과정을 안하면 private접근제한자가 있는 필드를 클래스내부에서밖에 사용하지못한다. 
	
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
