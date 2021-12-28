package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class BOJ_10773_ZeroThatOut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] != 0) {
				st.add(arr[i]);
			} else {
				st.pop();
			}
		}

		Iterator<Integer> iterator = st.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum += st.pop();
		}

		System.out.println(sum);

	}

}
