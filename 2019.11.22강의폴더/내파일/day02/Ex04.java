package day02;
//switch 문에서 의도적으로 break 를 생략하여
//특정 결과값들의 실행코드를 컨트롤 하는 방법
public class Ex04 {
	public static void main(String[] args) {
		int month = 5;
		switch(month) {
		case 1:
		case 3:
		case 5:  //조건이맞는 case 5만실행되고 
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31"); //break가 없으니 전부 생략되다가 break를 걸어 31을 출력해줌
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;
		case 2:
			System.out.println("28");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
            break;		
            //break문을 일부러 사용하는 예
		}
	}
}
