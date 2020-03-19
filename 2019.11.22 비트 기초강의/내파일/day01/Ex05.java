package day01;
//비교 연산자
//크냐, 크거나 같냐, 작냐, 작거나 같냐, 같냐, 다르냐
//>, 	   >=,		  <,	   <=,	    ==,	   != 
//비교는 항상 맞다 or 틀리다 가 나오기 때문에
//결과값은 boolean이 된다.
public class Ex05 {
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);
		
		String str = "abc";
		String str2 = new String("abc");
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str==str2);
		System.out.println(str.equals(str2));
	}
}


