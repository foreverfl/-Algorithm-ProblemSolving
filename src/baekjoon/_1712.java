package baekjoon;

import java.util.Scanner;

public class _1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fixed = sc.nextInt();
		int making = sc.nextInt();
		int price = sc.nextInt();
		sc.close();

		if (making >= price) {
			System.out.println("-1");
		} else {
			System.out.println((fixed / (price - making)) + 1); // 인트로 값 미리 지정해서 result 값 하면 /zero 오류
		}

	}

}
