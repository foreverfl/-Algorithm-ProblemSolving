package BOJ;

import java.util.Scanner;

public class Copied_BOJ_01316_GroupWordsChecker {

	static Scanner sc = new Scanner(System.in); // the 'Scanner' is used in a variety of methods.

	public static void main(String[] args) {

		int count = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean check() {
		boolean[] check = new boolean[26]; // true �� exist. false �� don't exist.
		int prev = 0;
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i); // i ��° ���� ���� (���� ����)

			// �ռ� ���ڿ� i ��° ���ڰ� ���� �ʴٸ�?
			if (prev != now) {

				// �ش� ���ڰ� ó�� ������ ��� (false �� ���)
				if (check[now - 'a'] == false) {
					check[now - 'a'] = true; // true �� �ٲ��ش�
					prev = now; // ���� ���� ���� prev �� �ٲ��ش�
				}

				// �ش� ���ڰ� �̹� ���� ���� �ִ� ��� (�׷�ܾ �ƴϰ� ��)
				else {
					return false; // �Լ� ����
				}
			}

			else { // �ռ� ���ڿ� i ��° ���ڰ� ���ٸ�? (���ӵ� ����)
				continue;
			}
		}
		return true;
	}
}
