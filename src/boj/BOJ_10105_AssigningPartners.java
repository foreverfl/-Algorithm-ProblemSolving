package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10105_AssigningPartners {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<String, String> check = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		String[] arr_first = new String[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr_first[i] = st.nextToken();
		}

		String[] arr_second = new String[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr_second[i] = st.nextToken();
		}

		for (int i = 0; i < N; i++) {
			check.put(arr_first[i], arr_second[i]);
		}

		boolean flag = true;

		for (int i = 0; i < N; i++) {
			String key_first = arr_first[i];
			String value_first = check.get(key_first);
			String key_second = check.get(value_first);
			
			if (!key_first.equals(key_second))
				flag = false;
			
			if (arr_first[i].equals(arr_second[i]))
				flag = false;
		}

		if (flag)
			System.out.println("good");
		else
			System.out.println("bad");
	}

}
