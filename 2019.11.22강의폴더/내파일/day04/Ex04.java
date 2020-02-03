package day04;
//ArrayList를 사용한 로또번호 제작기
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex04 {
	private static final int MAX = 45;
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		while(lottoNumbers.size() < 6) {
			int randomNumber = rand.nextInt(MAX)+1;
			if(!lottoNumbers.contains(randomNumber)) {
				lottoNumbers.add(randomNumber);
			}
		}
		//단순 출력만 할때에는
		//배열이나 arrayList를 좀더 쉽게 for 문을 돌리는 방법
			for(int i : lottoNumbers) {							//단순출력용으론 좋은코드
			//위에 ()의 의미는 해당 리스트에서 순서대로 하나씩 뽑아와서			//lotto : Integer모아둔것
			//임시 변수인 i에 값을 복사한다는 뜻이 된다.
			//즉 i에 값을 바꾸더라도 원본인 lottoNumbers 안에 값은 바뀌지 않는다.    
			//도한 이 방식을 할 때 주의할 점은
			//remove 나 add같이 크기를 바꾸는 메소드는 실행하면 안된다는것이다.
			System.out.println(i);
		}
			
			Collections.sort(lottoNumbers);
			for(int i : lottoNumbers) {
				System.out.println(i);
			
		}
	}
}
