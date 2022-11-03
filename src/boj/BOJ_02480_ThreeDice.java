package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_02480_ThreeDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			set.add(tmp);
			arr[i] = tmp;
		}
		
		Arrays.sort(arr);
		int result = 0;
		int a = 0;
		if (set.size() == 1) {

			Iterator<Integer> iterator = set.iterator();
			while (iterator.hasNext()) {
				a = iterator.next();
			}
			result = 10000 + a * 1000;

		} else if (set.size() == 2) {

			if (arr[0] == arr[1]) {
				a = arr[0];
			} else {
				a = arr[1];
			}

			result = 1000 + a * 100;

		} else {
			
			a = arr[2];
			result = a * 100;
			
		}

		System.out.println(result);

	}

}
