package day05;

import java.util.Scanner;

public class ParkEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ParkViewer viewer = new ParkViewer();
		while (true) {
			viewer.showMenu();
			int choice = scan.nextInt();
			if (choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			} else if (choice == 1) {
				viewer.insertPark(scan);
			} else if (choice == 2) {
				viewer.deletePark(scan);
			}
		}
		scan.close();
	}

}
