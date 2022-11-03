package programmers_Copied;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Copied_Programmers_92334_TakingResultOfReport {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] result = new int[id_list.length];
		Map<String, Integer> index = new HashMap<>();
		Map<String, List<Integer>> list = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			index.put(id_list[i], i);
		}

		for (String rep : report) {
			StringTokenizer st = new StringTokenizer(rep);
			String reporter = st.nextToken(), reportee = st.nextToken();
			if (!list.containsKey(reportee)) // reportee: reporter, reporter, ..., reporter(by index)
				list.put(reportee, new ArrayList<>());
			
			List<Integer> tmp = list.get(reportee); // The 'tmp' gets the list of reportees.
			
			if (!tmp.contains(index.get(reporter)))
				tmp.add(index.get(reporter));
		}

		for (int i = 0; i < id_list.length; i++) {
			String id = id_list[i];
			if (list.containsKey(id) && list.get(id).size() >= k) {
				for (int idx : list.get(id)) {
					result[idx]++;
				}
			}
		}

		return result;
	}
}

// reference: https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B3%A0-%EA%B2%B0%EA%B3%BC-%EB%B0%9B%EA%B8%B0-JAVA