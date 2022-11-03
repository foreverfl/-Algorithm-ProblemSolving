package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11034_ThreeKangaroo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
	
		
		while ((str = br.readLine()) != null) {
			
			st = new StringTokenizer(str, " ");
			int[] arr = new int[3];			
		
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int distance_1 = Math.abs(arr[0] - arr[1]);
			int distance_2 = Math.abs(arr[1] - arr[2]);
			int distance = Math.max(distance_1, distance_2);

			int result = distance - 1;
			sb.append(result).append('\n');
		}

		System.out.println(sb);
	}

}
