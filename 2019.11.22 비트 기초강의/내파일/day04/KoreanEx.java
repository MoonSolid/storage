package day04;

public class KoreanEx {
	public static void main(String[] args) {
		Korean k = new Korean ();
		k.name = "¹®±¹´ë";
		k.think();
		k.speak();
		
		Human h = new Human();
		Japanese j = new Japanese();
		j.think();
		h.think(j);
	}
}
