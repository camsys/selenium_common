package scratch;

import com.camsys.selenium.common.DateTimeUtilities;

public class Test {
	public static void main(String[] args){
		String date = "05/31/2016";
	
		System.out.println(DateTimeUtilities.getNextWeekday(date));
	}
}
