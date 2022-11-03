package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_13537_SequenceAndQuery {

	static List<Integer>[] tree;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tree = new ArrayList[N * 4];
		for (int i = 0; i < N * 4; i++) {
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(1, N, 1, i);
		}

		for (int i = 0; i < N * 4; i++) {
			Collections.sort(tree[i]);
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			sb.append(query(1, N, 1, a, b, k)).append('\n');
		}

		System.out.println(sb.toString());

	}

	public static void update(int start, int end, int node, int idx) {
		if (start > idx || end < idx)
			return;

		tree[node].add(arr[idx]);

		if (start == end)
			return;

		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx);
		update(mid + 1, end, node * 2 + 1, idx);
	}

	public static int query(int start, int end, int node, int left, int right, int k) {
		if (right < start || left > end)
			return 0;
		
		if (left <= start && end <= right) {
			int x = upperbound(tree[node], k); 
			return tree[node].size() - x;
		}

		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right, k) + query(mid + 1, end, node * 2 + 1, left, right, k);
	}

	public static int upperbound(List<Integer> data, int val) {
		int start = 0;
		int end = data.size();

		while (start < end) {
			int mid = (start + end) / 2;
			if (data.get(mid) > val) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

}

// reference: https://loosie.tistory.com/680