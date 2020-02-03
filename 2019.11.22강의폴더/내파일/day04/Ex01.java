package day04;
//배열
//배열이란? 똑같은 데이터타입이 모여있는 구조
import java.util.Random; 			//랜덤을 사용할때에 사용

public class Ex01 {
	private static final int SIZE = 6;
	private static final int MAX = 45;
	public static void main(String[] args) {
		//배열은 
		//데이터타입[] 배열이름 - new 데이터타입[크기]
		//으로 선언한다.
		int[] lottoNumber = new int[SIZE];
		//위의 코드에서 6은 magic number이다.
		//이러한 '마법의 숫자'는 사용을 기피해야 한다.
		//만약 이렇게 크기를 정해줘야한다면
		//상수로 만들어서 써야한다.
		
		//배열의 각 요소에 접글할때에는 index번호를 써서 접근한다
		lottoNumber[0] =5;
		//위의 코드는 배열에 0번째에 5를 집어넣는다는 의미
		System.out.println(lottoNumber[0]);
		//배열의 0번째 요소에 저장된 값을 출력하라
		
		//아래 코드는 오류가 난다.
		//lottoNumber[6] = 11;
		//왜냐하면 컴퓨터는 숫자를 0부터 세기 때문에
		//가징 마지막 인덱스번호는 크기 -1 이다.
		//따라서 현재 lottoNumber의 크기는 6이기 때문에
		//마지막 인덱스는 5이고, 6은 에러가 난다.
		
		//본격적으로 로또 번호 추첨기를 만들어보자
		//랜덤클래스는 0~1 사이에 실수를 갖고 있고 그걸로 난수를 제작한다.
		Random random = new Random();
		
		//만들어진 랜덤클래스로 lottoNumbers에 차례대로 난수를 집어넣어보자.
		lottoNumber[0] = random.nextInt(45)+1;
		//nextInt(숫자)를 하게되면 0~숫자 -1까지 난수가 나오기 때문에
		//+1을 해줘서 1~숫자 까지의 난수가 나오게 만들어준다.
		lottoNumber[1] = random.nextInt(45)+1;
		lottoNumber[2] = random.nextInt(45)+1;
		lottoNumber[3] = random.nextInt(45)+1;
		lottoNumber[4] = random.nextInt(45)+1;
		lottoNumber[5] = random.nextInt(45)+1;
		
		//하지만 위의 코드는 매우 나쁜 코드이다.
		//하드코딩의 대표적인 예시
		for(int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(MAX) +1;
		}
		
		//하지만 위의 코드에서는 중복이 발생할 수 있다.
		//2중 for문을 이용해서 중복된 숫자를 새로 배정하는 코드를 만들어보자.		
		for(int i =0; i < lottoNumber.length; i++) {
			for(int j =0; j< lottoNumber.length; j++) {
				if(lottoNumber[i] == lottoNumber[j] && i != j) {  //&& i != j i랑 j가 위치도 다를때
					//{1 12 38 49 33 22}
					lottoNumber[i] = random.nextInt(MAX)+1;
					j = -1;
				}
			}
		}
		
		
		//2중 for문으로 중복제거 완료 후
		//정렬을 하는 코드
		//정렬을 할때 현재 i번째와 i+1번째를 비교해서 i가 더 크면
		//2개의 순서를 바꿔준다.
		
		for(int i = 0; i < lottoNumber.length - 1; i++) {
			if(lottoNumber[i] > lottoNumber[i+1]) {
				int temp = lottoNumber[i];
				lottoNumber[i] = lottoNumber[i+1];
				lottoNumber[i+1] = temp;
				i = -1;
			}
			
		}
		
		
		for(int i = 0; i < lottoNumber.length; i++) {
			System.out.println(lottoNumber[i]);
		}
	}
}
