package day04;
//ArrayList 예제
import java.util.ArrayList;
public class Ex03 {
	public static void main(String[] args) {
		//ArrayList란?
		//배열과 비슷하지만 클래스로 되어있어서
		//좀더 사용하기가 쉽다.
		//ArrayList<데이터타입> list = new ArrayList<L>(); 로 선언해서 사용한다.
		ArrayList<Integer> list = new ArrayList<>();
		//<>안에는 클래스 만 들어올 수 있다.
		//그럼 기본형 데이터타입 8개인 경우는?
		//자바에서 제공하는 포장클래스 (wrapper class)를 사용하면 된다.
		//int의 경우에는 Integer
		
		//list안에 몇개의 요소가 들어있는지 볼때에는 size()메소드를 실행한다.
		System.out.println(list.size());
		
		//제일먼저 값을 집어넣을때에는 add() 메소드를 사용한다.
		//파라미터는 우리가 < > 안에 집어넣은 데이터타입과 일치해야한다.
		//wrapper class일 경우 기본형 데이터타입을 넣어도 된다.
		list.add(5);
		System.out.println(list.size());
		
		//ArrayList 안에서 객체를 뺄때는 (배열의 배열[index]처럼)
		//get(인덱스번호) 메소드를 실행한다.
		System.out.println(list.get(0));
		
		//만약 ArrayList에서 제거하고 싶다면?
		//2가지 방법이 가능하다.
		//1번. 제거하는 요소의 인덱스 번호를 알고 있을때
		//2번. 제거하는 객체를 직접 넣어줄때
		//둘다 remove()의 파라미터를 줄수 있다.
		//객체를 넣어줄 때에는 list의 각 요소에 대해 equals() 메소드를 실행하고
		//true가 나오는 첫번째 요소를 제거해준다.
		Integer number = 5;
		list.remove(number);  //객체를 직접넣어줌
		System.out.println(list.size());
		
		//해당위치의 요소를 다른걸로 바꿀 때에는
		//set(위치,바꿀 객체)를 실행시켜서 바꿔줄 수 있다.
		list.add(6);
		System.out.println(list.get(0));
		list.set(0, 26);
		System.out.println(list.get(0));
		
		//만약 해당 객체의 인덱스 번호가 궁금하면?
		//indexOF(객체) 로 첫번째로 등장하는 인덱스를 알 수 있다.
		//단 해당 객체를 찾지 못한다면? -1이 나온다.
		System.out.println(list.indexOf(26));
		System.out.println(list.indexOf(55));
		
		//해당 객체가 리스트에 있는지 없는지 궁금하다면?
		//contains(객체) 메소드를 실행하면
		//있으면 true, 없으면 false가 나온다.
		
		System.out.println(list.contains(26));
		System.out.println(list.contains(30));
	}

}
