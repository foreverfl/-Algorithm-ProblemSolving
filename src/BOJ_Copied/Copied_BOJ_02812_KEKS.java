package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Copied_BOJ_02812_KEKS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String input = br.readLine();

		char[] arr = input.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (K > 0 && !deque.isEmpty() && deque.getLast() < arr[i]) {
				deque.removeLast();
				K--;
			}
			deque.addLast(arr[i]);
		}

		StringBuilder sb = new StringBuilder();
		while (deque.size() > K) {
			sb.append(deque.removeFirst());
		}

		System.out.println(sb.toString());
	}

}

// reference: https://steady-coding.tistory.com/54
