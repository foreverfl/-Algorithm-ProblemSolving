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
			arr[i] = sc.next(); // 단어 입력
		}

		for (int i = 0; i < N; i++) {
			int temp = (int) Math.pow(10, arr[i].length() - 1); // 맨 앞자리 temp에 저장, ABC라고 할때 A에 100저장
			for (int j = 0; j < arr[i].length(); j++) {
				alphabet[(int) arr[i].charAt(j) - 65] += temp; // ABC라고 할 때 alphabet[0] =100, alphabet[1] = 10,
																// alphabet[2] =1
				temp /= 10;
			}
		}

		Arrays.sort(alphabet);
		int index = 9;
		int sum = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) { // 앞쪽부터 9부터 대입시작
			if (alphabet[i] == 0) {
				break;
			}
			sum += alphabet[i] * index;
			index--;
		}
		System.out.println(sum);
	}
}
