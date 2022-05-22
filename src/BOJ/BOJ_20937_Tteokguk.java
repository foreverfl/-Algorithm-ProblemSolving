package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20937_Tteokguk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[50001];

		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			int input = Integer.parseInt(st.nextToken());
			arr[input]++;
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			ans = Math.max(ans, arr[i]);
		}

		System.out.println(ans);

	}

}
