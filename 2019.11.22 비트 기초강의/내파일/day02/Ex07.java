package day02;
//for loop
//for loop 은 명확히 몇회동안 반복하라고 지시하게 된다.
//for(int i = 시작점; i < 끝날지점; i변화식){
//  	반복할 코드
//}
public class Ex07 {
	public static void main(String[] args) {
		//변수는 선언되면
		//해당 코드 블록과 그 코드 블록의 하위 코드블록에서만 사용 가능하다.
		//해당 코드 블록을 벗어나면 더이상 사용이 불가능하다.
		//이것을 변수의 유효범위, 생명주기 라고 표현한다.
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
			System.out.println(i+"는 짝수입니다.");    
		}else {
			System.out.println(i+"는 홀수입니다.");
			
		}
	}
  }
}
