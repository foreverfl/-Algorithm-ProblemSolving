package baekjoon;

import java.util.Scanner;

public class _11470_in_progress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		if (str.contains("+")) { // [String].contains ���ڿ��� Ư�� ���� ���� ����..
			char[] arr = str.toCharArray(); // ���ڿ��� �迭�� ��ȯ
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-') {
				
				}
			}

		} else {
			System.out.println(str);
		}

	}

	// �Է°� ����
	public boolean checkStr(String textInput) {

		char chrInput;

		for (int i = 0; i < textInput.length(); i++) {
			chrInput = textInput.charAt(i); // �Է¹��� �ؽ�Ʈ���� ���� �ϳ��ϳ� �����ͼ� üũ
			if (chrInput >= 0x30 && chrInput <= 0x39 && chrInput == 0x2B && chrInput == 0x2D) {
				// ����, +, -�� �� ����
				return true;
			}
		}
		return false;
	}
}
