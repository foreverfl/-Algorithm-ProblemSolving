package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_02531_ConveyorBeltSushi {

	static int N, d, k, c;
	static int[] sushi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		for (int i = 0; i < sushi.length; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(event(sushi, k));

	}

	private static int event(int[] arr, int coupon) {
		ArrayList<Integer> check = new ArrayList<>();
		Set<Integer> check_duplicate = new HashSet<>();
		int firstPointer = 0;
		int secondPointer = 0; // arr - firstPointer < k
		int cntMax = Integer.MIN_VALUE;
		int cnt = 0;
		int repeat = N;
		while (repeat-- > 0) {
			cnt = 0; // initialization
			check.clear();
			check_duplicate.clear();

			for (int i = firstPointer; i < firstPointer + k - secondPointer; i++) { // 체크 배열에 값 넣어줌
				check.add(arr[i]);
			}
			for (int i = 0; i < secondPointer; i++) {
				check.add(arr[i]);
			}

			for (int i = 0; i < check.size(); i++) { // 0부터 순회하면 안됨
				check_duplicate.add(check.get(i));
			}
			cnt = check_duplicate.size();

			if (!check_duplicate.contains(c)) {
				cnt++;
			}

			if (cnt > cntMax) { // 최대값 구하기
				cntMax = cnt;
			}

			if (N - firstPointer > k) {
				firstPointer++;
			} else {
				firstPointer++;
				secondPointer++;
			}
		}
		return cntMax;

	}

}
