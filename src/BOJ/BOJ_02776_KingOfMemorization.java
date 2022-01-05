package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02776_KingOfMemorization {
	static int memo_1, memo_2;
	static int[] arr_memo_1, arr_memo_2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			memo_1 = Integer.parseInt(br.readLine());
			arr_memo_1 = new int[memo_1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < memo_1; j++) {
				arr_memo_1[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr_memo_1);

			memo_2 = Integer.parseInt(br.readLine());
			arr_memo_2 = new int[memo_2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < memo_2; j++) {
				arr_memo_2[j] = Integer.parseInt(st.nextToken());
				if (binarySearch(arr_memo_2[j])) {
					bw.append("1").append("\n");
				} else {
					bw.append("0").append("\n");
				}
			}			
		}
		bw.flush();
		bw.close();
	}

	private static boolean binarySearch(int num) {
		int leftIndex = 0;
		int rightIndex = memo_1 - 1;

		while (leftIndex <= rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			int mid = arr_memo_1[midIndex];

			if (num > mid) {
				leftIndex = midIndex + 1;
			} else if (num < mid) {
				rightIndex = midIndex - 1;
			} else {
				return true;
			}

		}
		return false;

	}

}
