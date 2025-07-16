package t1_database.t4_Hoewon;

import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoewonService service = new HoewonService();
		
		boolean run = true;
		
		while(run) {
			System.out.print("\n==> 1:회원가입  2:전체조회  3:개별조회  4:회원수정  5:회원삭제  0:종료? ");
			int choice = scanner.nextInt();
			
			switch (choice) {
				case 1:	// 회원가입
					service.setHoewonInput();
					break;
				case 2:	// 전체조회
					service.getHoewonList();
					break;
				case 3:	// 개별조회
					service.getHoewonSearch();
					break;
				case 4:	// 수정처리
					service.setHoewonUpdate();
					break;
				case 5:	// 삭제처리
					service.setHoewonDelete();
					break;
				default:
					service.connClose();
					run = false;
			}
		}
		System.out.println("\n작업을 종료합니다.......");
		
		scanner.close();
	}
}
