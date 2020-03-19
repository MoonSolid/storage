package day05;

import java.util.Scanner;

//refactoring
//리팩토링이란? 프로그램의 실행 결과는 그대로이지만
//내부 소스는 더 효율적이거나 업그레이드 시키는것.
public class ParkViewer {
	private ParkController controller;
	public ParkViewer() {
		controller = new ParkController();
	}
	public void showMenu() {
		System.out.println("==================");
		System.out.println("비트 주차 관리 프로그램");
		System.out.println("==================");
		System.out.println("1.입차 2.출차 3.종료");
	}
	public void insertPark(Scanner scan) {
		// 입차시작.
		// 제일 먼저 빈 자리가 있는지 체크한다.
		if (controller.findEmpty()) {
			// 빈자리가 존재하므로 차량 번호 입력을 받는다.
			scan.nextLine();
			System.out.println("입차할 차량 번호를 입력하세요:");
			ParkDTO p = new ParkDTO();
			p.setNumber(scan.nextLine());
			while (controller.checkNumberExist(p.getNumber())) {
				// while문이 반복된다 = 중복된 차량번호이다!
				System.out.println("이미 입차된 번호입니다.");
				System.out.println("입차할 차량 번호를 입력하세요:");
				p.setNumber(scan.nextLine());
			}
			// while문을 넘겼다 = 중복된 차량번호가 아니다 -> 시간 입력받기
			System.out.println("입차 시간을 입력해주세요:");
			int inTime = scan.nextInt();
			while (controller.validateTime(inTime) == false) {
				System.out.println("형식이 잘못되었습니다.");
				System.out.println("입차 시간을 입력해주세요:");
				inTime = scan.nextInt();
			}
			// 이번 while문의 끝 = 시간이 올바른 형식
			// 이제 p에 담아서 controller.insert()호출
			p.setInTime(inTime);
			controller.insert(p);
		} else {
			System.out.println("빈 자리가 없습니다.");
		}
	}
	
	
	public void deletePark(Scanner scan) {
		// 먼저 주차된 차량이 있는지확인한다.
		if (controller.isEmpty()) {
			// 리스트가 비어있으므로
			// 경고 메시지만 출력
			System.out.println("주차된 차량이 없습니다.");
		} else {
			// 리스트에 주차된 ParkDTO가 존재하므로
			// 출차 시작
			scan.nextLine();
			System.out.println("차량 번호를 입력해주세요: ");
			ParkDTO p = new ParkDTO();
			p.setNumber(scan.nextLine());
			while (!controller.checkNumberExist(p.getNumber())) {
				System.out.println("입차된 기록이 없습니다.");
				System.out.println("차량 번호를 입력해주세요: ");
				p.setNumber(scan.nextLine());
			}
			// 차량번호가 존재 -> 하지만 inTime은?
			// 리스트의 해당 차량번호를 가진 ParkDTO 객체가 가지고 있으니깐
			// 그걸 불러와야 된다.

			p = controller.selectOne(p);

			// 출차시간을 입력을 받는다.
			// 출차시간은 시간의 유효성 뿐만이 아니라
			// 입차시간보다 늦어야 한다는 특징도 있다.
			System.out.println("출차 시간을 입력해주세요:");
			int outTime = scan.nextInt();
			while (controller.validateTime(outTime) == false || // while안의 outTime값이 false와 같으면 밑의 while문이 실행되는걸
																// 이용해
					p.getInTime() > outTime) { // outTime이 true인지false인지 확인
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("출차 시간을 입력해주세요: ");
				outTime = scan.nextInt();
			}
			System.out.println("총 요금은" + controller.calcRate(p, outTime) + "원입니다.");
			controller.remove(p);

		}
	}
}
