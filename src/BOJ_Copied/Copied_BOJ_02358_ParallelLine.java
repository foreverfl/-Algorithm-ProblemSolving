package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_02358_ParallelLine {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, ArrayList<Integer>> x_map = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> y_map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> x_list = new ArrayList<>();
			ArrayList<Integer> y_list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x_map.containsKey(x)) {
				y_list = x_map.get(x);
			}
			y_list.add(y);
			x_map.put(x, y_list);

			if (y_map.containsKey(y)) {
				x_list = y_map.get(y);
			}
			x_list.add(x);
			y_map.put(y, x_list);
		}

		int cnt = 0;
		for (int key : x_map.keySet()) {
			if (x_map.get(key).size() >= 2)
				cnt++;
		}

		for (int key : y_map.keySet()) {
			if (y_map.get(key).size() >= 2)
				cnt++;
		}

		System.out.println(cnt);
	}

}

// reference: https://velog.io/@kha0318/Algorithm-%EB%B0%B1%EC%A4%80-2358-%ED%8F%89%ED%96%89%EC%84%A0
