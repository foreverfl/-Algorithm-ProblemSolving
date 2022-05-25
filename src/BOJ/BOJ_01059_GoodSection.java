package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01059_GoodSection {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int S = Integer.parseInt(br.readLine());
		int[] arr = new int[S + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= S; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		int start = 0;
		int end = 0;
		if (n > arr[arr.length - 1]) {
			start = arr[arr.length - 1] + 1;
			end = n + 1;
		} else {
			for (int i = 0; i <= S; i++) {
				if (arr[i] > n) {
					start = arr[i - 1];
					end = arr[i];
					break;
				}
			}
		}
		for (int i = start + 1; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				list.add("" + i + " " + j);
			}
		}

		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			st = new StringTokenizer(list.get(i));
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j = s; j <= e; j++) {
				if (j == n)
					ans++;
			}
		}

		System.out.println(ans);
	}

}
