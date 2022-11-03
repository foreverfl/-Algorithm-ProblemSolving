package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Copied_BOJ_02304_WarehousePolygon {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int start = Integer.MAX_VALUE;
		int end = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			start = Math.min(L, start);
			end = Math.max(L, end);
		}

		Stack<Integer> height = new Stack<>();
		// left
		int temp = arr[start];
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < temp) {
				height.push(i);
			} else {
				while (!height.isEmpty()) {
					int x = height.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}
		height.clear();

		// right
		temp = arr[end];
		for (int i = end - 1; i >= start; i--) {
			if (arr[i] < temp)
				height.push(i);
			else {
				while (!height.isEmpty()) {
					int x = height.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}

		int result = 0;
		for (int i = start; i <= end; i++) {
			result += arr[i];
		}

		sb.append(result).append("\n");
		System.out.print(sb.toString());
	}

}

// reference: https://myeongju00.tistory.com/17
