package day04;

public class Ex02 {
	public static void main(String[] args) {
		Car[] arrayCar = new Car[5];
		//위의 코드는 배열에 대해서만 메모리 확보가 되었기 때문에
		//각 요소는 다시한번 new로 초기화해줘야
		//사용가능하다.
		System.out.println(arrayCar.length);
		for(int i = 0; i < arrayCar.length;i++) {
			arrayCar[i] = new Car();
		}
		arrayCar[0].setPlateNumber("01가 0000");
		//2번째, 배열에 비어있는데를 찾을려면 배열 전체를 다 돌아다녀야한다.
		for(int i = 0; i < arrayCar.length; i++) {
			if(arrayCar[i].getPlateNumber() == null) {
				System.out.println(i+"번째가 비어있습니다.");
			}
		}
	}
}
