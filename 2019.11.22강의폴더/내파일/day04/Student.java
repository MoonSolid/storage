package day04;

public class Student {
	//field
	//�ش� ��ü�� ������ ���� ��
	//�ʿ��� ������ ���� ���� �����ϵ��� ���� �Ѵ�.
	private int id;
	
	//���� ��� �ʵ���� private�� �Ǿ��� ������
	//�ܺο��� ���������� ���� �ְų� �� �� ���� �ȴ�.
	//���� �޼ҵ带 ���� �ش� Ŭ������ �ʵ尪�� ������ �� �ְ� �ؾ��Ѵ�.
	
	
	//���� �ܺο��� �޾Ƽ� ��ü ���ο� ������ ������ setter �޼ҵ带 ����Ѵ�.
	//setter�� public void set�ʵ��̸�(�ʵ嵥����Ÿ�� �ʵ��̸�)���� �����Ѵ�.  set method�� private �ʵ� �ȿ� �־��ش�
	public void setId(int id) {
		//this��? �ش� �޼ҵ带 ȣ���ϴ� ��ü �ڽ��� ���Ѵ�.
		
		this.id = id;
	}
	//getter�� ���� �ʵ忡 ����� ���� ȣ���� ������ �����ִ� �޼ҵ��̴�.
	//getter�� public �ʵ嵥����Ÿ�� get�ʵ��̸�()���� �����Ѵ�.
	public int getId() {
		return id;  
	}
	
	private String name;
	
	public void setName(String name) {
		
		
		this.name = name;
	}
	
	public String getName() {
		return name;  
	}
		
	private int kor;
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	
	
	private int eng;
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int  getEng() {
		return eng;
	}
	private int math;
	public void setMath(int math) {
		this.math = math;
	}
	public int  getMath() {
		return math;
	}
	
	
	
	//method�� �� Ŭ������ ��ɺκ��̴�.
	//method��
	//���������� ����Ÿ�� �޼ҵ��̸�(�Ķ���� ����)���� �����Ѵ�.   �Ķ���ʹ� �޼ҵ�  ����
	//����Ÿ���� �ش� �޼ҵ尡 ������ ���� ȣ�� �� ������ ������ ���� ������Ÿ��
	//�Ķ���ʹ� �ش� �޼ҵ尡 ȣ��ɶ� �޾Ƽ� �޼ҵ� ���ο��� ����� ���
	//�Ķ������ �̸��� ȣ��� ������ �Ѱܹ��� ���� Ȥ�� ���� �̸��� ���� �ʿ䰡 ����.
	//�ٸ� �� �޼ҵ� ���ο����� �ش� �̸����� ���� �ȴ�.
	
	public void showName(String name) {  //String�� ���ڿ�. 
		System.out.println("�̸���"+name);	//
	}
	//���������ڶ�? (Access Modifier)
	//�ش� field �� method�� ��� ������ �� �ִ��� ���Ѵ�.
	//public, package(=default),protected,private 4�ܰ谡 �ִ�.
	//public: ��𼭵��� ���� ����
	//package:��Ű�� ���ο����� ���� ����. ���� ������ ���������ڸ� ������������
	//			�ڵ����� package ���������� �ɸ��� �ȴ�.
	//protected: ��Ű�� ���� + ��ӹ޴� Ŭ���������� ���� ����
	//private: �ܺ��� ������ ��� ���´�.
	
	//�ٵ� ������ ���� �ܺο��� �� �޼ҵ常 public, �������� ��δ� private
	//���⼭ ���ϴ� �������� Ŭ���� ���ο��� ���� method��� ��� field�� ����
	
	//�����ڶ�?
	//�ش� Ŭ������ ��ü�� ��������� ȣ��Ǵ� �޼ҵ��̴�.
	//�ش� ��ü�� ������� �� �ؾ��ϴ� �ൿ���̳� Ȥ�� �ʱ�ȭ������ ������ �� �ִ�.
	//�츮�� �ȸ�����൵ �ڹٰ� �ڵ����� ������ִ� �����ڰ� �ִµ�
	//�ش� �����ڴ� �⺻�� ������Ÿ���� �ʵ���� 0���� �ʱ�ȭ�ϰ�
	//������ ������Ÿ���� �ʵ���� null�� �ʱ�ȭ�Ѵ�.
	//�����ڴ� public Ŭ�����̸�() ���� �����Ѵ�.
	
	//�����ڿ��� �Ķ���Ͱ� �ִ� �����ڿ� �Ķ���Ͱ� ���� �����ڰ� �ִµ�
	//�Ķ���Ͱ� �ִ� �����ڸ� ������ָ� �⺻ �����ڿ� �Ķ���Ͱ� ���� �����ڴ�
	//�� �� ���� �ȴ�.
	//���� �Ķ���Ͱ� �ִ� �����ڸ� ����� ���� �Ķ���Ͱ� ���� �����ڵ� �ʿ��ϸ�
	//�߰��� ���������Ѵ�.
		public Student(String name, int id, int kor, int eng, int math) {
		System.out.println("�⺻ ������ ȣ��");
		this.name = name;
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		}
		public Student() {
			name = "�л�";
			id = -1;
			kor = -1;
			eng = -1;
			math = -1;
		
		}
		public String toString() {
			return id+" "+name+" "+kor+" "+eng+" "+math;
		}

		//equals �޼ҵ��?
		//�ش� ��ü�� �Ķ���ͷ� ������ ��� ���� ���ϴ� �޼ҵ��̴�.
		//���� �ش� ��ü�� ������Ÿ���� ����
		//�ش� ��ü�� Ư�� �ʵ�� ���� ������ �Ȱ��� ��ü�� �Ǵ��Ͽ�
		//true�� �����ϰ�
		//���� ���� ������ �ƴϰų� �ʵ��� ���� �ٸ��� false�� �������ش�.
		public boolean equals(Object o) { //o�� ��Ʃ��Ʈ�� ��ü�� �����ϰ� 
			if(o instanceof Student) {  //o�� ��Ʃ��Ʈ�� ��ü���� ���ϰ� Ʈ����
				Student s = (Student)o;    //s��� 
				if(this.id == s.id && this.name.equals(s.name)) { //ȣ���� ������Ʈ�� ȣ���� 
					return true;
				}
			}
			
			return false;
		}
}









