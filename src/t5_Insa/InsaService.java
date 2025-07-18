package t5_Insa;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;

	// 오늘 날짜 구하기
	public InsaVO getCurrentDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();
		vo.setCbYY(cal.get(Calendar.YEAR) + "");
		vo.setCbYY((cal.get(Calendar.MARCH)+1) + "");
		vo.setCbYY(cal.get(Calendar.DATE) + "");
		
		return vo;
	}
}
