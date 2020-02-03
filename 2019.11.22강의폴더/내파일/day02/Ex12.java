package day02;
//1~100까지의 소수를 구하는 프로그램
//소수란? 1과 자기자신을 제외한 약수가 없는 수
//숫자에서의 가장 큰 약수 =자기자신
//요 2가지 조건을 이용해서 소수를 출력하는 프로그램을 만들어봅시다.
public class Ex12 {
	public static void main(String[] args){
		
		for(int i = 1; i <= 100; i++) {
			//i = 1 count = 0  j = 1
			int count = 0;  
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i+"는 소수입니다!");
			}
		}
	}
}
