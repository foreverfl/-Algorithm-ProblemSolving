package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01476_CalculatingDate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> possible_E = new ArrayList<>();
		List<Integer> possible_S = new ArrayList<>();
		List<Integer> possible_M = new ArrayList<>();

		for (int i = 1; i <= 8000; i++) { // The maximum value is the '7890'.
			if (E == 15) {
				if (i % 15 == 0)
					possible_E.add(i);
			} else {
				if (i % 15 == E)
					possible_E.add(i);
			}

		}

		for (int i = 0; i < possible_E.size(); i++) {
			if (S == 28) {
				if (possible_E.get(i) % 28 == 0)
					possible_S.add(possible_E.get(i));
			} else {
				if (possible_E.get(i) % 28 == S)
					possible_S.add(possible_E.get(i));
			}
	
		}

		for (int i = 0; i < possible_S.size(); i++) {
			if(M == 19) {
				if (possible_S.get(i) % 19 == 0)
					possible_M.add(possible_S.get(i));	
			} else {
				if (possible_S.get(i) % 19 == M)
					possible_M.add(possible_S.get(i));	
			}
			
		}

		System.out.println(possible_M.get(0));

	}

}
