package programmers;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Programmers_17678_ShuttleBus {

	public static void main(String[] args) throws ParseException {
		System.out.println(solution(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" }));
	}

	public static String solution(int n, int t, int m, String[] timetable) throws ParseException {
		List<LocalTime> list = new ArrayList<>();

		for (int i = 0; i < timetable.length; i++) {
			String[] tmp = timetable[i].split(":");
			LocalTime time = LocalTime.of(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			list.add(time);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		LinkedHashMap<LocalTime[], LocalTime[]> table = new LinkedHashMap<>();

		// 도착시간 시작시간 키 값으로 넣기
		LocalTime start = LocalTime.of(9, 00).minusMinutes(t);
		LocalTime arrive = LocalTime.of(9, 00);
		table.put(new LocalTime[] { start, arrive }, null);
		for (int i = 0; i < n - 1; i++) {
			start = start.plusMinutes(t);
			arrive = arrive.plusMinutes(t);
			table.put(new LocalTime[] { start, arrive }, null);
		}

		Iterator<LocalTime[]> keys = table.keySet().iterator();
		while (keys.hasNext()) {
			LocalTime[] now = keys.next();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isAfter(start) && list.get(i).isBefore(arrive)) {
					
				}
			}
		}

		String answer = "";
		return answer;
	}

}
