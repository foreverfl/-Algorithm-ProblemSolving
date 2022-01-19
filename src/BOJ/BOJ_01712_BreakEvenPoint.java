package BOJ;

import java.util.Scanner;

public class BOJ_01712_BreakEvenPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fixed = sc.nextInt();
		int making = sc.nextInt();
		int price = sc.nextInt();
		sc.close();

		if (making >= price) {
			System.out.println("-1");
		} else {
			System.out.println((fixed / (price - making)) + 1); // ��Ʈ�� �� �̸� �����ؼ� result �� �ϸ� /zero ����
		}

	}

}
