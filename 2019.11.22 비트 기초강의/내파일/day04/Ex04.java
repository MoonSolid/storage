package day04;
//ArrayList�� ����� �ζǹ�ȣ ���۱�
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex04 {
	private static final int MAX = 45;
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		while(lottoNumbers.size() < 6) {
			int randomNumber = rand.nextInt(MAX)+1;
			if(!lottoNumbers.contains(randomNumber)) {
				lottoNumbers.add(randomNumber);
			}
		}
		//�ܼ� ��¸� �Ҷ�����
		//�迭�̳� arrayList�� ���� ���� for ���� ������ ���
			for(int i : lottoNumbers) {							//�ܼ���¿����� �����ڵ�
			//���� ()�� �ǹ̴� �ش� ����Ʈ���� ������� �ϳ��� �̾ƿͼ�			//lotto : Integer��Ƶа�
			//�ӽ� ������ i�� ���� �����Ѵٴ� ���� �ȴ�.
			//�� i�� ���� �ٲٴ��� ������ lottoNumbers �ȿ� ���� �ٲ��� �ʴ´�.    
			//���� �� ����� �� �� ������ ����
			//remove �� add���� ũ�⸦ �ٲٴ� �޼ҵ�� �����ϸ� �ȵȴٴ°��̴�.
			System.out.println(i);
		}
			
			Collections.sort(lottoNumbers);
			for(int i : lottoNumbers) {
				System.out.println(i);
			
		}
	}
}
