package JUNGOL;

import java.util.Scanner;

public class _540 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;
	

		while (run) {
			int numInput = sc.nextInt();
			
			if (numInput == -1) { // A variable to exit while loop has to be declared first.
				break;
			}

			if (numInput % 3 != 0) {
				continue;
			} else {
				System.out.println(numInput / 3);
			}
			

		}
		sc.close();
	}

}
