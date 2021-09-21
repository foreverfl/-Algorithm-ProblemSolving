package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Copied_BOJ_01339_WordsMathematics {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		int[] alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next(); // �ܾ� �Է�
		}

		for (int i = 0; i < N; i++) {
			int temp = (int) Math.pow(10, arr[i].length() - 1); // �� ���ڸ� temp�� ����, ABC��� �Ҷ� A�� 100����
			for (int j = 0; j < arr[i].length(); j++) {
				alphabet[(int) arr[i].charAt(j) - 65] += temp; // ABC��� �� �� alphabet[0] =100, alphabet[1] = 10,
																// alphabet[2] =1
				temp /= 10;
			}
		}

		Arrays.sort(alphabet);
		int index = 9;
		int sum = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) { // ���ʺ��� 9���� ���Խ���
			if (alphabet[i] == 0) {
				break;
			}
			sum += alphabet[i] * index;
			index--;
		}
		System.out.println(sum);
	}
}
