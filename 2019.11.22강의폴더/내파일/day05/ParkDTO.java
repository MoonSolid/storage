package day05;

public class ParkDTO { // DTO = Data Transfer Object 이
	// 이 안에는 field 와 겟터셋터, equals, toString정도만 들어간다
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

	// ArrayList의 contains, indexOF 등의 메소드들은
	// template으로 들어온 class의 equals 메소드를 호출해서
	// 그 결과값을 메소드 내부에서 사용한다.
	// 우리 프로그램에선 차량 번호가 같으면 같은 차량이므로
	// number를 기준으로 한 equals 메소드를 만들어준다.

	public boolean equals(Object o) { // boolean으로 트루인지 펄스인지 equals으로 Object o()
		if (o instanceof ParkDTO) {
			ParkDTO p = (ParkDTO) o;
			if (this.number.equals(p.number)) {
				return true;   
			}
		}
		return false;
	}

}
