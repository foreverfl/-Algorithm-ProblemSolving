package JUNGOL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _150 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[10];

		for (int i = 0; i < 10; i++) {
			String a = sc.next();
			arr[i] = a;
		}
		sc.close();

		List<String> list = Arrays.asList(arr);
		/*
		 * The List<E> An ordered collection (also known as a sequence). The user of
		 * this interface has precise control over where in the list each element is
		 * inserted. The user can access elements by their integer index (position in
		 * the list), and search for elements in the list.
		 * 
		 * The '.asList()' returns a fixed-size list backed by the specified array.
		 */
		Collections.reverse(list);
		// The '.reverse()' reverses the order of the elements in the specified list.

		String[] reverseArr = list.toArray(arr);
		/*
		 * The '.toArray()' returns an array containing all of the elements in this list
		 * in proper sequence (from first to last element).
		 * 
		 */

		for (int i = 0; i < 10; i++) {
			System.out.print(reverseArr[i] + " ");
		}

	}

}
