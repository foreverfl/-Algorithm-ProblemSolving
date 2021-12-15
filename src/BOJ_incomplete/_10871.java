package BOJ_incomplete;

import java.util.*;

public class _10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int theNumberOfProgression = sc.nextInt();
		int maximum = sc.nextInt();
		int arr[] = new int[theNumberOfProgression];
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] < maximum) {
				result.add(arr[i]);
			}
		}

		for (int i = 0; i < result.size(); i++) {
			Integer val = result.get(i);
			System.out.print(val + " ");
			sc.close();
		}
	}
}
