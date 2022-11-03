package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Copied_BOJ_01253_Good {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> maps = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (maps.containsKey(arr[i])) {
				maps.put(arr[i], maps.get(arr[i]) + 1);
			} else {
				maps.put(arr[i], 1);
			}
		}
		
		int answer = 0;
		int sum;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				sum = arr[i] + arr[j];
				int add;
				if (maps.containsKey(sum)) {
					add = maps.get(sum);
					if (arr[i] == 0 && arr[j] == 0) {
						if (add >= 3) {
							answer = answer + add;
							maps.remove(sum);
						}
					} else if (arr[i] == 0 || arr[j] == 0) {
						if (add >= 2) {
							answer = answer + add;
							maps.remove(sum);
						}
					} else {
						answer = answer + add;
						maps.remove(sum);
					}
				}
			}
		}
		System.out.println(answer);
	}
}

// reference: https://howtolivelikehuman.tistory.com/258