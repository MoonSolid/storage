package day01;
//논리연산자
// && || !
public class Ex06 {
	public static void main(String[] args) {
	boolean isTrue = true;
	boolean isFalse = false;
	//&& = 앤드 연산자
	//둘다 트루 일때만 트루가 나온다.
	System.out.println(isTrue && isFalse);
  
	// || = or 연산자
	//둘 중 하나만 true여도 true가 나온다.
	System.out.println(isTrue || isFalse);
	
	//! = 반전 연산자
	//true는 false로 false는 true로 바꿔준다.
	System.out.println(!isTrue);
	System.out.println(!isFalse);
	int a = 10;
	System.out.println(a > 0 && a < 100);
  }
}