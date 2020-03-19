package day02;
//char
public class Ex10 {
	public static void main(String[] args) {
		//char는 ascii 테이블이라 불리는
		//코드 테이블에서 숫자값에 대응하는 글자를 불러온다.
		char myChar = 'a'; //char에 값을 넣을때에는 따옴표로 감싸준다.
		//쌍따옴표는 String이라는 의미이다.
		System.out.println((char)(myChar-32)); //a - 32???
	}
}
