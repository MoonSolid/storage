package day02;
//if문 예제 01
//if문이란? 조건식이 true가 나오면 실행,false가 나오면 실행되지 않는
//제어문이다.
//if - else if -else 로 구조가 이루어진다.
//if문 조건을 만족하면 아래의 else if+else는 무시가되고
//if문 조건을 만족하지않으면 else if를체크
//else if도 만족하지 않을시엔 else가 실행된다
//else if는 여러개가 나올 수 있다.
public class Ex01 {
	public static void main(String[] args) {
		int number = 52;
		if(number >= 100) {
			//if문의 조건식이 true 가 나오면
			//해당 code block 이 실행된다.
			//code block은 {}으로 감싸진 부분을 code block이라고 한다.
			System.out.println("number는 100보다 크거나 같습니다.");
		}else if (number >= 10){
			System.out.println("number는 100보다 작고 10보다크거나 같습니다.");
		}else if(number >=0) {
			System.out.println("number는 10보다 작고 0보다 크거나 같습니다");
		}else {
			System.out.println("number는 음의 정수입니다.");
		}
		
		}
		
	}

