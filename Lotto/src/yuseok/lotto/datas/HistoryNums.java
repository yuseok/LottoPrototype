package yuseok.lotto.datas;

import java.util.ArrayList;

public class HistoryNums {

	private static HistoryNums history = new HistoryNums();
	private ArrayList<String[]> arrayData = new ArrayList<String[]>();
	public static HistoryNums getInstance() {
		return history;
	}
	
	public String[] isLucky(String[] str){
		// 1,2,3,4,5,6 과 비교, 후 
		// 년도,회차, 날짜, 등수, 당첨자 수, 금액
		return null;
	}
	

}
