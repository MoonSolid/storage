package day04;

public class Human {
	public String name;
	
	public void think() {
		System.out.println("�����Ѵ�.");
	}
	
	public void think(Human h) {
		System.out.println(h.name + "�� ����Դϴ�.");
	}
	public void think(Human h1, Human h2) {
		System.out.println(h1.name+"�� ����Դϴ�.");
		System.out.println(h2.name+"�� ����Դϴ�.");

	}
	//�Ʒ��� think �޼ҵ�� �����ε��� �� ����. �ֳ��ϸ� �Ķ���� ������ ���� �����̴�.
	//public void think(Human h2) {
	//	System.out.println(h.name+"�� ����� �ƴմϴ�.");
	}

//overriding vs overloading
//�������̵��̶�?
//�θ�� ���� ��ӹ޴� �޼ҵ带 �ڽ���
//���Ӱ� �����ؼ� �ڽĿ��� ���� �°� �ٲ��ִ°�

//�����ε��̶�?

//���� �̸��� �޼ҵ尡 ���� Ŭ������ ���ǵǾ� ������
//�Ķ������ ������ �޶����鼭 �Ȱ��� �̸��� �޼ҵ带 �߰��� �� �ִ°�.
