package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_16165_IdolMasterJunseok {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> hashmap = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			int team_cnt = Integer.parseInt(br.readLine());

			for (int j = 0; j < team_cnt; j++) {
				sb.append(br.readLine() + " ");
			}
			hashmap.put(team, sb.toString());
			sb.setLength(0);
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			list.clear();

			if (quiz == 0) { // team -> member
				st = new StringTokenizer(hashmap.get(str));
				while (st.hasMoreTokens()) {
					list.add(st.nextToken());
				}
				
				Collections.sort(list);
				
				for (int j = 0; j < list.size(); j++) {
					sb.append(list.get(j) + "\n");
				}
			}

			else { // member -> team
				Iterator<String> iterator = hashmap.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					st = new StringTokenizer(hashmap.get(key));

					while (st.hasMoreTokens()) {
						String str_2 = st.nextToken();
			
						if (str.equals(str_2)) {
							sb.append(key + "\n");
						}
					}
				}
			}
		}

		System.out.println(sb.toString());
	}

}

// reference: https://kjs-dev.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%9E%90%EB%B0%94-16165-%EA%B1%B8%EA%B7%B8%EB%A3%B9-%EB%A7%88%EC%8A%A4%ED%84%B0-%EC%A4%80%EC%84%9D%EC%9D%B4?category=965744
