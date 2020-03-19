package day01;
//산술연산자
//+=*/%

public class Ex03 {
	public static void main(String[] args) {
		//변수를 만들어서 값을 넣어보자
		//데이터타입 변수명 = 값;
		int myNumber1 = 5;
		int myNumber2 = 10;
		System.out.println(myNumber1 + myNumber2);
		System.out.println(myNumber1 - myNumber2);
		System.out.println(myNumber1 * myNumber2);
		System.out.println(myNumber1 / myNumber2);
		System.out.println(myNumber1 % myNumber2);
	
		//typecasting(형변환)
		//데이터 타입을 바꿀 때에는 형변환을 해줘야 한다.
		//형변환에는 2가지 방법이 있다.
		//명시적 형변환 vs 암시적 형변환
		long myNumber3 = myNumber2;
		System.out.println(myNumber3);
		int number2 = 128;
		//명시적 형변환을 하는 방법:
		//(바꿀 데이터타입)값
		byte number4 = (byte)number2;
		
		//더큰 데이터타입과 작은 데이터타입을 산술연산하면?
		//자동으로 더큰 데이터타입이 결과로 나오게 된다.
		System.out.println(number4+ number2);
		double myDouble = 1.0;
		System.out.println(number4 * myDouble);
	}
}
