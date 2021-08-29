package baekjoon;

import java.util.Scanner;

public class _2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		sc.close();
		
		String b_100 = b.substring(2,3);
		String b_10 = b.substring(1,2);
		String b_1 = b.substring(0,1);
		int result1 = (Integer.parseInt(a) * Integer.parseInt(b_100));
		int result2 = (Integer.parseInt(a) * Integer.parseInt(b_10));
		int result3 = (Integer.parseInt(a) * Integer.parseInt(b_1));
		int result4 = (Integer.parseInt(a) * Integer.parseInt(b));
		// 'Integer.parseInt(n)' converts a string value to an integer value.
		
		System.out.printf("%d\n%d\n%d\n%d\n ", result1, result2, result3, result4);

	}

}
