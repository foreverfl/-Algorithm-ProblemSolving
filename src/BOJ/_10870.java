package BOJ;

import java.util.Scanner;

public class _10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int fibonacci[] = new int[a + 1]; // The 'a+1' is because the 'fibonacci[]' starts from the 'fibonacci[0].'
		sc.close();

		for (int i = 0; i < fibonacci.length; i++) {

			if (i == 0)
				fibonacci[0] = 0; // It prevents the 'outofboundexception' to occur.
			else if (i == 1)
				fibonacci[1] = 1;
			else
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		System.out.println(fibonacci[a]);

	}

}
