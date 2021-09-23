package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class _563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] arr = new Integer[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Integer[] arrayAnswer = arr;
		Arrays.sort(arrayAnswer, Collections.reverseOrder()); // .sort 쓸려면 wrapper 클래스...
		/* public static <T> void sort(T[] a, Comparator<? super T> c)
		 * 
		 */
        
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		sc.close();

	}
}
