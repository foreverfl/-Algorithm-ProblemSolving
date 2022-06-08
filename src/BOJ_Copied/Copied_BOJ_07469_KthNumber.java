package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_07469_KthNumber {

	static List<Integer>[] tree;
	static int[] arr;
	static final int MAX = 1000000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new ArrayList[N * 4];
		for (int i = 0; i < N * 4; i++) {
			tree[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(1, N, 1, i);
		}

		for (int i = 0; i < N * 4; i++) {
			Collections.sort(tree[i]);
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int left = -MAX, right = MAX;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (query(1, N, 1, a, b, mid) < k) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			sb.append(right).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

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

	static int query(int start, int end, int node, int left, int right, int val) {
		if (right < start || left > end)
			return 0;
		if (left <= start && end <= right) {
			return lowerBound(tree[node], val);
		}

		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right, val) + query(mid + 1, end, node * 2 + 1, left, right, val);
	}

	static int lowerBound(List<Integer> data, int val) {
		int start = 0;
		int end = data.size();

		while (start < end) {
			int mid = (start + end) / 2;
			if (data.get(mid) >= val) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

}

// reference: https://loosie.tistory.com/682