package day04;
//ArrayList ����
import java.util.ArrayList;
public class Ex03 {
	public static void main(String[] args) {
		//ArrayList��?
		//�迭�� ��������� Ŭ������ �Ǿ��־
		//���� ����ϱⰡ ����.
		//ArrayList<������Ÿ��> list = new ArrayList<L>(); �� �����ؼ� ����Ѵ�.
		ArrayList<Integer> list = new ArrayList<>();
		//<>�ȿ��� Ŭ���� �� ���� �� �ִ�.
		//�׷� �⺻�� ������Ÿ�� 8���� ����?
		//�ڹٿ��� �����ϴ� ����Ŭ���� (wrapper class)�� ����ϸ� �ȴ�.
		//int�� ��쿡�� Integer
		
		//list�ȿ� ��� ��Ұ� ����ִ��� �������� size()�޼ҵ带 �����Ѵ�.
		System.out.println(list.size());
		
		//���ϸ��� ���� ������������� add() �޼ҵ带 ����Ѵ�.
		//�Ķ���ʹ� �츮�� < > �ȿ� ������� ������Ÿ�԰� ��ġ�ؾ��Ѵ�.
		//wrapper class�� ��� �⺻�� ������Ÿ���� �־ �ȴ�.
		list.add(5);
		System.out.println(list.size());
		
		//ArrayList �ȿ��� ��ü�� ������ (�迭�� �迭[index]ó��)
		//get(�ε�����ȣ) �޼ҵ带 �����Ѵ�.
		System.out.println(list.get(0));
		
		//���� ArrayList���� �����ϰ� �ʹٸ�?
		//2���� ����� �����ϴ�.
		//1��. �����ϴ� ����� �ε��� ��ȣ�� �˰� ������
		//2��. �����ϴ� ��ü�� ���� �־��ٶ�
		//�Ѵ� remove()�� �Ķ���͸� �ټ� �ִ�.
		//��ü�� �־��� ������ list�� �� ��ҿ� ���� equals() �޼ҵ带 �����ϰ�
		//true�� ������ ù��° ��Ҹ� �������ش�.
		Integer number = 5;
		list.remove(number);  //��ü�� �����־���
		System.out.println(list.size());
		
		//�ش���ġ�� ��Ҹ� �ٸ��ɷ� �ٲ� ������
		//set(��ġ,�ٲ� ��ü)�� ������Ѽ� �ٲ��� �� �ִ�.
		list.add(6);
		System.out.println(list.get(0));
		list.set(0, 26);
		System.out.println(list.get(0));
		
		//���� �ش� ��ü�� �ε��� ��ȣ�� �ñ��ϸ�?
		//indexOF(��ü) �� ù��°�� �����ϴ� �ε����� �� �� �ִ�.
		//�� �ش� ��ü�� ã�� ���Ѵٸ�? -1�� ���´�.
		System.out.println(list.indexOf(26));
		System.out.println(list.indexOf(55));
		
		//�ش� ��ü�� ����Ʈ�� �ִ��� ������ �ñ��ϴٸ�?
		//contains(��ü) �޼ҵ带 �����ϸ�
		//������ true, ������ false�� ���´�.
		
		System.out.println(list.contains(26));
		System.out.println(list.contains(30));
	}

}
