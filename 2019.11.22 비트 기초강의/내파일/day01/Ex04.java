package day01;
//증강연산자
//현재 값을 1씩 증가하거나 감소하거나
//++ 		--
//다만 위치에 따라서 실행순서가 바뀌게 된다.
//증강연산자는 주로 제어문(control) 중 for 반복문에서 사용하게 된다.
public class Ex04 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a++); //System.out.println(a) -> a++ -> a는 11이 된다.
		System.out.println(a); //11출력
		System.out.println(++a); // ++a 부터 실행 => a가 12가된다. ->System.out.println(a)
		System.out.println(a);
	}

}
