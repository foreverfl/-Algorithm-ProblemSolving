package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int person[] = new int[T];
		int calculation[] = new int[T];
		int result[] = new int[T];
		int sum = 0;
		for (int i = 0; i < person.length; i++) {
			person[i] = sc.nextInt();
		}
		Arrays.sort(person); // sorting
	
		for (int i = 0; i < calculation.length; i++) { // 5, 4, 3, 2, 1
			calculation[i] = calculation.length - i;
		}
	
		for (int i = 0; i < result.length; i++) {
			result[i] = (person[i] * calculation[i]); // 1 * the young ~ n * the old
			sum += result[i];
		}
		System.out.println(sum);
	}

}
