package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_43164_JourneyPath {

	public static void main(String[] args) {
		String[][] tickets_1 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[] res_1 = solution(tickets_1);

		for (int i = 0; i < res_1.length; i++) {
			System.out.print(res_1[i] + " ");
		}
		System.out.println();

		String[][] tickets_2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		String[] res_2 = solution(tickets_2);

		for (int i = 0; i < res_2.length; i++) {
			System.out.print(res_2[i] + " ");
		}
	}

	static boolean[] visited;
	static List<String> list;

	public static String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		list = new ArrayList<>();
		
		dfs(tickets, "ICN", "ICN", 0);

		Collections.sort(list);

		String answer[] = list.get(0).split(" ");

		list.clear();
		
		return answer;
	}

	public static void dfs(String[][] tickets, String now, String path, int depth) {
		if (depth == tickets.length) {
			list.add(path);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && now.equals(tickets[i][0])) {

				visited[i] = true;
				dfs(tickets, tickets[i][1], path + " " + tickets[i][1], depth + 1);
				visited[i] = false;
			}
		}

	}

}
