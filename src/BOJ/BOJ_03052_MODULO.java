package BOJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_03052_MODULO {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		Set<Integer> set = new HashSet<Integer>(); // excluding duplicated values through the 'Set'

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i] % 42);
		}

		System.out.println(set.size());

	}

}
