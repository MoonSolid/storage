package day01;
//데이터타입
//데이터타입은 크게 2가지로 나뉜다 : 기본형과 참조형
//기본형:stack메모리에 선언되고 값이 해당 주소에 들어간다.
//기본형에는 byte short int long float double char boolean 8가지만 있다.
//byte, short, int, long: 정수형 데이터타입(8비트, 16비트, 32비트, 64비트)
//float, double:실수형
//char: 문자형
//boolean: 참/거짓
//참조형: heap 메모리에 선언되고 해당 주소에는 그 변수로 들어가는 메모리 주소가 저장된다.
//참조형은 크게 class, interface, 배열 3가지 종류의 변수가 있다.
public class Ex02 {
	public static void main(String[] args) {
		//만약 데이터타입이 표현할 수 있는 최대 범위를 넘으면
		//오히려 -로 가게 되는데
		//이러한 버그를 overflow라고 한다.
		
		//반대로 표현할 수 있는 최소 범위를 넘으면
		//+로 바뀌는데
		//이러한 버그를 underflow라고 한다.
		byte max = (byte)(127+1);
		System.out.println(max);
	}
}
