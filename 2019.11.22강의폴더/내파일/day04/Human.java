package day04;

public class Human {
	public String name;
	
	public void think() {
		System.out.println("생각한다.");
	}
	
	public void think(Human h) {
		System.out.println(h.name + "는 사람입니다.");
	}
	public void think(Human h1, Human h2) {
		System.out.println(h1.name+"는 사람입니다.");
		System.out.println(h2.name+"도 사람입니다.");

	}
	//아래의 think 메소드는 오버로딩될 수 없다. 왜냐하면 파라미터 내용이 같기 때문이다.
	//public void think(Human h2) {
	//	System.out.println(h.name+"은 사람이 아닙니다.");
	}

//overriding vs overloading
//오버라이딩이란?
//부모로 부터 상속받는 메소드를 자식이
//새롭게 정의해서 자식에게 좀더 맞게 바꿔주는것

//오버로딩이란?

//같은 이름의 메소드가 같은 클래스에 정의되어 있지만
//파라미터의 내용이 달라지면서 똑같은 이름의 메소드를 추가할 수 있는것.
