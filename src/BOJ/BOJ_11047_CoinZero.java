package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_11047_CoinZero {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int total = sc.nextInt();
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < T; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list, Collections.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			count += (total / list.get(i));
			total = total % list.get(i);

		}
		System.out.println(count);
	}

}
