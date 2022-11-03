package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_04153_Egypt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		while (!str.equals("0 0 0")) {
			st = new StringTokenizer(str);
			double[] arr = new double[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);

			if ((Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) == Math.pow(arr[2], 2)) {
				sb.append("right").append('\n');
			} else {
				sb.append("wrong").append('\n');
			}

			str = br.readLine();
		}

		System.out.println(sb.toString());
	}

}
