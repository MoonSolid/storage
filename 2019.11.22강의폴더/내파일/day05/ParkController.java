package day05;
//객체지향 프로그래밍에는
//5가지 원칙이 있다. (SOLID)
//그중 첫번째 원칙이 바로 Single Responsibility Principle
//개별 책임 원칙이다.
//이 원칙은 생각보다 간단하다.
//클래스는 한개의 기능만 책임져야 한다는 것이다.
//대표적인 예가 POJO 클래스이다. POJO클래스는 다른 기능은 없이
//오직 데이터를 담는 틀의 역할만 한다.
//즉 프로그램의 기능을 컨트롤하는건 다른 클래스가 담당해야되고
//프로그램의 UI는 또 다른 클래스가 담당해야하는 것이다.

import java.util.ArrayList;

//controller 클래스는
//ArrayList를 이용해서
//ParkDTO를 관리하는 클래스가 된다.
//실제 DB와 연결되면 ArrayList를 필드로 가지고 있을
//필요가 없지만 우리는 DB가 없으므로
//field의 ArrayList를 유사 DB로 쓸 것이다.

public class ParkController {						

	private final int MAX = 5;
	private final int UNUT_MINUTE = 10;
	private final int UNIT_PRICE = 1000; 
	private ArrayList<ParkDTO> list;				//ParkDTO라는 ArrayList를 불러옴

	public ParkController() {									//			
		// 이렇게 하면 생성자만 호출해도 list가 사용될 준비가 된다.
		list = new ArrayList<ParkDTO>();
	}

	public boolean checkNumberExist(String number) {					//주차할때 차량이 있는지없는지 중복검사
		// 클래스 변수(=객체)는 필요할때 마다 만들어서 써주면 된다.
		ParkDTO p = new ParkDTO();
		p.setNumber(number);
		return list.contains(p);
	}

	public boolean validateTime(int time) {							//시간은 24시간을 넘기지않게 분은 60분을 넘기지않게 하는과정
		int hour = time / 100;
		int min = time % 100;
		if (hour > -1 && hour < 24 && min > -1 && min < 60) {
			return true;
		}
		return false;
	}

	public boolean findEmpty() {			//주차장에 빈자리가 있는지 찾는 과정
		return list.size() < MAX;
	}
	

	public void insert(ParkDTO p) {			//주차장에 차를 넣는과정
		list.add(p);
	}
	public boolean isEmpty() {			//리스트에 해당요소 있는지없는지 확인
		return list.isEmpty();
		}	
	
	//2가지 방법이 가능
	//1. parkDTO 객체 보내주기
	//2. inTime만 보내주기
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