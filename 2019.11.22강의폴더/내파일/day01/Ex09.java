package day01;
//사용자로부터 이름, 키(미터단위), 몸무게를 입력받아서
//이름: ~~~ BMI: ~~~~가 출력되는 프로그램을 만들어봅시다.
//BMI 계산법: 몸무게 / 키의 제곱 = 몸무게 / 키 / 키
import java.util.Scanner;
public class Ex09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name = scan.nextLine();
		//지금은 nextLine부터 실행하기 때문에
		//버퍼메모리에 엔터키가 없고 따라서 nextLine을 단독실행 시켜줄 필요가 없다.
		System.out.println("키를 미터단위로 입력하세요:");
		double height = scan.nextDouble();
		System.out.println("몸무게를 입력하세요:");
		double weight = scan.nextDouble();
		
		double bmi = weight / height / height;
		System.out.println("이름:"+name+" BMI:"+bmi);
		//스캐너는 메모리를 강제로 참조하기 때문에
		//끝날때 닫아주지 않으면 항상 경고를 띄운다.
		//닫아주는 방법은 close() 메소드를 실행하면 된다.
		
	}

}
