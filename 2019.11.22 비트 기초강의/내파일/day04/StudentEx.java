package day04;

public class StudentEx {
	public static void main(String[] args) {
		Student s = new Student("������", 0, 80, 90, 100);
		String str = "abc";
		s.showName(str);
		s.showName("������");
		s.setId(0);
		Student s2 = new Student();
		s2.showName(str);
		s2.setId(2);
		
		s.setId(0);
		s.setName("������") ;
		s.setKor(80);
		s.setEng(90);
		s.setMath(100);
		System.out.println("�� �л��� �̸���:"+s.getName());
		System.out.println("�� �л��� �̸���:"+s2.getName());
		
		//System.out.println �޼ҵ��
		//�Ķ���ͷ� calss ��ü�� ������
		//�ش� ��ü�� toString()�̶�� �޼ҵ带 ������Ѽ�
		//�� ������� ȭ�鿡 ����Ѵ�.
		
		//�츮�� ���� toString()�޼ҵ带 ������ �ʾƵ�
		//�ڹٿ��� ������� toString()�޼ҵ带 ������Ѽ�
		//������ִµ�
		//�ڹٿ��� ������ִ� toString()�޼ҵ��
		//��Ű����.Ŭ�����̸�@�޸��ּҰ� �� �����ش�.
		
		//���� �츮�� ��ü�� �ʵ尪�� println���� �����ַ���
		//getter�� ȣ���ϰų� toString()�޼ҵ带 ���� ������� �Ѵ�.
		
		System.out.println(s);
		System.out.println(s2);
		
		//equals �޼ҵ� ������
		System.out.println(s.equals(s2));
		s2.setId(0);
		s2.setName("������");
		System.out.println(s.equals(s2));
	}
}





