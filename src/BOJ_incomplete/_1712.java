package BOJ_incomplete;

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
			System.out.println((fixed / (price - making)) + 1); // ��Ʈ�� �� �̸� �����ؼ� result �� �ϸ� /zero ����
		}

	}

}
