package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_04084_VivalaDiferencia {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		

		while (true) {
			String testCase = br.readLine();
			if (testCase.equals("0 0 0 0"))
				break;

			st = new StringTokenizer(testCase);
			int[] nums = new int[4];
			for (int i = 0; i < 4; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			int time = 0;
			while (true) {
				if (isEnd(nums))
					break;

				++time;
				nums = makeNewArray(nums);
			}
			sb.append(time + "\n");
		}

		System.out.println(sb.toString());
	}

	private static int[] makeNewArray(int[] arr) {
		int[] res = new int[4];

		res[0] = Math.abs(arr[0] - arr[1]);
		res[1] = Math.abs(arr[1] - arr[2]);
		res[2] = Math.abs(arr[2] - arr[3]);
		res[3] = Math.abs(arr[0] - arr[3]);

		return res;
	}

	private static boolean isEnd(int[] arr) {
		if (arr[0] == arr[1]) {
			if (arr[1] == arr[2]) {
				if (arr[2] == arr[3]) {
					return true;
				}
			}
		}

		return false;
	}

}
