package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02505_FlipOverTwoTimes {

	static class Interval {
		int x, y;

		Interval() {
			x = 1;
			y = 1;
		}

		public void reset() {
			x = 1;
			y = 1;
		}
	}

	static int[] origin, array;
	static int N;
	static Interval first, second;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		origin = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}

		first = new Interval();
		second = new Interval();

		// starting from the front
		if (!front()) {
			first.reset();
			second.reset();
			// If failed in the front, it will always success.
			back();
		}

		System.out.println(first.x + " " + first.y);
		System.out.println(second.x + " " + second.y);

	}

	public static boolean front() {
		array = origin.clone();
		int reverseCnt = 0;

		for (int i = 1; i <= N; i++) {
			if (array[i] != i) {
				int s = i;

				int e = N;
				for (int j = i + 1; j <= N; j++) {
					if (array[j] == i) {
						e = j;
						break;
					}
				}
				reverse(s, e);
				reverseCnt++;
				if (reverseCnt == 1) {
					first.x = s;
					first.y = e;
				} else if (reverseCnt == 2) {
					second.x = s;
					second.y = e;
				}
			}
			if (reverseCnt >= 3)
				break;
		}
		
		if (reverseCnt <= 2)
			return true;

		return false;
	}

	public static boolean back() {
		array = origin.clone();
		int reverseCnt = 0;

		for (int i = N; i >= 1; i--) {
			if (array[i] != i) {
				int s = 1;
				int e = i;
				for (int j = 1; j < e; j++) {
					if (array[j] == i) {
						s = j;
						break;
					}
				}
				reverse(s, e);
				reverseCnt++;
				if (reverseCnt == 1) {
					first.x = s;
					first.y = e;
				} else if (reverseCnt == 2) {
					second.x = s;
					second.y = e;
				}
			}
			if (reverseCnt >= 3)
				break;
		}
		if (reverseCnt <= 2)
			return true;

		return false;
	}

	public static void reverse(int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}

// reference: https://www.acmicpc.net/problem/2505