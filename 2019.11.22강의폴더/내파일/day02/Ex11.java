package day02;

//char ascii 값을 이용한 5x5 체스판 만들기
public class Ex11 {
	public static void main(String[] args) {
		// println과 print의 차이
		// println은 () 안의 내용을 출력하고 자동으로 줄바꿈한다.
		// print는 () 안의 내용을 출력하고 그 옆으로 커서를 옮긴다.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print((char) ('A' + i) + Integer.toString(j + 1));
			}
			System.out.println();
		}

	}

}
