package BOJ_incomplete;

import java.util.Scanner;

public class _3046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R1 = sc.nextInt();
		int S = sc.nextInt();
		int R2 = 2*S - R1;
		
		System.out.println(R2);
		sc.close();
	}

}
