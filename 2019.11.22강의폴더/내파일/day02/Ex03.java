package day02;
//switch
//switch는 조건식이 아니라
//변수를 잡아서
//해당 변수가 나올 수 있는 값에 따라
//조건문을 실행하게된
public class Ex03 {
	public static void main(String[] args) {
		int number = 5;
		switch (number) {
		case 6:
			System.out.println("6입니다.");
			break;
		case 5:
			System.out.println("5입니다.");
			
		case 4:
			System.out.println("4입니다.");
			
		default:
			System.out.println("그외입니다.");
			
		}
	}

}
