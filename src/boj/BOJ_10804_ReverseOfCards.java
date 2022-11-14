package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10804_ReverseOfCards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[21];
		for (int i = 1; i <= 20; i++) {
			arr[i] = i;
		}

		int repeat = 10;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new LinkedList<>();

			for (int i = start; i <= end; i++) {
				queue.offer(arr[i]);
			}

			for (int i = end; i >= start; i--) {
				arr[i] = queue.poll();
			}
		}

		for (int i = 1; i <= 20; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
