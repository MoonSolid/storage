package day02;

//점수를 입력받아서
//switch문을 이용해서
//A B C D F를 출력하시오.
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("점수를 입력하세요 :");
		int score = scan.nextInt();
		if(score > 100) { //스코어가 100보다 크면 if문을 실행하게해서 else값이 출력되게만듬(int는 정수형이라 소수점은생략하기때문에 10으로 나눠주면  
			System.out.println("잘못 입력하셨습니다.");  //case를 1부터 100까지 하나하나 입력해줄필요가없다 101~109는 10으로 나눴을때 문제가 생겨서  if문을사용 )
		}else {
			switch(score / 10) { //score를 10으로 나눠줘서 
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
			case 6:
				System.out.println("D");
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				System.out.println("F");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;	
		}
		}
		scan.close();
	}
}
