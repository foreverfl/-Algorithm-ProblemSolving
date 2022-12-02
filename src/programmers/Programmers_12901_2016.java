package programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Programmers_12901_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int a, int b) {
		LocalDate date = LocalDate.of(2016, a, b);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();
		
		String ans = "";
		if (dayOfWeekNumber == 1) {
			ans = "MON";
		} else if (dayOfWeekNumber == 2) {
			ans = "TUE";
		} else if (dayOfWeekNumber == 3) {
			ans = "WED";
		} else if (dayOfWeekNumber == 4) {
			ans = "THU";
		} else if (dayOfWeekNumber == 5) {
			ans = "FRI";
		} else if (dayOfWeekNumber == 6) {
			ans = "SAT";
		} else if (dayOfWeekNumber == 7) {
			ans = "SUN";
		}

		return ans;
	}

}
