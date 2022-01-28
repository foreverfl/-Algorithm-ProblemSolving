package Programmers_Copied;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Copied_Programmers_92334_TakingResultOfReport {

	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			report = Arrays.stream(report).distinct().toArray(String[]::new);

			Map<String, Integer> result = new LinkedHashMap<>();

			Map<String, ArrayList<String>> reportMap = new HashMap<>();

			for (int i = 0; i < id_list.length; i++) {
				result.put(id_list[i], 0);
			}

			for (int i = 0; i < report.length; i++) {

				String[] arrReport = report[i].split(" ");
				String reporter = arrReport[0];
				String target = arrReport[1];

				if (reportMap.containsKey(target)) {
					reportMap.get(target).add(reporter);
				} else {
					ArrayList<String> list = new ArrayList<String>();
					list.add(reporter);
					reportMap.put(target, list);
				}
			}

			for (String key : reportMap.keySet()) {
				if (reportMap.get(key).size() >= k) {
					for (String i : reportMap.get(key)) {
						result.put(i, result.getOrDefault(i, 0) + 1);
					}
				}
			}

			return result.values().stream().mapToInt(Integer::intValue).toArray();
		}
	}
}

// reference: https://velog.io/@gombibi/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B3%A0-%EA%B2%B0%EA%B3%BC-%EB%B0%9B%EA%B8%B0