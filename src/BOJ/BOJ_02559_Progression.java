package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_02559_Progression {

	static int N, K;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		consecutiveProgression(arr);

		Collections.sort(result, Collections.reverseOrder());
		
		System.out.println(result.get(0));
	}

	private static void consecutiveProgression(int[] arr) {
		for (int i = 0; i <= arr.length - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += arr[j];
			}
			result.add(sum);
		}
		
	}

}
